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
public class Respuestas {
    private int respuestaId;
    private int preguntaId;
    private String respuesta;

    public Respuestas() {
    }

    public Respuestas(int respuestaId, int preguntaId, String respuesta) {
        this.respuestaId = respuestaId;
        this.preguntaId = preguntaId;
        this.respuesta = respuesta;
    }

    public int getRespuestaId() {
        return respuestaId;
    }

    public void setRespuestaId(int respuestaId) {
        this.respuestaId = respuestaId;
    }

    public int getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(int preguntaId) {
        this.preguntaId = preguntaId;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
