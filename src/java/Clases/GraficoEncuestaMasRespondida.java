/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Urban
 */
public class GraficoEncuestaMasRespondida {
    private int nREncuesta;
    private String encuestaNombre;

    public GraficoEncuestaMasRespondida() {
    }

    public GraficoEncuestaMasRespondida(int nREncuesta, String encuestaNombre) {
        this.nREncuesta = nREncuesta;
        this.encuestaNombre = encuestaNombre;
    }

    public int getnREncuesta() {
        return nREncuesta;
    }

    public void setnREncuesta(int nREncuesta) {
        this.nREncuesta = nREncuesta;
    }

    public String getEncuestaNombre() {
        return encuestaNombre;
    }

    public void setEncuestaNombre(String encuestaNombre) {
        this.encuestaNombre = encuestaNombre;
    }
}
