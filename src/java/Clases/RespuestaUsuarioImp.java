/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.IRespuestaUsuario;
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
public class RespuestaUsuarioImp extends Conexion implements IRespuestaUsuario {

    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public void crear(RespuestaUsuario t) {
        Connection con = null;
        try {
            con = super.conectar();
            ps = con.prepareStatement("INSERT INTO tblrespuestausuario VALUES(DEFAULT," + t.getRespuestaId() + "," + t.getUsuarioId() + ",'" + t.getRespuesta() + "');");
            ps.execute();
        } catch (Exception e) {
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EncuestaImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void eliminar(RespuestaUsuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(RespuestaUsuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<RespuestaUsuario> Listar() {
        Connection con = null;

        ArrayList<RespuestaUsuario> alRespuestaUsuario = new ArrayList<>();
        try {
            con = super.conectar();
            ps = con.prepareStatement("SELECT * FROM tblRespuestaUsuario;");

            //Ejecuta el query
            rs = ps.executeQuery();

            while (rs.next()) {
                //Armamos el objeto
                RespuestaUsuario respuestaUsuario = new RespuestaUsuario(rs.getInt("usuarioRespuestaId"), rs.getInt("respuestaId"), rs.getInt("usuarioId"), rs.getString("respuesta"));

                //Add a la lista
                alRespuestaUsuario.add(respuestaUsuario);
            }
        } catch (Exception e) {
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EncuestaImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Retornamos lista
        return alRespuestaUsuario;
    }

    @Override
    public ArrayList<RespuestaUsuario> ListarIdUsuario(int idUsuario) {
        Connection con = null;

        ArrayList<RespuestaUsuario> alRespuestaUsuario = new ArrayList<>();
        try {
            con = super.conectar();
            ps = con.prepareStatement("SELECT * FROM tblRespuestaUsuario where tblRespuestaUsuario.usuarioId ="+idUsuario+";");

            //Ejecuta el query
            rs = ps.executeQuery();

            while (rs.next()) {
                //Armamos el objeto
                RespuestaUsuario respuestaUsuario = new RespuestaUsuario(rs.getInt("usuarioRespuestaId"), rs.getInt("respuestaId"), rs.getInt("usuarioId"), rs.getString("respuesta"));

                //Add a la lista
                alRespuestaUsuario.add(respuestaUsuario);
            }
        } catch (Exception e) {
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EncuestaImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Retornamos lista
        return alRespuestaUsuario;
    }

}
