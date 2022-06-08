/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Acer ES 15
 */
public class Venta {

    Date fechaVenta;
    double TotalVenta;
    int idVenta;

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Venta() {
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getTotalVenta() {
        return TotalVenta;
    }

    public void setTotalVenta(double TotalVenta) {
        this.TotalVenta = TotalVenta;
    }

}
