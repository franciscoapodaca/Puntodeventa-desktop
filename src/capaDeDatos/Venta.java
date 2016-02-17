/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDeDatos;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Z470
 */
public class Venta {

    int id_Venta;
    double total;
    Date fecha;

    ArrayList<Venta> productos = new ArrayList<>();

    public Venta(double total, Date fecha) {
//        this.id = id;
        this.total = total;
        this.fecha = fecha;
    }

    public int getId() {
        return id_Venta;
    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return ", total=  " + total + ", fecha=  " + fecha;
    }

}
