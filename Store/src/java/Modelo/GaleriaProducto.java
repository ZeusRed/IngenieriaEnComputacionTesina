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
public class GaleriaProducto {

    private int idProducto, idgaleriaProductos;
    private String base64Image;
    private byte[] Imagen;

    public GaleriaProducto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdgaleriaProductos() {
        return idgaleriaProductos;
    }

    public void setIdgaleriaProductos(int idgaleriaProductos) {
        this.idgaleriaProductos = idgaleriaProductos;
    }

    public byte[] getImagen() {
        return Imagen;
    }

    public void setImagen(byte[] Imagen) {
        this.Imagen = Imagen;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
}
