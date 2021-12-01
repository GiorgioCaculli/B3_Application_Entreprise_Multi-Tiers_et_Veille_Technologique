package be.helha.aemt.control;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class EndControl
{
    @Inject
    private BonjourControl bControl;
    
    private String nom;
    
    public String doEnd()
    {
        nom = bControl.getNom();
        return "end";
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom( String nom )
    {
        this.nom = nom;
    }
}
