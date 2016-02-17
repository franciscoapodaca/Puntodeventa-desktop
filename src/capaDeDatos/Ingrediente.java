/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDeDatos;

/**
 *
 * @author Z470
 */
public class Ingrediente {

    int id_ingrediente;
    String nombre;
    double existencia;

    String tipo;

    public Ingrediente() {
    }

    public Ingrediente(int id, String nombre, double existencia) {
        this.id_ingrediente = id;
        this.nombre = nombre;
        this.existencia = existencia;
    }

    public int getId() {
        return id_ingrediente;
    }

    public void setId(int id) {
        this.id_ingrediente = id;
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

    @Override
    public String toString() {
        return "id" + id_ingrediente + "Nombre " + nombre;
    }

}
