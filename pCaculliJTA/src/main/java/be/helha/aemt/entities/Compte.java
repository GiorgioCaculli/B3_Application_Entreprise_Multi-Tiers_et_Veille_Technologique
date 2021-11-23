package be.helha.aemt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

@Entity
public class Compte
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;
    private String numero;
    
    public Compte( String numero )
    {
        this.numero = numero;
    }
    
    public Compte()
    {
        this.numero = String.format( "C%d", id );
    }
    
    public Integer getID()
    {
        return id;
    }
    
    public String getNumero()
    {
        return numero;
    }
    
    public void setNumero( String numero )
    {
        this.numero = numero;
    }
    
    public String toString()
    {
        return String.format( "Compte - ID: %d - Numero: %s", id, numero );
    }
    
    public boolean equals( Object o )
    {
        if( o instanceof Compte )
        {
            Compte tmp = ( Compte ) o;
            return tmp.id.equals( id );
        }
        return false;
    }
}
