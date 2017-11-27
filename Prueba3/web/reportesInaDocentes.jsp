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

        <form name="reporte" action="ControladorPDF">
            <h1 class="yellow darken-1">Reporte Inasistencias en pdf</h1>       
            <button class="btn-large waves-effect waves-light  indigo darken-3 center-align" type="submit" name="btnver" value="Visualizar PDF" >
                Crear PDF<i class="material-icons right">picture_as_pdf
                </i>
            </button>
            <a  class="white-text btn-large  waves-effect waves-light  red" href="Director.jsp">Volver</a>
       
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
                order by rut_docente;
            </sql:query>
            <table border="1" class=" grey lighten-2">
                <thead>
                    <tr class="amber darken-3">                    
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
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/init.js"></script>
    </body>
</html>
