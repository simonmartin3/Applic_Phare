/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import static Classes.Persistance.getPathConfig;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.text.DateFormat;
import java.util.*;

/**
 *
 * @author Simon
 */
public class currentDate {
    private static int formatDate;
    private static int formatHeure;
    private static Locale formatPays;
    
    private String currentDate;
    private String logDate;
    
    Properties propertiesConfig;
    
    public currentDate() throws IOException
    {
        propertiesConfig = Persistance.LoadProperties(getPathConfig());
        
        StringTokenizer st = new StringTokenizer(propertiesConfig.get("formatDate").toString(), "/");         
        formatDate = Integer.parseInt(st.nextToken());
        formatHeure = Integer.parseInt(st.nextToken());
        formatPays = new Locale(st.nextToken());
        
        Date date = new Date();
        currentDate = DateFormat.getDateTimeInstance(formatDate,formatHeure,formatPays).format(date);
        logDate = DateFormat.getDateTimeInstance(formatDate,formatHeure,formatPays).format(date);
    }
    
    public currentDate(int fDate, int fHeure, Locale pays)
    {
        Date date = new Date();
        formatDate = fDate;
        formatHeure = fHeure;
        formatPays = pays;
        
        currentDate = DateFormat.getDateTimeInstance(formatDate,formatHeure,formatPays).format(date);
        logDate = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT,Locale.FRANCE).format(date);
    }
    
    public String getCurrentDate()
    {
        return currentDate;
    }
    
    public String getLogDate()
    {
        return logDate;
    }
    
    public int getDate()
    {
        return formatDate;
    }
    
    public int getHeure()
    {
        return formatHeure;
    }
    
    public Locale getPays()
    {
        return formatPays;
    }
}
