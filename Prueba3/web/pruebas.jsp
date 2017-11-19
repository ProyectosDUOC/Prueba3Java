<%-- 
    Document   : pruebas
    Created on : 19-nov-2017, 18:14:19
    Author     : benja
--%>

<%@page import="modelo.Alumno"%>
<%@page import="dao.AlumnoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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

              <select name="motivos">
                    <option value="" disabled selected>Seleccion un motivo</option>                    
                    <%
                        ArrayList<Alumno> arrayMotivos = new ArrayList();
                        arrayMotivos = new AlumnoDAO().mostrarDatos();
                        for (Alumno mot : arrayMotivos) {
                    %>                    
                    <option value="<%= mot.getRutAlumno()%>" > <%= mot.getPnombre()%> </option>                    

                    <%   }
                    %>
                </select>   
    </body>
</html>
