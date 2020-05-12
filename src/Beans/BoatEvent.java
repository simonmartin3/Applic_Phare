/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.*;

/**
 *
 * @author Simon
 */
public class BoatEvent extends EventObject {
    
    private String typeBateau;
    private String pavillon;
    private Date dateArrivee;
    
    public BoatEvent(Object src) {
        super(src);
    }
    
    public BoatEvent(Object src, String t, String p, Date arrivée) {
        super(src);
        typeBateau = t;
        pavillon = p;
        dateArrivee = arrivée;
    }
    
    public String getTypeBateau()
    {
        return typeBateau;
    }
    
    public String getPavillon()
    {
        return pavillon;
    }
    
    public Date getDateArrivee()
    {
        return dateArrivee;
    }
}
