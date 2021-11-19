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
public class Encuesta {
    private int encuestaId;
    private String encuestaNombre;

    public Encuesta() {
    }

    public Encuesta(int encuestaId, String encuestaNombre) {
        this.encuestaId = encuestaId;
        this.encuestaNombre = encuestaNombre;
    }

    public int getEncuestaId() {
        return encuestaId;
    }

    public void setEncuestaId(int encuestaId) {
        this.encuestaId = encuestaId;
    }

    public String getEncuestaNombre() {
        return encuestaNombre;
    }

    public void setEncuestaNombre(String encuestaNombre) {
        this.encuestaNombre = encuestaNombre;
    }
}
