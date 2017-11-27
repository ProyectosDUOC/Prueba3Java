<%-- 
    Document   : Director
    Created on : 18-11-2017, 20:44:51
    Author     : Seba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MEnu director</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body><div class="marco">
        <h1>Director de Carrera</h1>
        <form method="POST" action="ControladorDirector">
            <input class="boton" type="submit" value="Reporte por Semestre" name="Opcion" />
            <input class="boton" type="submit" value="Acceder" name="Opcion" />
            <input class="boton" type="submit" value="Checkeado por docente" name="Opcion" />
            <input class="boton" type="sumbit" value="Inasistencias" name="Opcion" />
            <input class="boton" type="submit" name="Opcion" value="Salir"/>
        </form></div>
    </body>
</html>
