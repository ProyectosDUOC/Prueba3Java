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
        
        <%
        ControlUsuario user = (ControlUsuario) session.getAttribute("usuario"); 
        if(user==null) response.sendRedirect("error.jsp");
        int rutAlumno = user.getRutUsuario();
        Alumno alu = (new AlumnoDAO()).buscarDatos(rutAlumno);
        if(alu==null) response.sendRedirect("error.jsp");
        ArrayList<Inasistencia> faltas = (new InasistenciaDAO()).buscarRut(rutAlumno);
        %>
    </head>
    <body>
        <h1>Menu Alumno</h1>
            
        <form action="ControladorAlumno" method="post" >
            <h2>Datos Alumno</h2>
            <ul>
                <li>Nombre: <%=alu.getPnombre()+" "+alu.getAppaterno()+" "+alu.getApmaterno() %></li>
                <li>Rut: <%=rutAlumno+"-"+alu.getDvAlumno()%> </li>
            </ul>
            <table>
                <tr>
                    <th>Ramo</th>
                    <th>Fecha</th>
                    <th>Motivo</th>
                    <th>Glosa</th>
                    <th>Estado</th>
                    <th>Accion</th>
                </tr>
                <% for (Inasistencia falta : faltas) {   %>
                    <tr>
                        <td>falta</td>
                        <td>${row.fecha}</td>
                        <td>${row.nombre_motivo}</td>
                        <td>${row.glosa}</td>
                        <td>${row.nombre_estadoi}</td>
                        <td><input class="boton" type="submit" name="${row.id_inasistencia}" value="<${accionAlumno}" /></td>
                    </tr>
                <% }%>
            </table>
            <input class="boton" type="submit" name="opcion" value="Salir"/>
        </form>
    </body>
</html>
