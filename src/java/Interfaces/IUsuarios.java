/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.Usuarios;

/**
 *
 * @author Urban
 */
public interface IUsuarios extends ICrudGeneral<Usuarios>{
    Usuarios ListarPorCorreo(String correo);
}
