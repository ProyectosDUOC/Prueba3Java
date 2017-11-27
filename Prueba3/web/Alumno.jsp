<%-- 
    Document   : Alumno
    Created on : 18-11-2017, 20:44:23
    Author     : Seba
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.*"%>
<%@page import="dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alumno</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style1.css" type="text/css" rel="stylesheet" media="screen,projection"/>

        <%
            ControlUsuario user = (ControlUsuario) session.getAttribute("usuario");
            if (user == null) response.sendRedirect("error.jsp");
            int rutAlumno = user.getRutUsuario();
            Alumno alu = (new AlumnoDAO()).buscarDatos(rutAlumno);
            if (alu == null) response.sendRedirect("error.jsp");
            ArrayList<Inasistencia> faltas = (new InasistenciaDAO()).buscarRut(rutAlumno);
            ClasesConsultas consultaBD = new ClasesConsultas();
        %>
    </head>
    <body>
        <div class="container">
            <h1 class="yellow darken-1">Menu Alumno</h1>
            <form action="ControladorAlumno" method="post" >
                <button class="btn waves-effect waves-light red right" type="submit" name="opcion" value="Salir">
                    Cerrar Sesion
                </button>
                <h3 class="black-text">Datos Alumno</h3>               
                <ul>
                    <li class="amber darken-3 black-text">Nombre: <%=alu.getPnombre() + " " + alu.getAppaterno() + " " + alu.getApmaterno()%></li>
                    <li class="amber darken-3 black-text">Rut: <%=rutAlumno + "-" + alu.getDvAlumno()%> </li>
                </ul>
                <table class=" grey lighten-2">
                    <tr class="amber darken-3">
                        <th>Ramo</th>
                        <th>Fecha</th>
                        <th>Estado</th>
                        <th>Accion</th>
                    </tr>
                    <% for (Inasistencia falta : faltas) {   %>
                    <tr>  
                        <%  if (falta.getIdEstadoi() != 0) {%>
                        <td><%=falta.getIdSeccion()%></td>
                        <td><%=falta.getFecha()%></td>
                        <td><%=consultaBD.buscarEstadoInasistencia(falta.getIdEstadoi()).getNombreEstadoi()%></td>
                        <td>
                            <% if (falta.getIdEstadoi() == 1) {%>
                            <button 
                                class="btn waves-effect waves-light indigo darken-3" 
                                type="submit" 
                                name="opcion" 
                                value="j<%=falta.getIdInasistencia()%>"> 
                                Justificar 
                            </button>
                            <% }%>
                        </td>   
                        <% } %>
                    </tr>
                    <% }%>
                </table>    
                <button class="btn waves-effect waves-light red " type="submit" name="opcion" value="Salir">
                    Cerrar Sesion
                </button>
            </form>                
        </div>       
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/init.js"></script>
    </body>
</html>
