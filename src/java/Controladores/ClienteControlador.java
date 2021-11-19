/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Encuesta;
import Clases.EncuestaImp;
import Clases.RespuestaUsuario;
import Clases.RespuestaUsuarioImp;
import Clases.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Urban
 */
@WebServlet(name = "ClienteControlador", urlPatterns = {"/ClienteControlador"})
public class ClienteControlador extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClienteControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClienteControlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        if (request.getParameter("nEncuesta")!=null && request.getParameter("name")!=null) {
            request.getParameter("nEncuesta");
            request.getParameter("name");
            HttpSession session = request.getSession();
            
            Encuesta encuesta = new Encuesta(Integer.parseInt(request.getParameter("nEncuesta")), request.getParameter("name"));
            
            EncuestaImp encuestaImp = new EncuestaImp();
            encuestaImp.actualizar(encuesta);
            
            session.setAttribute("encuesta", encuesta);

        }
        request.getRequestDispatcher("IndexCliente.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        Usuarios usuario = (Usuarios) session.getAttribute("usuario");
        if (request.getParameter("btnGuardar")!=null) {
            RespuestaUsuario respuestaUsuario = new RespuestaUsuario(0, Integer.parseInt(request.getParameter("txtIDrespuesta")), usuario.getUsuarioId(), "");
            if (request.getParameter("respuesta")!=null) {
                respuestaUsuario.setRespuesta(request.getParameter("respuesta"));
            }
            if (request.getParameter("respuesta1")!=null) {
                respuestaUsuario.setRespuesta(request.getParameter("respuesta1"));
            }
            RespuestaUsuarioImp respuestaUsuarioImp = new RespuestaUsuarioImp();
            respuestaUsuarioImp.crear(respuestaUsuario);
        }
        request.getRequestDispatcher("IndexCliente.jsp").forward(request, response);
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
