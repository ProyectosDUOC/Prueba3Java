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
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body><div class="marco">
        <h1>Menu Coordinador</h1>
        <form action="MenuCoordinador" method="post" >
            <input class="boton" type="submit" name="opcion" value="Subir Inasistencias"/>
            <input class="boton" type="submit" name="opcion" value="Enviar Correos"/>
            <input class="boton" type="submit" name="opcion" value="Ver datos"/>
        </form></div>
    </body>
</html>
