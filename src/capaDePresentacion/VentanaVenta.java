package capaDePresentacion;

import capaDeDatos.Bebida;
import capaDeDatos.Venta;
import capaDeDatos.Vaso;
import capaDeDatos.Ingrediente;
import capaDeDatos.Ticket;
import capaDeNegocios.AdministrarVenta;
import capaDeNegocios.IFacade;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Z470
 */
public class VentanaVenta extends javax.swing.JFrame {

    public static Bebida bebida = new Bebida();
    public static Vaso vaso = new Vaso();
    public static String descripcion = "";
    static double costoVenta = 0.0;
    Date hoy = null;
    Calendar c1 = Calendar.getInstance();
    Calendar c2 = new GregorianCalendar();
    int anio = c2.get(Calendar.YEAR);
    int mes = c2.get(Calendar.MONTH);
    int dia = c2.get(Calendar.DATE);
    public static ArrayList<Ingrediente> listaIng = new ArrayList<>();
    public static ArrayList<Bebida> listaBeb = new ArrayList<>();
    public static ArrayList<Vaso> listaVaso = new ArrayList<>();
    IFacade facade = new IFacade();

    /**
     * Creates new form VentaForm
     */
    public VentanaVenta() {

        initComponents();
        this.setLocationRelativeTo(null);
        botonVender.setEnabled(false);

    }

    public void generarCambio() {
        double valor1 = Double.parseDouble(txtTotal.getText());
        double valor2 = Double.parseDouble(txtPago.getText());
        if (valor2 < valor1 == true) {
            JOptionPane.showMessageDialog(null, "Pago menor al total de la venta ");
        } else {
            double restar = valor2 - valor1;
            String cambio = Double.toString(restar);
            txtCambio.setText(cambio);
        }

    }

    public static void generarCosto() {
        String c = Double.toString(costoVenta);
        txtTotal.setText(c);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        botonRegresarMenuPrincipal = new javax.swing.JButton();
        etiquetaCambio = new javax.swing.JLabel();
        etiquetaPago = new javax.swing.JLabel();
        txtCambio = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        botonPreparado = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        botonVender = new javax.swing.JButton();
        txtPago = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        modelo = new DefaultListModel();
        jList1 = new javax.swing.JList();
        botonBebida = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        etiquetaFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VENTANA VENTA");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(981, 631));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(botonRegresarMenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 650, -1, 70));

        etiquetaCambio.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        etiquetaCambio.setText("CAMBIO: $");
        getContentPane().add(etiquetaCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, -1, -1));

