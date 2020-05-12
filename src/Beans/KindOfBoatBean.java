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
public class KindOfBoatBean implements UtilisateurNombre{
    
    private ThreadRandomGenerator TRG;
    private String oldType;
    private String typeBateau;
    protected PropertyChangeSupport PCS;
    
    public void KindOfBoatBean()
    {

    }
    
    public void KindOfBoatBean(ThreadRandomGenerator tmp)
    {
        TRG = tmp;
        TRG.start();
        PCS = new PropertyChangeSupport(this);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener pcl)
    {
        PCS.addPropertyChangeListener(pcl);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener pcl)
    {
        PCS.removePropertyChangeListener(pcl);
    }
    
    public void setTypeBateau(String type)
    {
        oldType = this.typeBateau;

        this.typeBateau = type;
        PCS.firePropertyChange("typeBateau", oldType, this.typeBateau);
    }
    
    public String getIdentifiant()
    {
        return this.toString();
    }
    
    public void traiteNombre(int n)
    {        
        if((n % 7) == 0)
        {
            setTypeBateau("Plaisance");
            typeBateau="none";
        }
        if((n % 17) == 0)
        {
            setTypeBateau("Peche");
            typeBateau="none";
        }
    }    
}