/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDeDatos;

import java.sql.Date;

/**
 *
 * @author Francisco
 */
public class Compras {

    int id_compra;
    double totalCompra;
    Date fecha;

    public Compras() {
    }

    public Compras(double totalCompra, Date fecha) {

        this.totalCompra = totalCompra;
        this.fecha = fecha;

    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    @Override
    public String toString() {
        return "Id Compra: " + getId_compra() + "Fecha: " + getFecha() + "Total Compra: " + getTotalCompra();
    }
}
