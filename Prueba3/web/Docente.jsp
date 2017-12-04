<%-- 
    Document   : Docente
    Created on : 18-11-2017, 20:44:32
    Author     : Seba
--%>

<%@page import="modelo.Motivo"%>
<%@page import="dao.JustificacionDAO"%>
<%@page import="modelo.Seccion"%>
<%@page import="dao.DocenteDAO"%>
<%@page import="modelo.Docente"%>
<%@page import="dao.InasistenciaDAO"%>
<%@page import="dao.AlumnoDAO"%>
<%@page import="modelo.Alumno"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ClasesConsultas"%>
<%@page import="modelo.Inasistencia"%>
<%@page import="modelo.ControlUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style1.css" type="text/css" rel="stylesheet" media="screen,projection"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Docente</title>
        <%
            ControlUsuario user = (ControlUsuario) session.getAttribute("usuario");
            if (user == null) {
                response.sendRedirect("error.jsp");
            }
            int rutDocente = user.getRutUsuario();
            Docente docente = (new DocenteDAO()).buscarDatos(rutDocente);
            if (docente == null) {
                response.sendRedirect("error.jsp");
            }
            AlumnoDAO alumnos= new AlumnoDAO();
            ClasesConsultas consultaBD = new ClasesConsultas();
            ArrayList<Seccion> secciones = consultaBD.buscarSeccionesRut(rutDocente);
            ArrayList<Inasistencia> faltas = new ArrayList();
            ArrayList<Inasistencia> faltasTemp = new ArrayList();
            InasistenciaDAO faltaDAO = new InasistenciaDAO();
            for (Seccion sec : secciones) {
                faltasTemp = faltaDAO.buscarSeccion(sec.getIdSeccion());
                for (Inasistencia ina : faltasTemp) {
                    faltas.add(ina);
                }
            }
        %>
    </head>
    <body>
        <div class="container">
            <form action="ControladorDocente" method="POST">                
                <h1 class="yellow darken-1 center-align">Docente</h1>
                <button class="btn waves-effect waves-light red right" type="submit" name="opcion" value="Salir">
                    Cerrar Sesion
                </button>
                <h3 class="black-text">Datos Docente</h3>               
                <ul>
                    <li class="amber darken-3 black-text">Nombre: <%=docente.getPnombre() + " " + docente.getAppaterno() + " " + docente.getApmaterno()%></li>
                    <li class="amber darken-3 black-text">Rut: <%=docente.getRutDocente() + "-" + docente.getDvDocente()%></li>
                </ul>
                <table class=" grey lighten-2">
                    <tr class="amber darken-3">
                        <th>Ramo</th>
                        <th>Fecha</th>
                        <th>Rut Alumno</th>
                        <th>Motivo</th>
                        <th>Estado</th>                        
                        <th>Accion</th>
                    </tr>
                    <% for (Inasistencia falta : faltas) {   %>
                    <tr>  
                        <%  if (falta.getIdEstadoi() > 1) {%>
                        <td><%=falta.getIdSeccion()%></td>
                        <td><%=falta.getFecha()%></td>
                        <td><%=falta.getRutAlumno()%>-<%=alumnos.buscarDatos(falta.getRutAlumno()).getDvAlumno()%>  </td>
                        <td><%=consultaBD.buscarMotivos(((new JustificacionDAO()).buscarDatos(falta.getIdInasistencia())).getIdMotivo()).getNombreMotivo() %></td>
                        <td><%=consultaBD.buscarEstadoInasistencia(falta.getIdEstadoi()).getNombreEstadoi()%></td>
                         <td>
                            <% if(falta.getIdEstadoi()==2){%>
                                <button 
                                 class="btn waves-effect waves-light indigo darken-3" 
                                 type="submit" 
                                 name="opcion" 
                                 value="j<%=falta.getIdInasistencia()%>"> 
                                    Aceptar Justificacion 
                                </button>
                            <% }
                               if(falta.getIdEstadoi()==3){ %>
                                <button 
                                 class="btn waves-effect waves-light  grey darken-1" 
                                 type="submit" 
                                 name="opcion" 
                                 value="j<%=falta.getIdInasistencia()%>"> 
                                     ver
                                </button>
                           <% }%>
                        </td>   
                        <% } %>
                    </tr>
                    <% }%>
                </table>
            </form>
        </div>       
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/init.js"></script>
    </body>
</html>
