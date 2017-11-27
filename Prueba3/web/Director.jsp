<%-- 
    Document   : Director
    Created on : 18-11-2017, 20:44:51
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
        <title>Menu director</title>
    </head>
    <body><div class="container">
            <h1 class="indigo darken-3" >Director de Carrera</h1>
            <form method="POST" action="ControladorDirector">
                <table border="1">
                    <tr>
                        <td>
                            <button class="btn-large waves-effect waves-light" type="submit" name="Opcion" value="Inasistencias Justificadas">Inasistencias Justificadas</button>   
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn-large waves-effect waves-light" type="submit" name="Opcion" value="Checkeado por docente">Checkeado por docente</button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn-large waves-effect waves-light" type="submit" name="Opcion" value="Reporte por Semestre">Reporte por Semestre</button>
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
