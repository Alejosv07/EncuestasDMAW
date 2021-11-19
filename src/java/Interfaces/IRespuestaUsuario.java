/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.RespuestaUsuario;
import java.util.ArrayList;

/**
 *
 * @author Urban
 */
public interface IRespuestaUsuario extends ICrudGeneral<RespuestaUsuario>{
    ArrayList<RespuestaUsuario> ListarIdUsuario(int idUsuario);
}
