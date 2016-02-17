/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import capaDeDatos.Ingrediente;
import capaDeNegocios.AdministrarIngredientes;
import capaDeNegocios.IFacade;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Z470
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

//        Ingrediente ingrediente = new Ingrediente();
//        IFacade facade = new IFacade();
//
//        ingrediente.setId(1);
//        ingrediente.setNombre("Fresiux");
//        ingrediente.setExistencia(3000);
//        facade.actualizarIngrediente(ingrediente);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        //obtiene la resolucion de la pantalla en PPP (Puntos por pulgada)
        int sr = Toolkit.getDefaultToolkit().getScreenResolution();
        //muestra la informacion por la consola de java
        System.out.println("Tamaño de pantalla: " + d.width + "x" + d.height + ", definición: " + sr + " ppp");
    }

}
