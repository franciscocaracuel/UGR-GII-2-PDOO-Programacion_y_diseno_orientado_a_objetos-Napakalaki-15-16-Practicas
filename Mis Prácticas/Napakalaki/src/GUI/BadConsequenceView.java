/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import napakalaki.BadConsequence;

/**
 *
 * @author fran
 */
public class BadConsequenceView extends javax.swing.JPanel {
    
    // Variables
    private BadConsequence badConsequenceModel;

    /**
     * Creates new form BadConsequenceView
     */
    public BadConsequenceView() {
        
        initComponents();
        
        // El diseño tiene los labels para poner el texto.
        // Al usar las imágenes, se dejan sin texto en lugar de eliminarlos,
        jLabelBCLevel.setText("");
        jLabelBCText.setText("");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelBCText = new javax.swing.JLabel();
        jLabelBCLevel = new javax.swing.JLabel();

        jLabelBCText.setText("Text");
        add(jLabelBCText);

        jLabelBCLevel.setText("Level");
        add(jLabelBCLevel);
    }// </editor-fold>//GEN-END:initComponents

    // Setters
    public void setBadConsequence(BadConsequence bc){
        
        badConsequenceModel = bc;
        
        // No se pone el texto porque se muestra la imagen
        //jLabelBCText.setText(bc.getText());
        //jLabelBCLevel.setText(bc.getLevels() + "");
        
        repaint();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelBCLevel;
    private javax.swing.JLabel jLabelBCText;
    // End of variables declaration//GEN-END:variables
}
