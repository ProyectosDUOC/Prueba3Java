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
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style1.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    </head>
    <body>
        <%
            String idInasistencia = request.getParameter("id");
            session.setAttribute("inaActual", idInasistencia);
        %>
        <div class="container">
            <form action="ControladorJustificar" method="post">
                <h1 class="yellow darken-1 center-align">Justificacion</h1>
                <table class=" grey lighten-2">
                    <tr>
                        <td >Motivo:</td>
                        <td class="col s12 m6 l3">
                            <select name="motivo" class="yellow darken-1 center-align" required="required">
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
                        <td>Glosa: <i class="material-icons prefix">textsms</i></td>                       
                        <td>
                            <div class="row">                                
                                <div class="row">
                                    <div class="input-field col s12">
                                        <textarea name="glosa" rows="10" cols="30" id="textarea1" class="materialize-textarea" required="required"></textarea>
                                        <label for="textarea1">Comente sus motivos</label>
                                    </div>
                                </div>                                
                            </div>
                        </td>
                    </tr>
                </table>
                <button class="btn-large waves-effect waves-light" type="submit" name="opcion" value="Guardar">
                    Guardar
                </button>
                <a  class="white-text btn-large  waves-effect waves-light  red" href="Alumno.jsp">Volver</a>

            </form>
        </div>
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
