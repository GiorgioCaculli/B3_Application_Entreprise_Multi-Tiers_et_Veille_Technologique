package be.helha.aemt.ejb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.daojta.AdresseDAO;
import be.helha.aemt.daojta.ArticleDAO;
import be.helha.aemt.daojta.CommandeDAO;
import be.helha.aemt.daojta.DAO;
import be.helha.aemt.daojta.UtilisateurDAO;
import be.helha.aemt.daojta.VisiteurDAO;
import be.helha.aemt.entities.Adresse;
import be.helha.aemt.entities.Article;
import be.helha.aemt.entities.Commande;
import be.helha.aemt.entities.Compte;
import be.helha.aemt.entities.Utilisateur;

@Stateless
@LocalBean
public class GestionUtilisateurEJB implements IGestionUtilisateurEJB
{
    @EJB
    private UtilisateurDAO utilisateurDAO;
    @EJB
    private ArticleDAO articleDAO;
    @EJB
    private AdresseDAO adresseDAO;
    @EJB
    private CommandeDAO commandeDAO;
    @EJB
    private VisiteurDAO visiteurDAO;
    
    public GestionUtilisateurEJB()
    {
    }

    @Override
    public List< Utilisateur > findAllUtilisateurs()
    {
        return utilisateurDAO.findAll();
    }

    @Override
    public Utilisateur createUtilisateur( Utilisateur utilisateur )
    {
        return utilisateurDAO.create( utilisateur );
    }

    @Override
    public List< Article > findAllArticles()
    {
        return articleDAO.findAll();
    }

    @Override
    public Article createArticle( Article article )
    {
        return articleDAO.create( article );
    }
    
    
}
