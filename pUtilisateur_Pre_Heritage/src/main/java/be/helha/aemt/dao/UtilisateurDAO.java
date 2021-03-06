package be.helha.aemt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import be.helha.aemt.entities.Adresse;
import be.helha.aemt.entities.Commande;
import be.helha.aemt.entities.Utilisateur;

public class UtilisateurDAO extends DAO< Utilisateur >
{
    private AdresseDAO adresseDAO;
    private CommandeDAO commandeDAO;
    
    /* 
     * Attention uniquement en RESOURCE_LOCAL
     * A modifier avec JTA
     */
    public UtilisateurDAO( String dbName )
    {
        super( dbName );
        adresseDAO = new AdresseDAO( dbName );
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
        Utilisateur resultLogin = null;
        try
        {
            resultLogin = ( Utilisateur ) query.getResultList().get( 0 );   
        }
        catch ( NoResultException nre ) {
        }
        return resultLogin;
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
        em.clear();
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
        em.clear();
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
        em.persist( utilisateur );
        submit();
        em.detach( utilisateur ); /* En RESOURCE_LOCAL */
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
            em.detach( utilisateur );
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
        submit();
        em.detach( tmp );
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
        submit();
        /* em.detach( tmp ); PAS NECESSAIRE CAR remove gere LE detach */
        return tmp;
    }

    @Override
    public List< Utilisateur > findAll()
    {
        return null;
    }
}
