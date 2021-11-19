/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.IRespuestas;
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
public class RespuestasImpt extends Conexion implements IRespuestas {

    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public void crear(Respuestas t) {
        Connection con = null;
        try {
            con = super.conectar();
            ps = con.prepareStatement("INSERT INTO tblrespuestas VALUES(DEFAULT," + t.getPreguntaId() + ",'" + t.getRespuesta() + "');");
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
    public void eliminar(Respuestas t) {
        Connection con = null;
        try {
            con = super.conectar();
            ps = con.prepareStatement("DELETE FROM tblrespuestas WHERE tblrespuestas.preguntaId = " + t.getPreguntaId()+ ";");
            //Recorda que los mandamos como ? o podes concatenar 
            //Ejecuta el query
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
    public void actualizar(Respuestas t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Respuestas> Listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Respuestas> ListarIDPregunta(int idPregunta) {
        Connection con = null;

        ArrayList<Respuestas> alRespuestas = new ArrayList<>();
        try {
            con = super.conectar();
            ps = con.prepareStatement("SELECT * FROM tblrespuestas WHERE tblrespuestas.preguntaId="+idPregunta);

            //Ejecuta el query
            rs = ps.executeQuery();

            while (rs.next()) {
                //Armamos el objeto
                Respuestas respuestas = new Respuestas(rs.getInt("respuestaId"), rs.getInt("preguntaId"), rs.getString("respuesta"));

                //Add a la lista
                alRespuestas.add(respuestas);
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
        return alRespuestas;
    }

}
