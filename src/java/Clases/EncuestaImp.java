/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.IEncuesta;
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
public class EncuestaImp extends Conexion implements IEncuesta{
    
    private PreparedStatement ps;
    private ResultSet rs;
    
    @Override
    public void crear(Encuesta t) {
        Connection con = null;
        try{
            con = super.conectar();
            ps = con.prepareStatement("INSERT INTO tblencuesta VALUES(DEFAULT,'"+t.getEncuestaNombre()+"');");
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
    public void eliminar(Encuesta t) {
        Connection con = null;
        try{
            con = super.conectar();
            ps = con.prepareStatement("DELETE FROM tblencuesta WHERE tblencuesta.encuestaId = "+t.getEncuestaId()+";");
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
    public void actualizar(Encuesta t) {
        Connection con = null;
        try{
            con = super.conectar();
            ps = con.prepareStatement("UPDATE tblencuesta SET tblencuesta.encuestaNombre = '"+t.getEncuestaNombre()+"' where tblencuesta.encuestaId ="+t.getEncuestaId()+";");
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
    public ArrayList<Encuesta> Listar() {
        Connection con = null;
        
        ArrayList<Encuesta> alEncuesta = new ArrayList<>();
        try{
            con = super.conectar();
            ps = con.prepareStatement("SELECT * FROM tblencuesta");
            
            //Ejecuta el query
            rs = ps.executeQuery();
            
            while(rs.next()){
                //Armamos el objeto
                Encuesta encuesta = new Encuesta(rs.getInt("encuestaId"), rs.getString("encuestaNombre"));
                
                //Add a la lista
                alEncuesta.add(encuesta);
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
        return alEncuesta;
    }
    
}
