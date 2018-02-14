/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;

/**
 *
 * @author Seba
 */
public class ControladorEnviarCorreos extends HttpServlet {

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
        
        if(opcion.equals("Enviar")){  
            InasistenciaDAO faltas = new InasistenciaDAO();
            ArrayList<Inasistencia> faltasAlumno;           
            ArrayList<Alumno> arrayAlumnos = new AlumnoDAO().mostrarDatos();
            JustificacionDAO justificaciones = new JustificacionDAO();
            Justificacion justi = new Justificacion();           
            Date fechaActual = new Date();
             
            String correo = "controlinasistencia@gmail.com";
            String pass = "abcd14abcd";
            String asunto = "Aviso de inasistencias";


            for (Alumno alumno : arrayAlumnos) {

                faltasAlumno = faltas.buscarNuevos(alumno.getRutAlumno());
                if(faltasAlumno.size()>0){
                    StringBuilder mensaje = new StringBuilder();
                    mensaje.append("Estimado Alumno ");
                    mensaje.append(alumno.getPnombre());
                    mensaje.append(" ");
                    mensaje.append(alumno.getAppaterno());
                    mensaje.append("\n");
                    mensaje.append("Nuestro sistema registra que usted tiene inasistencias,");
                    mensaje.append(" favor de dirigirse al sitio www.miinasistencia.cl y justificarlas.\n");

                    for (Inasistencia falta : faltasAlumno) {
                        mensaje.append(falta.getFecha());
                        mensaje.append(" ");
                        mensaje.append(falta.getIdSeccion());
                        mensaje.append("\n");
                        
                        faltas.actualizarEnviadoAlumnos(falta.getIdInasistencia(), 1);
                        justi = new Justificacion(falta.getIdInasistencia(),fechaActual, 0," ", 0, 1);
                        justificaciones.agregar(justi);
                    }

                    mensaje.append("Saluda atentamente\n Coordinador.");

                    ControladorCorreo.Enviar(correo, pass, alumno.getEmail(), asunto, mensaje.toString());
                }
            }
            response.sendRedirect("enviarCorreos.jsp?mensaje=Correos Enviados Existosamente");            
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
