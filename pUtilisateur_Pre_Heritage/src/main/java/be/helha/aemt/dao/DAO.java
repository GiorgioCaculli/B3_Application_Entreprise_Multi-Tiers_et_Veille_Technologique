package be.helha.aemt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import be.helha.aemt.entities.Utilisateur;

public abstract class DAO< T > implements IDAO< T >
{
    private static EntityManagerFactory emf;
    protected static EntityManager em;
    private static EntityTransaction tx;
    
    public DAO( String dbName )
    {
        /* Eviter de creer plusieurs emf */
        emf = Persistence.createEntityManagerFactory( dbName ); 
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }
    
    protected static void submit()
    {
        tx.begin();
        tx.commit();
    }

    public static void close()
    {
        em.close();
        emf.close();
    }
}
