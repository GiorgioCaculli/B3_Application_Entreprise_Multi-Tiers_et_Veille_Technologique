package be.helha.aemt.ejb;

import be.helha.aemt.dao.UtilisateurDAO;
import be.helha.aemt.entities.Utilisateur;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class UtilisateurEJB
{
    @EJB
    private UtilisateurDAO utilisateurDAO;

    public UtilisateurEJB()
    {
    }

    public List< Utilisateur > getAllUtilisateurs()
    {
        return utilisateurDAO.findAll();
    }

    public Utilisateur createUtilisateur( String login, String password, String role )
    {
        return utilisateurDAO.create( new Utilisateur( login, password, role ) );
    }
}
