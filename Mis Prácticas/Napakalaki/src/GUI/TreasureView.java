/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import napakalaki.Treasure;

/**
 *
 * @author fran
 */
public class TreasureView extends javax.swing.JPanel {
    
    // Variables
    private Treasure treasureModel;
    private boolean selected;

    /**
     * Creates new form TreasureView
     */
    public TreasureView() {
        
        // Por defecto no se verá el color de fondo
        this.setOpaque(false);
        
        initComponents();
        
        // Se inicializa selected a false
        selected = false;
        
        // El diseño tiene los labels para poner el texto.
        // Al usar las imágenes, se dejan sin texto en lugar de eliminarlos,
        // para usarlo en caso que sea necesario
        jLabelTreasureBonus.setText("");
        jLabelTreasureName.setText("");
        jLabelTreasureType.setText("");
        
        // Se establece el fondo que tendrá al seleccionarlo
        this.setBackground(new Color(0,0,0,50));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTreasureName = new javax.swing.JLabel();
        jLabelTreasureBonus = new javax.swing.JLabel();
        jLabelTreasureType = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelTreasureIco = new javax.swing.JLabel();

        setBackground(java.awt.Color.lightGray);
        setBorder(null);
        setForeground(new java.awt.Color(254, 254, 254));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel1.setOpaque(false);

        jLabelTreasureName.setText("Nombre");
        jPanel1.add(jLabelTreasureName);

        jLabelTreasureBonus.setForeground(new java.awt.Color(254, 254, 254));
        jLabelTreasureBonus.setText("Bonus");
        jPanel1.add(jLabelTreasureBonus);

        jLabelTreasureType.setText("Type");
        jPanel1.add(jLabelTreasureType);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabelTreasureIco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabelTreasureIco, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
        // Se cambia el valor a selected
        selected = !selected;
        
        // Se establece la nueva condición al panel
        this.setOpaque(selected);
        
        // Es necesario volver a cargar la página
        repaint();
        
    }//GEN-LAST:event_formMouseClicked

    // Getters
    public boolean isSelected(){
        return selected;
    }
    
    public Treasure getTreasure(){
        return treasureModel;
    }
    
    // Setters
    public void setTreasure(Treasure t){
        
        treasureModel = t;
        
        // No se pone el texto porque se muestra la imagen
        //jLabelTreasureName.setText(treasureModel.getName());
        jLabelTreasureBonus.setText("Bonus: "+treasureModel.getBonus() + "");
        //jLabelTreasureType.setText(treasureModel.getType().toString());
                
        jLabelTreasureIco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/treasures/"+t.getName()+".jpg")));
        
        repaint();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelTreasureBonus;
    private javax.swing.JLabel jLabelTreasureIco;
    private javax.swing.JLabel jLabelTreasureName;
    private javax.swing.JLabel jLabelTreasureType;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
