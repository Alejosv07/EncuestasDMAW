<%-- 
    Document   : pdf
    Created on : Nov 19, 2021, 11:48:29 AM
    Author     : rober
--%>

<%@page import="Clases.Conexion"%>
<%@page import="java.net.URL"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reportes</title>
    </head>
    <body>
        <%
            String accion = request.getParameter("target");
            if (request.getParameter("target") != null && request.getParameter("id") == null) { //nombres de encuestas
                Conexion conexion = new Conexion();
                Connection con = conexion.conectar();
                File reportFile = new File(application.getRealPath("/reportes/encuestaNombres.jasper"));
                Map<String, Object> parametro = new HashMap();
                byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parametro, con);
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ServletOutputStream salida = response.getOutputStream();
                salida.write(bytes, 0, bytes.length);
                salida.flush();
                salida.close();
            } else if (request.getParameter("target") != null && request.getParameter("id") != null) { // preguntas de la encuesta
                Conexion conexion = new Conexion();
                Connection con = conexion.conectar();
                File reportFile = new File(application.getRealPath("/reportes/encuestaPreguntas.jasper"));
                Map<String, Object> parametro = new HashMap();
                parametro.put("Id", Integer.valueOf(request.getParameter("id")));
                parametro.put("Titulo", request.getParameter("titulo"));
                byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parametro, con);
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ServletOutputStream salida = response.getOutputStream();
                salida.write(bytes, 0, bytes.length);
                salida.flush();
                salida.close();
            }
        %>
    </body>
</html>
