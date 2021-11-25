package be.helha.aemt.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse implements Serializable
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;
    private String rue;
    private String numero;
    private String ville;
    private int codePostal;
    
    public Adresse( String rue, String numero, String ville, int codePostal )
    {
        this.rue = rue;
        this.numero = numero;
        this.ville = ville;
        this.codePostal = codePostal;
    }
    
    public Adresse()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public String getRue()
    {
        return rue;
    }

    public void setRue( String rue )
    {
        this.rue = rue;
    }

    public String getNumero()
    {
        return numero;
    }

    public void setNumero( String numero )
    {
        this.numero = numero;
    }

    public String getVille()
    {
        return ville;
    }

    public void setVille( String ville )
    {
        this.ville = ville;
    }

    public int getCodePostal()
    {
        return codePostal;
    }

    public void setCodePostal( int codePostal )
    {
        this.codePostal = codePostal;
    }
    
    public String toString()
    {
        return String.format(
                "Adresse - ID: %d - Rue: %s - Numero: %s - Ville: %s - Code postal: %d",
                id, rue, numero, ville, codePostal );
    }
}
