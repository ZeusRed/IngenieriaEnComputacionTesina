package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Producto {

    private int idProducto, idcattipoproducto, existencia, iteracion;
    private String Descripcion, base64Image;
    private List<GaleriaProducto> galeria= new ArrayList<>();

    public List<GaleriaProducto> getGaleria() {
        return galeria;
    }

    public void setGaleria(List<GaleriaProducto> galeria) {
        this.galeria = galeria;
    }
    private byte[] Imagen;
    private double precio;

    public Producto() {

    }

    public int getIteracion() {
        return iteracion;
    }

    public void setIteracion(int iteracion) {
        this.iteracion = iteracion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdcattipoproducto() {
        return idcattipoproducto;
    }

    public void setIdcattipoproducto(int idcattipoproducto) {
        this.idcattipoproducto = idcattipoproducto;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public byte[] getImagen() {
        return Imagen;
    }

    public void setImagen(byte[] Imagen) {
        this.Imagen = Imagen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
}
