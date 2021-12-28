package be.helha.aemt.dao;

import be.helha.aemt.entities.Publication;
import be.helha.aemt.entities.Utilisateur;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Stateless
@LocalBean
public class UtilisateurDAO extends DAO< Utilisateur >
{
    public Utilisateur findUtilisateurByLogin( Utilisateur u )
    {
        if ( u == null || u.getLogin() == null )
        {
            return null;
        }
        String loginQuery = "SELECT u FROM Utilisateur u WHERE u.login = :login";
        Query query = em.createQuery( loginQuery );
        query.setParameter( "login", u.getLogin() );
        Utilisateur resultUtilisateur = null;
        try
        {
            resultUtilisateur = ( Utilisateur ) query.getSingleResult();
        } catch ( NoResultException nre )
        {
            nre.printStackTrace();
        }
        return resultUtilisateur;
    }

    @Override
    public Utilisateur create( Utilisateur utilisateur )
    {
        if ( findUtilisateurByLogin( utilisateur ) != null )
        {
            return null;
        }
        if ( utilisateur == null )
        {
            return null;
        }
        if ( utilisateur.getLogin() == null )
        {
            return null;
        }
        try
        {
            String passwordBase64 = new String( Base64.getEncoder().encode(
                    MessageDigest.getInstance( "SHA-256" )
                            .digest( utilisateur.getPassword().getBytes(
                                    StandardCharsets.UTF_8 ) ) ) );
            utilisateur.setPassword( passwordBase64 );
            em.persist( utilisateur );
            return  utilisateur;
        }
        catch ( Exception e )
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Utilisateur read( Integer id )
    {
        if ( id == null )
        {
            return null;
        }
        Utilisateur utilisateur = em.find( Utilisateur.class, id );
        if ( utilisateur != null )
        {
        }
        return utilisateur;
    }

    @Override
    public Utilisateur update( Utilisateur object1, Utilisateur object2 )
    {
        return super.update( object1, object2 );
    }

    @Override
    public Utilisateur delete( Utilisateur object )
    {
        return super.delete( object );
    }

    @Override
    public List< Utilisateur > findAll()
    {
        String loginQuery = "SELECT u FROM Utilisateur u";
        TypedQuery< Utilisateur > query = em.createQuery( loginQuery, Utilisateur.class );
        return query.getResultList();
    }
}
