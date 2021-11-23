package be.helha.aemt.daojta;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import be.helha.aemt.entities.Adresse;
import be.helha.aemt.entities.Article;
import be.helha.aemt.entities.Utilisateur;

@Stateless
@LocalBean
public class ArticleDAO extends DAO< Article >
{

    public ArticleDAO()
    {
    }
    
    public Article findArticleByLibelle( Article a )
    {
        if( a == null || a.getLibelle() == null )
        {
            return null;
        }
        String loginQuery = "SELECT a FROM Article a WHERE a.libelle = :libelle";
        Query query = em.createQuery( loginQuery );
        query.setParameter( "libelle", a.getLibelle() );
        Article resultArticle = null;
        try
        {
            resultArticle = ( Article ) query.getSingleResult();   
        }
        catch ( NoResultException nre ) {
        }
        return resultArticle;
    }

    @Override
    public Article create( Article article )
    {
        if( findArticleByLibelle( article ) != null )
        {
        	System.out.println("LIBELLE");
            return null;
        }
        if( article == null )
        {
        	System.out.println("NULL");
            return null;
        }
        if( article.getLibelle() == null )
        {
        	System.out.println("NO LIBELLE");
            return null;
        }
        em.persist( article );
        submit();
        em.detach( article ); /* En RESSOURCE_LOCAL */
        return article;
    }

    @Override
    public Article read( Integer id )
    {
        if( id == null )
        {
            return null;
        }
        Article article = em.find( Article.class, id );
        if( article != null )
        {
            em.detach( article );
        }
        return article;
    }

    @Override
    public Article delete( Article object )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Article update( Article object1, Article object2 )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List< Article > findAll()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
