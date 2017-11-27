<%-- 
    Document   : Docente
    Created on : 18-11-2017, 20:44:32
    Author     : Seba
--%>

<%@page import="modelo.Seccion"%>
<%@page import="dao.DocenteDAO"%>
<%@page import="modelo.Docente"%>
<%@page import="dao.InasistenciaDAO"%>
<%@page import="dao.AlumnoDAO"%>
<%@page import="modelo.Alumno"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ClasesConsultas"%>
<%@page import="modelo.Inasistencia"%>
<%@page import="modelo.ControlUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style1.css" type="text/css" rel="stylesheet" media="screen,projection"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Docente</title>
        <%
            ControlUsuario user = (ControlUsuario) session.getAttribute("usuario");
            if (user == null) {
                response.sendRedirect("error.jsp");
            }
            int rutDocente = user.getRutUsuario();
            Docente docente = (new DocenteDAO()).buscarDatos(rutDocente);
            if (docente == null) {
                response.sendRedirect("error.jsp");
            }

            ArrayList<Seccion> secciones = (new ClasesConsultas().mostrarSeccion());
            ArrayList<Seccion> seccionesProfe = new ArrayList<Seccion>();
            for (Seccion xx : secciones) {
                if (xx.getRutDocente() == docente.getRutDocente()) {
                    seccionesProfe.add(xx);
                }
            }


        %>
    </head>
    <body>
        <div class="container">
            <h1 class="yellow darken-1 center-align">Docente</h1>

            <button class="btn waves-effect waves-light red right" type="submit" name="opcion" value="Salir">
                Cerrar Sesion
            </button>
            <h3 class="black-text">Datos Alumno</h3>               
            <ul>
                <li class="amber darken-3 black-text">Nombre: <%=docente.getPnombre() + " " + docente.getAppaterno() + " " + alu.getApmaterno()%></li>
                <li class="amber darken-3 black-text">Rut: <%=docente.getRutDocente() + "-" + docente.getDvDocente()%></li>
            </ul>
            <h1> <%=docente.getRutDocente()%> - <%=docente.getPnombre()%>  </h1>
        </div>       
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/init.js"></script>
    </body>
</html>
