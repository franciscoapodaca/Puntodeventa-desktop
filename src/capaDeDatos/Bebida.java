 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDeDatos;

/**
 *
 * @author Z470
 */
public class Bebida {

    int id_bebida;
    String nombre;
    double precio;
    double existencia;

    public Bebida() {
    }

    public Bebida(int id, String nombre, double precio, double existencia) {
        this.id_bebida = id;
        this.nombre = nombre;

        this.precio = precio;
    }
    
     public Bebida(int id, String nombre, double existencia) {
        this.id_bebida = id;
        this.nombre = nombre;
        this.existencia=existencia;
    }

    public int getId() {
        return id_bebida;
    }

    public void setId(int id) {
        this.id_bebida = id;
    }

    @Override
    public String toString() {
        return nombre + ", " + "    $  " + precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getExistencia() {
        return existencia;
    }

    public void setExistencia(double existencia) {
        this.existencia = existencia;
    }
    

}
