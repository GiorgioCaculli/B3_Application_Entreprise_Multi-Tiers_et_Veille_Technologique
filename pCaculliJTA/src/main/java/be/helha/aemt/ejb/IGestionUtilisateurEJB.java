package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Article;
import be.helha.aemt.entities.Utilisateur;

@Remote
public interface IGestionUtilisateurEJB
{
    List< Utilisateur > findAllUtilisateurs();
    Utilisateur createUtilisateur( Utilisateur utilisateur );
    List< Article > findAllArticles();
    Article createArticle( Article article );
}
