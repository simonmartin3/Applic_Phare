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
public class SailorWithoutIdentificationException extends Exception
{
    private String message;
    
    public SailorWithoutIdentificationException()
    {
        message = "Erreur lors de l'instanciation d'un MARIN.";
    }
    
    public SailorWithoutIdentificationException(String tmp)
    {
        message = tmp;
    }
    
    public void Affiche()
    {
        JOptionPane.showMessageDialog(null,message, "Erreur - Instanciation marin", JOptionPane.ERROR_MESSAGE, null);
    }
}
