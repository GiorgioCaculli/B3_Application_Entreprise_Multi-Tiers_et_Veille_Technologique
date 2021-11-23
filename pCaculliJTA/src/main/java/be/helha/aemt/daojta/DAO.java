package be.helha.aemt.daojta;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import be.helha.aemt.entities.Utilisateur;

@Stateless
@LocalBean
public class DAO< T > implements IDAO< T >
{
    @PersistenceContext
    protected EntityManager em;
    
    public DAO()
    {
        em = Persistence.createEntityManagerFactory( "pUUtilisateur" ).createEntityManager();
    }
    
    protected void submit()
    {
    }

    public void close()
    {
        em.close();
    }

    @Override
    public T create( T object )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T read( Integer id )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T update( T object1, T object2 )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T delete( T object )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List< T > findAll()
    {
        // TODO Auto-generated method stub
        return null;
    }
}
