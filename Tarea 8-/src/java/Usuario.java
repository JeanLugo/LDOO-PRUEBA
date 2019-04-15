/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JeanLugo
 */
public class Usuario {
    private int iD;
    private String nomb;
    private String appP;
    private String appM;
    
    public void setID(int iD) {
        this.iD = iD;
    }

    public int getID() {
        return iD;
    }
    public String getNomb() {
        return nomb;
    }

    public void setNomb(String nomb) {
        this.nomb = nomb;
    }

    public String getAppP() {
        return appP;
    }

    public void setAppP(String appP) {
        this.appP = appP;
    }

    public String getAppM() {
        return appM;
    }

    public void setAppM(String appM) {
        this.appM = appM;
    }
    
}
