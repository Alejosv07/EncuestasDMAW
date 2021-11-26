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
public class GraficoPreguntaMasResuelta {
    private String pregunta;
    private int nRespuesta;

    public GraficoPreguntaMasResuelta() {
    }

    public GraficoPreguntaMasResuelta(String pregunta, int nRespuesta) {
        this.pregunta = pregunta;
        this.nRespuesta = nRespuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getnRespuesta() {
        return nRespuesta;
    }

    public void setnRespuesta(int nRespuesta) {
        this.nRespuesta = nRespuesta;
    }
}
