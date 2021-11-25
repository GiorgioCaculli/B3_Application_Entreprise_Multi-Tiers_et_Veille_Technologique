package be.helha.aemt.client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.ejb.IGestionUtilisateurEJB;
import be.helha.aemt.entities.Adresse;
import be.helha.aemt.entities.Article;
import be.helha.aemt.entities.Commande;
import be.helha.aemt.entities.Compte;
import be.helha.aemt.entities.Utilisateur;

public class Main
{

    public static void main( String[] args )
    {
        try
        {
            Article caculliArticle = new Article( "CACULLI", 0.10 );
            
            Adresse caculliAdresse = new Adresse( "CACULLI", "12", "CACULLI", 7000 );
            
            Compte caculliCompte1 = new Compte( "CACULLI" );
            Compte caculliCompte2 = new Compte( "CACULLI_GIORGIO" );
            
            Utilisateur caculliUtilisateur1 = new Utilisateur( "127.0.0.1", "CACULLI", "CACULLI-PASSWORD", "CACULLI@EMAIL.COM", caculliCompte1, caculliAdresse );
            Utilisateur caculliUtilisateur2 = new Utilisateur( "127.0.0.1", "CACULLI_GIORGIO", "CACULLI_GIORGIO_PASSWORD", "CACULLI_GIORGIO@EMAIL.COM", caculliCompte2, caculliAdresse );
            
            Commande caculliCommande = new Commande( LocalDate.now() );
            caculliCommande.ajouterArticle( caculliArticle );
            
            List< Commande > caculliCommandes = new ArrayList< Commande >();
            
            caculliCommandes.add( caculliCommande );
            
            caculliUtilisateur1.setCommandes( caculliCommandes );
            caculliUtilisateur2.setCommandes( caculliCommandes );
            
            Context ctx = new InitialContext();
            IGestionUtilisateurEJB bean=(IGestionUtilisateurEJB) ctx.lookup("java:global/pCaculliJTA/GestionUtilisateurEJB!be.helha.aemt.ejb.IGestionUtilisateurEJB");
            System.out.println( bean.findAllArticles() );
            System.out.println( bean.createArticle( caculliArticle ) );
            System.out.println( bean.findAllUtilisateurs() );
            System.out.println( bean.createUtilisateur( caculliUtilisateur1 ) );
            System.out.println( bean.createUtilisateur( caculliUtilisateur2 ) );
        }
        catch ( NamingException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
