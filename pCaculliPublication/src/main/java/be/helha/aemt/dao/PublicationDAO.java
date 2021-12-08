package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.helha.aemt.entities.Publication;

@Stateless
@LocalBean
public class PublicationDAO extends DAO< Publication >
{

    @Override
    public Publication create( Publication object )
    {
        // TODO Auto-generated method stub
        return super.create( object );
    }

    @Override
    public Publication read( Integer id )
    {
        // TODO Auto-generated method stub
        return super.read( id );
    }

    @Override
    public Publication update( Publication object1, Publication object2 )
    {
        // TODO Auto-generated method stub
        return super.update( object1, object2 );
    }

    @Override
    public Publication delete( Publication object )
    {
        // TODO Auto-generated method stub
        return super.delete( object );
    }

    @Override
    public List< Publication > findAll()
    {
        // TODO Auto-generated method stub
        return super.findAll();
    }
    
}
