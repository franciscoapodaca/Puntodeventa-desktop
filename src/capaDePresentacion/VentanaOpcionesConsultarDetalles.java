/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDePresentacion;

import javax.swing.JOptionPane;

/**
 *
 * @author Francisco
 */
public class VentanaOpcionesConsultarDetalles extends javax.swing.JFrame {

    /**
     * Creates new form VentanaOpcionesInventario
     */
    public VentanaOpcionesConsultarDetalles() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonRegresar = new javax.swing.JButton();
        botonConsultaIngredientes = new javax.swing.JButton();
        botonConsultaCompras = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/back.png"))); // NOI18N
        botonRegresar.setBorder(null);
        botonRegresar.setBorderPainted(false);
        botonRegresar.setContentAreaFilled(false);
        botonRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, 60));

        botonConsultaIngredientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonConsultaIngredientes.png"))); // NOI18N
        botonConsultaIngredientes.setBorder(null);
        botonConsultaIngredientes.setBorderPainted(false);
        botonConsultaIngredientes.setContentAreaFilled(false);
        botonConsultaIngredientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonConsultaIngredientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultaIngredientesActionPerformed(evt);
            }
        });
        getContentPane().add(botonConsultaIngredientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        botonConsultaCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonConsultaCompras.png"))); // NOI18N
        botonConsultaCompras.setBorder(null);
        botonConsultaCompras.setBorderPainted(false);
        botonConsultaCompras.setContentAreaFilled(false);
        botonConsultaCompras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonConsultaCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultaComprasActionPerformed(evt);
            }
        });
        getContentPane().add(botonConsultaCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoOpcionesDetalles.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonConsultaIngredientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultaIngredientesActionPerformed
        VentanaDetalleVentas vvdi;
        vvdi = new VentanaDetalleVentas();
        vvdi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonConsultaIngredientesActionPerformed

    private void botonConsultaComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultaComprasActionPerformed
        VentanaDetalleCompras vdci;
        vdci = new VentanaDetalleCompras();
        vdci.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonConsultaComprasActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "¿ Esta seguro que desea regresar ?", "Mensaje",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            this.dispose();
            VentanaPrincipalSistema vps;
            vps = new VentanaPrincipalSistema();
            vps.setVisible(true);

        }
    }//GEN-LAST:event_botonRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonConsultaCompras;
    private javax.swing.JButton botonConsultaIngredientes;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}