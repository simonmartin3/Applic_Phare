/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.*;
import java.util.*;

/**
 *
 * @author Simon
 */
public class Persistance {
    
    public static String getPathLogin()
    {
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "Config" + System.getProperty("file.separator") + "login.properties";
        return filePath;
    }
    
    public static String getPathBateau()
    {
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "Config" + System.getProperty("file.separator") + "bateaux.dat";
        return filePath;
    }
    
//    public static String getPathQuai()
//    {
//        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "Config" + System.getProperty("file.separator") + "quai.dat";
//        return filePath;
//    }
//    
//    public static String getPathPonton()
//    {
//        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "Config" + System.getProperty("file.separator") + "ponton.dat";
//        return filePath;
//    }
    
    public static String getPathLog()
    {
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "Config" + System.getProperty("file.separator") + "log.txt";
        return filePath;
    }
    
    // Charger le fichier properties
    public static Properties LoadProperties (String filePath) throws IOException
    {
        Properties prop = new Properties();
        try
        {
            prop.load(new FileInputStream(filePath));
        }
        catch (FileNotFoundException e){System.err.println("Fichier properties non trouvé !");}
        catch (IOException e) {System.err.println("Error chargement properties :" + e.getMessage());}
        finally {return prop;}
    }
    
    // Sauvegarder les propeties dans le fichier
    public static void SaveProperties(Properties prop, String filePath) throws IOException
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(filePath);
            prop.store(fos,"Fichier properties");
            fos.close();
            System.out.println("Fichier properties sauvergarder.");
            
        }
        catch (FileNotFoundException e){System.err.println("Fichier properties non trouvé ! " + e.getMessage());}
        catch (IOException e) {System.err.println("Error sauvegarde properties : " + e.getMessage());}
    }
    
    // Sauvegarder les objets dans le fichier
    public static void SaveObject(Object obj, String filePath)
    {
        try
        {
            FileOutputStream file = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(obj);
            out.close();
            file.close();
        }
        catch(IOException e) {
            System.out.println("Error sauvegarde objet : " + e.getMessage());
        }
    }
    
    // Charger le fichier avec des objets
    public static Object LoadObject(String filePath)throws FileNotFoundException, IOException
    {
        Object obj = new Object();

        try
        {   
            File file = new File(filePath);
            if(file.length() > 0)
            {
                FileInputStream fileIn = new FileInputStream(filePath);
                ObjectInputStream ois = new ObjectInputStream(fileIn);
                obj = (Object) ois.readObject();
                ois.close();
                fileIn.close();
            }
            else
            {
               obj = null; 
            }
        }
        catch(IOException e) {
            System.out.println("Error chargement objet : " + e.getMessage());}
        finally {return obj;}
    }
    
    public static void WriteLog(String tmp,String filePath)
    {
        try 
        {
            FileWriter fw = new FileWriter(filePath,true);
            fw.write(tmp + ".\n");
            fw.close();
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static String ReadLog(String filePath)
    {
        FileReader flux;
        BufferedReader input;
        String line;
        String tmp = new String();
        
        try
        { 
            flux = new FileReader (filePath);
            input = new BufferedReader(flux);
            
            // Lis ligne par ligne jusqu'à la fin et ajoute les lignes lu dans le text area
            while((line = input.readLine()) != null){
                tmp = tmp + '\n' + line;
            }
            input.close();
            flux.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }  
        return tmp;
    }
    
    public static void displayProperties(Properties p)
    {
        Iterator it = p.keySet().iterator();
        
        while(it.hasNext())
        {
            String name = it.next().toString();
            String value = p.getProperty(name);
            System.out.println(name + " = " + value);
        }
    }
}
