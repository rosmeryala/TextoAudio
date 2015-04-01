/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.DTO;

/**
 *
 * @author thedarker
 */
public class TipoUsuario extends Usuarios {

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public String getTipoUSer() {
        return tipoUSer;
    }

    public void setTipoUSer(String tipoUSer) {
        this.tipoUSer = tipoUSer;
    }
    private int idU;
    private String tipoUSer;

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }
    private String Mensaje;

}
