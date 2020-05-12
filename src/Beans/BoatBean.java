/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Interfaces.BoatEventListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

/**
 *
 * @author Simon
 */
public class BoatBean implements PropertyChangeListener{
    
    private String typeBateau;
    private String pavillon;
    private Date dateArrivee = new Date();;
    private ArrayList <BoatEventListener> BoatEventListenerList = new ArrayList<BoatEventListener>();    
    
    public void BoatBean()
    {

    }
    
    public void propertyChange(PropertyChangeEvent e)
    {
        pavillon = randomPavillon();
        typeBateau = e.getNewValue().toString();
        notifyBoatEventDetected(typeBateau, pavillon, dateArrivee);
    }
    
    public String randomPavillon()
    {
        Hashtable<Integer, String> pavillonHashtable = new Hashtable<Integer, String>(); 
        Double random;
        
        pavillonHashtable.put(1, "FR"); 
        pavillonHashtable.put(2, "UK"); 
        pavillonHashtable.put(3, "DE");
        
        random = new Double(1 + Math.random()*(4 - 1));
        
        return pavillonHashtable.get(random.intValue());
    }
    
    public void addBoatEventListenerList(BoatEventListener bel)
    {
        this.BoatEventListenerList.add(bel);
    }
    
    public void removeBoatEventListenerList(BoatEventListener bel)
    {
        this.BoatEventListenerList.remove(bel);
    }
    
    public void notifyBoatEventDetected(String t, String p, Date date)
    {
        BoatEvent be = new BoatEvent(this, t, p, date);
        
        for(int i = 0; i < BoatEventListenerList.size(); i++)
        {
            BoatEventListener bel = BoatEventListenerList.get(i);
            bel.boatEventDetected(be);
        }
    }
}
