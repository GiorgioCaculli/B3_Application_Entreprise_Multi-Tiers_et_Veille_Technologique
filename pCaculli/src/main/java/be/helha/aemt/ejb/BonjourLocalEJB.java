package be.helha.aemt.ejb;

import javax.ejb.Stateless;

@Stateless
public class BonjourLocalEJB
{	
	public String bonjourLocal()
	{
		return "Hello Local";
	}
}
