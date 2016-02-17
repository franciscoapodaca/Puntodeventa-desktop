/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDePresentacion;

import capaDeDatos.Ingrediente;
import capaDeNegocios.AdministrarIngredientes;
import capaDeNegocios.IFacade;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Francisco
 */
public class VentanaInventarioIngredienteUsuarioSimple extends javax.swing.JFrame {
    
    IFacade facade = new IFacade();
    Ingrediente ing = new Ingrediente();
    AdministrarIngredientes admin = new AdministrarIngredientes();

    /**
     * Creates new form VentanaConsultasIngredientes
     */
    public VentanaInventarioIngredienteUsuarioSimple() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrarDatos();
    }
    
    public void mostrarDatos() {
        DefaultTableModel dtm = new DefaultTableModel();
        this.tablaIngredientes.setModel(dtm);
        ResultSet rs = null;
        dtm.setColumnIdentifiers(new Object[]{"ID", "NOMBRE DE INGREDIENTE", "EXISTENCIA EN GRAMOS"});
        facade.GetConnection();
        
        try {
            rs = facade.obtenerTodosIngrediente();
        } catch (SQLException ex) {
            Logger.getLogger(VentanaInventarioIngredienteUsuarioSimple.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getInt("id_ingrediente"), rs.getString("nombre"), rs.getInt("existencia")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentanaInventarioIngredienteUsuarioSimple.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void validacionSoloNumeros(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        String txt = "-,+*¨{.}[]_!#$%&*/()=?¡áéíóú´|°¬;:";
        String caracter = String.valueOf(c);
        if (txt.contains(caracter)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Signo no permitido, Solo números");
        }
    }

    private void validacionSoloLetras(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        String txt = "-,+*¨{.}[]_!#$%&*/()=?¡áéíóú´|°¬;:";
        String caracter = String.valueOf(c);
        if (txt.contains(caracter)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Signo no permitido, letras");
        }
    }
    
    private void validacionNumeros(java.awt.event.KeyEvent evt) {
        if (!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar())) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo se permiten números");
        }
    }
    
    private void validacionLetras(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo se permiten letras");
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaIngredientes = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtNombreBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultas de Ingredientes");
        setFocusable(false);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Lista de Ingredientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        jPanel4.setToolTipText("");
        jPanel4.setFocusable(false);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tablaIngredientes.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tablaIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaIngredientes.setAutoscrolls(false);
        tablaIngredientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaIngredientes.setFocusable(false);
        tablaIngredientes.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jScrollPane1.setViewportView(tablaIngredientes);

        jLabel5.setText("Buscar por Nombre:");

        txtNombreBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreBuscarActionPerformed(evt);
            }
        });
        txtNombreBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreBuscarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreBuscarKeyTyped(evt);
            }
        });

        botonBuscar.setText("Buscar");
        botonBuscar.setBorder(null);
        botonBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBuscar.setFocusable(false);
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 800, 340));

        botonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/back blue.png"))); // NOI18N
        botonRegresar.setBorder(null);
        botonRegresar.setBorderPainted(false);
        botonRegresar.setContentAreaFilled(false);
        botonRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreBuscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            botonBuscarActionPerformed(null);
        }

    }//GEN-LAST:event_txtNombreBuscarKeyPressed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        if (txtNombreBuscar.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "VERIFIQUE QUE NO EXISTAN CAMPOS VACIOS");
        } else {
            DefaultTableModel dtm = new DefaultTableModel();
            this.tablaIngredientes.setModel(dtm);
            ResultSet rs = null;
            dtm.setColumnIdentifiers(new Object[]{"ID", "NOMBRE DE INGREDIENTE", "EXISTENCIA EN GRAMOS"});
            facade.GetConnection();
            rs = admin.BuscarLike(txtNombreBuscar.getText());
            txtNombreBuscar.setText(null);
            try {
                while (rs.next()) {
                    dtm.addRow(new Object[]{rs.getInt("id_ingrediente"), rs.getString("nombre"), rs.getFloat("existencia")});
                }
            } catch (SQLException ex) {
                Logger.getLogger(VentanaInventarioIngredienteUsuarioSimple.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "¿ Esta seguro que desea regresar ?", "Mensaje",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            this.dispose();
            VentanaInventarioUsuarioSimple vi = new VentanaInventarioUsuarioSimple();
            vi.setVisible(true);
        }
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void txtNombreBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreBuscarActionPerformed

    private void txtNombreBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreBuscarKeyTyped
        validacionLetras(evt);
        validacionSoloLetras(evt);
    }//GEN-LAST:event_txtNombreBuscarKeyTyped

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaIngredientes;
    private javax.swing.JTextField txtNombreBuscar;
    // End of variables declaration//GEN-END:variables
}
