package be.helha.aemt.ejb;

import be.helha.aemt.dao.PublicationDAO;
import be.helha.aemt.entities.Publication;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class PublicationEJB
{
    @EJB
    private PublicationDAO publicationDAO;

    public PublicationEJB()
    {
    }

    public List< Publication > getAllPublications()
    {
        return publicationDAO.findAll();
    }

    public Publication createPublication( String titre, int annee, double prix )
    {
        return publicationDAO.create( new Publication( titre, annee, prix ) );
    }

    public Publication getSpecificPublication( int id )
    {
        return publicationDAO.read( id );
    }
}
