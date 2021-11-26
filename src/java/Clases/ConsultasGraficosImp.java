/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

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
public class ConsultasGraficosImp extends Conexion{
    private PreparedStatement ps;
    private ResultSet rs;
    
    public ArrayList<GraficoEncuestaMasRespondida> ListarEncuestaMRespondida() {
        Connection con = null;
        
        ArrayList<GraficoEncuestaMasRespondida> alGrafico = new ArrayList<>();
        try{
            con = super.conectar();
            ps = con.prepareStatement("SELECT COUNT(tblpreguntas.encuestaId) AS 'nREncuesta',tblencuesta.encuestaNombre FROM tblrespuestausuario INNER JOIN tblrespuestas ON tblrespuestausuario.respuestaId = tblrespuestas.respuestaId INNER JOIN tblpreguntas ON tblpreguntas.preguntaId = tblrespuestas.preguntaId INNER JOIN tblencuesta ON tblencuesta.encuestaId = tblpreguntas.encuestaId GROUP BY tblencuesta.encuestaNombre;");
            //Limitando solo a 5
            //ps = con.prepareStatement("SELECT COUNT(tblpreguntas.encuestaId) AS 'nREncuesta',tblencuesta.encuestaNombre FROM tblrespuestausuario INNER JOIN tblrespuestas ON tblrespuestausuario.respuestaId = tblrespuestas.respuestaId INNER JOIN tblpreguntas ON tblpreguntas.preguntaId = tblrespuestas.preguntaId INNER JOIN tblencuesta ON tblencuesta.encuestaId = tblpreguntas.encuestaId GROUP BY tblencuesta.encuestaNombre LIMIT 5;");
            
            //Ejecuta el query
            rs = ps.executeQuery();
            
            while(rs.next()){
                //Armamos el objeto
                GraficoEncuestaMasRespondida grafico = new GraficoEncuestaMasRespondida(rs.getInt("nREncuesta"), rs.getString("encuestaNombre"));
                
                //Add a la lista
                alGrafico.add(grafico);
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
        return alGrafico;
    }
    
    public ArrayList<GraficoPreguntaMasResuelta> ListarPreguntaMRespondida() {
        Connection con = null;
        
        ArrayList<GraficoPreguntaMasResuelta> alGrafico = new ArrayList<>();
        try{
            con = super.conectar();
            ps = con.prepareStatement("SELECT tblpreguntas.pregunta, COUNT(tblpreguntas.pregunta) AS 'nRespuesta' FROM tblrespuestausuario INNER JOIN tblrespuestas ON tblrespuestausuario.respuestaId = tblrespuestas.respuestaId INNER JOIN tblpreguntas ON tblpreguntas.preguntaId = tblrespuestas.preguntaId GROUP BY tblpreguntas.pregunta;");
            
            //Limitando solo a 5
            //ps = con.prepareStatement("SELECT tblpreguntas.pregunta, COUNT(tblpreguntas.pregunta) AS 'nRespuesta' FROM tblrespuestausuario INNER JOIN tblrespuestas ON tblrespuestausuario.respuestaId = tblrespuestas.respuestaId INNER JOIN tblpreguntas ON tblpreguntas.preguntaId = tblrespuestas.preguntaId GROUP BY tblpreguntas.pregunta LIMIT 5;");
            
            //Ejecuta el query
            rs = ps.executeQuery();
            
            while(rs.next()){
                //Armamos el objeto
                GraficoPreguntaMasResuelta grafico = new GraficoPreguntaMasResuelta(rs.getString("pregunta"), rs.getInt("nRespuesta"));
                //Add a la lista
                alGrafico.add(grafico);
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
        return alGrafico;
    }
}
