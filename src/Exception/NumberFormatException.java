/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

import javax.swing.JOptionPane;

/**
 *
 * @author Simon
 */
public class NumberFormatException extends Exception
{
    private String message;
    
    public NumberFormatException()
    {
        message = "Veuiller entrer une valeur numérique.";
    }
    
    public NumberFormatException(String tmp)
    {
        message = tmp;
    }
    
    public void Affiche()
    {
        JOptionPane.showMessageDialog(null,message, "Erreur - Tonnage", JOptionPane.ERROR_MESSAGE, null);
    }
}
