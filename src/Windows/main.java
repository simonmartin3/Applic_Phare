/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows;

import Classes.Persistance;
import static Classes.Persistance.*;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Locale;
import java.util.Properties;

/**
 *
 * @author Simon
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        File dossier = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "Config"); 
        boolean res = dossier.mkdir();

        if(res) {
            System.out.println("Le dossier a été créé.");
        }
        else {
            System.out.println("Le dossier existe déja.");
        }
        
        // Chargement du fichier properties des config
        Properties propertiesConfig = Persistance.LoadProperties(getPathConfig());
             
        //Le fichier properties des logins n'existe pas, on le crée
        if(propertiesConfig.isEmpty())        
        { 
            propertiesConfig.setProperty("loginPath", System.getProperty("user.home") + System.getProperty("file.separator") + "Config" + System.getProperty("file.separator") + "login.properties"); 
            propertiesConfig.setProperty("bateauPath", System.getProperty("user.home") + System.getProperty("file.separator") + "Config" + System.getProperty("file.separator") + "bateaux.dat");
            propertiesConfig.setProperty("pharePath", System.getProperty("user.home") + System.getProperty("file.separator") + "Config" + System.getProperty("file.separator") + "phare.dat");
            propertiesConfig.setProperty("logPath",System.getProperty("user.home") + System.getProperty("file.separator") + "Config" + System.getProperty("file.separator") + "log.txt");
            propertiesConfig.setProperty("portServer","50000");
            propertiesConfig.setProperty("timeSleep","1000");
            propertiesConfig.setProperty("reference","7-17");
            propertiesConfig.setProperty("formatDate",Integer.toString(DateFormat.SHORT) + "/" + Integer.toString(DateFormat.SHORT) + "/" + Locale.FRANCE.getLanguage());
           
            
           
            //On ajoute les properties
            Persistance.SaveProperties(propertiesConfig,getPathConfig());
        }
        
        // On vérifie si le fichier bateaux existe sinon on le crée
        if(!new File(Persistance.getPath("pharePath")).exists())
	{
            new File(Persistance.getPath("pharePath")).createNewFile();
            System.out.println ("Création du fichier bateaux.bat");
        }else
	{
            System.out.println ("Le fichier bateaux.bat existe déjà");
	}
        
        LoginWindow LW;
        LW = new LoginWindow();
        LW.setVisible(true);
    }
    
}
