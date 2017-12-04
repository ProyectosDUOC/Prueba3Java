/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.*;
import modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Seba
 */
public class ControladorJustificar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String opcion = request.getParameter("opcion");

        String idInasistencia = (String) request.getSession().getAttribute("inaActual");
        int idIna = Integer.parseInt(idInasistencia);
        
        if (opcion.equals("Guardar")) {
            String motivo = "";
            String glosa = request.getParameter("glosa");
            String[] miselect = request.getParameterValues("motivo");
            for (int i = 0; i < miselect.length; i++) {
                motivo = miselect[i];
            }

            int idMotivo = Integer.parseInt(motivo);
           
            Date fecha = new Date();
            glosa = fecha.toString() + ": " + glosa;
            (new JustificacionDAO()).actualizarJustificacion(idIna, idMotivo, glosa, 1);
            (new InasistenciaDAO()).actualizarEnviadoAlumnos(idIna, 2);
            Inasistencia inasistencia = new InasistenciaDAO().buscar(idIna);
            Seccion seccion = new ClasesConsultas().buscarSeccion(inasistencia.getIdSeccion());
            Docente docente = new DocenteDAO().buscarDatos(seccion.getRutDocente());

            String asunto = "Inasistencia Justificada Por Alumno";
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("Estimado Profesor: ");
            mensaje.append(docente.getPnombre());
            mensaje.append(" ");
            mensaje.append(docente.getAppaterno());
            mensaje.append("\n");
            mensaje.append(" Nuestro sistema acaba de tener un registro de inasistencia por el alumno ");
            mensaje.append(" RUT: ");
            mensaje.append(inasistencia.getRutAlumno());
            mensaje.append(" de la Seccion ");
            mensaje.append(seccion);
            mensaje.append("Por favor ingrese al portal web sitio www.miinasistencia.cl y verifique justificacion.\n");

            (new ControladorCorreo()).EnviarProfesor(docente.getEmail(), mensaje.toString(), asunto);

            response.sendRedirect("Alumno.jsp");
        }
        if (opcion.equals("Justificar")) {                      
           (new InasistenciaDAO()).actualizarEnviadoAlumnos(idIna, 3);
            response.sendRedirect("Docente.jsp");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
