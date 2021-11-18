package be.helha.aemt.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.ejb.IBonjourRemoteEJB;

public class MainClient
{
    public static void main( String[] args )
    {
        try
        {
            Context ctx = new InitialContext();
            IBonjourRemoteEJB bean=(IBonjourRemoteEJB) ctx.lookup("java:global/pCaculli/BonjourEJB!be.helha.aemt.ejb.IBonjourRemoteEJB");
            System.out.println( bean.bonjourDistant() );
        }
        catch ( NamingException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
