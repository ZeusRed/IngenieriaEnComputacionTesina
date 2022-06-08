/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Acer ES 15
 */
 
public class CatTipoUsuario  implements Serializable{
   
    private int idcattipoUsuario;
    private String descripcion;
    
    public CatTipoUsuario(){
    
    }

    public int getIdcattipoUsuario() {
        return idcattipoUsuario;
    }

    public void setIdcattipoUsuario(int idcattipoUsuario) {
        this.idcattipoUsuario = idcattipoUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
