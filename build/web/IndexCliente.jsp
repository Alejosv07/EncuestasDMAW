<%-- 
    Document   : IndexAdmi
    Created on : 18-nov-2021, 14:53:15
    Author     : Urban
--%>

<%@page import="Clases.Usuarios"%>
<%@page import="Clases.RespuestaUsuarioImp"%>
<%@page import="Clases.RespuestaUsuario"%>
<%@page import="Clases.PreguntasImp"%>
<%@page import="Clases.Preguntas"%>
<%@page import="Clases.Respuestas"%>
<%@page import="Clases.RespuestasImpt"%>
<%@page import="Clases.Encuesta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clases.EncuestaImp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/styles.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;1,100;1,300;1,400;1,500&display=swap" rel="stylesheet">
        <title>Encuestadora</title>
    </head>

    <body>
        <%
            Usuarios usuario = (Usuarios) session.getAttribute("usuario");
            if (usuario == null) {
                request.getRequestDispatcher("login.jsp?error=logearse").forward(request, response);
            }
        %>
        <!-- header -->
        <header class="header">
            <ul class="ul">
                <li class="item">
                    <h1 class="brand">Encuestadora</h1>
                </li>
                <li class="item">
                    <div id="identificator">
                        <p class="text"><%
                            out.print(usuario.getUsuarioNombre());
                            %></p>
                        <i class="fas fa-user"></i>
                    </div>
                        <a type="submit" class="btn btn--vacio" href="CerrarSesionControlador">
                        <i class="fas fa-sign-out-alt"></i>
                    </a>
                </li>
            </ul>
        </header>

        <main class="main">
            <div class="mainbody">
                <!-- panel de listas de encuentas -->
                <div class="listSurvey">
                    <h2 class="listSurvey__title">Encuestas</h2>
                    <form action="#" method="get" class="formSearch">
                        <input required type="text" name="txtSearchTitle" class="inputBuscador" placeholder="Buscar">
                        <i class="fas fa-search"></i>
                    </form>

                    <!-- si hay resgistro mostrar-->
                    <div class="listSurvey__body" id="listSurvey__body">
                        <%
                            EncuestaImp encuestaImp = new EncuestaImp();
                            ArrayList<Encuesta> alEncuesta = encuestaImp.Listar();
                            if (alEncuesta.size() > 0) {
                                for (Encuesta elem : alEncuesta) {
                                    out.print("<a class=\"boxSurvey link2\" href=\"ClienteControlador?nEncuesta=" + elem.getEncuestaId() + "&name=" + elem.getEncuestaNombre() + "\"><p class=\"boxSurvey__title\">" + elem.getEncuestaNombre() + "</p></a>");
                                }
                            }
                        %>
                        <!--<div class="boxSurvey">
                            <p class="boxSurvey__title">Salud</p>
                            </div>-->
                    </div>
                </div>
                <!-- si no hay registro -->
                <!-- <h2 class="mensaje">Vaya parece que no hay encuestas registradas.</h2> -->

                <!-- si hay registro mostrar -->
                <%
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
                %>

            </div>

        </main>
        <footer class="footer">
            <h6 class="brandFooter">Design by BALR</h6>
            <a class="github link" href="https://github.com/Alejosv07">
                follow me
                <i class="fab fa-github"></i>
            </a>
        </footer>
        <script src="js/admi.js"></script>
    </body>

</html>