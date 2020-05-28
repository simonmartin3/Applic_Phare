/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Interfaces.UtilisateurNombre;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Simon
 */
public class ThreadRandomGenerator extends java.lang.Thread {
    
    private UtilisateurNombre utilisateurThread;
    private int borneInferieure, borneSuperieure, multipleDeclenchement, tempsPause;
    private int nombreProduit;
    private boolean isEnMarche = true;

    public ThreadRandomGenerator(UtilisateurNombre un, int bi, int bs, int md, int tp)
    {
        utilisateurThread = un; 
        borneInferieure=bi; 
        borneSuperieure=bs;
        multipleDeclenchement = md; 
        tempsPause = tp; 
        nombreProduit = -1;
    }

    public void run()
    {
        Double dr;
        
        try
        {
            Thread.sleep(5000);
        
            while(true)
            {
                synchronized(this)
                {
                    while(!isEnMarche)
                    {
                         wait();
                    }
                }

                dr = new Double(borneInferieure + Math.random()*(borneSuperieure - borneInferieure));
                nombreProduit = dr.intValue();
                System.out.println(utilisateurThread.getIdentifiant() + "> nombreProduit = " + nombreProduit);

                if (nombreProduit % multipleDeclenchement == 0)
                {
                    System.out.println(utilisateurThread.getIdentifiant() + "> -------------- !!!!!!! " + nombreProduit + "!!!!");
                    utilisateurThread.traiteNombre(nombreProduit);
                }

                Thread.sleep(tempsPause*1000);
            }
        }
        catch (InterruptedException e) {
            System.out.println("Erreur de thread interrompu : " + e.getMessage());
        }
    }
    
    public synchronized void setEnMarche(boolean em)
    {
        isEnMarche = em;
        notify();
    }
    
    public boolean getEnMarche()
    {
        return isEnMarche;
    }
}
