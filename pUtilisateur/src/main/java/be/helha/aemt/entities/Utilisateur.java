package be.helha.aemt.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;

@Entity
public class Utilisateur
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;
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
    
    public Utilisateur( String login, String password, String email, Compte compte, Adresse adresse )
    {
        this.login = login;
        this.password = password;
        this.email = email;
        this.compte = compte;
        this.adresse = adresse;
        commandes = new ArrayList< Commande >();
    }

    public Utilisateur( String login, String password, String email, Compte compte )
    {
        this( login, password, email, compte, new Adresse() );
    }

    public Utilisateur( String login, String password, String email )
    {
        this( login, password, email, new Compte() );
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

    public Integer getId()
    {
        return id;
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
                "ID: %d - Login: %s - Email: %s - Password: %s\nCompte: %s\nAdresse: %s",
                id, login, email, password, compte, adresse );
    }
}
