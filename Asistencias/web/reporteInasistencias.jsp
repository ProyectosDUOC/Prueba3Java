<%-- 
    Document   : reporteInasistencias
    Created on : 19-11-2017, 22:03:06
    Author     : carlos
--%>

<%@page import="modelo.ControlUsuario"%>
<%@page import="dao.ClasesConsultas" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inasistencia por alumno</title>
        <% ControlUsuario user = (ControlUsuario) session.getAttribute("usuario"); %>
        <% if (user == null) {
                response.sendRedirect("error.jsp");
            }%>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style1.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    </head>
    <body>
        <h1 class="yellow darken-1 center-align">Reporte Inasistencias</h1>

        <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="sql"   uri="http://java.sun.com/jstl/sql" %>


        <sql:setDataSource
            driver="com.mysql.jdbc.Driver"
            url="jdbc:mysql://localhost:3306/instituto"
            user="root"
            password=""/>      

        <sql:query var="reportes">
            select  * from justificacion JOIN inasistencia using(id_inasistencia) JOIN alumno using (rut_alumno) join motivo USING(id_motivo) where id_estadoj = 1;
        </sql:query>
        <div class="container">
            <div class="row">
                <a  class="white-text btn  waves-effect waves-light  red" href="${sessionScope.tipoUsuario}.jsp">Volver</a>

                <table border="1" class="striped grey lighten-2">
                    <thead>
                        <tr class="amber darken-3 black-text">
                            <th>Rut Alumno</th> 
                            <th>Nombre Alumno</th>
                            <th>Fecha Inasistencia</th>
                            <th>Seccion</th>
                            <th>Motivo</th>
                            <th>Descripcion del Motivo</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="row" items="${reportes.rows}">
                            <tr>
                                <td>${row.rut_alumno} - 
                                    ${row.dv_alumno}</td>
                                <td>
                                    ${row.pnombre}
                                    ${row.snombre}
                                    ${row.appaterno}
                                    ${row.apmaterno}
                                </td>
                                <td>
                                    ${row.fecha}
                                </td>
                                <td>
                                    ${row.id_seccion}
                                </td>
                                <td>
                                    ${row.nombre_motivo} 
                                </td>
                                <td>
                                    ${row.glosa}
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <a  class="white-text btn-large  waves-effect waves-light  red" href="${sessionScope.tipoUsuario}.jsp">Volver</a>
            </div>
        </div>    
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/init.js"></script>
    </body>
</html>
