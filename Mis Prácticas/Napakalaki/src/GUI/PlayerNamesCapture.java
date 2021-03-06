/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author fran
 */
public class PlayerNamesCapture extends javax.swing.JDialog {
    
    // Variables
    private ArrayList<String> names;

    /**
     * Creates new form PlayerNamesCapture
     */
    public PlayerNamesCapture(java.awt.Frame parent, boolean modal) {
                
        super(parent, modal);
        
        // Se le cambia el diseño de la aplicación
        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | 
                InstantiationException | IllegalAccessException e) {
            // handle exception
        }
                
        names = new ArrayList<>();
        
        initComponents();
        
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        
        setIconButtonPlay();
        setIconButtonCancel();
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelPlayer1 = new javax.swing.JLabel();
        jTextFieldPlayer1 = new javax.swing.JTextField();
        jLabelPlayer2 = new javax.swing.JLabel();
        jTextFieldPlayer2 = new javax.swing.JTextField();
        jLabelPlayer3 = new javax.swing.JLabel();
        jTextFieldPlayer3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButtonPlay = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Añade los jugadores");
        setBackground(new java.awt.Color(122, 2, 20));
        setResizable(false);

        jLabelPlayer1.setText("Player 1");

        jLabelPlayer2.setText("Player 2");

        jLabelPlayer3.setText("Player 3");

        jPanel1.setLayout(new java.awt.GridLayout());

        jButtonPlay.setText("Play!");
        jButtonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonPlay);

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPlayer1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldPlayer1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPlayer2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldPlayer2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPlayer3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldPlayer3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPlayer1)
                    .addComponent(jTextFieldPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPlayer2)
                    .addComponent(jTextFieldPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPlayer3)
                    .addComponent(jTextFieldPlayer3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayActionPerformed
        
        if(!jTextFieldPlayer1.getText().isEmpty()){
            names.add(jTextFieldPlayer1.getText());
        }
        
        if(!jTextFieldPlayer2.getText().isEmpty()){
            names.add(jTextFieldPlayer2.getText());
        }
        
        if(!jTextFieldPlayer3.getText().isEmpty()){
            names.add(jTextFieldPlayer3.getText());
        }
        
        if(names.size()>=3){
            this.dispose();
        } else{
            JOptionPane.showMessageDialog(this,"Debes introducir 3 jugadores",
            "¡Atención!", JOptionPane.PLAIN_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jButtonPlayActionPerformed

    ////////////////////////////////////////////////////////////////////////////
    // Muestra el cuadro de dialogo y se espera hasta que cierra
    // @return Los nombres que se encuentra en names
    public ArrayList<String> getNames(){
        this.setVisible(true);
        return names;
    }
    
    // Le establece un icono al boton DiscardAllTreasures
    private void setIconButtonPlay(){
        
        jButtonPlay.setText("");
        jButtonPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/play.png")));
        jButtonPlay.setBorder(BorderFactory.createMatteBorder(0,0,0,0, new Color(0,0,0,0)));
        jButtonPlay.setBackground(new Color(0,0,0,0));
        
    }
    
    // Le establece un icono al boton DiscardAllTreasures
    private void setIconButtonCancel(){
        
        jButtonCancel.setText("");
        jButtonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png")));
        jButtonCancel.setBorder(BorderFactory.createMatteBorder(0,0,0,0, new Color(0,0,0,0)));
        jButtonCancel.setBackground(new Color(0,0,0,0));
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonPlay;
    private javax.swing.JLabel jLabelPlayer1;
    private javax.swing.JLabel jLabelPlayer2;
    private javax.swing.JLabel jLabelPlayer3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldPlayer1;
    private javax.swing.JTextField jTextFieldPlayer2;
    private javax.swing.JTextField jTextFieldPlayer3;
    // End of variables declaration//GEN-END:variables
}
