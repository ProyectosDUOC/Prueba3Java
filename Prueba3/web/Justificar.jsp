<%-- 
    Document   : Justificar
    Created on : 27-11-2017, 0:33:27
    Author     : Seba
--%>

<%@page import="modelo.*"%>
<%@page import="dao.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Justificacion</title>
    </head>
    <body>
        <%
            String idInasistencia= request.getParameter("id");
            session.setAttribute("inaActual", idInasistencia);
        %>

        <form action="ControladorJustificar" method="post">
            <h1>Justificacion</h1>
            <table>
                <tr>
                    <td>Motivo:</td>
                    <td>
                        <select name="motivo"  required="required">
                            <option value="" disabled selected>Seleccione un Motivo</option>                    
                            <%  ArrayList<Motivo> motivos = new ArrayList();
                                motivos = new ClasesConsultas().mostrarMotivos();
                                for (Motivo mot : motivos) {
                                    if (mot.getIdMotivo() != 0) {
                            %>
                            <option value="<%=mot.getIdMotivo()%>" >
                                <%= mot.getNombreMotivo()%>
                            </option>
                            <%      }
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Glosa:</td>
                    <td><textarea name="glosa" rows="10" cols="30"></textarea></td>
                </tr>
            </table>
            <button class="btn waves-effect waves-light" type="submit" name="opcion" value="Guardar">
                Guardar
            </button>
        </form>
    </body>
</html>
