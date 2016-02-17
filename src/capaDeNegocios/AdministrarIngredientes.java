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
import capaDeDatos.Vaso;
import java.util.List;

/**
 *
 * @author Z470
 */
public class AdministrarIngredientes {

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
    public ArrayList<Ingrediente> ingredientes = new ArrayList<>();

    public AdministrarIngredientes() {
        ingredientes = new ArrayList<>();
    }

    public ResultSet BuscarVaso(String tamaño) {

        PreparedStatement pst;
        ResultSet rs1 = null;
        try {
            Connection cn = GetConnection();
            pst = cn.prepareStatement("SELECT * FROM Vaso WHERE tamaño=?");
            pst.setString(1, tamaño);
            rs1 = pst.executeQuery();

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }
        return rs1;
    }

    public ResultSet BuscarIngrediente(String nombre) {

        PreparedStatement pst;
        ResultSet rs1 = null;
        try {
            Connection cn = GetConnection();
            pst = cn.prepareStatement("SELECT * FROM Ingrediente WHERE nombre=?");
            pst.setString(1, nombre);
            rs1 = pst.executeQuery();

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }
        return rs1;

    }

    public void updateInventarioIngrediente(Ingrediente ingrediente) throws SQLException {
        PreparedStatement pst;
        Ingrediente selecto = new Ingrediente();
        Connection con = GetConnection();
        pst = con.prepareStatement("UPDATE Ingrediente SET  " + "existencia = ? " + "WHERE id_ingrediente= ?");
        Float x = obtenExistencia(ingrediente);
        x = x - 30;
        pst.setFloat(1, x);
        pst.setInt(2, ingrediente.getId());
        pst.execute();
    }

    public void updateInventarioIngrediente2(ArrayList<Ingrediente> ingrediente) throws SQLException {
        PreparedStatement pst;
        Ingrediente selecto = new Ingrediente();
        Connection con = GetConnection();
        for (Ingrediente ing : ingrediente) {
            pst = con.prepareStatement("UPDATE Ingrediente SET  " + "existencia = ? " + "WHERE id_ingrediente= ?");
            Double suma = ing.getExistencia();
            Float existenciabd = obtenExistencia(ing);
            double nuevaExistencia = (double) existenciabd;
            nuevaExistencia = existenciabd + suma;

            pst.setDouble(1, nuevaExistencia);
            pst.setInt(2, ing.getId());
            pst.execute();

        }

    }

    public float obtenExistencia(Ingrediente ingrediente) throws SQLException {
        ResultSet rs = getExistencia(ingrediente);
        float existencia = 0;
        if (rs.next()) {
            existencia = rs.getFloat("existencia");
        }

        return existencia;
    }

    public ResultSet getExistencia(Ingrediente ingrediente) {

        PreparedStatement pst;
        ResultSet rs1 = null;
        try {
            Connection cn = GetConnection();
            pst = cn.prepareStatement("Select existencia from Ingrediente where id_ingrediente = ?");
            pst.setInt(1, ingrediente.getId());
            rs1 = pst.executeQuery();

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }
        return rs1;

    }

    public void updateInventarioVaso(Vaso vaso) throws SQLException {
        PreparedStatement pst;
        Connection con = GetConnection();
        pst = con.prepareStatement("UPDATE Vaso SET  "
                + "existencia = ? "
                + "WHERE id_Vaso= ?");
        Float x = obtenExistenciaVaso(vaso);
        x = x - 1;
        pst.setFloat(1, x);
        pst.setInt(2, vaso.getId());
        pst.execute();
    }

    public float obtenExistenciaVaso(Vaso vaso) throws SQLException {
        ResultSet rs = getExistenciaVaso(vaso);
        float existencia = 0;
        if (rs.next()) {
            existencia = rs.getFloat("existencia");
        }

        return existencia;
    }

