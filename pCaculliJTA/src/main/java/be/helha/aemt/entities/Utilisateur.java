package be.helha.aemt.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;

@Entity
public class Utilisateur extends Visiteur implements Serializable
{
	/*
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;
    */
    private String login;
    private String password;
    private String email;
    
    @OneToOne( cascade = { CascadeType.PERSIST, CascadeType.REMOVE } )
    /*@JoinColumn( name = "COMPTE_ID", referencedColumnName = "ID" ) // PAS NECESSAIRE */
    private Compte compte;
    
    @ManyToOne( cascade = { CascadeType.PERSIST } )
    private Adresse adresse;
    
    @OneToMany( cascade = { CascadeType.PERSIST, CascadeType.REMOVE } )
    private List< Commande > commandes;
    
    public Utilisateur( String adresseIP, String login, String password, String email, Compte compte, Adresse adresse )
    {
    	super( adresseIP );
        this.login = login;
        this.password = password;
        this.email = email;
        this.compte = compte;
        this.adresse = adresse;
        commandes = new ArrayList< Commande >();
    }

    public Utilisateur( String adresseIP, String login, String password, String email, Compte compte )
    {
        this( adresseIP, login, password, email, compte, new Adresse() );
    }

    public Utilisateur( String adresseIP, String login, String password, String email )
    {
        this( adresseIP, login, password, email, new Compte() );
    }

    public Utilisateur()
    {
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin( String login )
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }
    
    public Compte getCompte()
    {
        return compte;
    }
    
    public Adresse getAdresse()
    {
        return adresse;
    }
    
    public void setAdresse( Adresse adresse )
    {
        this.adresse = adresse;
    }
    
    public boolean ajouterCommande( Commande commande )
    {
        if( commande == null )
        {
            return false;
        }
        if( commandes.contains( commande ) )
        {
            return false;
        }
        return commandes.add( commande );
    }
    
    public void setCommandes( List< Commande > commandes )
    {
        this.commandes = commandes;
    }
    
    public List< Commande > getCommandes()
    {
        return commandes;
    }

    @Override
    public String toString()
    {
        return String.format(
                "%s - Login: %s - Email: %s - Password: %s\nCompte: %s\nAdresse: %s\n",
                super.toString(), login, email, password, compte, adresse );
    }
}
