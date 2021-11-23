package be.helha.aemt.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.ejb.IGestionUtilisateurEJB;

public class Main
{

    public static void main( String[] args )
    {
        try
        {
            Context ctx = new InitialContext();
            IGestionUtilisateurEJB bean=(IGestionUtilisateurEJB) ctx.lookup("java:global/pCaculliJTA/GestionUtilisateurEJB!be.helha.aemt.ejb.IGestionUtilisateurEJB");
            System.out.println( bean.init() );
        }
        catch ( NamingException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
