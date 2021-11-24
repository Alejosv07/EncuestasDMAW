/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.IUsuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Urban
 */
public class UsuariosImp extends Conexion implements IUsuarios{

    private PreparedStatement ps;
    private ResultSet rs;
    
    @Override
    public Usuarios ListarPorCorreo(String correo) {
        Connection con = null;
        Usuarios usuarios = new Usuarios();
        try{
            con = super.conectar();
            ps = con.prepareStatement("SELECT * FROM tblusuarios where tblusuarios.usuarioCorreo = '"+correo+"' ;");
            
            //Ejecuta el query
            rs = ps.executeQuery();
            
            while(rs.next()){
                //Armamos el objeto
                usuarios = new Usuarios(rs.getInt("usuarioId"), rs.getString("usuarioNombre"),
                        rs.getString("usuarioApellido"), rs.getString("usuarioCorreo"), rs.getString("usuarioClave"));
            }
        }catch(Exception e){
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EncuestaImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Retornamos lista
        return usuarios;
    }

    @Override
    public void crear(Usuarios t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Usuarios t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Usuarios t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuarios> Listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
