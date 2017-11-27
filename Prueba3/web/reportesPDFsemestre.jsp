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
        <title>JSP Page</title>
    </head>
    <body>
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
    </body>
</html>
