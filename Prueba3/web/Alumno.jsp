<%-- 
    Document   : Alumno
    Created on : 18-11-2017, 20:44:23
    Author     : Seba
--%>

<%@page import="modelo.*"%>
<%@page import="dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alumno</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        
        <% ControlUsuario user = (ControlUsuario) session.getAttribute("usuario"); %>
        <% if(user==null) response.sendRedirect("error.jsp");%>
        <% int rutAlumno = user.getRutUsuario(); %>
        <% session.setAttribute("rutAlumno",rutAlumno+""); %>
        <% Alumno alu = (new AlumnoDAO()).buscarDatos(rutAlumno); %>
        <% if(alu==null) response.sendRedirect("error.jsp");%>
    </head>
    <body>
        <h1>Menu Alumno</h1>
        
        <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="sql"   uri="http://java.sun.com/jsp/jstl/sql" %>
        
        <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="sql"   uri="http://java.sun.com/jsp/jstl/sql" %>
        
        <sql:setDataSource
            driver="com.mysql.jdbc.Driver"
            url="jdbc:mysql://localhost:3306/instituto"
            user="root"
            password=""/>
        <c:set var="filtro" value="where rut_alumno=${sessionScope.rutAlumno}"/>        
        <sql:query var="consulta">
            SELECT *
            FROM inasistencia
            JOIN seccion using(id_seccion) 
            JOIN docente using(rut_docente)
            JOIN justificacion using(id_inasistencia)
            JOIN motivo using(id_motivo)
            JOIN estado_inasistencia using(id_estadoi)
            ${filtro}
            order by rut_docente;
        </sql:query>
            
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
                </tr>
                <c:forEach var="row" items="${consulta.rows}">
                    <tr>
                        <td>${row.id_ramo}</td>
                        <td>${row.fecha}</td>
                        <td>${row.nombre_motivo}</td>
                        <td>${row.glosa}</td>
                        <td>${row.nombre_estadoi}</td>
                        <td><input class="boton" type="submit" name="${row.id_inasistencia}" value="" /></td>
                    </tr>
                </c:forEach>
            </table>
            <input class="boton" type="submit" name="opcion" value="Salir"/>
        </form>
    </body>
</html>
