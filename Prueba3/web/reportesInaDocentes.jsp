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
        <h1>Hello World!</h1>
         <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="sql"   uri="http://java.sun.com/jstl/sql" %>


        <sql:setDataSource
            driver="com.mysql.jdbc.Driver"
            url="jdbc:mysql://localhost:3306/instituto"
            user="root"
            password=""/>      

        <sql:query var="alumnos">
            SELECT * FROM alumno;
        </sql:query>

        <UL>
            <c:forEach var="row" items="${alumnos.rows}">
                <li>${row.rut_alumno}
                    ${row.dv_alumno}
                    ${row.pnombre}   
                </c:forEach>
        </UL>
    </body>
</html>
