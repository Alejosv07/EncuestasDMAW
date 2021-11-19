/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.ArrayList;

/**
 *
 * @author Urban
 */
public interface ICrudGeneral<T> {
    void crear(T t);
    void eliminar(T t);
    void actualizar(T t);
    ArrayList<T> Listar();
}
