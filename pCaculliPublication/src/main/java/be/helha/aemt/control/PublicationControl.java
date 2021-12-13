package be.helha.aemt.control;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.PublicationEJB;
import be.helha.aemt.entities.Publication;

@Named
@SessionScoped
public class PublicationControl implements Serializable
{
    @EJB
    private PublicationEJB publicationEJB;
    
    public String showListPage()
    {
        return "listePublications";
    }
    
    public String showAddPage()
    {
        return "ajoutPublication";
    }
    
    public String showList()
    {
        StringBuilder sb = new StringBuilder();
        
        for( Publication publication : publicationEJB.getAllPublications() )
        {
            sb.append( "<li>" ).append( publication ).append( "</li>" );
        }
        
        return sb.toString();
    }
}