        etiquetaPago.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        etiquetaPago.setText("PAGO: $");
        getContentPane().add(etiquetaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, -1, -1));

        txtCambio.setEditable(false);
        txtCambio.setBackground(new java.awt.Color(255, 255, 255));
        txtCambio.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txtCambio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCambio.setBorder(null);
        txtCambio.setFocusable(false);
        getContentPane().add(txtCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 530, 160, 50));

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setBorder(null);
        txtTotal.setFocusable(false);
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 160, 50));

        botonPreparado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Normal1.png"))); // NOI18N
        botonPreparado.setBorder(null);
        botonPreparado.setBorderPainted(false);
        botonPreparado.setContentAreaFilled(false);
        botonPreparado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonPreparado.setFocusable(false);
        botonPreparado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonPreparado.setIconTextGap(-3);
        botonPreparado.setInheritsPopupMenu(true);
        botonPreparado.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Normal 3.png"))); // NOI18N
        botonPreparado.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Normal2.png"))); // NOI18N
        botonPreparado.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        botonPreparado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonPreparado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPreparadoActionPerformed(evt);
            }
        });
        getContentPane().add(botonPreparado, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 450, 260, 70));

        botonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonCancelarVenta.png"))); // NOI18N
        botonCancelar.setBorderPainted(false);
        botonCancelar.setContentAreaFilled(false);
        botonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCancelar.setFocusable(false);
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 610, 290, 100));

        botonVender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonVender.png"))); // NOI18N
        botonVender.setBorderPainted(false);
        botonVender.setContentAreaFilled(false);
        botonVender.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonVender.setFocusable(false);
        botonVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVenderActionPerformed(evt);
            }
        });
        getContentPane().add(botonVender, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 600, 280, 120));

        txtPago.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txtPago.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPago.setBorder(null);
        txtPago.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPagoActionPerformed(evt);
            }
        });
        txtPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPagoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagoKeyTyped(evt);
            }
        });
        getContentPane().add(txtPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 160, 50));

        jList1.setModel(modelo);
        jList1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jList1.setFocusable(false);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList1MousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 330, 320));

        botonBebida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/NormalB1.png"))); // NOI18N
        botonBebida.setBorder(null);
        botonBebida.setBorderPainted(false);
        botonBebida.setContentAreaFilled(false);
        botonBebida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBebida.setFocusable(false);
        botonBebida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonBebida.setIconTextGap(-3);
        botonBebida.setInheritsPopupMenu(true);
        botonBebida.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/NormalB3.png"))); // NOI18N
        botonBebida.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/NormalB2.png"))); // NOI18N
        botonBebida.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        botonBebida.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBebidaActionPerformed(evt);
            }
        });
        getContentPane().add(botonBebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 440, 260, 80));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel10.setText("TOTAL: $");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 190, -1));

        etiquetaFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoPrincipal.jpg"))); // NOI18N
        etiquetaFondo.setText("jLabel1");
        getContentPane().add(etiquetaFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1000, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonPreparadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPreparadoActionPerformed
        VentanaVentaIngredientes ventanaIngre;
        try {
            ventanaIngre = new VentanaVentaIngredientes();
            ventanaIngre.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(VentanaVenta.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_botonPreparadoActionPerformed

    private void botonBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBebidaActionPerformed
        VentanaVentaBebidas f1;
        try {
            f1 = new VentanaVentaBebidas();
            f1.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(VentanaVenta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_botonBebidaActionPerformed

    private void botonVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVenderActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "¿ Desea realizar la venta ?", "Confirmar Venta",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            botonVender.setEnabled(false);
            int idVenta = 0;
            hoy = new Date(anio - 1900, mes, dia);
            String costo = txtTotal.getText();
            costoVenta = Double.valueOf(costo);
            Float f = Float.valueOf(costo);
            Venta v = new Venta(costoVenta, hoy);
            try {
                facade.registrarVenta(v);
                idVenta = facade.obtenMaxid_Venta();
                for (Ingrediente ingrediente : listaIng) {
                    facade.updateInventarioIngrediente(ingrediente);
                }
                for (Bebida be : listaBeb) {
                    facade.updateInventarioBebida(be);
                }
                for (Ingrediente ingrediente : listaIng) {
                    facade.insertarDettaleIngrediente(idVenta, ingrediente.getId());
                }

                for (Bebida be : listaBeb) {
                    facade.updateInventarioBebida(be);
                }
                for (Bebida be : listaBeb) {
                    facade.insertarDettaleBebida(idVenta, be.getId());
                }
                for (Vaso va : listaVaso) {
                    facade.updateInventarioVaso(va);
                }
                for (Vaso va : listaVaso) {
                    facade.insertarDettaleVaso(idVenta, va.getId());
                }

                //  System.out.println(descripcion);
            } catch (SQLException ex) {
                Logger.getLogger(VentanaVenta.class.getName()).log(Level.SEVERE, null, ex);
            }

//            Ticket ticket = new Ticket(idVenta,bebida.getId(),vaso.getId(), descripcion, f);
//        try {
//            AdministrarVenta.registrarTicket(ticket);
//            TicketForm t = new TicketForm();
//            t.setVisible(true);
//            AdministrarVenta.crearTicket(ticket);
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(VentanaVenta.class.getName()).log(Level.SEVERE, null, ex);
//        }
            modelo.removeAllElements();
            txtTotal.setText("");
            txtCambio.setText("");
            txtPago.setText("");
            costoVenta = 0;
            JOptionPane.showMessageDialog(null, "Venta Realizada");
            for (int i = 0; i < listaBeb.size(); i++) {
                listaBeb.remove(i);
            }
            for (int i = 0; i < listaIng.size(); i++) {
                listaIng.remove(i);
            }
            for (int i = 0; i < listaVaso.size(); i++) {
                listaVaso.remove(i);
            }
            
        }
    }//GEN-LAST:event_botonVenderActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        costoVenta = 0.0;
        int response = JOptionPane.showConfirmDialog(null, "¿ Desea Cancelar la venta ?", "Cancelar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            VentanaVenta.modelo.removeAllElements();
            VentanaVenta.txtTotal.setText("");
            VentanaVentaBebidas.costo = 0.0;
            VentanaVentaIngredientes.costo = 0.0;
            txtCambio.setText("");
            txtPago.setText("");
        }


    }//GEN-LAST:event_botonCancelarActionPerformed

    private void txtPagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if(txtPago.getText().isEmpty()==false){
            generarCambio();
            botonVender.setEnabled(true);
            
            }
            
        }

    }//GEN-LAST:event_txtPagoKeyPressed

    private void txtPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "No se permiten letras");
        }

        String txt = "-,+*¨{.}[]_!#$%&*/()=?¡";
        String caracter = String.valueOf(c);
        if (txt.contains(caracter)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Signo no permitido,Solo numeros");
        }


    }//GEN-LAST:event_txtPagoKeyTyped

    private void jList1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MousePressed

    }//GEN-LAST:event_jList1MousePressed

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

    private void txtPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBebida;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonPreparado;
    private javax.swing.JButton botonRegresarMenuPrincipal;
    private javax.swing.JButton botonVender;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel etiquetaCambio;
    private javax.swing.JLabel etiquetaFondo;
    private javax.swing.JLabel etiquetaPago;
    private javax.swing.JLabel jLabel10;
    public static javax.swing.JList jList1;
    public static DefaultListModel modelo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtPago;
    public static javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
