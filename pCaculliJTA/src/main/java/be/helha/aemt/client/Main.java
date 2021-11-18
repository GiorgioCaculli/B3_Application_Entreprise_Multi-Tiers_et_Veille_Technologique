package be.helha.aemt.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Main
{

    public static void main( String[] args )
    {
        try
        {
            Context ctx = new InitialContext();
        }
        catch ( NamingException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
