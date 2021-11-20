/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Conexion;
import Clases.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rober
 */
@WebServlet(name = "LoginUsuarioControlador", urlPatterns = {"/LoginUsuarioControlador"})
public class LoginUsuarioControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            /* TODO output your page here. You may use following sample code. */
            Connection con = null;
            //Statement st = null;
            Conexion conexion = new Conexion();
            con = conexion.conectar();
            //st = con.createStatement()
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String email = request.getParameter("email");
            String clave = request.getParameter("pass");

            if (email.equals("root@gmail.com") && clave.equals("root")) {
                request.getRequestDispatcher("IndexAdmi.jsp").forward(request, response);
            } else {
                PreparedStatement stat = con.prepareStatement("SELECT loginUsuario('" + email + "') AS resultado;");
                //String query = "SELECT crearUsuario('"+ nombre +"', '"+ apellido +"', '"+ email +"', '"+ clave +"')";
                //st.execute(query);
                ResultSet result = stat.executeQuery();
                while (result.next()) {
                    if (result.getInt("resultado") == 0) {
                        request.getRequestDispatcher("login.jsp?error=noexiste").forward(request, response);
                    }
                }
                HttpSession sesion = request.getSession();
                PreparedStatement stat2 = con.prepareStatement("SELECT usuarioId, usuarioNombre, usuarioApellido, usuarioCorreo, usuarioClave FROM tblusuarios WHERE usuarioCorreo = ' " + email + " ' limit 1;");
                ResultSet result2 = stat2.executeQuery();
                int ide = -99;
                Usuarios usuario = new Usuarios();
                while (result2.next()) {
                    usuario.setUsuarioNombre(result2.getString("usuarioNombre"));
                    usuario.setUsuarioApellido(result2.getString("usuarioApellido"));
                    usuario.setUsuarioCorreo(result2.getString("usuarioCorreo"));
                    usuario.setUsuarioClave(result2.getString("usuarioClave"));
                    usuario.setUsuarioId(result2.getInt("usuarioId"));
                }

                sesion.setAttribute("usuario", usuario);
                request.getRequestDispatcher("IndexCliente.jsp").forward(request, response);
            }

        } catch (Exception ex) {
            request.getRequestDispatcher("login.jsp?error=true").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
