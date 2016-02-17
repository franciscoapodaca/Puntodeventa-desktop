/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDeDatos;

/**
 *
 * @author Z470
 */
public class Ticket {

    int id_Venta;
    int id_Bebida;
    int id_Vaso;
    String descripcion;
    double costo;

    public Ticket(int id_Venta, int id_Bebida, int id_Vaso, String descripcion, double costo) {
        this.id_Venta = id_Venta;
        this.id_Bebida = id_Bebida;
        this.id_Vaso = id_Vaso;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public int getId_Venta() {
        return id_Venta;
    }

    public void setId_Venta(int id_Venta) {
        this.id_Venta = id_Venta;
    }

    public int getId_Bebida() {
        return id_Bebida;
    }

    public void setId_Bebida(int id_Bebida) {
        this.id_Bebida = id_Bebida;
    }

    public int getId_Vaso() {
        return id_Vaso;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setId_Vaso(int id_Vaso) {
        this.id_Vaso = id_Vaso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "id_Venta=" + id_Venta + ", id_Bebida=" + id_Bebida
                + ", id_Vaso=" + id_Vaso + ", descripcion =" + descripcion;
    }

}
