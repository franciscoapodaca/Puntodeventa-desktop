/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDeNegocios;

import capaDeDatos.Compras;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Francisco
 */
public class AdministrarCompras {

    public static Connection GetConnection() {
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
    public ArrayList<Compras> compras = new ArrayList<>();

    public AdministrarCompras() {
        compras = new ArrayList<>();
    }

    public void agregarIngrediente(Compras compras) throws SQLException {
        Connection con = GetConnection();
        String sql = "Insert into Compras values (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, compras.getFecha());

            ps.setDouble(4, compras.getTotalCompra());
            ps.execute();
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());
        }
    }

    public void registrarCompra(Compras compra) throws SQLException {
        Connection con = GetConnection();

        PreparedStatement pst = con.prepareStatement(" INSERT INTO Compras (totalCompra,fecha)VALUES(?,?)");
        pst.setDouble(1, compra.getTotalCompra());
        pst.setDate(2, compra.getFecha());
        pst.executeUpdate();

    }

    public int obtenerMaximo(String nomTabla) {
        int n = 0;
        PreparedStatement pst;
        ResultSet rs1 = null;
        try {
            Connection cn = GetConnection();

            pst = cn.prepareStatement("SELECT MAX(id_compra)as id_compra FROM ?");
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

    
    
     public ResultSet ingredientesCompra(int id_Compra) {

        PreparedStatement pst;
        ResultSet rs1 = null;
        try {
            Connection cn = GetConnection();
            pst = cn.prepareStatement("select det.id_ingrediente,i.nombre "
                    + "from DetalleCompraIngrediente det ,"
                    + " Ingrediente i   where det.id_compra= ? "
                    + "and i.id_ingrediente = det.id_ingrediente");
            pst.setInt(1, id_Compra);
            rs1 = pst.executeQuery();

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }
        return rs1;

    }
    
     public ResultSet bebidasCompra(int id_Compra) {

        PreparedStatement pst;
        ResultSet rs1 = null;
        try {
            Connection cn = GetConnection();
            pst = cn.prepareStatement("select det.id_bebida,b.nombre "+
"                     from DetalleCompraBebida det , Bebida b " +
"                    where det.id_compra= ? and b.id_bebida = det.id_bebida");
            pst.setInt(1, id_Compra);
            rs1 = pst.executeQuery();

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }
        return rs1;

    }
     public ResultSet CostoCompra(int id_Compra) {

        PreparedStatement pst;
        ResultSet rs1 = null;
        try {
            Connection cn = GetConnection();
            pst = cn.prepareStatement("select  totalCompra as Total from Compras " +
"					where id_compra = ? ");
            pst.setInt(1, id_Compra);
            rs1 = pst.executeQuery();

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }
        return rs1;

    }
    
     
     
     
     
     
     
     
    
    
    public void insertarDettaleCompraIngrediente(int id_compra, int id_ingrediente) throws SQLException {
        Connection con = GetConnection();

        PreparedStatement pst = con.prepareStatement(" INSERT INTO DetalleCompraIngrediente(id_compra,id_ingrediente)VALUES(?,?)");
        pst.setInt(1, id_compra);
        pst.setInt(2, id_ingrediente);
        pst.executeUpdate();
    }

    public void insertarDettaleCompraBebida(int id_compra, int id_bebida) throws SQLException {
        Connection con = GetConnection();

        PreparedStatement pst = con.prepareStatement(" INSERT INTO DetalleCompraBebida(id_compra,id_bebida) VALUES(?,?)");
        pst.setInt(1, id_compra);
        pst.setInt(2, id_bebida);
        pst.executeUpdate();
    }

    public ResultSet buscarMax() {

        Connection con = GetConnection();
        Statement st;
        ResultSet rs1 = null;

        try {
            st = con.createStatement();
            rs1 = st.executeQuery("SELECT MAX(id_compra) AS ultimo FROM Compras");

        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }
        return rs1;
    }

    public int obtenMaxid_Compra() throws SQLException {
        Connection cn = GetConnection();
        int x = 0;
        ResultSet rs = buscarMax();
        if (rs.next()) {
            x = rs.getInt(1);
        }
        return x;
    }

}
