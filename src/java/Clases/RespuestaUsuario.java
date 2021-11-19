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
public class RespuestaUsuario {
    private int usuarioRespuestaId;
    private int respuestaId;
    private int usuarioId;
    private String respuesta;

    public RespuestaUsuario() {
    }

    public RespuestaUsuario(int usuarioRespuestaId, int respuestaId, int usuarioId, String respuesta) {
        this.usuarioRespuestaId = usuarioRespuestaId;
        this.respuestaId = respuestaId;
        this.usuarioId = usuarioId;
        this.respuesta = respuesta;
    }

    public int getUsuarioRespuestaId() {
        return usuarioRespuestaId;
    }

    public void setUsuarioRespuestaId(int usuarioRespuestaId) {
        this.usuarioRespuestaId = usuarioRespuestaId;
    }

    public int getRespuestaId() {
        return respuestaId;
    }

    public void setRespuestaId(int respuestaId) {
        this.respuestaId = respuestaId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
