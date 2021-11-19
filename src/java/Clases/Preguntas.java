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
public class Preguntas {
    private int preguntaId;
    private int encuestaId ;
    private int preguntaTipo;
    private String pregunta;

    public Preguntas() {
    }

    public Preguntas(int preguntaId, int encuestaId, int preguntaTipo, String pregunta) {
        this.preguntaId = preguntaId;
        this.encuestaId = encuestaId;
        this.preguntaTipo = preguntaTipo;
        this.pregunta = pregunta;
    }

    public int getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(int preguntaId) {
        this.preguntaId = preguntaId;
    }

    public int getEncuestaId() {
        return encuestaId;
    }

    public void setEncuestaId(int encuestaId) {
        this.encuestaId = encuestaId;
    }

    public int getPreguntaTipo() {
        return preguntaTipo;
    }

    public void setPreguntaTipo(int preguntaTipo) {
        this.preguntaTipo = preguntaTipo;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
}
