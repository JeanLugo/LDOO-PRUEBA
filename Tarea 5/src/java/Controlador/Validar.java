/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author JeanLugo
 */
public class Validar {
    private String correo;
    private String pass;
    private String rcorreo;
    private String rpass;
    private boolean check = false;
        
    public void validar(){
        if (correo.equals(rcorreo) && pass.equals(rpass)) {
            check = true;
        } else { 
            check = false; 
        }
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setRcorreo(String rcorreo) {
        this.rcorreo = rcorreo;
    }

    public void setRpass(String rpass) {
        this.rpass = rpass;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPass() {
        return pass;
    }

    public String getRcorreo() {
        return rcorreo;
    }

    public String getRpass() {
        return rpass;
    }
    
    public Boolean getCheck() {
        return check;
    }
}

