<%-- 
    Document   : enviarCorreos
    Created on : 20-11-2017, 1:12:29
    Author     : Seba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enviar Correos</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <h1>Enviar Correos</h1>
        <form method="post" action="ControladorEnviarCorreos">
            <div class="marco">
            <p>Clic para enviar correos</p>
            <input type="submit" name="opcion" value="Enviar">
            </div>
            <a href="Coordinador.jsp"><button class="boton" type="button">Atras</button></a>
        </form>
    </body>
</html>
