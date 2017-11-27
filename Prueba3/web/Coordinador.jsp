<%-- 
    Document   : Coordinador
    Created on : 18-11-2017, 20:45:00
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
        <title>Coordinador</title>
    </head>
    <body>
        <div class="container">

            <h1 class="indigo darken-3" >Menu Coordinador</h1>
            <form action="MenuCoordinador" method="post" >
                <table border="1">
                    <tr>
                        <td>
                            <button class="btn-large waves-effect waves-light" type="submit" name="Opcion" value="Subir Inasistencias">Subir Inasistencias</button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn-large waves-effect waves-light" type="submit" name="Opcion" value="Enviar Correos">Enviar Correos</button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn-large waves-effect waves-light" type="submit" name="Opcion" value="Ver datos">Ver datos</button> 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn-large waves-effect waves-light" type="submit" name="Opcion" value="Salir">Salir</button>
                        </td>
                    </tr>
                </table>

            </form></div>
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/init.js"></script>

    </body>
</html>
