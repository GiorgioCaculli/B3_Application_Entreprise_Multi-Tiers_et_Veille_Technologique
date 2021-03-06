package be.helha.aemt.util;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.sessions.coordination.Command;

import be.helha.aemt.dao.AdresseDAO;
import be.helha.aemt.dao.ArticleDAO;
import be.helha.aemt.dao.CommandeDAO;
import be.helha.aemt.dao.DAO;
import be.helha.aemt.dao.IDAO;
import be.helha.aemt.dao.UtilisateurDAO;
import be.helha.aemt.dao.VisiteurDAO;
import be.helha.aemt.entities.Adresse;
import be.helha.aemt.entities.Article;
import be.helha.aemt.entities.Commande;
import be.helha.aemt.entities.Compte;
import be.helha.aemt.entities.Utilisateur;
import be.helha.aemt.entities.Visiteur;

public class MainUtilisateurs
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        String baseInfo = String.format( "%d", System.currentTimeMillis() % 1000 );
        
        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory( "pUUtilisateur" );
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();*/
        
        /*Compte c1 = new Compte( "C" + baseInfo );
        Adresse a1 = new Adresse( "R" + baseInfo, "N" + baseInfo, "V" + baseInfo, Integer.parseInt( baseInfo ) );
        Random randPrix = new Random();
        Article ar1 = new Article( "Banana", randPrix.nextDouble() );
        Article ar2 = new Article( "Pera", randPrix.nextDouble() );
        Article ar3 = new Article( "Penna", randPrix.nextDouble() );
        Article ar4 = new Article( "Cocomero", randPrix.nextDouble() );
        Commande co1 = new Commande( LocalDate.now() );
        Commande co2 = new Commande( LocalDate.now() );
        co1.ajouterArticle( ar1 );
        co1.ajouterArticle( ar2 );
        co1.ajouterArticle( ar3 );
        co1.ajouterArticle( ar4 );
        co2.ajouterArticle( ar3 );*/
        
        String tousLesArticlesQuery = "SELECT a FROM Article a";
        
        /*Query query = em.createQuery( tousLesArticlesQuery );
        
        
        List< Article > resultArticles = query.getResultList();
        for( Article article : resultArticles )
        {
            System.out.println( article );
        }
        
        String adresseCodePostaleQuery = "SELECT a FROM Adresse a WHERE a.codePostal = :codePostal";
        query = em.createQuery( adresseCodePostaleQuery );
        query.setParameter( "codePostal", 491 );
        
        List< Adresse > resultAdresses = query.getResultList();
        for( Adresse adresse : resultAdresses )
        {
            System.out.println( adresse );
        }
        
        //String utilisateurCodePostalQuery = "SELECT u FROM Utilisateur u INNER JOIN u.adresse a WHERE a.codePostal = :codePostal";
        String utilisateurCodePostalQuery = "SELECT u FROM Utilisateur u WHERE u.adresse.codePostal = :codePostal";
        query = em.createQuery( utilisateurCodePostalQuery );
        query.setParameter( "codePostal", 491 );
        
        List< Utilisateur > resultUtilisateurCodePostal = query.getResultList();
        for( Utilisateur utilisateur : resultUtilisateurCodePostal )
        {
            System.out.println( utilisateur );
        }
        
        //rechercher les commandes qui contiennent un article de libelle donne
        String commandeLibelleQuery = "SELECT c FROM Commande c INNER JOIN c.articles a WHERE a.libelle = :libelle";
        query = em.createQuery( commandeLibelleQuery );
        query.setParameter( "libelle", "Penna" );
        
        List< Commande > resultsCommandeLibelle = query.getResultList();
        for( Commande commande : resultsCommandeLibelle )
        {
            System.out.println( commande );
        }*/
        
        //Pas de doublons dans le login
        
        //em.persist( c1 );
        
        /*Utilisateur u1 = new Utilisateur( "127.0.0.1", String.format( "L%s", baseInfo ), String.format( "P%s", baseInfo ), String.format( "E%s", baseInfo ), c1, a1 );
        u1.ajouterCommande( co1 );
        Visiteur v1 = new Visiteur( "185.212.226.76" );*/
        
        //em.persist( u1 );
        
        //tx.begin();
        //tx.commit();
        
        //em.close();
        //emf.close();

        /*System.out.println( u1 );*/
        
        String dbName = "pUUtilisateur";
        
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO( dbName );
        ArticleDAO articleDAO = new ArticleDAO( dbName );
        AdresseDAO adresseDAO = new AdresseDAO( dbName );
        CommandeDAO commandeDAO = new CommandeDAO( dbName );
        VisiteurDAO visiteurDAO = new VisiteurDAO(dbName);
        
        Article caculliArticle = new Article( "CACULLI", 0.10 );
        /*System.out.println( articleDAO.create( caculliArticle ) );*/
        
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
        
        /*System.out.println( utilisateurDAO.create( caculliUtilisateur1 ) );
        System.out.println( utilisateurDAO.create( caculliUtilisateur2 ) );*/
        
        
        //u1 = utilisateurDAO.read( 19 );

        /* C.R.U.D. */

        /* CREATE */
        /*System.out.println( "CREATE: " + utilisateurDAO.create( u1 ) );
        System.out.println( "CREATE: " + visiteurDAO.create( v1 ) );
        
        System.out.println( "Find Visiteur" );
        System.out.println( visiteurDAO.findAll() );
        System.out.println( "Find Utilisateur" );
        System.out.println( utilisateurDAO.findAll() );*/
        
        /*Utilisateur u3 = new Utilisateur( String.format( "L%s", baseInfo ), String.format( "P%s", baseInfo ), String.format( "E%s", baseInfo ), c1, a1 );
        System.out.println( udao.create( u3 ) );*/
        
        /* READ */
        /*Utilisateur u2 = utilisateurDAO.read( u1.getId() );
        //Utilisateur u2 = new Utilisateur( "LProb", "PProb", "EProb", u1.getCompte() );
        System.out.println( "READ: " + u2 );
        a1 = adresseDAO.read( 10 );
        Utilisateur testAdresse = new Utilisateur( "127.0.0.1", "TestLogin4", "TestPassword4", "TestEmail4", c1, a1 );
        utilisateurDAO.create( testAdresse );*/
        
        /* UPDATE */
        /*baseInfo = String.format( "%d", System.currentTimeMillis() % 1000 );
        u2.setLogin( "LModif" + baseInfo );
        u2.setPassword( "PModif" + baseInfo );
        u2.setEmail( "EModif" + baseInfo );
        u2.ajouterCommande( co2 );
        utilisateurDAO.update( u1, u2 );
        System.out.println( "UPDATE: " + utilisateurDAO.read( u2.getId() ) );*/
        
        /* DELETE */
        //udao.delete( udao.read( u1.getId() ) );
        
        /*System.out.println( "Find by Login" );
        Utilisateur u10 = utilisateurDAO.findByLogin( u2 );
        System.out.println( u10 );
        
        System.out.println( "Find by Address" );
        List< Utilisateur > findByAddress = utilisateurDAO.findByAddress( a1 );
        System.out.println( findByAddress );
        
        System.out.println( "Find by Code Postal" );
        List< Utilisateur > findByCodePostal = utilisateurDAO.findByPostalCode( a1.getCodePostal() );
        System.out.println( findByCodePostal );
        
        System.out.println( "Find Utilisateur by Adresse" );
        Adresse u14 = adresseDAO.findAdresseByUtilisateur( u2 );
        System.out.println( u14 );
        
        System.out.println( "Find Commandes By Utilisateur" );
        u10.ajouterCommande( co2 );
        List< Commande > commandes = commandeDAO.findCommandesByUtilisateur( u10 );
        System.out.println( commandes );
        
        System.out.println( "Find Commandes by Article" );
        List< Commande > commandesArticle = commandeDAO.findCommandeByArticle( ar3 );
        System.out.println( commandesArticle );
        
        System.out.println( "Find Articles by Utilisateur" );
        List< Article > articlesUtilisateur = commandeDAO.findArticlesByUtilisateurLogin( u10 );
        System.out.println( articlesUtilisateur );
        
        System.out.println( "Find Articles by Utilisateur" );
        List< Article > articlesCodePostal = commandeDAO.findArticlesByCodePostal( u2.getAdresse().getCodePostal() );
        System.out.println( articlesCodePostal );*/
        
        DAO.close();
    }
}
