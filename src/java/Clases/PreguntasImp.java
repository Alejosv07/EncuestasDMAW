/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.IPreguntas;
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
public class PreguntasImp extends Conexion implements IPreguntas{

    private PreparedStatement ps;
    private ResultSet rs;
    
    @Override
    public void crear(Preguntas t) {
        Connection con = null;
        try{
            con = super.conectar();
            ps = con.prepareStatement("INSERT INTO tblpreguntas VALUES(DEFAULT,"+t.getEncuestaId()+","+t.getPreguntaTipo()+","
                    + "'"+t.getPregunta()+"');");
            ps.execute();
        }catch(Exception e){
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EncuestaImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void eliminar(Preguntas t) {
        Connection con = null;
        try{
            con = super.conectar();
            ps = con.prepareStatement("DELETE FROM tblpreguntas WHERE tblpreguntas.preguntaId = "+t.getPreguntaId()+";");
            //Recorda que los mandamos como ? o podes concatenar 
            //Ejecuta el query
            ps.execute();
        }catch(Exception e){
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EncuestaImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void actualizar(Preguntas t) {
        Connection con = null;
        try{
            con = super.conectar();
            ps = con.prepareStatement("UPDATE tblpreguntas SET tblpreguntas.preguntaTipo = "+t.getPreguntaTipo()+",tblpreguntas.pregunta = '"+t.getPregunta()+"' where tblpreguntas.preguntaId = "+t.getPreguntaId()+";");
            //Recorda que los mandamos como ? o podes concatenar 
            //Ejecuta el query
            ps.execute();
        }catch(Exception e){
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EncuestaImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public ArrayList<Preguntas> ListarIDEncuesta(int idEncuesta) {
        Connection con = null;
        
        ArrayList<Preguntas> alPreguntas = new ArrayList<>();
        try{
            con = super.conectar();
            ps = con.prepareStatement("SELECT * FROM tblpreguntas WHERE tblpreguntas.encuestaId = "+idEncuesta+";");
            
            //Ejecuta el query
            rs = ps.executeQuery();
            
            while(rs.next()){
                //Armamos el objeto
                Preguntas preguntas = new Preguntas();
                preguntas.setPreguntaId(rs.getInt("preguntaId"));
                preguntas.setEncuestaId(rs.getInt("encuestaId"));
                preguntas.setPregunta(rs.getString("pregunta"));
                preguntas.setPreguntaTipo(rs.getInt("preguntaTipo"));
                //Add a la lista
                alPreguntas.add(preguntas);
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
        return alPreguntas;
    }

    @Override
    public ArrayList<Preguntas> Listar() {
        Connection con = null;
        
        ArrayList<Preguntas> alPreguntas = new ArrayList<>();
        try{
            con = super.conectar();
            ps = con.prepareStatement("SELECT * FROM tblencuesta");
            
            //Ejecuta el query
            rs = ps.executeQuery();
            
            while(rs.next()){
                //Armamos el objeto
                Preguntas preguntas = new Preguntas(rs.getInt("preguntaId"), rs.getInt("encuestaId"), rs.getInt("preguntaTipo"), rs.getString("pregunta"));
                
                //Add a la lista
                alPreguntas.add(preguntas);
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
        return alPreguntas;
    }

    @Override
    public void eliminarRepuestasPorIdPegunta(int idPregunta) {
        Connection con = null;
        try{
            con = super.conectar();
            ps = con.prepareStatement("DELETE FROM tblpreguntas WHERE tblpreguntas.preguntaId = "+idPregunta+";");
            ps.execute();
            ps = con.prepareStatement("DELETE FROM tblrespuestas WHERE tblrespuestas.preguntaId = "+idPregunta+";");
            ps.execute();
            //Recorda que los mandamos como ? o podes concatenar 
            //Ejecuta el query
        }catch(Exception e){
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EncuestaImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
