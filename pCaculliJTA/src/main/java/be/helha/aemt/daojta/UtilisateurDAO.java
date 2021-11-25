package be.helha.aemt.daojta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Adresse;
import be.helha.aemt.entities.Article;
import be.helha.aemt.entities.Commande;
import be.helha.aemt.entities.Utilisateur;
import be.helha.aemt.entities.Visiteur;

@Stateless
@LocalBean
public class UtilisateurDAO extends DAO< Utilisateur >
{
    @EJB
    private AdresseDAO adresseDAO;
    @EJB
    private ArticleDAO articleDAO;
    @EJB
    private CommandeDAO commandeDAO;
    
    /* 
     * Attention uniquement en RESOURCE_LOCAL
     * A modifier avec JTA
     */
    public UtilisateurDAO()
    {
    }
    
    public Utilisateur findByLogin( Utilisateur u )
    {
        if( u == null || u.getLogin() == null )
        {
            return null;
        }
        String loginQuery = "SELECT u FROM Utilisateur u WHERE u.login = :login";
        Query query = em.createQuery( loginQuery );
        query.setParameter( "login", u.getLogin() );
        List< Utilisateur > resultLogin = query.getResultList();
        return resultLogin.size() > 0 ? resultLogin.get(0) : null;
    }
    
    public List< Utilisateur > findByAddress( Adresse a )
    {
        if( a == null || a.getRue() == null || a.getNumero() == null || a.getVille() == null )
        {
            return null;
        }
        String loginQuery = "SELECT u FROM Utilisateur u WHERE u.adresse.rue = :rue AND "
                + "u.adresse.numero = :numero AND "
                + "u.adresse.ville = :ville AND "
                + "u.adresse.codePostal = :codePostal";
        Query query = em.createQuery( loginQuery );
        query.setParameter( "rue", a.getRue() );
        query.setParameter( "numero", a.getNumero() );
        query.setParameter( "ville", a.getVille() );
        query.setParameter( "codePostal", a.getCodePostal() );
        List< Utilisateur > resultAdresse = query.getResultList();
        /*em.clear();*/
        return resultAdresse;
    }
    
    public List< Utilisateur > findByPostalCode( int postalCode )
    {
        if( postalCode < 0 )
        {
            return null;
        }
        String loginQuery = "SELECT u FROM Utilisateur u WHERE u.adresse.codePostal = :codePostal";
        Query query = em.createQuery( loginQuery );
        query.setParameter( "codePostal", postalCode );
        List< Utilisateur > resultCodePostal = query.getResultList();
        /*em.clear();*/
        return resultCodePostal;
    }

    @Override
    public Utilisateur create( Utilisateur utilisateur )
    {
        if( findByLogin( utilisateur ) != null )
        {
            return null;
        }
        if( utilisateur == null )
        {
            return null;
        }
        if( utilisateur.getAdresse() == null )
        {
            return null;
        }
        Adresse tmpAdresse = adresseDAO.findByRueNumeroCodePostalVille( utilisateur.getAdresse() );
        if( tmpAdresse != null )
        {
            utilisateur.setAdresse( tmpAdresse );
        }
        Commande commande = new Commande( LocalDate.now() );
        for( Commande c : utilisateur.getCommandes() )
        {
            for( Article article : c.getArticles() )
            {
            	if( articleDAO.findArticleByLibelle( article ) != null )
            	{
            		commande.ajouterArticle( articleDAO.findArticleByLibelle( article ) );
            	}
            }
        }
        List< Commande > commandes = new ArrayList< Commande >();
        commandes.add( commande );
        utilisateur.setCommandes( commandes );
        em.persist( utilisateur );
        /*em.detach( utilisateur );*/ /* En RESSOURCE_LOCAL */
        return utilisateur;
    }

    @Override
    public Utilisateur read( Integer id )
    {
        if( id == null )
        {
            return null;
        }
        Utilisateur utilisateur = em.find( Utilisateur.class, id );
        if( utilisateur != null )
        {
            /*em.detach( utilisateur );*/
        }
        return utilisateur;
    }

    @Override
    public Utilisateur update( Utilisateur utilisateur1, Utilisateur utilisateur2 )
    {
        if( utilisateur1 == null || utilisateur2 == null )
        {
            return null;
        }
        if( utilisateur1.getId() == null )
        {
            return null;
        }
        Utilisateur tmp = read( utilisateur1.getId() );
        if( tmp == null )
        {
            return null;
        }
        tmp.setLogin( utilisateur2.getLogin() );
        tmp.setPassword( utilisateur2.getPassword() );
        tmp.setEmail( utilisateur2.getEmail() );
        em.merge( tmp );
        /*em.detach( tmp );*/
        return tmp;
    }

    @Override
    public Utilisateur delete( Utilisateur utilisateur )
    {
        if( utilisateur == null )
        {
            return null;
        }
        if( utilisateur.getId() == null )
        {
            return null;
        }
        Utilisateur tmp = em.find( Utilisateur.class, utilisateur.getId() );
        em.remove( tmp );
        /* em.detach( tmp ); PAS NECESSAIRE CAR remove gere LE detach */
        return tmp;
    }

    @Override
    public List< Utilisateur > findAll()
    {
        String loginQuery = "SELECT u FROM Utilisateur u";
        TypedQuery< Utilisateur > query = em.createQuery(loginQuery, Utilisateur.class );
        List< Utilisateur > resultAdresse = query.getResultList();
       
        return resultAdresse;
    }
}
