<%-- 
    Document   : reportesInaDocentes
    Created on : 19-nov-2017, 22:15:05
    Author     : benja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="reporte" action="ControladorPDF">
        <h1>Hello World!</h1>
        <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="sql"   uri="http://java.sun.com/jstl/sql" %>


        <sql:setDataSource
            driver="com.mysql.jdbc.Driver"
            url="jdbc:mysql://localhost:3306/instituto"
            user="root"
            password=""/>      

        <sql:query var="consulta">               
            SELECT *
            FROM docente JOIN seccion using(rut_docente) 
            JOIN inasistencia using(id_seccion)
            JOIN justificacion using(id_inasistencia)
            JOIN motivo  using(id_motivo) where id_estadoi=3;
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
                    </tr>
                </c:forEach>
            </tbody>
        </table>           
            <h1>Hola<h1>
            <input type="submit" value="Visualizar PDF" name="btnver" />
        </form>
    </body>
</html>
