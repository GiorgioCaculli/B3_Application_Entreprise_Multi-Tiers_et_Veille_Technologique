package be.helha.aemt.ejb;

import javax.ejb.Stateless;

@Stateless
public class BonjourEJB implements IBonjourRemoteEJB
{
	private BonjourLocalEJB bonjourLocalEJB;

	@Override
	public String bonjourDistant()
	{
		return bonjourLocalEJB.bonjourLocal();
	}
}
