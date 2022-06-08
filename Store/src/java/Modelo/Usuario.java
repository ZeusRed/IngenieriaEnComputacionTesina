 
package Modelo;

 
 
public class Usuario {
    private int idUsuario, idcattipousuario;
    private String Nombre,ApPaterno,ApMaterno,correo,password;
    
    public Usuario(){
        
    }
 

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdcattipousuario() {
        return idcattipousuario;
    }

    public void setIdcattipousuario(int idcattipousuario) {
        this.idcattipousuario = idcattipousuario;
    }
 
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApPaterno() {
        return ApPaterno;
    }

    public void setApPaterno(String ApPaterno) {
        this.ApPaterno = ApPaterno;
    }

    public String getApMaterno() {
        return ApMaterno;
    }

    public void setApMaterno(String ApMaterno) {
        this.ApMaterno = ApMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}

