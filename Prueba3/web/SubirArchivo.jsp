<%-- 
    Document   : SubirArchivo
    Created on : 19-11-2017, 21:44:45
    Author     : Seba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subir Inasistencias</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div class="marco">
        <h1>Cargar Inasistencias</h1>
        <p>Subir archivo Excel (.xlsx) </p>
        <form action="CargarExcel" method="post" enctype="multipart/form-data">
            <input type="file" name="file"  accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"/>
            <input type="submit" value="Subir" />
        </form>
        <div class="mensaje">${param.mensaje}</div>
        <a href="Coordinador.jsp"><button class="boton" type="button">Atras</button></a>
        </div>
    </body>
</html>
