package be.helha.aemt.ejb;

import javax.ejb.Remote;

@Remote
public interface IBonjourRemoteEJB
{
	String bonjourDistant();
}
