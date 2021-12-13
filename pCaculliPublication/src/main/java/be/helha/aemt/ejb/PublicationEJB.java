package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.PublicationDAO;
import be.helha.aemt.entities.Publication;

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
}