    public ResultSet getExistenciaVaso(Vaso vaso) {

        PreparedStatement pst;
        ResultSet rs1 = null;
        try {
            Connection cn = GetConnection();
            pst = cn.prepareStatement("Select existencia from Vaso where id_Vaso = ?");
            pst.setInt(1, vaso.getId());
            rs1 = pst.executeQuery();

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }
        return rs1;

    }

    public void agrega(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    public ResultSet SeleccionarIngredientes() {

        Connection con = GetConnection();
        Statement st;
        ResultSet rs1 = null;

        try {
            st = con.createStatement();
            rs1 = st.executeQuery("Select * from Ingrediente where existencia >0 order by nombre");

        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }
        return rs1;

    }

    public ResultSet SeleccionarVasos() {

        Connection con = GetConnection();
        Statement st;
        ResultSet rs1 = null;

        try {
            st = con.createStatement();
            rs1 = st.executeQuery("Select * from Vaso where existencia>0 order by tamaño");

        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }
        return rs1;

    }

    public void agregarIngrediente(Ingrediente ingrediente) throws SQLException {
        Connection con = GetConnection();
        String sql = "Insert into ingrediente values (?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ingrediente.getNombre());
            ps.setDouble(2, ingrediente.getExistencia());
            ps.execute();
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());
        }
    }

    public void actualizarIngrediente(Ingrediente ingrediente) throws SQLException {
        Connection con = GetConnection();
        String sql = "UPDATE Ingrediente SET nombre =?, existencia= ? where id_ingrediente = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ingrediente.getNombre());
            ps.setDouble(2, ingrediente.getExistencia());
            ps.setInt(3, ingrediente.getId());

            ps.executeUpdate();
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());
        }
    }

    public void eliminarIngrediente(Ingrediente ingrediente) throws SQLException {
        Connection con = GetConnection();
        String sql = "DELETE FROM Ingrediente WHERE id_ingrediente =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ingrediente.getId());
            ps.execute();
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());
        }
    }

    public ResultSet BuscarIngredienteNombre(String nombre) {

        PreparedStatement pst;
        ResultSet rs1 = null;
        try {
            Connection cn = GetConnection();
            pst = cn.prepareStatement("SELECT * FROM Ingrediente WHERE nombre=?");
            pst.setString(1, nombre);
            rs1 = pst.executeQuery();

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }
        return rs1;

    }

    public ResultSet obtenerTodosIngredientes() {

        Connection con = GetConnection();
        Statement st;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery("Select * from Ingrediente");
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());
        }
        return rs;
    }

    private List getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList();
        while (rs.next()) {
            Ingrediente ingrediente = new Ingrediente();
            ingrediente.setId(rs.getInt("id_ingrediente"));
            ingrediente.setNombre(rs.getString("nombre"));
            ingrediente.setExistencia(rs.getDouble("existencia"));
            results.add(ingrediente);
        }
        return results;
    }

    public ResultSet ObtenerMasVendidosTop10() {
        PreparedStatement pst;
        ResultSet rs1 = null;
        try {
            Connection cn2 = GetConnection();
            pst = cn2.prepareStatement("select top 10 det.id_ingrediente, i.nombre, det.cantidad from Ingrediente i left join (select det.id_ingrediente ,count(*) as cantidad from DetalleIngrediente det group by det.id_ingrediente) det  on i.id_ingrediente = det.id_ingrediente order by cantidad desc");

            rs1 = pst.executeQuery();

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }

        return rs1;
    }

    public ResultSet avisoIngredienteBajo() {
        PreparedStatement pst;
        ResultSet rs1 = null;
        try {
            Connection cn2 = GetConnection();
            pst = cn2.prepareStatement("select nombre ,existencia from Ingrediente where existencia<500");
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
            pst = cn2.prepareStatement("SELECT * FROM Ingrediente WHERE nombre like ?");
            pst.setString(1, "%" + letra + "%");

            rs1 = pst.executeQuery();

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());

        }
        return rs1;

    }

}
