/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDePresentacion;

import capaDeDatos.Bebida;
import capaDeDatos.Compras;
import capaDeDatos.Ingrediente;
import capaDeNegocios.AdministrarBebidas;
import capaDeNegocios.AdministrarCompras;
import capaDeNegocios.AdministrarIngredientes;
import capaDeNegocios.IFacade;
import static capaDePresentacion.VentanaVenta.listaVaso;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Francisco
 */
public class VentanaRegistrarCompra extends javax.swing.JFrame {

    IFacade facade = new IFacade();
    AdministrarIngredientes admin = new AdministrarIngredientes();
    AdministrarBebidas admbeb = new AdministrarBebidas();
    AdministrarCompras admcomp = new AdministrarCompras();
    public static ArrayList<Double> listaExistencia = new ArrayList<>();
    public static ArrayList<Ingrediente> listaIng = new ArrayList<>();
    public static ArrayList<Bebida> listaBeb = new ArrayList<>();

    Ingrediente ingrediente = new Ingrediente();
    Bebida bebida = new Bebida();

    DefaultTableModel model;
    DefaultTableModel model2;
    static double costoCompra = 0.0;
    Calendar c1 = Calendar.getInstance();
    Calendar c2 = new GregorianCalendar();
    int anio = c2.get(Calendar.YEAR);
    int mes = c2.get(Calendar.MONTH);
    int dia = c2.get(Calendar.DATE);
    Date hoy = new Date(anio - 1900, mes, dia);

