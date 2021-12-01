package be.helha.aemt.control;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named /* Par defaut bonjourControl */
@SessionScoped
public class BonjourControl implements Serializable
{
    private String nom;
    
    public String doNext()
    {
        return "next";
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
