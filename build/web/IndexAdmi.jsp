<%-- 
    Document   : IndexAdmi
    Created on : 18-nov-2021, 14:53:15
    Author     : Urban
--%>

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
        <!-- header -->
        <header class="header">
            <ul class="ul">
                <li class="item">
                    <h1 class="brand">Encuestadora</h1>
                </li>
                <li class="item">
                    <div id="identificator">
                        <p class="text">Administrador</p>
                        <i class="fas fa-user"></i>
                    </div>
                    <button type="submit" class="btn btn--vacio">
                        <i class="fas fa-sign-out-alt"></i>
                    </button>
                </li>
            </ul>
        </header>

        <main class="main">
            <!-- panel agregar survey-->
            <div class="panelAgregar">
                <form action="EncuestaControlador" method="post">
                    <input type="text" name="txtNombreEncuesta" class="inputText" placeholder="Nombre de encuesta" required>
                    <button type="submit" class="btn btn--agregar">Agregar <i class="fas fa-plus"></i></button>
                </form>
            </div>
            <div class="mainbody">
                <!-- panel de listas de encuentas -->
                <div class="listSurvey">
                    <h2 class="listSurvey__title">Encuestas</h2>
                    <a class="btn btn--imprimir-todo link" href="ImprimirControlador?target=todos" target="_blink"> <i class="fas fa-print"></i></a>
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
                                    out.print("<a class=\"boxSurvey link2\" href=\"PreguntasControlador?nEncuesta=" + elem.getEncuestaId() + "&name=" + elem.getEncuestaNombre() + "\"><p class=\"boxSurvey__title\">" + elem.getEncuestaNombre() + "</p></a>");
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
                    if (encuesta != null) {
                        out.print("<div class=\"listQuestion\" id=\"listQuestion\"> <div class=\"listQuestion__title\"> <i class=\"fas fa-list\"></i> <form action=\"EncuestaControlador\" method=\"post\"> <input required type=\"text\" id=\"txtEditarEncuesta\" name=\"txtEditarEncuesta\" value=\"" + encuesta.getEncuestaNombre() + "\"> <div class=\"botonera\"> <button class=\"btn btn--editar\" id=\"btnEditar\" type=\"submit\" name=\"btnEditarEncuesta\">Editar <i class=\"fas fa-pen\"></i></button> <a class=\"btn btn--eliminar link\" href=\"EncuestaControlador?nEncuesta=" + encuesta.getEncuestaId() + "\" id=\"btnEditar\">Eliminar <i class=\"fas fa-trash-alt\"></i></a> <a class=\"btn btn--imprimir link\" href=\"EncuestaControlador?nEncuesta=" + encuesta.getEncuestaId() + "\" id=\"btnEditar\">Imprimir <i class=\"fas fa-file-pdf\"></i></a> </div></form> </div><div class=\"boxOption\"> <button type=\"submit\" name=\"btnAgregar\" class=\"btn btn--agregar\" id=\"btnAgregar\">Agregar <i class=\"fas fa-plus\"></i></button> </div><div class=\"listQuestion__body\"> <form action=\"#\" method=\"get\" class=\"formSearch\"> <input required type=\"text\" name=\"txtSearchTitle\" class=\"inputBuscador\" placeholder=\"Buscar\"> <i class=\"fas fa-search\"></i> </form> <div class=\"cards\" id=\"cards\">");
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