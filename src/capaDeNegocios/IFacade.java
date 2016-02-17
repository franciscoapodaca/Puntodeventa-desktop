/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDeNegocios;

import capaDeDatos.Bebida;
import capaDeDatos.Ingrediente;
import capaDeDatos.Ticket;
import capaDeDatos.Vaso;
import capaDeDatos.Venta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Francisco
 */
public class IFacade {

    private AdministrarBebidas admBebidas;
    private AdministrarIngredientes admIngredientes;
    private AdministrarVenta admVenta;

    public IFacade() {
        admBebidas = new AdministrarBebidas();
        admIngredientes = new AdministrarIngredientes();
        admVenta = new AdministrarVenta();
    }

    public Connection GetConnection() {
        Connection conexion = null;
        try {
            String url = "jdbc:sqlserver://localhost\\SQLExpress:1433;databaseName=SpicyFactory;"
                    + "user=sa;password=sa;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection(url);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la Base de Datos " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la Base de Datos " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la Base de Datos " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } finally {
            return conexion;
        }
    }

    public void updateInventarioBebida(Bebida bebida) throws SQLException {
        admBebidas.updateInventarioBebida(bebida);
    }

    public float obtenExistenciaBebida(Bebida bebida) throws SQLException {
        return admBebidas.obtenExistenciaBebida(bebida);
    }

    public ResultSet getExistenciaBebida(Bebida bebida) {
        return admBebidas.getExistenciaBebida(bebida);
    }

    public ResultSet BuscarBebida(String nombre) {
        return admBebidas.BuscarBebida(nombre);
    }

    public ResultSet SeleccionarBebidas() {
        return admBebidas.SeleccionarBebidas();
    }

    public ResultSet BuscarVaso(String tamaño) {
        return admIngredientes.BuscarVaso(tamaño);
    }

    public ResultSet BuscarIngrediente(String nombre) {
        return admIngredientes.BuscarIngrediente(nombre);
    }

    public float obtenExistencia(Ingrediente ingrediente) throws SQLException {
        return admIngredientes.obtenExistencia(ingrediente);
    }

    public void updateInventarioIngrediente(Ingrediente ingrediente) throws SQLException {
        admIngredientes.updateInventarioIngrediente(ingrediente);
    }

    public ResultSet getExistencia(Ingrediente ingrediente) {
        return admIngredientes.getExistencia(ingrediente);
    }

    public void updateInventarioVaso(Vaso vaso) throws SQLException {
        admIngredientes.updateInventarioVaso(vaso);
    }

    public float obtenExistenciaVaso(Vaso vaso) throws SQLException {
        return admIngredientes.obtenExistenciaVaso(vaso);
    }

    public ResultSet getExistenciaVaso(Vaso vaso) {
        return admIngredientes.getExistenciaVaso(vaso);
    }

    public void agrega(Ingrediente ingrediente) {
        admIngredientes.agrega(ingrediente);
    }

    public ResultSet SeleccionarIngredientes() {
        return admIngredientes.SeleccionarIngredientes();
    }

    public ResultSet SeleccionarVasos() {
        return admIngredientes.SeleccionarVasos();
    }

    public void agregarIngrediente(Ingrediente ingrediente) throws SQLException {
        admIngredientes.agregarIngrediente(ingrediente);
    }

    public void actualizarIngrediente(Ingrediente ingrediente) throws SQLException {
        admIngredientes.actualizarIngrediente(ingrediente);
    }

    public ResultSet obtenerTodosIngrediente() throws SQLException {
        return  admIngredientes.obtenerTodosIngredientes();
    }

    public int obtenerMaximo(String nomTabla) {
        return admVenta.obtenerMaximo(nomTabla);
    }

    public ResultSet buscarTicket(int id_Venta) {
        return admVenta.buscarTicket(id_Venta);
    }

    public void insertarDettaleIngrediente(int id_Venta, int id_ingrediente) throws SQLException {
        admVenta.insertarDettaleIngrediente(id_Venta, id_ingrediente);
    }

    public void insertarDettaleBebida(int id_Venta, int id_bebida) throws SQLException {
        admVenta.insertarDettaleBebida(id_Venta, id_bebida);
    }

    public void insertarDettaleVaso(int id_Venta, int id_Vaso) throws SQLException {
        admVenta.insertarDettaleVaso(id_Venta, id_Vaso);
    }

    public void registrarVenta(Venta venta) throws SQLException {
        admVenta.registrarVenta(venta);
    }

    public void crearTicket(Ticket ticket) throws SQLException {
        admVenta.crearTicket(ticket);
    }

    public void registrarTicket(Ticket ticket) throws SQLException {
        admVenta.registrarTicket(ticket);
    }

    public ResultSet buscarMax() {
        return admVenta.buscarMax();
    }

    public int obtenMaxid_Venta() throws SQLException {
        return admVenta.obtenMaxid_Venta();
    }

    public ResultSet ingredientesVenta(int id_Venta) {
        return admVenta.ingredientesVenta(id_Venta);
    }

    public ResultSet bebidasVenta(int id_Venta) {
        return admVenta.bebidasVenta(id_Venta);
    }
    
    

}
