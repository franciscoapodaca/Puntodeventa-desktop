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
import capaDeDatos.Bebida;

/**
 *
 * @author Z470
 */
public class AdministrarBebidas {

    static ArrayList<Bebida> bebidas = new ArrayList<>();

    public AdministrarBebidas() {
        bebidas = new ArrayList<>();
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

    public void updateInventarioBebida(Bebida bebida) throws SQLException {
        PreparedStatement pst;
        Connection con = GetConnection();
        pst = con.prepareStatement("UPDATE Bebida SET  "
                + "existencia = ? "
                + "WHERE id_bebida= ?");
        Float x = obtenExistenciaBebida(bebida);
        x = x - 1;
        pst.setFloat(1, x);
        pst.setInt(2, bebida.getId());

        pst.execute();
    }

    public float obtenExistenciaBebida(Bebida bebida) throws SQLException {
        ResultSet rs = getExistenciaBebida(bebida);
        float existencia = 0;
        if (rs.next()) {
            existencia = rs.getFloat("existencia");
        }

        return existencia;
    }

    public ResultSet getExistenciaBebida(Bebida bebida) {

        PreparedStatement pst;
        ResultSet rs1 = null;
        try {
            Connection cn = GetConnection();
            pst = cn.prepareStatement("Select existencia from Bebida where id_bebida = ?");
            pst.setInt(1, bebida.getId());
            rs1 = pst.executeQuery();

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }
        return rs1;

    }

    public ResultSet BuscarBebida(String nombre) {

        PreparedStatement pst;
        ResultSet rs1 = null;
        try {
            Connection cn = GetConnection();
            pst = cn.prepareStatement("SELECT * FROM Bebida WHERE nombre=?");
            pst.setString(1, nombre);
            rs1 = pst.executeQuery();

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }
        return rs1;

    }

    public ResultSet SeleccionarBebidas() {

        Connection con = GetConnection();
        Statement st;
        ResultSet rs1 = null;

        try {
            st = con.createStatement();
            rs1 = st.executeQuery("Select * from Bebida");

        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }
        return rs1;

    }

    public void agregarBebida(Bebida bebida) throws SQLException {
        Connection con = GetConnection();
        String sql = "Insert into bebida values (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, bebida.getNombre());
            ps.setDouble(2, bebida.getPrecio());
            ps.setDouble(3, bebida.getExistencia());
            ps.execute();
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());
        }
    }

    public void actualizarBebida(Bebida bebida) throws SQLException {
        Connection con = GetConnection();
        String sql = "UPDATE Bebida SET nombre= ?, existencia= ?, precio = ? where id_bebida = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, bebida.getNombre());
            ps.setDouble(2, bebida.getExistencia());
            ps.setDouble(3, bebida.getPrecio());
            ps.setInt(4, bebida.getId());
            ps.executeUpdate();
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());
        }
    }

    public void eliminarBebida(Bebida bebida) throws SQLException {
        Connection con = GetConnection();
        String sql = "DELETE FROM Bebida WHERE id_bebida =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, bebida.getId());
            ps.execute();
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());
        }
    }

    public ResultSet BuscarBebidaNombre(String nombre) {

        PreparedStatement pst;
        ResultSet rs1 = null;
        try {
            Connection cn = GetConnection();
            pst = cn.prepareStatement("SELECT * FROM Bebida WHERE nombre=?");
            pst.setString(1, nombre);
            rs1 = pst.executeQuery();

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }
        return rs1;

    }

    public ResultSet obtenerTodasBebidas() {

        Connection con = GetConnection();
        Statement st;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery("Select * from Bebida");
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());
        }
        return rs;
    }

    public ResultSet obtenerBebidasSinPrecio() {

        Connection con = GetConnection();
        Statement st;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery("Select id_bebida, nombre,existencia from Bebida");
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());
        }
        return rs;
    }

    public ResultSet ObtenerMasVendidosTop10() {
        PreparedStatement pst;
        ResultSet rs1 = null;
        try {
            Connection cn2 = GetConnection();
            pst = cn2.prepareStatement("select top 3 det.id_bebida, b.nombre, det.cantidad from Bebida b left join (select det.id_bebida, COUNT(*) as cantidad from DetalleBebida det group by det.id_bebida) det on b.id_bebida = det.id_bebida order by cantidad desc");

            rs1 = pst.executeQuery();

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }

        return rs1;
    }

    public ResultSet avisoBebidaBaja() {
        PreparedStatement pst;
        ResultSet rs1 = null;
        try {
            Connection cn2 = GetConnection();
            pst = cn2.prepareStatement("select nombre ,existencia from Bebida where existencia<10");
            rs1 = pst.executeQuery();

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());
        }

        return rs1;
    }

    public ResultSet BuscarLike(String letra) {

        PreparedStatement pst;
        ResultSet rs1 = null;
        try {
            Connection cn2 = GetConnection();
            pst = cn2.prepareStatement("SELECT * FROM Bebida WHERE nombre like ?");
            pst.setString(1, "%" + letra + "%");

            rs1 = pst.executeQuery();

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }
        return rs1;

    }
    
    

    public void updateInventarioBebida2(ArrayList<Bebida> bebida) throws SQLException {
        PreparedStatement pst;
        Bebida selecto = new Bebida();
        Connection con = GetConnection();
        for (Bebida beb : bebida) {
            pst = con.prepareStatement("UPDATE Bebida SET  " + "existencia = ? " + "WHERE id_bebida= ?");
            Double suma = beb.getExistencia();
            Float existenciabd = obtenExistenciaBebida(beb);
            double nuevaExistencia = (double) existenciabd;
            nuevaExistencia = existenciabd + suma;
            pst.setDouble(1, nuevaExistencia);
            pst.setInt(2, beb.getId());
            pst.execute();

        }

    }

}
