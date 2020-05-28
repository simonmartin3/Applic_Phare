/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Classes.Persistance;
import static Classes.Persistance.getPathConfig;
import Interfaces.*;
import java.beans.*;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Simon
 */
public class KindOfBoatBean implements UtilisateurNombre{
    
    private ThreadRandomGenerator TRG;
    private String oldType;
    private String typeBateau;
    protected PropertyChangeSupport PCS;
    Properties properties;
    
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
        try {
            properties = Persistance.LoadProperties(getPathConfig());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
        StringTokenizer st = new StringTokenizer(properties.get("reference").toString(), "-");
        
        int plaisance = Integer.parseInt(st.nextToken());
        int peche = Integer.parseInt(st.nextToken());
        
        
        if((n % plaisance) == 0)
        {
            setTypeBateau("Plaisance");
            typeBateau="none";
        }
        if((n % peche) == 0)
        {
            setTypeBateau("Peche");
            typeBateau="none";
        }
    }    
}