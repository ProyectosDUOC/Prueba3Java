<%-- 
    Document   : enviarCorreo
    Created on : 18-nov-2017, 22:22:50
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
        <h1>WEB correo</h1>
        <form method="POST" action="ControladorServletCorreo">
            mi correo: <input type="text" name="miCorreo" value="controlinasistencia@gmail.com" required="required"><br>
            Contraseña <input  type="password" name="pass" value="abcd14abcd" required="required"><br>            
            Destino: <input type="text" name="destino" required="required"><br>
            Asunto: <input  type="text" name="asunto" required="required"><br>
            Texto: <input type="text" name="mensaje" required="required"><br>
            <input type="submit" name="opcion"  value="enviar"><br>
        </form>
    </body>
</html>
