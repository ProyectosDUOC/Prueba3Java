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
        <title>Coordinador</title>
        <link rel="stylesheet" type="text/css" href="css/login.css">
    </head>
    <body>
        <h1>Menu Coordinador</h1>
        <form action="MenuCoordinador" method="post" >
            <div>
            <input type="button" name="opcion" value="Subir Inasistencias"/>
            <input type="button" name="opcion" value="Enviar Correos"/>
            <input type="button" name="opcion" value="Ver datos"/>
            </div>
        </form>
    </body>
</html>
