package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Clases.Usuarios;
import Clases.RespuestaUsuarioImp;
import Clases.RespuestaUsuario;
import Clases.PreguntasImp;
import Clases.Preguntas;
import Clases.Respuestas;
import Clases.RespuestasImpt;
import Clases.Encuesta;
import java.util.ArrayList;
import Clases.EncuestaImp;

public final class IndexCliente_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        ");

            Usuarios usuario = new Usuarios(1, "Alejandro", "Romero", "alejo@gmail.com", "1234");
            session.setAttribute("usuario", usuario);
        
      out.write("\n");
      out.write("        <!-- header -->\n");
      out.write("        <header class=\"header\">\n");
      out.write("            <ul class=\"ul\">\n");
      out.write("                <li class=\"item\">\n");
      out.write("                    <h1 class=\"brand\">Encuestadora</h1>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"item\">\n");
      out.write("                    <div id=\"identificator\">\n");
      out.write("                        <p class=\"text\">");

                            out.print(usuario.getUsuarioNombre());
                            
      out.write("</p>\n");
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
                                    out.print("<a class=\"boxSurvey link2\" href=\"ClienteControlador?nEncuesta=" + elem.getEncuestaId() + "&name=" + elem.getEncuestaNombre() + "\"><p class=\"boxSurvey__title\">" + elem.getEncuestaNombre() + "</p></a>");
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

                    ArrayList<RespuestaUsuario> alRespuestaUsuario = new ArrayList<>();
                    RespuestaUsuarioImp respuestaUsuarioImp = new RespuestaUsuarioImp();

                    //Obtener el objeto de sesionn usuario
                    alRespuestaUsuario = respuestaUsuarioImp.ListarIdUsuario(usuario.getUsuarioId());

                    if (encuesta != null) {
                        out.print("<div class=\"listQuestion\" id=\"listQuestion\"> <div class=\"listQuestion__title\"> <i class=\"fas fa-list\"></i><p>" + encuesta.getEncuestaNombre() + "</p> </div><div class=\"listQuestion__body\"> <form action=\"#\" method=\"get\" class=\"formSearch\"> <input required type=\"text\" name=\"txtSearchTitle\" class=\"inputBuscador\" placeholder=\"Buscar\"> <i class=\"fas fa-search\"></i> </form> <div class=\"cards\" id=\"cards\">");
                        RespuestasImpt respuestasImpt = new RespuestasImpt();
                        PreguntasImp preguntasImp = new PreguntasImp();

                        //Session encuesta
                        encuesta = (Encuesta) session.getAttribute("encuesta");
                        if (preguntasImp.ListarIDEncuesta(encuesta.getEncuestaId()).size() > 0) {
                            int i = 1;
                            String respuestaCliente = "";
                            int idAnteriorPregunta = 0;
                            for (Preguntas pre : preguntasImp.ListarIDEncuesta(encuesta.getEncuestaId())) {
                                if (respuestasImpt.ListarIDPregunta(pre.getPreguntaId()).size() > 0) {
                                    out.print("<form class=\"card\" method=\"post\" action=\"ClienteControlador\"> <div class=\"card__header\"> <p class=\"numero\">" + i + ")</p></div>"
                                            + "<div class=\"card__body\"><Label>" + pre.getPregunta() + "</Label>");
                                    //Verificamos si la respuesta ya fue contestada
                                    String[] abcd = {"A", "B", "C", "D"};
                                    int ite = 0;
                                    for (Respuestas res : respuestasImpt.ListarIDPregunta(pre.getPreguntaId())) {
                                        boolean bandera = false;
                                        if (alRespuestaUsuario.size() > 0 || alRespuestaUsuario != null) {
                                            ite = 0;
                                            for (RespuestaUsuario elem : alRespuestaUsuario) {
                                                if (elem.getRespuestaId() == res.getRespuestaId()) {
                                                    bandera = true;
                                                    respuestaCliente = elem.getRespuesta();
                                                    break;
                                                }
                                                ite++;
                                            }
                                        }
                                        if (idAnteriorPregunta != pre.getPreguntaId()) {
                                            idAnteriorPregunta = pre.getPreguntaId();
                                            if (bandera) {
                                                out.print("<label style=\"margin-bottom:1em;\">" + abcd[ite] + ") "+ respuestaCliente + "</label>");
                                            } else {
                                                if (pre.getPreguntaTipo() > 0) {
                                                    out.print("<select name=\"respuesta\" id=\"option\">");
                                                    ite = 0;
                                                    for (Respuestas res2 : respuestasImpt.ListarIDPregunta(pre.getPreguntaId())) {
                                                        if (res2.getPreguntaId() == res.getPreguntaId()) {
                                                            out.print("<option value=" + res2.getRespuesta() + ">" + abcd[ite] + ") " + res2.getRespuesta() + "</option>");
                                                        }
                                                        ite++;
                                                    }
                                                    out.print("</select>");
                                                } else {
                                                    out.print("<input required type=\"text\" class=\"inputText\" placeholder=\"Respuesta\" style=\"width: 100%; margin-bottom:1em;\" name=\"respuesta1\">");
                                                }
                                                out.print("<button type=\"submit\" class=\"btn btnGuardar\" name=\"btnGuardar\">Guardar</button>");
                                            }
                                            out.print("<input required type=\"text\" class=\"inputText\" name=\"txtIDrespuesta\" Style=\"Display: none;\" value=\"" + res.getRespuestaId() + "\">");
                                            out.print("</div></form>");
                                        }
                                    }
                                }
                                i++;
                            }
                        }
                    } else {
                        out.print("Selecciona una encuesta");
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
