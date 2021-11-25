package be.helha.aemt.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Visiteur implements Serializable
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;
    private String adresseIP;

    public Visiteur(String adresseIP)
    {
		super();
		this.adresseIP = adresseIP;
	}
    
    public Visiteur()
    {
    }

	public Integer getId()
    {
        return id;
    }
	
	public String getAdresseIP()
	{
		return adresseIP;
	}
	
	public void setAdresseIP( String adresseIP )
	{
		this.adresseIP = adresseIP;
	}

    @Override
    public String toString()
    {
        return String.format(
                "ID: %d - Adresse IP: %s\n",
                id, adresseIP );
    }
}
