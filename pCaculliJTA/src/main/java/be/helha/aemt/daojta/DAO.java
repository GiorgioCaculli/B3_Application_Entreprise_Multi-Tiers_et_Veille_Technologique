package be.helha.aemt.daojta;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
@LocalBean
public class DAO< T > implements IDAO< T >
{
    @PersistenceContext(unitName = "pUUtilisateur")
    protected EntityManager em;
    
    public DAO()
    {
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
