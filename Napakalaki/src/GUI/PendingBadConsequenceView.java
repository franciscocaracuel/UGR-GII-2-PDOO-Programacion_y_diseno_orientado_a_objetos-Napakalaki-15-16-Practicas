/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JOptionPane;
import napakalaki.BadConsequence;

/**
 *
 * @author fran
 */
public class PendingBadConsequenceView extends javax.swing.JPanel {
    
    // Variables
    private BadConsequence pendingBadConsequenceModel;

    /**
     * Creates new form PendingBadConsequenceView
     */
    public PendingBadConsequenceView() {
        
        initComponents();
        
        jLabelBCPText.setText("");
        jLabelBCPLevel.setText("");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelBCPText = new javax.swing.JLabel();
        jLabelBCPLevel = new javax.swing.JLabel();

        setOpaque(false);

        jLabelBCPText.setForeground(new java.awt.Color(254, 254, 254));
        jLabelBCPText.setText("Text");
        add(jLabelBCPText);

        jLabelBCPLevel.setForeground(new java.awt.Color(254, 254, 254));
        jLabelBCPLevel.setText("Level");
        add(jLabelBCPLevel);
    }// </editor-fold>//GEN-END:initComponents

    // Setters
    public void setPendingBadConsequence(BadConsequence bc){
        
        pendingBadConsequenceModel = bc;
        
        if(bc.getText().isEmpty()){
            jLabelBCPText.setText("");
            jLabelBCPLevel.setText("");            
        }else{
            jLabelBCPText.setText(bc.getText()+". ");
            jLabelBCPLevel.setText("Nivel: "+bc.getLevels());
        }
        
        repaint();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel jLabelBCPLevel;
    protected javax.swing.JLabel jLabelBCPText;
    // End of variables declaration//GEN-END:variables
}