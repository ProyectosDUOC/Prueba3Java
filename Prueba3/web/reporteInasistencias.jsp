<%-- 
    Document   : reporteInasistencias
    Created on : 19-11-2017, 22:03:06
    Author     : carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Reporte Inasistencias</h1>

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

        <table border="1">
            <thead>
                <tr>
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


        <a href="Director.jsp">Volver</a>
    </body>
</html>
