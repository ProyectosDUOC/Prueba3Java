<%-- 
    Document   : enviarCorreo
    Created on : 18-nov-2017, 22:22:50
    Author     : benja
--%>

<%@page import="dao.ClasesConsultas"%>
<%@page import="modelo.Motivo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>WEB correo</h1>
        <form method="POST" action="ControladorServletCorreo">
            <table>
                <tr>
                    <td>mi correo: </td>
                    <td><input type="text" name="miCorreo" ></td>
                </tr>
                <tr>
                    <td>Contraseña </td>
                    <td><input type="password" name="pass"></td>
                </tr>
                <tr>
                    <td>Destino: </td>
                    <td><input type="text" name="destino" ></td>
                </tr> 
                <tr>
                    <td>Asunto: </td>
                    <td><input  type="text" name="asunto"></td>
                </tr>
                <tr>
                    <td>Texto: </td>
                    <td><input type="text" name="mensaje"></td>
                </tr>
            </table>
            <input type="submit" name="opcion"  value="Enviar"><br>
        </form>
        
          <div class="input-field col s12">
                <select name="motivos">
                    <option value="" disabled selected>Seleccion un motivo</option>                    
                    <%
                        ArrayList<Motivo> arrayMotivos = new ArrayList();
                        arrayMotivos = new ClasesConsultas().mostrarMotivos();
                        for (Motivo mot : arrayMotivos) {
                    %>                    
                    <option value="<%= mot.getIdMotivo()%>" > <%= mot.getNombreMotivo()%> </option>                    

                    <%   }
                    %>
                </select>                
            </div>
    </body>
</html>
