<%-- 
    Document   : reportesInaDocentes
    Created on : 19-nov-2017, 22:15:05
    Author     : benja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inasistencias por docente</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style1.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    </head>
    <body>
        <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="sql"   uri="http://java.sun.com/jsp/jstl/sql" %>
        <% ControlUsuario user = (ControlUsuario) session.getAttribute("usuario"); %>
        <% if (user == null) {
                response.sendRedirect("error.jsp");%>
        <% String profe = user.getRutUsuario().toString();%>
        <c:set var="filtro" value="where rut_docente=${profe}"/>
        <div class="container">
            <form name="reporte" action="ControladorPDF">
                <h1 class="yellow darken-1">Reporte Inasistencias</h1>
                <input type="submit" value="Visualizar PDF" name="btnver" />
                <sql:setDataSource
                    driver="com.mysql.jdbc.Driver"
                    url="jdbc:mysql://localhost:3306/instituto"
                    user="root"
                    password=""/>    
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
                <table border="1">
                    <thead>
                        <tr>                    
                            <th>Rut Docente</th> 
                            <th>Nombre Docente</th>
                            <th>Seccion</th>
                            <th>Rut alumno</th>
                            <th>Fecha inasistencia</th>
                            <th>Motivo</th>
                            <th>Dscripcion del Motivo</th>
                            <th>Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="row" items="${consulta.rows}">
                            <tr>
                                <td>${row.rut_docente} - 
                                    ${row.dv_docente}</td>
                                <td>
                                    ${row.pnombre}
                                    ${row.snombre}
                                    ${row.appaterno}
                                    ${row.apmaterno}
                                </td>
                                <td>
                                    ${row.id_seccion}
                                </td>
                                <td>${row.rut_alumno}</td>
                                <td>
                                    ${row.fecha} 
                                </td>
                                <td>
                                    ${row.nombre_motivo} 
                                </td>
                                <td>
                                    ${row.glosa}
                                </td>
                                <td>${row.nombre_estadoi}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>      
            </form>
        </div>
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/init.js"></script>
    </body>
</html>
