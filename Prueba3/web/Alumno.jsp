<%-- 
    Document   : Alumno
    Created on : 18-11-2017, 20:44:23
    Author     : Seba
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.*"%>
<%@page import="dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alumno</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">

        <%
            ControlUsuario user = (ControlUsuario) session.getAttribute("usuario");
            if (user == null) {
                response.sendRedirect("error.jsp");
            }
            int rutAlumno = user.getRutUsuario();
            Alumno alu = (new AlumnoDAO()).buscarDatos(rutAlumno);
            if (alu == null) {
                response.sendRedirect("error.jsp");
            }
            ArrayList<Inasistencia> faltas = (new InasistenciaDAO()).buscarRut(rutAlumno);
            ClasesConsultas consultaBD = new ClasesConsultas();
        %>
    </head>
    <body>
        <h1>Menu Alumno</h1>

        <form action="ControladorAlumno" method="post" >
            <h2>Datos Alumno</h2>
            <ul>
                <li>Nombre: <%=alu.getPnombre() + " " + alu.getAppaterno() + " " + alu.getApmaterno()%></li>
                <li>Rut: <%=rutAlumno + "-" + alu.getDvAlumno()%> </li>
            </ul>
            <table>
                <tr>
                    <th>Ramo</th>
                    <th>Fecha</th>
                    <th>Estado</th>
                    <th>Accion</th>
                </tr>
                <% for (Inasistencia falta : faltas) {   %>
                <tr>
                    <%  if (falta.getIdEstadoi() != 0) {%>
                    <td><%=falta.getIdSeccion()%></td>
                    <td><%=falta.getFecha()%></td>
                    <td><%=consultaBD.buscarEstadoInasistencia(falta.getIdEstadoi()).getNombreEstadoi()%></td>
                    <td>
                        <% if (falta.getIdEstadoi() == 1) {%>
                        <button 
                            class="btn waves-effect waves-light" 
                            type="submit" 
                            name="opcion" 
                            value="j<%=falta.getIdInasistencia()%>"> 
                            Justificar 
                        </button>
                        <%}
                        %>
                    </td>   
                    <%
                        }
                    %>

                </tr>
                <% }%>
            </table>
            <button class="btn waves-effect waves-light" type="submit" name="opcion" value="Salir">
                Salir
            </button>
        </form>
    </body>
</html>
