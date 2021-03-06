/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Interfaces.*;
import Windows.*;
import Windows.PhareWindow;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Simon
 */
public class NotifyBean extends BoatBean implements BoatEventListener {
    
    PhareWindow tmp;
    
    public void NotifyBean()
    {
        
    }
    
    public void NotifyBean(PhareWindow pw)
    {
        tmp = pw;
    }
    
    public void boatEventDetected(BoatEvent e)
    {
        try {
            String libelle = e.getTypeBateau() + " / " + e.getPavillon();
            
            JOptionPane.showMessageDialog(new JFrame(), "Nouveau bateau", "Infos", JOptionPane.ERROR_MESSAGE);
            
            tmp.vBateau.push(libelle);
            tmp.insertionBateau();
            tmp.saveandload();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());;
        }
    }
    
}