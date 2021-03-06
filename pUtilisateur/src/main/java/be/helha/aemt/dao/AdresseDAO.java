package be.helha.aemt.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import be.helha.aemt.entities.Adresse;
import be.helha.aemt.entities.Utilisateur;

public class AdresseDAO extends DAO< Adresse >
{

    public AdresseDAO( String dbName )
    {
        super( dbName );
    }
    
    public Adresse findByRueNumeroCodePostalVille( Adresse a )
    {
        if( a == null || a.getRue() == null || a.getNumero() == null || a.getVille() == null )
        {
            return null;
        }
        String loginQuery = "SELECT a FROM Adresse a WHERE a.rue = :rue AND a.numero = :numero AND a.codePostal = :codePostal AND a.ville = :ville";
        Query query = em.createQuery( loginQuery );
        query.setParameter( "rue", a.getRue() );
        query.setParameter( "numero", a.getNumero() );
        query.setParameter( "codePostal", a.getCodePostal() );
        query.setParameter( "ville", a.getVille() );
        Adresse resultAdresse = null;
        try
        {
            resultAdresse = ( Adresse ) query.getSingleResult();   
        }
        catch ( NoResultException nre ) {
        }
        return resultAdresse;
    }
    
    public Adresse findAdresseByUtilisateur( Utilisateur u )
    {
        if( u == null || u.getLogin() == null )
        {
            return null;
        }
        String loginQuery = "SELECT u.adresse FROM Utilisateur u WHERE u.login = :login";
        Query query = em.createQuery( loginQuery );
        query.setParameter( "login", u.getLogin() );
        Adresse resultAdresse = null;
        try
        {
            resultAdresse = ( Adresse ) query.getSingleResult();
        }
        catch( NoResultException nre )
        {
        }
        em.clear();
        return resultAdresse;
    }

    @Override
    public Adresse create( Adresse adresse )
    {
        if( findByRueNumeroCodePostalVille( adresse ) != null )
        {
            return null;
        }
        if( adresse == null )
        {
            return null;
        }
        if( adresse.getRue() == null || adresse.getVille() == null || adresse.getCodePostal() < 0 )
        {
            return null;
        }
        em.persist( adresse );
        submit();
        em.detach( adresse ); /* En RESSOURCE_LOCAL */
        return adresse;
    }

    @Override
    public Adresse read( Integer id )
    {
        if( id == null )
        {
            return null;
        }
        Adresse adresse = em.find( Adresse.class, id );
        if( adresse != null )
        {
            em.detach( adresse );
        }
        return adresse;
    }

    @Override
    public Adresse update( Adresse adresse1, Adresse adresse2 )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Adresse delete( Adresse adresse )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List< Adresse > findAll()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
