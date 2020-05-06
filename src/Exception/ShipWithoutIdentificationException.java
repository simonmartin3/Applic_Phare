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
public class ShipWithoutIdentificationException extends Exception
{
    private String message;
    
    public ShipWithoutIdentificationException()
    {
        message = "Erreur lors de l'instanciation d'un BATEAU.";
    }
    
    public ShipWithoutIdentificationException(String tmp)
    {
        message = tmp;
    }
    
    public void Affiche()
    {
        JOptionPane.showMessageDialog(null,message, "Erreur - Instanciation bateau", JOptionPane.ERROR_MESSAGE, null);
    }
}
