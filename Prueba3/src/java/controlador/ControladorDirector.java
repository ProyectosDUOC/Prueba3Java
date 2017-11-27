/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carlos
 */
public class ControladorDirector extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        String opcion = request.getParameter("Opcion");
        
        if(opcion.equalsIgnoreCase("Acceder"))
        {
            response.sendRedirect("reporteInasistencias.jsp");
        }
        if (opcion.equalsIgnoreCase("Checkeado por docente")) {
            response.sendRedirect("reportesInaDocentes.jsp");
        }
        if (opcion.equalsIgnoreCase("Reporte por Semestre")) {
             response.sendRedirect("reportesPDFsemestre.jsp");
        }
        if (opcion.equalsIgnoreCase("Enviar")) {
            String semestre="2", anio = "2017";
            
            String[] miselect = request.getParameterValues("semestre");
                for (int i = 0; i < miselect.length; i++) {
                    semestre = miselect[i];
                }
            String[] miselect1 = request.getParameterValues("anio");
                for (int i = 0; i < miselect1.length; i++) {
                    anio = miselect1[i];
                }
            response.sendRedirect("reportesSemestrales.jsp?anio="+anio+"&sem="+semestre);
        }
        if(opcion.equals("Salir")){
            request.getSession().invalidate();
            response.sendRedirect("index.jsp");
        }
      
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorDirector</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorDirector at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
