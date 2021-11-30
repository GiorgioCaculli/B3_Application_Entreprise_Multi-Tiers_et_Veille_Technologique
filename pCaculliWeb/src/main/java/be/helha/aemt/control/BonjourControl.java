package be.helha.aemt.control;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named /* Par defaut bonjourControl */
@RequestScoped
public class BonjourControl
{
    public String doNext()
    {
        return "next";
    }
}
