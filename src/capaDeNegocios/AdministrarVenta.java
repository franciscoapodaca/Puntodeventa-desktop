/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDeNegocios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import capaDeDatos.Ingrediente;
import capaDeDatos.Ticket;
import capaDePresentacion.VentanaVentaTicket;
import capaDeDatos.Venta;

/**
 *
 * @author Z470
 */
public class AdministrarVenta {

    ResultSet rs;
    static ArrayList<Venta> ventas = new ArrayList<>();

    public AdministrarVenta() {
        ventas = new ArrayList<>();
    }

    public Venta obten(Ingrediente articulo) {
        int pos = ventas.indexOf(articulo);
        if (pos >= 0) {
            return ventas.get(pos);
        }
        return null;
    }

    public Connection GetConnection() {
        Connection conexion = null;

        try {

            String url = "jdbc:sqlserver://localhost\\SQLExpress:1433;databaseName=SpicyFactory;"
                    + "user=sa;password=sa;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection(url);

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } finally {
            return conexion;
        }
    }

    public int obtenerMaximo(String nomTabla) {
        int n = 0;
        PreparedStatement pst;
        ResultSet rs1 = null;
        try {
            Connection cn = GetConnection();

            pst = cn.prepareStatement("SELECT MAX(id_Venta)as id_Venta FROM ?");
            pst.setString(1, nomTabla);
            rs1 = pst.executeQuery();
            if (rs1.next()) {
                n = rs1.getInt(1);
            }

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }
        return n;

    }

    public ResultSet buscarTicket(int id_Venta) {

        PreparedStatement pst;
        ResultSet rs1 = null;
        try {
            Connection cn = GetConnection();
            pst = cn.prepareStatement("SELECT * FROM Ticket WHERE id_Venta = ?");
            pst.setInt(1, id_Venta);
            rs1 = pst.executeQuery();

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }
        return rs1;

    }

    public void insertarDettaleIngrediente(int id_Venta, int id_ingrediente) throws SQLException {
        Connection con = GetConnection();

        PreparedStatement pst = con.prepareStatement(" INSERT INTO DetalleIngrediente(id_Venta,id_ingrediente)VALUES(?,?)");
        pst.setInt(1, id_Venta);
        pst.setInt(2, id_ingrediente);
        pst.executeUpdate();
    }

    public void insertarDettaleBebida(int id_Venta, int id_bebida) throws SQLException {
        Connection con = GetConnection();

        PreparedStatement pst = con.prepareStatement(" INSERT INTO DetalleBebida(id_Venta,id_bebida)VALUES(?,?)");
        pst.setInt(1, id_Venta);
        pst.setInt(2, id_bebida);
        pst.executeUpdate();
    }

    public void insertarDettaleVaso(int id_Venta, int id_Vaso) throws SQLException {
        Connection con = GetConnection();
        PreparedStatement pst = con.prepareStatement(" INSERT INTO DetalleVaso(id_Venta,id_Vaso)VALUES(?,?)");
        pst.setInt(1, id_Venta);
        pst.setInt(2, id_Vaso);
        pst.executeUpdate();
    }

    public void registrarVenta(Venta venta) throws SQLException {
        Connection con = GetConnection();

        PreparedStatement pst = con.prepareStatement(" INSERT INTO Venta(total,fecha)VALUES(?,?)");
//    pst.setInt(1,0);
        pst.setDouble(1, venta.getTotal());
        pst.setDate(2, venta.getFecha());
        pst.executeUpdate();

    }

    public void crearTicket(Ticket ticket) throws SQLException {
        int x = 0;
        ResultSet rs = buscarTicket(ticket.getId_Venta());

        while (rs.next()) {
            VentanaVentaTicket.textoArea.append("IdVenta----------" + rs.getInt(1) + "\n");
            VentanaVentaTicket.textoArea.append("IdBebida----------" + rs.getInt(2) + "\n");
            VentanaVentaTicket.textoArea.append("IdVaso ----------" + rs.getInt(3) + "\n");
            VentanaVentaTicket.textoArea.append("Descripcion ----------" + rs.getString(4) + "\n");
            VentanaVentaTicket.textoArea.append("Costo ----------" + rs.getDouble(5) + "\n");
        }

    }

    public void registrarTicket(Ticket ticket) throws SQLException {
        Connection con = GetConnection();
        PreparedStatement pst = con.prepareStatement("INSERT INTO Ticket(id_Venta,id_Bebida,id_Vaso,descripcion,costo)VALUES(?,?,?,?,?)");
        pst.setInt(1, ticket.getId_Venta());
        pst.setInt(2, ticket.getId_Bebida());
        pst.setInt(3, ticket.getId_Vaso());
        pst.setString(4, ticket.getDescripcion());
        pst.setDouble(5, ticket.getCosto());
        pst.execute();

    }

    public ResultSet buscarMax() {

        Connection con = GetConnection();
        Statement st;
        ResultSet rs1 = null;

        try {
            st = con.createStatement();
            rs1 = st.executeQuery("SELECT MAX(id_Venta) AS ultimo FROM Venta");

        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }
        return rs1;
    }

    public int obtenMaxid_Venta() throws SQLException {
        Connection cn = GetConnection();
        int x = 0;
        ResultSet rs = buscarMax();
        if (rs.next()) {
            x = rs.getInt(1);
        }
        return x;
    }

    public ResultSet obtenerVentas() {

        PreparedStatement pst;
        ResultSet rs1 = null;

        try {
            Connection cn = GetConnection();
            pst = cn.prepareStatement("Select * from venta");
            rs1 = pst.executeQuery();
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }
        return rs1;
    }

    /**
     * Regresa un resulset(resultado sql) sobre los ingredientes utilizados en
     * una venta
     *
     * @param id_Venta = id de la venta.
     * @return
     */
    public ResultSet ingredientesVenta(int id_Venta) {

        PreparedStatement pst;
        ResultSet rs1 = null;
        try {
            Connection cn = GetConnection();
            pst = cn.prepareStatement("select det.id_ingrediente,i.nombre"
                    + " from DetalleIngrediente det , Ingrediente i "
                    + "where det.id_Venta=? and i.id_ingrediente = det.id_ingrediente");
            pst.setInt(1, id_Venta);
            rs1 = pst.executeQuery();

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }
        return rs1;

    }

    public ResultSet bebidasVenta(int id_Venta) {

        PreparedStatement pst;
        ResultSet rs1 = null;
        try {
            Connection cn = GetConnection();
            pst = cn.prepareStatement("select det.id_bebida,b.nombre"
                    + " from DetalleBebida det , Bebida b "
                    + "where det.id_Venta=? and b.id_bebida = det.id_bebida");
            pst.setInt(1, id_Venta);
            rs1 = pst.executeQuery();

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }
        return rs1;

    }

}
