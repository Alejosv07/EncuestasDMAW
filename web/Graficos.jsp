<%-- 
    Document   : Graficos.jsp
    Created on : 25-nov-2021, 23:12:17
    Author     : Urban
--%>

<%@page import="Clases.GraficoPreguntaMasResuelta"%>
<%@page import="Clases.ConsultasGraficosImp"%>
<%@page import="Clases.GraficoEncuestaMasRespondida"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/styles.css">
        <script src="https://cdn.jsdelivr.net/npm/chart.js@3.6.0/dist/chart.min.js"></script>
        <style></style>
        <title>Encuestadora</title>
    </head>

    <body>
        <!-- header -->
        <header class="header">
            <ul class="ul">
                <li class="item">
                    <a href="IndexAdmi.jsp" style="text-decoration: none">
                        <h1 class="brand">Encuestadora</h1>
                    </a>
                </li>
                <li class="item">
                    <a href="Graficos.jsp" style="text-decoration: none; background: white; margin: 0; padding: 0 0.5em; border-radius: 8px">
                        <h3 style="color: #1E1731">Graficos</h3>
                    </a>
                    <div id="identificator">
                        <p class="text">Administrador</p>
                        <i class="fas fa-user"></i>
                    </div>
                    <a type="submit" class="btn btn--vacio" href="CerrarSesionControlador">
                        <i class="fas fa-sign-out-alt"></i>
                    </a>
                </li>
            </ul>
        </header>
        <div class="containerGraficos" style="display: flex; flex-wrap: wrap; justify-content: center; padding: 2em; gap: 2em; height: 80vh;">
            <div style="box-shadow: 0 3px 6px; padding: 1em">
                <h4>Encuestas más respondidas</h4>
                <canvas id="encuestaMasrepondida"></canvas>
            </div>
            <div style="box-shadow: 0 3px 6px; padding: 1em">
                <h4>Preguntas más respondidas</h4>
                <canvas id="preguntaMasrepondida"></canvas>
            </div>
        </div>
        <footer class="footer">
            <h6 class="brandFooter">Design by BALR</h6>
            <a class="github link" href="https://github.com/Alejosv07">
                follow me
                <i class="fab fa-github"></i>
            </a>
        </footer>
        <script>
            <%
                ConsultasGraficosImp consultasG = new ConsultasGraficosImp();
                ArrayList<GraficoEncuestaMasRespondida> alEncuestaMR = new ArrayList<>();
                ArrayList<GraficoPreguntaMasResuelta> alPreguntaMR = new ArrayList<>();

                //Encuesta
                alEncuestaMR = consultasG.ListarEncuestaMRespondida();
                String encuestasNombre = "";
                String encuestasDatos = "";
                String colors = "";
                for (GraficoEncuestaMasRespondida e : alEncuestaMR) {
                    encuestasNombre += "'" + e.getEncuestaNombre() + "',";
                    encuestasDatos += "'" + e.getnREncuesta() + "',";
                    colors += "'rgba(" + Math.floor(Math.random() * 250) + ", " + Math.floor(Math.random() * 250) + ", " + Math.floor(Math.random() * 250) + ", 0." + (Math.round(Math.random() * 8) + 1) + ")',";
                }
                //Preguntas
                alPreguntaMR = consultasG.ListarPreguntaMRespondida();
                String preguntaNombre = "";
                String preguntaDatos = "";
                String colors2 = "";
                for (GraficoPreguntaMasResuelta e : alPreguntaMR) {
                    preguntaNombre += "'" + e.getPregunta() + "',";
                    preguntaDatos += "'" + e.getnRespuesta() + "',";
                    colors2 += "'rgba(" + Math.floor(Math.random() * 250) + ", " + Math.floor(Math.random() * 250) + ", " + Math.floor(Math.random() * 250) + ", 0." + (Math.round(Math.random() * 8) + 1) + ")',";
                }
            %>
            const ctx = document.getElementById('encuestaMasrepondida');
            const ctx2 = document.getElementById('preguntaMasrepondida');
            const myChart = new Chart(ctx, {
                type: 'pie',
                responsive: false,
                data: {
                    labels: [<%=encuestasNombre%>],
                    datasets: [{
                            label: '# of Votes',
                            data: [<%=encuestasDatos%>],
                            backgroundColor: [<%=colors%>],
                            borderColor: [<%=colors%>],
                            borderWidth: 1
                        }]
                },
            });
            const myChart2 = new Chart(ctx2, {
                type: 'pie',
                responsive: false,
                data: {
                    labels: [<%=preguntaNombre%>],
                    datasets: [{
                            label: '# of Votes',
                            data: [<%=preguntaDatos%>],
                            backgroundColor: [<%=colors2%>],
                            borderColor: [<%=colors2%>],
                            borderWidth: 1
                        }]
                },
            });
        </script>
    </body>

</html>
