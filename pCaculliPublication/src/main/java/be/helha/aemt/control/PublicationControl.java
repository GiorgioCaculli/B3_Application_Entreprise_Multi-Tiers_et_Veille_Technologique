package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
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
        return "listePublications.xhtml?faces-redirect=true";
    }
    
    public String showAddPage()
    {
        return "ajoutPublication.xhtml?faces-redirect=true";
    }
    
    public List< Publication > showList()
    {
        return publicationEJB.getAllPublications();
    }
    
    @PostConstruct
    public void createNewPublication()
    {
        try
        {
            Map< String, String > requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            String titre = requestParams.get( "titre" );
            int annee = Integer.parseInt( requestParams.get( "annee" ) );
            double prix = Double.parseDouble( requestParams.get( "prix" ) );
            
            System.out.println( publicationEJB.createPublication( titre, annee, prix ) );
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
