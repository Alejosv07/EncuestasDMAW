/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Encuesta;
import Clases.Preguntas;
import Clases.PreguntasImp;
import Clases.Respuestas;
import Clases.RespuestasImpt;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "PreguntasControlador", urlPatterns = {"/PreguntasControlador"})
public class PreguntasControlador extends HttpServlet {

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
            out.println("<title>Servlet PreguntasControlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PreguntasControlador at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        if (request.getParameter("nEncuesta")!=null && request.getParameter("name")!=null) {
            Encuesta encuesta = new Encuesta(Integer.parseInt(request.getParameter("nEncuesta")), request.getParameter("name"));
            session.setAttribute("encuesta", encuesta);
        }
        
        if (request.getParameter("nPregunta")!=null) {
            PreguntasImp preguntasImp = new PreguntasImp();
            preguntasImp.eliminarRepuestasPorIdPegunta(Integer.parseInt(request.getParameter("nPregunta")));
        }

        request.getRequestDispatcher("IndexAdmi.jsp").forward(request, response);
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
        if (request.getParameter("btnGuardar") != null) {
            //Guardar respuesta
            HttpSession session = request.getSession();

            Encuesta encuesta = (Encuesta) session.getAttribute("encuesta");

            Preguntas preguntas = new Preguntas();
            preguntas.setEncuestaId(encuesta.getEncuestaId());

            preguntas.setPreguntaTipo(Integer.parseInt(request.getParameter("tipoPregunta")));
            preguntas.setPregunta(request.getParameter("txtPregunta"));

            PreguntasImp preguntasImp = new PreguntasImp();

            RespuestasImpt respuestasImpt = new RespuestasImpt();

            //Sabemos ID
            if (request.getParameter("txtIDpregunta") != null) {
                //Existe y hay que actulizar datos
                preguntas.setPreguntaId(Integer.parseInt(request.getParameter("txtIDpregunta")));
                preguntasImp.actualizar(preguntas);
            } else {
                //Es una nueva pregunta

                //Creamos la pregunta
                preguntasImp.crear(preguntas);
                
                //Sabemos el ultimo id
                int idUltimaPregunta = 0;
                if (preguntasImp.ListarIDEncuesta(encuesta.getEncuestaId()).size() > 0) {
                    for (Preguntas pre : preguntasImp.ListarIDEncuesta(encuesta.getEncuestaId())) {
                        if (pre.getPreguntaId() > idUltimaPregunta) {
                            idUltimaPregunta = pre.getPreguntaId();
                        }
                    }
                }
                preguntas.setPreguntaId(idUltimaPregunta);
            }
            
            
            
            //Validamos que existan respuestas para eliminar
            ArrayList<Respuestas> alRespuestas = new ArrayList<>();
            alRespuestas = respuestasImpt.ListarIDPregunta(preguntas.getPreguntaId());

            if (alRespuestas != null || alRespuestas.size() > 0) {
                //Eliminamos las respuestas
                for (Respuestas item : alRespuestas) {
                    respuestasImpt.eliminar(item);
                }
            }

            //Preguntamos el tipo de respuesta
            if (preguntas.getPreguntaTipo() > 0) {
                //Selección multiple

                //Agregamos respuestas
                //Validamos si no esta vacio el campo
                if (request.getParameter("respuesta2") != null) {
                    //Identificamos cuantas respuestas son
                    for (int i = 1; i < 5; i++) {
                        Respuestas respuestas = new Respuestas(0, preguntas.getPreguntaId(), request.getParameter("respuesta" + i));
                        respuestasImpt.crear(respuestas);
                    }
                }
            } else {
                //Seleccion 1
                Respuestas respuestas = new Respuestas(0, preguntas.getPreguntaId(), request.getParameter("respuesta1"));
                respuestasImpt.crear(respuestas);
            }

            //Salimos
            request.getRequestDispatcher("IndexAdmi.jsp").forward(request, response);
        }
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
