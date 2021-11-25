package be.helha.aemt.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Article implements Serializable
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String libelle;
    private double prix;
    
    public Article( String libelle, double prix )
    {
        this.libelle = libelle;
        this.prix = prix;
    }
    
    public Article()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public String getLibelle()
    {
        return libelle;
    }

    public void setLibelle( String libelle )
    {
        this.libelle = libelle;
    }

    public double getPrix()
    {
        return prix;
    }

    public void setPrix( double prix )
    {
        this.prix = prix;
    }
    
    public String toString()
    {
        return String.format(
                "Article - ID: %d - Libelle: %s - Prix: %.2f",
                id, libelle, prix );
    }
    
    public boolean equals( Object o )
    {
        if( o instanceof Article )
        {
            Article tmp = ( Article ) o;
            return tmp.libelle.equalsIgnoreCase( libelle );
        }
        return false;
    }
}
