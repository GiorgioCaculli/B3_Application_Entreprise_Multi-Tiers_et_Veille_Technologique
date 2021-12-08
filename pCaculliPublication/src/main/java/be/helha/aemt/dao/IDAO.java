package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

public interface IDAO< T >
{
    T create( T object );
    
    T read( Integer id );
    
    T update( T object1, T object2 );
    
    T delete( T object );
    
    List< T > findAll();
}
