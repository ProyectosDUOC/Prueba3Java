<%-- 
    Document   : reportesSemetrales
    Created on : 20-nov-2017, 12:28:37
    Author     : benja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reportes Semestral</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style1.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    </head>
    <body>
        <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="sql"   uri="http://java.sun.com/jstl/sql" %>      
        <sql:setDataSource
            driver="com.mysql.jdbc.Driver"
            url="jdbc:mysql://localhost:3306/instituto"
            user="root"
            password=""/>

        <c:set var="filtro" value="where anio=${param.anio} and semestre=${param.sem}"/> 

        <sql:query var="consulta">               
            SELECT 
            nombre_motivo , count(id_motivo) AS contador, id_motivo FROM instituto.justificacion INNER join instituto.motivo using(id_motivo) 
            where id_inasistencia in (select 
            id_inasistencia
            from 
            instituto.alumno join instituto.detalle_seccion using(rut_alumno) join instituto.inasistencia using(rut_alumno) 
            ${filtro}
            group by id_inasistencia) and id_estadoj = 1
            group by id_motivo;
        </sql:query>
        <sql:query var="Motivos">               
            SELECT 
            *
            FROM motivo;
        </sql:query>
        <sql:query var="NoS">               
            SELECT 
            nombre_motivo, 0 as Valor
            FROM instituto.motivo where nombre_motivo <> ' ' and id_motivo not in ( Select id_motivo from instituto.justificacion where id_inasistencia in ( select 
            id_inasistencia
            from 
            instituto.alumno join instituto.detalle_seccion using(rut_alumno) join instituto.inasistencia using(rut_alumno) 
            ${filtro}  
            group by id_inasistencia)     group by id_motivo);

        </sql:query>    
        <div class="container">
            <h1> Reportes por paramentros</h1>
            <h2> Semestre: ${param.sem}  Año: ${param.anio}</h2>
            
            <table border="1"  class=" grey lighten-2">
                <thead class="amber darken-3">
                    <tr>      
                        <th>Motivo</th> 
                        <th>Cantiadad</th>
                    </tr>
                </thead>
                <tbody>     
                    <c:forEach var="mot" items="${Motivos.rows}">                   
                        <c:forEach var="row" items="${consulta.rows}">
                            <c:if test = "${row.nombre_motivo == mot.nombre_motivo}">
                                <tr>
                                    <td> ${row.nombre_motivo}</td>
                                    <td class="blue-text"> ${row.contador}</td>
                                </tr>
                            </c:if>                              
                        </c:forEach>
                    </c:forEach>   
                    <c:forEach var="no" items="${NoS.rows}">                   
                        <tr>
                            <td> ${no.nombre_motivo}</td>
                            <td class="blue-text"> ${no.valor}</td>
                        </tr>
                    </c:forEach>  
                </tbody>           
            </table>   
            <a  class="white-text btn-large  waves-effect waves-light  red" href="Director.jsp">Volver</a>
        </div>
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/init.js"></script>
    </body>
</html>
