<%-- 
    Document   : index
    Created on : 18-nov-2017, 3:34:48
    Author     : benja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="css/login.css">        
    </head>
    <body>
        <h1>Sistema Asistencia</h1>
        <div id="main">
        <h1>Ingresa acá</h1>
        <form action="Login" method="post">
            <table>
                <tr>
                    <td>Usuario:</td>
                    <td><input type="text" name="txtUser"/></td>
                </tr>
                <tr>
                    <td>Contraseña:</td>
                    <td><input type="password" name="txtPass"/></td>
                </tr>
            </table>
            <div>
                <input id="entrar" type="submit" name="opcion" value="Entrar"/>
                <span id="mensaje"> ${param.mensaje}</span>
            </div>
        </form>
        </div>
    </body>
</html>