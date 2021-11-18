package be.helha.aemt.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class BonjourEJB implements IBonjourRemoteEJB
{
    @EJB
    private BonjourLocalEJB bonjourLocalEJB;

    public String bonjourDistant()
    {
        return bonjourLocalEJB.bonjourLocal();
    }
}
