/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.Preguntas;
import java.util.ArrayList;

/**
 *
 * @author Urban
 */
public interface IPreguntas extends ICrudGeneral<Preguntas>{
    ArrayList<Preguntas>ListarIDEncuesta(int idEncuesta);
    void eliminarRepuestasPorIdPegunta(int idPregunta);
}
