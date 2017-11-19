<%-- 
    Document   : Coordinador
    Created on : 18-11-2017, 20:45:00
    Author     : Seba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Coordinador</h1>
        <form action="upload" method="post" enctype="multipart/form-data">
            <input type="file" name="file"  accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"/>
            <input type="submit" value="Subir" />
        </form>
    </body>
</html>
