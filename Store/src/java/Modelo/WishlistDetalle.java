/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Acer ES 15
 */
public class WishlistDetalle {
    
    String Producto, base64Image;
    double Cantidad, Subtotal;
    int idwhislist;

    public int getIdwhislist() {
        return idwhislist;
    }

    public void setIdwhislist(int idwhislist) {
        this.idwhislist = idwhislist;
    }

    public WishlistDetalle() {
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    public double getCantidad() {
        return Cantidad;
    }

    public void setCantidad(double Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(double Subtotal) {
        this.Subtotal = Subtotal;
    }
}
