package be.helha.aemt.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Commande implements Serializable
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;
    private LocalDate date;
    @ManyToMany( cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER )
    private List< Article > articles;
    
    public Commande( LocalDate date )
    {
        this.date = date;
        articles = new ArrayList< Article >();
    }
    
    public Commande()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate( LocalDate date )
    {
        this.date = date;
    }
    
    public boolean ajouterArticle( Article a )
    {
        if( a == null )
        {
            return false;
        }
        if( articles.contains( a ) )
        {
            return false;
        }
        return articles.add( a );
    }

    public List< Article > getArticles()
    {
        return articles;
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "Commande - " ).append( "ID: " + id + "\n" );
        for( Article article : articles )
        {
            sb.append( article ).append( "\n" );
        }
        return sb.toString();
    }
    
    public boolean equals( Object o )
    {
        if( o instanceof Commande )
        {
            Commande tmp = ( Commande ) o;
            return tmp.id.equals( id );
        }
        return false;
    }
}
