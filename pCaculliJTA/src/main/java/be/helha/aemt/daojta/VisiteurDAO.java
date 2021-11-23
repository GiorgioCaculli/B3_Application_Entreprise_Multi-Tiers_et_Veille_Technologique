package be.helha.aemt.daojta;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Utilisateur;
import be.helha.aemt.entities.Visiteur;

@Stateless
@LocalBean
public class VisiteurDAO extends DAO< Visiteur >
{

	public VisiteurDAO()
	{
	}
	
	public Visiteur findByIPAddress( Visiteur visiteur )
	{
		if( visiteur == null )
		{
			return null;
		}
        String loginQuery = "SELECT v FROM Visiteur WHERE v.login = :login";
        Query query = em.createQuery( loginQuery );
        query.setParameter( "login", visiteur.getAdresseIP() );
        List< Utilisateur > resultLogin = query.getResultList();
        return resultLogin.size() > 0 ? resultLogin.get(0) : null;
	}

	@Override
	public Visiteur create( Visiteur visiteur )
	{
		if( visiteur == null )
		{
			return null;
		}
        em.persist( visiteur );
        submit();
        em.detach( visiteur ); /* En RESSOURCE_LOCAL */
        return visiteur;
	}

	@Override
	public Visiteur read( Integer id )
	{
		return null;
	}

	@Override
	public Visiteur update( Visiteur visiteur1, Visiteur visiteur2 )
	{
		return null;
	}

	@Override
	public Visiteur delete( Visiteur visiter )
	{
		return null;
	}

	@Override
	public List< Visiteur > findAll()
	{
        String loginQuery = "SELECT v FROM Visiteur v";
        TypedQuery< Visiteur > query = em.createQuery( loginQuery, Visiteur.class );
        List< Visiteur > resultAdresse = query.getResultList();
        em.clear();
        return resultAdresse;
	}

}
