<%-- 
    Document   : enviarCorreos
    Created on : 20-11-2017, 1:12:29
    Author     : Seba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style1.css" type="text/css" rel="stylesheet" media="screen,projection"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enviar Correos</title>
    </head>
    <body>        
        <div class="container">
            <h1 class="yellow darken-1 center-align">Enviar Correos</h1>
            <div class="col s12 m4 l8">
                <form method="post" action="ControladorEnviarCorreos">
                    <table border="1">
                        <tr>
                            <td>                                                          
                                <p class="red-text"><strong>Clic para enviar correos</strong></p>
                                <button class="btn-large waves-effect waves-light yellow black-text" type="submit" name="opcion" value="Enviar">Enviar</button>
                            </td>
                            <span id="mensaje"> ${param.mensaje}</span>
                        </tr>
                        <tr>
                            <td>
                                <a  class="white-text btn-large  waves-effect waves-light  red" href="Coordinador.jsp">Volver</a>
                            </td>
                        </tr>
                    </table>                  
                </form>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/init.js"></script>
    </body>
</html>
