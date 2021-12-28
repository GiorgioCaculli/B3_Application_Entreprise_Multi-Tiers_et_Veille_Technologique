package be.helha.aemt.control;

import be.helha.aemt.ejb.UtilisateurEJB;
import be.helha.aemt.entities.Utilisateur;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@SessionScoped
public class UtilisateurControl implements Serializable
{
    @EJB
    private UtilisateurEJB utilisateurEJB;
    private Utilisateur utilisateur = new Utilisateur();

    public String showRegisterPage()
    {
        return "register.xhtml?faces-redirect=true";
    }

    public List< Utilisateur > showUtilisateurList()
    {
        return utilisateurEJB.getAllUtilisateurs();
    }

    public void createNewUtilisateur()
    {
        try
        {
            utilisateurEJB.createUtilisateur( utilisateur.getLogin(), utilisateur.getPassword(), utilisateur.getRole() );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }

    public Utilisateur getUtilisateur()
    {
        return utilisateur;
    }

    public void setUtilisateur( Utilisateur utilisateur )
    {
        this.utilisateur = utilisateur;
    }
}
