package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Clases.PreguntasImp;
import Clases.Preguntas;
import Clases.Respuestas;
import Clases.RespuestasImpt;
import Clases.Encuesta;
import java.util.ArrayList;
import Clases.EncuestaImp;

public final class IndexAdmi_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.15.4/css/all.css\" integrity=\"sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/normalize.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/styles.css\">\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;1,100;1,300;1,400;1,500&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <title>Encuestadora</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <!-- header -->\n");
      out.write("        <header class=\"header\">\n");
      out.write("            <ul class=\"ul\">\n");
      out.write("                <li class=\"item\">\n");
      out.write("                    <h1 class=\"brand\">Encuestadora</h1>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"item\">\n");
      out.write("                    <div id=\"identificator\">\n");
      out.write("                        <p class=\"text\">Administrador</p>\n");
      out.write("                        <i class=\"fas fa-user\"></i>\n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"submit\" class=\"btn btn--vacio\">\n");
      out.write("                        <i class=\"fas fa-sign-out-alt\"></i>\n");
      out.write("                    </button>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <main class=\"main\">\n");
      out.write("            <!-- panel agregar survey-->\n");
      out.write("            <div class=\"panelAgregar\">\n");
      out.write("                <form action=\"EncuestaControlador\" method=\"post\">\n");
      out.write("                    <input type=\"text\" name=\"txtNombreEncuesta\" class=\"inputText\" placeholder=\"Nombre de encuesta\" required>\n");
      out.write("                    <button type=\"submit\" class=\"btn btn--agregar\">Agregar <i class=\"fas fa-plus\"></i></button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"mainbody\">\n");
      out.write("                <!-- panel de listas de encuentas -->\n");
      out.write("                <div class=\"listSurvey\">\n");
      out.write("                    <h2 class=\"listSurvey__title\">Encuestas</h2>\n");
      out.write("                    <form action=\"#\" method=\"get\" class=\"formSearch\">\n");
      out.write("                        <input required type=\"text\" name=\"txtSearchTitle\" class=\"inputBuscador\" placeholder=\"Buscar\">\n");
      out.write("                        <i class=\"fas fa-search\"></i>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                    <!-- si hay resgistro mostrar-->\n");
      out.write("                    <div class=\"listSurvey__body\" id=\"listSurvey__body\">\n");
      out.write("                        ");

                            EncuestaImp encuestaImp = new EncuestaImp();
                            ArrayList<Encuesta> alEncuesta = encuestaImp.Listar();
                            if (alEncuesta.size() > 0) {
                                for (Encuesta elem : alEncuesta) {
                                    out.print("<a class=\"boxSurvey link2\" href=\"PreguntasControlador?nEncuesta=" + elem.getEncuestaId() + "&name=" + elem.getEncuestaNombre() + "\"><p class=\"boxSurvey__title\">" + elem.getEncuestaNombre() + "</p></a>");
                                }
                            }
                        
      out.write("\n");
      out.write("                        <!--<div class=\"boxSurvey\">\n");
      out.write("                            <p class=\"boxSurvey__title\">Salud</p>\n");
      out.write("                            </div>-->\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- si no hay registro -->\n");
      out.write("                <!-- <h2 class=\"mensaje\">Vaya parece que no hay encuestas registradas.</h2> -->\n");
      out.write("\n");
      out.write("                <!-- si hay registro mostrar -->\n");
      out.write("                ");

                    Encuesta encuesta = (Encuesta) session.getAttribute("encuesta");
                    if (encuesta != null) {
                        out.print("<div class=\"listQuestion\" id=\"listQuestion\"> <div class=\"listQuestion__title\"> <i class=\"fas fa-list\"></i> <form action=\"EncuestaControlador\" method=\"post\"> <input required type=\"text\" id=\"txtEditarEncuesta\" name=\"txtEditarEncuesta\" value=\"" + encuesta.getEncuestaNombre() + "\"> <div class=\"botonera\"> <button class=\"btn btn--editar\" id=\"btnEditar\" type=\"submit\" name=\"btnEditarEncuesta\">Editar <i class=\"fas fa-pen\"></i></button> <a class=\"btn btn--eliminar link\" href=\"EncuestaControlador?nEncuesta=" + encuesta.getEncuestaId() + "\" id=\"btnEditar\">Eliminar <i class=\"fas fa-trash-alt\"></i></a> </div></form> </div><div class=\"boxOption\"> <button type=\"submit\" name=\"btnAgregar\" class=\"btn btn--agregar\" id=\"btnAgregar\">Agregar <i class=\"fas fa-plus\"></i></button> </div><div class=\"listQuestion__body\"> <form action=\"#\" method=\"get\" class=\"formSearch\"> <input required type=\"text\" name=\"txtSearchTitle\" class=\"inputBuscador\" placeholder=\"Buscar\"> <i class=\"fas fa-search\"></i> </form> <div class=\"cards\" id=\"cards\">");
                        RespuestasImpt respuestasImpt = new RespuestasImpt();
                        PreguntasImp preguntasImp = new PreguntasImp();

                        //Session encuesta
                        encuesta = (Encuesta) session.getAttribute("encuesta");
                        if (preguntasImp.ListarIDEncuesta(encuesta.getEncuestaId()).size() > 0) {
                            int i = 1;
                            for (Preguntas pre : preguntasImp.ListarIDEncuesta(encuesta.getEncuestaId())) {
                                if (respuestasImpt.ListarIDPregunta(pre.getPreguntaId()).size() > 0) {

                                    out.print("<form class=\"card\" method=\"post\" action=\"PreguntasControlador\"> <div class=\"card__header\"> <p class=\"numero\">" + i + ")</p><a type=\"submit\" name=\"btnBorrarPregunta\" class=\"btn btn--vacio\" href=\"PreguntasControlador?nPregunta="+ pre.getPreguntaId()+"\"> <i class=\"fas fa-trash-alt\"></i> </a> </div>"
                                            + "<div class=\"card__body\"><input required type=\"text\" class=\"inputText\" placeholder=\"Pregunta\" name=\"txtPregunta\" value=\"" + pre.getPregunta() + "\"><input required type=\"text\" class=\"inputText\" name=\"txtIDpregunta\" Style=\"Display: none;\" value=\"" + pre.getPreguntaId()+ "\">");
                                    if (pre.getPreguntaTipo() > 0) {
                                        out.print("<select name=\"tipoPregunta\" id=\"option\"> <option value=0>Complementar</option> <option value=1 selected>Opción multiple</option> </select> <div id=\"dinamico\">");
                                    } else {
                                        out.print("<select name=\"tipoPregunta\" id=\"option\"> <option value=0 selected>Complementar</option> <option value=1>Opción multiple</option> </select> <div id=\"dinamico\">");
                                    }
                                    int j = 1;
                                    for (Respuestas res : respuestasImpt.ListarIDPregunta(pre.getPreguntaId())) {
                                        out.print("<input required type=\"text\" class=\"inputText\" placeholder=\"Respuesta\" style=\"width: 100%; margin-bottom:1em;\" value=\"" + res.getRespuesta() + "\" name=\"respuesta"+j+"\">");
                                        j++;
                                    }
                                    out.print("</div><button type=\"submit\" class=\"btn btnGuardar\" name=\"btnGuardar\">Guardar</button> </div></form>");
                                    i++;
                                }
                            }
                        }
//                                + "<form class=\"card\" method=\"post\" action=\"PreguntasControlador\"> <div class=\"card__header\"> <p class=\"numero\">1)</p><a type=\"submit\" name=\"btnBorrarPregunta\" class=\"btn btn--vacio\" href=\"#\"> <i class=\"fas fa-trash-alt\"></i> </a> </div><div class=\"card__body\"> <input type=\"text\" class=\"inputText\" placeholder=\"Pregunta\" name=\"txtPregunta\"> <select name=\"tipoPregunta\" id=\"option\"> <option value=\"0\">Complementar</option> <option value=\"1\">Opción multiple</option> </select> <div id=\"dinamico\"> <input type=\"text\" class=\"inputText\" placeholder=\"Respuesta\" style=\"width: 100%;\"> </div><button type=\"submit\" class=\"btn btnGuardar\" name=\"btnGuardar\">Guardar</button> </div></form>"
//                                + " </div></div></div>");
                    } else {
                        out.print("Selecciona una encuesta o creala");
                    }
                
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </main>\n");
      out.write("        <footer class=\"footer\">\n");
      out.write("            <h6 class=\"brandFooter\">Design by BALR</h6>\n");
      out.write("            <a class=\"github link\" href=\"https://github.com/Alejosv07\">\n");
      out.write("                follow me\n");
      out.write("                <i class=\"fab fa-github\"></i>\n");
      out.write("            </a>\n");
      out.write("        </footer>\n");
      out.write("        <script src=\"js/admi.js\"></script>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}