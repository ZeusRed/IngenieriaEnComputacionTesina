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
public class Wishlist {
    int idwishlist,idProducto,idusuario;
    String Descripcion;

    public Wishlist() {
    }

    public int getIdwishlist() {
        return idwishlist;
    }

    public void setIdwishlist(int idwishlist) {
        this.idwishlist = idwishlist;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
}
