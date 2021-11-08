package be.helha.aemt.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import be.helha.aemt.entities.Adresse;
import be.helha.aemt.entities.Article;
import be.helha.aemt.entities.Commande;
import be.helha.aemt.entities.Utilisateur;

public class CommandeDAO extends DAO< Commande >
{
    private ArticleDAO articleDAO;

    public CommandeDAO( String dbName )
    {
        super( dbName );
        articleDAO = new ArticleDAO( dbName );
    }
    
    public List< Commande > findCommandesByUtilisateur( Utilisateur u )
    {
        if( u == null || u.getLogin() == null )
        {
            return null;
        }
        String loginQuery = "SELECT u.commandes FROM Utilisateur u WHERE u.login = :login";
        Query query = em.createQuery( loginQuery );
        query.setParameter( "login", u.getLogin() );
        List< Commande > resultAdresse = query.getResultList();
        em.clear();
        return resultAdresse;
    }
    
    public List< Commande > findCommandeByArticle( Article a )
    {
        if( a == null || a.getLibelle() == null )
        {
            return null;
        }
        String loginQuery = "SELECT c FROM Commande c INNER JOIN c.articles a WHERE a.libelle = :libelle";
        Query query = em.createQuery( loginQuery );
        query.setParameter( "libelle", a.getLibelle() );
        List< Commande > resultAdresse = query.getResultList();
        em.clear();
        return resultAdresse;
    }
    
    public List< Article > findArticlesByUtilisateurLogin( Utilisateur u )
    {
        if( u == null || u.getLogin() == null )
        {
            return null;
        }
        String loginQuery = "SELECT a FROM Utilisateur u JOIN u.commandes c, c.articles a WHERE u.login = :login";
        Query query = em.createQuery( loginQuery );
        query.setParameter( "login", u.getLogin() );
        List< Article > articles = query.getResultList();
        em.clear();
        return articles;
    }
    
    public List< Article > findArticlesByCodePostal( int codePostal )
    {
        if( codePostal < 0 )
        {
            return null;
        }
        String loginQuery = "SELECT a FROM Utilisateur u JOIN u.commandes c, c.articles a WHERE u.adresse.codePostal = :codePostal";
        Query query = em.createQuery( loginQuery );
        query.setParameter( "codePostal", codePostal );
        List< Article > articles = query.getResultList();
        em.clear();
        return articles;
    }

    @Override
    public Commande create( Commande commande )
    {
        if( commande == null )
        {
            return null;
        }
        for( Article a : commande.getArticles() )
        {
        	if( findCommandeByArticle( a ).size() < 0 )
        	{
        		return null;
        	}
        }
        List< Article > articles = commande.getArticles();
        for( Article a : articles )
        {
        	commande.ajouterArticle( articleDAO.findArticleByLibelle( a ) );
        }
        em.persist( commande );
        submit();
        em.clear();
        return null;
    }

    @Override
    public Commande read( Integer id )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Commande update( Commande object1, Commande object2 )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Commande delete( Commande object )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List< Commande > findAll()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
