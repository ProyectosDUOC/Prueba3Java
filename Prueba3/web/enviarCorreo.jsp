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
            <table>
                <tr>
                    <td>mi correo: </td>
                    <td><input type="text" name="miCorreo" value="controlinasistencia@gmail.com" required="required"></td>
                </tr>
                <tr>
                    <td>Contraseña </td>
                    <td><input type="password" name="pass" value="abcd14abcd" required="required"></td>
                </tr>
                <tr>
                    <td>Destino: </td>
                    <td><input type="text" name="destino" required="required"></td>
                </tr> 
                <tr>
                    <td>Asunto: </td>
                    <td><input  type="text" name="asunto" required="required"></td>
                </tr>
                <tr>
                    <td>Texto: </td>
                    <td><input type="text" name="mensaje" required="required"></td>
                </tr>
            </table>
            <input type="submit" name="opcion"  value="Enviar"><br>
        </form>
    </body>
</html>
