/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDeNegocios;

import capaDeDatos.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Francisco
 */
public class AdministrarUsuarios {

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

    public void agregarUsuario(Usuario usuario) throws SQLException {
        Connection con = GetConnection();
        String sql = "Insert into usuario values (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getContraseña());
            ps.setString(3, usuario.getTipoUsuario());
            ps.execute();
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());
        }
    }

    public void actualizarUsuario(Usuario usuario) throws SQLException {
        Connection con = GetConnection();
        String sql = "UPDATE usuario SET tipoUsuario =?, contraseña= ? where nombre = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getTipoUsuario());
            ps.setString(2, usuario.getContraseña());
            ps.setString(3, usuario.getNombre());
            ps.executeUpdate();
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());
        }
    }

    public void eliminarUsuario(Usuario usuario) throws SQLException {
        Connection con = GetConnection();
        String sql = "DELETE FROM usuario WHERE nombre =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.execute();
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());
        }
    }

    public ResultSet obtenerTodosUsuarios() {

        Connection con = GetConnection();
        Statement st;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery("Select * from usuario");
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Error de Conexion \n" + x.toString());
        }
        return rs;
    }

}
