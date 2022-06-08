 
package Logica;

 
public class SessionLogic {

    String correo, password;
    int tiempoInactivoPermitido , idUsuario;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setTiempoInactivoPermitido(int tiempoInactivoPermitido) {
        this.tiempoInactivoPermitido = tiempoInactivoPermitido;
    }

    public int getTiempoInactivoPermitido() {
        return tiempoInactivoPermitido;
    }

    public SessionLogic() {
    }

    public SessionLogic(String correo, String password) {
        this.correo = correo;
        this.password = password;
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
