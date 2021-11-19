/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.Preguntas;
import Clases.Respuestas;
import java.util.ArrayList;

/**
 *
 * @author Urban
 */
public interface IRespuestas extends ICrudGeneral<Respuestas>{
    ArrayList<Respuestas>ListarIDPregunta(int idPregunta);
}
