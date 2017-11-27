<%-- 
    Document   : Director
    Created on : 18-11-2017, 20:44:51
    Author     : Seba
--%>

<%@page import="modelo.ControlUsuario"%>
<%@page import="modelo.ControlUsuario"%>
<%@page import="modelo.Seccion"%>
<%@page import="dao.ClasesConsultas"%>
<%@page import="dao.DirectorDAO"%>
<%@page import="modelo.Director"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu director</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style1.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    </head>
    <body>
        <div class="section">
            <div class="container">            
                <h1 class="yellow darken-1 center-align">Director de Carrera</h1>   

                <form method="POST" action="ControladorDirector">
                    <table border="1" class="center-align">   
                        <tr>
                            <td>
                                <button class="btn-large waves-effect waves-light  indigo darken-3" type="submit" name="Opcion" value="Acceder">
                                    Inasistencias Justificadas<i class="material-icons">cached</i>
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <button class="btn-large waves-effect waves-light  indigo darken-3" type="submit" name="Opcion" value="Checkeado por docente">
                                    Checkeado por docente <i class="material-icons">check</i>
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <button class="btn-large waves-effect waves-light  indigo darken-3" type="submit" name="Opcion" value="Reporte por Semestre">
                                    Reporte por Semestre
                                </button>
                            </td>
                        </tr> 
                        <tr>
                            <td>
                                <button class="btn-large waves-effect red waves-light " type="submit" namewaves="Opcion" value="Salir">
                                    Salir <i class="material-icons right">exit_to_app</i>
                                </button> 
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
