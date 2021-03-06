/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDePresentacion;

import capaDeDatos.Ingrediente;
import capaDeNegocios.AdministrarIngredientes;
import capaDeNegocios.IFacade;
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
public class VentanaConsultasIngredientes extends javax.swing.JFrame {

    IFacade facade = new IFacade();
    Ingrediente ing = new Ingrediente();
    AdministrarIngredientes admin = new AdministrarIngredientes();

    /**
     * Creates new form VentanaConsultasIngredientes
     */
    public VentanaConsultasIngredientes() {
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
            Logger.getLogger(VentanaConsultasIngredientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getInt("id_ingrediente"), rs.getString("nombre"), rs.getInt("existencia")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentanaConsultasIngredientes.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtExistencia = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        botonAgregar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonMostrarTodos = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaIngredientes = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtNombreBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        botonRegresarMenuPrincipal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultas de Ingredientes");
        setFocusable(false);
        setMaximumSize(new java.awt.Dimension(1000, 800));
        setMinimumSize(new java.awt.Dimension(1000, 800));
        setPreferredSize(new java.awt.Dimension(1000, 800));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(177, 208, 108));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null), "Datos del Ingrediente:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("NOMBRE:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("EXISTENCIA:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtExistencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 520, 260));

        jPanel2.setBackground(new java.awt.Color(177, 208, 108));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null), "Opciones", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        botonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregarIngrediente.png"))); // NOI18N
        botonAgregar.setBorder(null);
        botonAgregar.setBorderPainted(false);
        botonAgregar.setContentAreaFilled(false);
        botonAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonAgregar.setFocusable(false);
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizarIngrediente.png"))); // NOI18N
        botonActualizar.setBorder(null);
        botonActualizar.setBorderPainted(false);
        botonActualizar.setContentAreaFilled(false);
        botonActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonActualizar.setFocusable(false);
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminarIngrediente.png"))); // NOI18N
        botonEliminar.setBorder(null);
        botonEliminar.setBorderPainted(false);
        botonEliminar.setContentAreaFilled(false);
        botonEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminar.setFocusable(false);
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonMostrarTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mostrarTodos.png"))); // NOI18N
        botonMostrarTodos.setBorderPainted(false);
        botonMostrarTodos.setContentAreaFilled(false);
        botonMostrarTodos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonMostrarTodos.setFocusable(false);
        botonMostrarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(botonEliminar)
                        .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonMostrarTodos))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonMostrarTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 400, 260));

        jPanel4.setBackground(new java.awt.Color(177, 208, 108));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null), "Lista de Ingredientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
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
        tablaIngredientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaIngredientesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaIngredientes);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
        });

        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonBuscarIngrediente.png"))); // NOI18N
        botonBuscar.setBorder(null);
        botonBuscar.setBorderPainted(false);
        botonBuscar.setContentAreaFilled(false);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBuscar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(botonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 950, 310));

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
        getContentPane().add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 680, -1, 60));

        botonRegresarMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/volverMenuPrincipal.png"))); // NOI18N
        botonRegresarMenuPrincipal.setBorder(null);
        botonRegresarMenuPrincipal.setBorderPainted(false);
        botonRegresarMenuPrincipal.setContentAreaFilled(false);
        botonRegresarMenuPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRegresarMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarMenuPrincipalActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegresarMenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 670, -1, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoConsultasIngredientes.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1000, 820));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaIngredientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaIngredientesMousePressed
        int fila = tablaIngredientes.getSelectedRow();
        if (fila >= 0) {
            txtId.setText(tablaIngredientes.getValueAt(fila, 0).toString());
            txtNombre.setText(tablaIngredientes.getValueAt(fila, 1).toString());
            txtExistencia.setText(tablaIngredientes.getValueAt(fila, 2).toString());
            txtId.setEnabled(false);
            botonActualizar.setEnabled(true);
            botonEliminar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "NO A SELECCIONADO NINGUN INGREDIENTE");
        }
    }//GEN-LAST:event_tablaIngredientesMousePressed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        VentanaAgregarIngrediente ventanaAgregar;
        ventanaAgregar = new VentanaAgregarIngrediente();
        ventanaAgregar.setVisible(true);
        txtId.setText(null);
        txtNombre.setText(null);
        txtExistencia.setText(null);
        txtNombreBuscar.setText(null);
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        if (txtNombre.getText().trim().length() == 0 || txtExistencia.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "VERIFIQUE NO EXISTAN CAMPOS VACIOS");
        } else {
            ing.setId(Integer.parseInt(txtId.getText()));
            ing.setNombre(txtNombre.getText());
            ing.setExistencia(Float.parseFloat(txtExistencia.getText()));
            txtId.setEnabled(false);
            mostrarDatos();
            try {
                facade.actualizarIngrediente(ing);
                JOptionPane.showMessageDialog(null, "Ingrediente Actualizado");
                botonAgregar.setEnabled(true);
                mostrarDatos();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR EL INGREDIENTE ", "¡ERROR!", 0);

            }
        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        if (txtId.getText().trim().length() == 0 || txtNombre.getText().trim().length() == 0 || txtExistencia.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "VERIFIQUE QUE NO EXISTAN CAMPOS VACIOS");
        } else {
            ing.setId(Integer.parseInt(txtId.getText()));
            try {
                admin.eliminarIngrediente(ing);
                JOptionPane.showMessageDialog(null, "Ingrediente Eliminado");
                txtId.setText(null);
                txtNombre.setText(null);
                txtExistencia.setText(null);
                txtNombreBuscar.setText(null);
                mostrarDatos();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR EL INGREDIENTE ", "¡ERROR!", 0);
            }
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

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
                Logger.getLogger(VentanaConsultasIngredientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonMostrarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarTodosActionPerformed
        mostrarDatos();
        botonActualizar.setEnabled(false);
        botonEliminar.setEnabled(false);
    }//GEN-LAST:event_botonMostrarTodosActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "¿ Esta seguro que desea regresar ?", "Mensaje",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            this.dispose();
            VentanaInventario vi = new VentanaInventario();
            vi.setVisible(true);
        }
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void txtNombreBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreBuscarActionPerformed

    private void botonRegresarMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarMenuPrincipalActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "¿ Esta seguro que desea regresar al menú principal ?", "Mensaje",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            this.dispose();
            VentanaPrincipalSistema vps;
            vps = new VentanaPrincipalSistema();
            vps.setVisible(true);
        }
    }//GEN-LAST:event_botonRegresarMenuPrincipalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonMostrarTodos;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JButton botonRegresarMenuPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaIngredientes;
    private javax.swing.JTextField txtExistencia;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreBuscar;
    // End of variables declaration//GEN-END:variables
}
