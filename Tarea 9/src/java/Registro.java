

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JeanLugo
 */
public class Registro {
    private String username;
    private String correoE;
    private String contrasena;
    private String cumpleA;
    private String tipoUser;

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }
    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public void setCumpleA(String cumpleA){
        this.cumpleA = cumpleA;
    } 

    public String getCorreoE() {
        return correoE;
    }

    public String getContrasena() {
        return contrasena;
    }
    public String getCumpleA(){
        return cumpleA;
    }
}
