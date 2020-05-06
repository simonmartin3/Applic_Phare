/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows;

import java.awt.Color;
import java.io.File;
import java.util.*;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import network.*;

/**
 *
 * @author Simon
 */
public class PhareWindow extends javax.swing.JFrame {

    /**
     * Creates new form PhareWindow
     */
    
    private NetworkBasicClient nbc;
    private int PORT = 50000;
    
    Stack <String> vBateau = new Stack<>();
    
    
    public PhareWindow(java.awt.Frame parent, Hashtable tmp) {
        initComponents();
        this.setLocation(0,0);
        this.setResizable(false);
        this.setTitle("Phare d'Inpres-Harbour");
        
        // Création de bateau en attente
        
        vBateau.push("Plaisance / UK");
        vBateau.push("Peche / DE");
        vBateau.push("Plaisance / FR");
        vBateau.push("Peche / UK");
        
        // Insertion de bateau dans la JList
        Label_Attente.setText("Bateaux en attente");
        insertionBateau();
        
        
        // Insertion images ----------------------------------------------------
        
        String image = "images" + File.separator + "phare.jpg";
                
        ImageIcon image1 = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(Label_Image.getWidth(), Label_Image.getHeight(), 20));
        Label_Image.setText(null);
        Label_Image.setIcon(image1);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Button_Connecter = new javax.swing.JButton();
        Button_Suivant = new javax.swing.JButton();
        Label_Attente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        List_Attente = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        TextField_Identifié = new javax.swing.JTextField();
        Button_Autorisation = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Label_Réponse = new javax.swing.JLabel();
        Button_RAZ = new javax.swing.JButton();
        Button_EntreeRade = new javax.swing.JButton();
        Label_Entrée = new javax.swing.JLabel();
        Button_Deconnecter = new javax.swing.JButton();
        Label_Image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Button_Connecter.setText("Se connecter au serveur");
        Button_Connecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ConnecterActionPerformed(evt);
            }
        });

        Button_Suivant.setText("Suivant");
        Button_Suivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SuivantActionPerformed(evt);
            }
        });

        Label_Attente.setText("/");

        List_Attente.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                List_AttentePropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(List_Attente);

        jLabel2.setText("Bateau identifié :");

        TextField_Identifié.setEditable(false);

        Button_Autorisation.setText("Demander autorisation entrée");
        Button_Autorisation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AutorisationActionPerformed(evt);
            }
        });

        jLabel3.setText("Réponse de la capitainerie :");

        Label_Réponse.setText("/");

        Button_RAZ.setText("RAZ");
        Button_RAZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_RAZActionPerformed(evt);
            }
        });

        Button_EntreeRade.setText("Bateau entrée dans la rade");
        Button_EntreeRade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_EntreeRadeActionPerformed(evt);
            }
        });

        Label_Entrée.setText("/");

        Button_Deconnecter.setText("Se déconnecter du serveur");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Button_Deconnecter))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Button_Autorisation)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Button_EntreeRade)
                                        .addGap(18, 18, 18)
                                        .addComponent(Label_Entrée, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(Label_Réponse, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(Button_RAZ, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 73, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Label_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Button_Connecter)
                                    .addComponent(Button_Suivant))
                                .addGap(98, 98, 98)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(Label_Attente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TextField_Identifié, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Button_Connecter)
                            .addComponent(Label_Attente))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Button_Suivant)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Label_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextField_Identifié, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(Button_Autorisation)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Label_Réponse)
                    .addComponent(Button_RAZ))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_EntreeRade)
                    .addComponent(Label_Entrée))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(Button_Deconnecter)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_ConnecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ConnecterActionPerformed
        nbc = new NetworkBasicClient("localhost", PORT);
    }//GEN-LAST:event_Button_ConnecterActionPerformed

    private void Button_SuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SuivantActionPerformed
        if(vBateau.isEmpty())
        {
            JOptionPane.showMessageDialog(new JFrame(), "Plus de bateau en attente !", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            String bateauAtt = vBateau.get(0);
            InfoBateauWindow ibw = new InfoBateauWindow(this, true, bateauAtt);
            ibw.setVisible(true);
            Button_Suivant.setEnabled(false);
        }
    }//GEN-LAST:event_Button_SuivantActionPerformed

    private void List_AttentePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_List_AttentePropertyChange
        
        if(vBateau.isEmpty())
        {
            Label_Attente.setText("Plus de bateaux en attente");
        }
        else
        {
            Label_Attente.setText("Bateaux en attente");
        }
        
    }//GEN-LAST:event_List_AttentePropertyChange

    private void Button_AutorisationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AutorisationActionPerformed
        if(TextField_Identifié.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(new JFrame(), "Aucun bateau n'a été sélectionné !", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            String msgSend = TextField_Identifié.getText() + " / " + vBateau.get(0);
            String rep = nbc.sendString(msgSend);
            Label_Réponse.setText(rep);
        }
    }//GEN-LAST:event_Button_AutorisationActionPerformed

    private void Button_EntreeRadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_EntreeRadeActionPerformed
        StringTokenizer infoBateau = new StringTokenizer(TextField_Identifié.getText(), " / ");
        String nomBateau = infoBateau.nextElement().toString();
        
        String msgSend = "Bateau " + nomBateau + " bien entré dans la rade.";
        String rep = nbc.sendString(msgSend);
        Label_Entrée.setText(rep);
        
        String check = nomBateau + "<--" + Label_Réponse.getText();
        if(rep.equals(check))
        {
            vBateau.remove(0);
            insertionBateau();
        }
        else
            JOptionPane.showMessageDialog(new JFrame(), "Il y a eu une erreur, recommencer l'encodage !", "Erreur", JOptionPane.ERROR_MESSAGE);
        
        Button_Suivant.setEnabled(true);
    }//GEN-LAST:event_Button_EntreeRadeActionPerformed

    private void Button_RAZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_RAZActionPerformed
        clean();
    }//GEN-LAST:event_Button_RAZActionPerformed

    
    public void insertionBateau()
    {
        DefaultListModel model = new DefaultListModel();
        
        for(int i = 0; i < vBateau.size(); i++)
        {
            model.addElement(vBateau.get(i)); 
        }
        List_Attente.setModel(model);
    }
    
    private void clean()
    {
        TextField_Identifié.setText("");
        TextField_Identifié.setBackground(Color.WHITE);
        Label_Entrée.setText("/");
        Label_Réponse.setText("/");
        Button_Suivant.setEnabled(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PhareWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhareWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhareWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhareWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhareWindow(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Autorisation;
    private javax.swing.JButton Button_Connecter;
    private javax.swing.JButton Button_Deconnecter;
    private javax.swing.JButton Button_EntreeRade;
    private javax.swing.JButton Button_RAZ;
    private javax.swing.JButton Button_Suivant;
    private javax.swing.JLabel Label_Attente;
    private javax.swing.JLabel Label_Entrée;
    private javax.swing.JLabel Label_Image;
    private javax.swing.JLabel Label_Réponse;
    private javax.swing.JList<String> List_Attente;
    public javax.swing.JTextField TextField_Identifié;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}