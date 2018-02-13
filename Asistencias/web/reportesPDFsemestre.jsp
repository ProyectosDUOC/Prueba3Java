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
        <title>Reportes por Año y Semestre</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style1.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    </head>
    <body>          
        <form action="ControladorDirector" method="POST"> 
            <div class="section">
                <div class="row">
                    <div class="col s12 "> 
                        <h1 class="yellow darken-1">Reporte por año y semestre especifico</h1>                           
                        <div class="col s12 m6 l3"></div>
                        <div class="col s12 m6 l3">
                            <select name="semestre" required="required">
                                <option value="" disabled selected>Seleccione Semestre</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                            </select> 
                            <label>Semestre</label>
                        </div>
                        <div class="col s12 m6 l3">
                            <select name="anio" required="required">
                                <option value="" disabled selected>Seleccione un año</option>
                                <option value="2017">2017</option>
                                <option value="2016">2016</option>
                                <option value="2015">2015</option>
                                <option value="2014">2014</option>
                                <option value="2013">2013</option>
                            </select>   
                            <label>Año</label>
                        </div>
                         <div class="col s12 m6 l3"> <button class="btn-large waves-effect waves-light  indigo darken-3" type="submit" name="Opcion" value="Enviar">
                            Solicitar<i class="material-icons right">cached</i>   </div>
                           <div class="col s12 m6 l3"><a  class="white-text btn-large  waves-effect waves-light  red" href="Director.jsp">Volver</a></div>
                         
                    </div>
                </div>
            </div>        
        </form>    

        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/init.js"></script>
        <script>
            $(document).ready(function () {
                $('select').material_select();
            });
        </script>  
    </body>
</html>
