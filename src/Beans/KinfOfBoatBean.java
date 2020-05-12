/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Interfaces.*;
import java.beans.*;

/**
 *
 * @author Simon
 */
public class KinfOfBoatBean implements UtilisateurNombre{
    
    private ThreadRandomGenerator TRG;
    private int nbreRandom;
    private int oldNbreRandom;
    private String typeBateau;
    protected PropertyChangeSupport PCS = new PropertyChangeSupport(this);
    
    public void KinfOfBoatBean()
    {
        TRG.start();
    }
    
    public void addPropertyChangeListener(PropertyChangeListener pcl)
    {
        PCS.addPropertyChangeListener(pcl);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener pcl)
    {
        PCS.removePropertyChangeListener(pcl);
    }
    
    public void setTypeBateau(String newType)
    {
        String oldType;
        if(oldNbreRandom != nbreRandom)
        {
            oldType = this.typeBateau;
            this.typeBateau = newType;
            PCS.firePropertyChange("typeBateau", oldType, this.typeBateau);
        }
    }
    
    public String getIdentifiant()
    {
        return this.toString();
    }
    
    public void traiteNombre(int n)
    {
        oldNbreRandom = this.nbreRandom;
        nbreRandom = n;
        
        if((n % 7) == 0)
        {
            setTypeBateau("Plaisance");
        }
        if((n % 17) == 0)
        {
            setTypeBateau("Peche");
        }
    }
    
}
