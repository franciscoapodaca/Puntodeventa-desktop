/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDeDatos;

/**
 *
 * @author Z470
 */
public class Vaso {

    int id;
    String tamaño;
    double precio;

    public Vaso() {

    }

    public Vaso(int id, String tamaño, double precio) {
        this.id = id;
        this.tamaño = tamaño;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Vaso " + tamaño + ", " + "    $  " + precio;
    }

}