    /**
     * Creates new form VentanaRegistrarCompra
     */
    public VentanaRegistrarCompra() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrarDatosBebidas();
        mostrarDatosIngredientes();
        comprasIngredientes();
        String x = String.valueOf(hoy);
        txtFecha.setText(x);
        botonAgregarBebida.setEnabled(false);
        botonAgregarIngrediente.setEnabled(false);
        txtTotal.setEditable(false);
        txtId.setEnabled(false);
        txtFecha.setEnabled(false);
        txtNombre.setEnabled(false);
        txtPrecio.setEnabled(false);
        txtExistencia.setEnabled(false);
    }

    public void mostrarDatosBebidas() {
        DefaultTableModel dtm = new DefaultTableModel();
        this.tablaBebidas.setModel(dtm);
        ResultSet rs = null;
        dtm.setColumnIdentifiers(new Object[]{"ID", "NOMBRE DE BEBIDA", "CANTIDAD"});
        facade.GetConnection();
        rs = admbeb.obtenerBebidasSinPrecio();
        try {
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getInt("id_bebida"), rs.getString("nombre"), rs.getInt("existencia")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentanaConsultasBebidas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarDatosIngredientes() {
        DefaultTableModel dtm = new DefaultTableModel();
        this.tablaIngredientes.setModel(dtm);
        ResultSet rs = null;
        dtm.setColumnIdentifiers(new Object[]{"ID", "NOMBRE DE INGREDIENTE", "CANTIDAD"});
        facade.GetConnection();

        try {
            rs = facade.obtenerTodosIngrediente();
        } catch (SQLException ex) {
            Logger.getLogger(VentanaConsultasIngredientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getInt("id_ingrediente"), rs.getString("nombre"), rs.getDouble("existencia")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentanaConsultasIngredientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void comprasIngredientes() {
        String data[][] = {};
        String col[] = {"ID", "NOMBRE", "PRECIO", "CANTIDAD"};
        model = new DefaultTableModel(data, col);
        model2 = new DefaultTableModel(data, col);
        tablaCompraIngredientes.setModel(model);
        tablaCompraBebidas.setModel(model2);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtExistencia = new javax.swing.JTextField();
        label = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        botonAgregarIngrediente = new javax.swing.JButton();
        botonAgregarBebida = new javax.swing.JButton();
        botonRegistrarCompra = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaIngredientes = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaBebidas = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCompraBebidas = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaCompraIngredientes = new javax.swing.JTable();
        botonRegresarMenuPrincipal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1200, 900));
        setMinimumSize(new java.awt.Dimension(1200, 900));
        setPreferredSize(new java.awt.Dimension(1200, 900));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Cantidad:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("ID:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Precio:");

        txtId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtExistencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtExistencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtExistenciaKeyTyped(evt);
            }
        });

        txtPrecio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Fecha:");

        txtFecha.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setText("TOTAL COMPRA:");

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTotal.setFocusable(false);

        botonAgregarIngrediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonAgregarIngrediente.png"))); // NOI18N
        botonAgregarIngrediente.setBorderPainted(false);
        botonAgregarIngrediente.setContentAreaFilled(false);
        botonAgregarIngrediente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonAgregarIngrediente.setFocusable(false);
        botonAgregarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarIngredienteActionPerformed(evt);
            }
        });

        botonAgregarBebida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonAgregarBebida.png"))); // NOI18N
        botonAgregarBebida.setBorderPainted(false);
        botonAgregarBebida.setContentAreaFilled(false);
        botonAgregarBebida.setFocusable(false);
        botonAgregarBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarBebidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonAgregarIngrediente)
                            .addComponent(botonAgregarBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(botonAgregarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonAgregarBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel10))
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 580, 300));

        botonRegistrarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonRegistrarCompra2.png"))); // NOI18N
        botonRegistrarCompra.setBorderPainted(false);
        botonRegistrarCompra.setContentAreaFilled(false);
        botonRegistrarCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRegistrarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarCompraActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegistrarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 620, 220, 160));

        botonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonCancelarCompra.png"))); // NOI18N
        botonCancelar.setBorderPainted(false);
        botonCancelar.setContentAreaFilled(false);
        botonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 630, 310, 110));

        jPanel1.setBackground(new java.awt.Color(0, 169, 157));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), null), "Lista de Ingredientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setFocusable(false);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
        tablaIngredientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaIngredientesMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tablaIngredientes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 25, -1, -1));

        jPanel3.setBackground(new java.awt.Color(0, 169, 157));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), null), "Lista de Bebidas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane4.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tablaBebidas.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tablaBebidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaBebidas.setAutoscrolls(false);
        tablaBebidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaBebidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaBebidasMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(tablaBebidas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, -1, -1));

        jPanel4.setBackground(new java.awt.Color(0, 169, 157));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Lista de la Compra Bebidas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tablaCompraBebidas.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tablaCompraBebidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaCompraBebidas.setAutoscrolls(false);
        tablaCompraBebidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaCompraBebidas.setFocusable(false);
        tablaCompraBebidas.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(tablaCompraBebidas);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(367, 367, 367))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, -1, 180));

        jPanel6.setBackground(new java.awt.Color(0, 169, 157));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Lista de la Compra Ingredientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane5.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tablaCompraIngredientes.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tablaCompraIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaCompraIngredientes.setAutoscrolls(false);
        tablaCompraIngredientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaCompraIngredientes.setFocusable(false);
        tablaCompraIngredientes.setRequestFocusEnabled(false);
        jScrollPane5.setViewportView(tablaCompraIngredientes);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(367, 367, 367))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, -1, 180));

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
        getContentPane().add(botonRegresarMenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 760, -1, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoRegistrarCompra.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -60, 1200, 920));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegistrarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarCompraActionPerformed
        if (txtTotal.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Error necesita agregar ingredientes o bebidas a la lista de compras");
        } else {

            int response = JOptionPane.showConfirmDialog(null, "Esta seguro que desea Registrar Compra ?", "Confirmar Compra",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                int idCompra = 0;

                String costo = txtTotal.getText();

                try {
                    double costod = Double.valueOf(costo);
                    idCompra = admcomp.obtenMaxid_Compra();
                    Compras c = new Compras(costod, hoy);
                    admcomp.registrarCompra(c);
                    admin.updateInventarioIngrediente2(listaIng);
                    admbeb.updateInventarioBebida2(listaBeb);

                    for (Bebida be : listaBeb) {
                        admcomp.insertarDettaleCompraBebida(idCompra, be.getId());
                    }

                    for (Ingrediente ing : listaIng) {
                        admcomp.insertarDettaleCompraIngrediente(idCompra, ing.getId());
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(VentanaVenta.class.getName()).log(Level.SEVERE, null, ex);
                }

                txtTotal.setText("");
                costoCompra = 0;
                JOptionPane.showMessageDialog(null, "¡Compra Registrada Exitosamente!");

                for (int i = 0; i < listaBeb.size(); i++) {
                    listaBeb.remove(i);
                }
                for (int i = 0; i < listaIng.size(); i++) {
                    listaIng.remove(i);
                }
                for (int i = 0; i < listaVaso.size(); i++) {
                    listaVaso.remove(i);
                }
                for (int i = 0; i < tablaCompraBebidas.getRowCount(); i++) {
                    model2.removeRow(i);
                    i -= 1;
                }

                for (int i = 0; i < tablaCompraIngredientes.getRowCount(); i++) {
                    model.removeRow(i);
                    i -= 1;
                }
            }
        }


    }//GEN-LAST:event_botonRegistrarCompraActionPerformed

    private void tablaIngredientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaIngredientesMousePressed
        int fila = tablaIngredientes.getSelectedRow();
        if (fila >= 0) {
            txtId.setText(tablaIngredientes.getValueAt(fila, 0).toString());
            txtNombre.setText(tablaIngredientes.getValueAt(fila, 1).toString());
            txtId.setEnabled(false);
            label.setText("Gramos");
            botonAgregarIngrediente.setEnabled(true);
            botonAgregarBebida.setEnabled(false);
            txtNombre.setEnabled(true);
            txtPrecio.setEnabled(true);
            txtExistencia.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "NO A SELECCIONADO NINGUN INGREDIENTE");
        }
    }//GEN-LAST:event_tablaIngredientesMousePressed

    private void tablaBebidasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBebidasMousePressed
        int fila = tablaBebidas.getSelectedRow();
        if (fila >= 0) {
            txtId.setText(tablaBebidas.getValueAt(fila, 0).toString());
            txtNombre.setText(tablaBebidas.getValueAt(fila, 1).toString());
            txtId.setEnabled(false);
            label.setText("Piezas");
            botonAgregarBebida.setEnabled(true);
            botonAgregarIngrediente.setEnabled(false);
            txtNombre.setEnabled(true);
            txtPrecio.setEnabled(true);
            txtExistencia.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "NO A SELECCIONADO NINGUNA BEBIDA");
        }
    }//GEN-LAST:event_tablaBebidasMousePressed

    private void botonAgregarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarIngredienteActionPerformed
        if (txtNombre.getText().trim().length() == 0 || txtExistencia.getText().trim().length() == 0 || txtPrecio.getText().trim().length() == 0 || txtFecha.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "VERIFIQUE NO EXISTAN CAMPOS VACIOS");
        } else {
            double precio1 = Double.parseDouble(txtPrecio.getText());

            model.addRow(new Object[]{txtId.getText(), txtNombre.getText(), txtPrecio.getText(), txtExistencia.getText()});
            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            costoCompra = costoCompra + precio1;
            String c = String.valueOf(costoCompra);
            txtTotal.setText(c);
            Float exist = Float.parseFloat(txtExistencia.getText());
            Ingrediente ing = new Ingrediente(id, nombre, exist);
            listaIng.add(ing);
            txtId.setText("");
            txtNombre.setText("");
            txtPrecio.setText("");
            txtExistencia.setText("");
            botonAgregarIngrediente.setEnabled(false);
            botonAgregarBebida.setEnabled(false);
            txtNombre.setEnabled(false);
            txtPrecio.setEnabled(false);
            txtExistencia.setEnabled(false);
        }
    }//GEN-LAST:event_botonAgregarIngredienteActionPerformed

    private void botonAgregarBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarBebidaActionPerformed
        if (txtNombre.getText().trim().length() == 0 || txtExistencia.getText().trim().length() == 0 || txtPrecio.getText().trim().length() == 0 || txtFecha.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "VERIFIQUE NO EXISTAN CAMPOS VACIOS");
        } else {
            double precio1 = Double.parseDouble(txtPrecio.getText());
            model2.addRow(new Object[]{txtId.getText(), txtNombre.getText(), txtPrecio.getText(), txtExistencia.getText()});
            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            costoCompra = costoCompra + precio1;
            String c = String.valueOf(costoCompra);
            txtTotal.setText(c);
            Float exist = Float.parseFloat(txtExistencia.getText());
            Bebida beb = new Bebida(id, nombre, exist);
            listaBeb.add(beb);
            txtId.setText("");
            txtNombre.setText("");
            txtPrecio.setText("");
            txtExistencia.setText("");
            botonAgregarBebida.setEnabled(false);
            botonAgregarIngrediente.setEnabled(false);
            txtNombre.setEnabled(false);
            txtPrecio.setEnabled(false);
            txtExistencia.setEnabled(false);
        }
    }//GEN-LAST:event_botonAgregarBebidaActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "¿ Desea Cancelar la Compra ?", "Cancelar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            costoCompra = 0.0;
            txtTotal.setText("");
            txtId.setText("");
            txtNombre.setText("");
            txtPrecio.setText("");
            listaBeb.removeAll(listaBeb);
            listaIng.removeAll(listaIng);

            for (int i = 0; i < tablaCompraBebidas.getRowCount(); i++) {
                model2.removeRow(i);
                i -= 1;
            }

            for (int i = 0; i < tablaCompraIngredientes.getRowCount(); i++) {
                model.removeRow(i);
                i -= 1;
            }
            this.dispose();
            VentanaPrincipalSistema vps;
            vps = new VentanaPrincipalSistema();
            vps.setVisible(true);
        }

    }//GEN-LAST:event_botonCancelarActionPerformed

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        validacionNumeros(evt);
        validacionSoloNumeros(evt);
    }//GEN-LAST:event_txtIdKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        validacionLetras(evt);
        validacionSoloLetras(evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtExistenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExistenciaKeyTyped
        validacionSoloNumeros(evt);
        validacionNumeros(evt);
    }//GEN-LAST:event_txtExistenciaKeyTyped

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        validacionNumeros(evt);
        validacionSoloNumeros(evt);
    }//GEN-LAST:event_txtPrecioKeyTyped

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
    private javax.swing.JButton botonAgregarBebida;
    private javax.swing.JButton botonAgregarIngrediente;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonRegistrarCompra;
    private javax.swing.JButton botonRegresarMenuPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel label;
    private javax.swing.JTable tablaBebidas;
    private javax.swing.JTable tablaCompraBebidas;
    private javax.swing.JTable tablaCompraIngredientes;
    private javax.swing.JTable tablaIngredientes;
    private javax.swing.JTextField txtExistencia;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
