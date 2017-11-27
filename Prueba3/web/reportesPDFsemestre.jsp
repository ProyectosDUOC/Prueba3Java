<%-- 
    Document   : reportesPDFsemestre
    Created on : 26-nov-2017, 22:51:49
    Author     : benja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report PDF</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style1.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    </head>
    <body>
        <div class="container">
            <h1>Reporte por año y semestre especifico</h1>
            <form action="ControladorDirector" method="POST">
                <table border="1">   
                    <tr>
                        <td>Semestre</td>
                        <td>Año</td>
                    </tr>
                    <tr>
                        <td>
                            <select name="semestre" required="required">
                                <option value="" disabled selected>Seleccione Semestre</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                            </select></td>
                        <td>   <select name="anio" required="required">
                                <option value="" disabled selected>Seleccione un año</option>
                                <option value="2017">2017</option>
                                <option value="2016">2016</option>
                                <option value="2015">2015</option>
                                <option value="2014">2014</option>
                                <option value="2013">2013</option>
                            </select>
                        </td>   
                    <input type="submit" value="Enviar" name="Opcion" />
                    </tr>
                </table>
            </form>            
        </div>      
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/init.js"></script>
    </body>
</html>
