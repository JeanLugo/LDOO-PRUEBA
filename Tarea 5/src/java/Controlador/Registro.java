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
public class Registro {
    private String nombre1;
    private String apellidoP;
    private String apellidoM;
    private String correoE;
    private String contrasena;

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }
    
    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre1() {
        return nombre1;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public String getCorreoE() {
        return correoE;
    }

    public String getContrasena() {
        return contrasena;
    }
}
