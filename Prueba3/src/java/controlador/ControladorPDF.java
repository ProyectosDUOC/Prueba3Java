/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.AlumnoDAO;
import dao.ClasesConsultas;
import dao.DocenteDAO;
import dao.JustificacionDAO;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumno;
import modelo.Docente;
import modelo.Inasistencia;
import modelo.Justificacion;
import modelo.Motivo;
import modelo.Seccion;

/**
 *
 * @author benja
 */
@WebServlet(name = "ControladorPDF", urlPatterns = {"/ControladorPDF"})
public class ControladorPDF extends HttpServlet {

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
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();

        try {
            //Se crea un instacia de documento
            Document documento = new Document();
            //se crea la salida de documento pdf
            PdfWriter.getInstance(documento, out);

            //Se abrira el documento
            documento.open();
            //PARA ESCRIBIR
            Paragraph par1 = new Paragraph();
            //TITULO
            Font fontitulo = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLUE);
            par1.add(new Phrase("REPORTES INASISTENCIAS", fontitulo));
            par1.setAlignment(Element.ALIGN_CENTER);

            //SAto de linea o salto de pagina
            par1.add(new Phrase(Chunk.NEWLINE));
            par1.add(new Phrase(Chunk.NEWLINE));

            //agregar al documento
            documento.add(par1);

            Paragraph par2 = new Paragraph();
            //TITULO
            Font descripcion = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
            par2.add(new Phrase("Informe general de inasistencia chequedas por docentes", descripcion));
            par2.setAlignment(Element.ALIGN_JUSTIFIED);

            //SAto de linea o salto de pagina
            par2.add(new Phrase(Chunk.NEWLINE));
            par2.add(new Phrase(Chunk.NEWLINE));

            //agregar al documento
            documento.add(par2);

            /*
            Image imagen = Image.getInstance("C:\\Users\\benja\\Desktop\\4TO SEMESTRE DUOC\\2.- 4to Semestre\\Desarrollo en Java\\Clases\\Prueba3\\Prueba 3\\Prueba3Java\\Prueba3\\src\\java\\imagen\\logo_duoc.png");
            imagen.setAlignment(Element.ALIGN_CENTER);
            imagen.scaleAbsolute(100, 50);
            documento.add(imagen);
             */
            //tablas
            // Cantidad de lineas
            PdfPTable tabla = new PdfPTable(7);
            //cantidad de celdas
            PdfPCell celda1 = new PdfPCell(new Paragraph("Rut Docente", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.RED)));
            PdfPCell celda2 = new PdfPCell(new Paragraph("Nombre Docente", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.RED)));
            PdfPCell celda3 = new PdfPCell(new Paragraph("Seccion", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.RED)));
            PdfPCell celda4 = new PdfPCell(new Paragraph("Rut Alumno", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.RED)));
            PdfPCell celda5 = new PdfPCell(new Paragraph("Fecha Inasistencia", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.RED)));
            PdfPCell celda6 = new PdfPCell(new Paragraph("Motivo", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.RED)));
            PdfPCell celda7 = new PdfPCell(new Paragraph("Detalle", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.RED)));

            tabla.addCell(celda1);
            tabla.addCell(celda2);
            tabla.addCell(celda3);
            tabla.addCell(celda4);
            tabla.addCell(celda5);
            tabla.addCell(celda6);
            tabla.addCell(celda7);

            /*      <th>Rut Docente</th> 
                    <th>Nombre Docente</th>
                    <th>Seccion</th>
                    <th>Rut alumno</th>
                    <th>Fecha inasistencia</th>
                    <th>Motivo</th>
                    <th>Dscripcion del Motivo</th>*/
            ArrayList<Inasistencia> arrayInasistencia = new ArrayList();
            arrayInasistencia = new dao.InasistenciaDAO().mostrarDatos();

            for (modelo.Inasistencia xx : arrayInasistencia) {
                if (xx.getIdEstadoi() == 3) {
                    Justificacion justi = new Justificacion();
                    justi = new JustificacionDAO().buscarDatos(xx.getIdInasistencia());
                    Motivo motivo = new Motivo();
                    motivo = new ClasesConsultas().buscarMotivos(justi.getIdMotivo());
                    Seccion seccion = new Seccion();
                    seccion = new ClasesConsultas().buscarSeccion(xx.getIdSeccion());
                    Docente docente = new Docente();
                    docente = new DocenteDAO().buscarDatos(seccion.getRutDocente());                   
                    tabla.addCell(docente.getRutDocente() + "-" + docente.getDvDocente());
                    tabla.addCell(docente.getPnombre() + " " + docente.getAppaterno());
                    tabla.addCell(seccion.getIdRamo());
                    tabla.addCell(xx.getRutAlumno()+"");
                    tabla.addCell(xx.getFecha() + "");
                    tabla.addCell(motivo.getNombreMotivo());
                    tabla.addCell(justi.getGlosa());
                }
            }

            documento.add(tabla);
            documento.close();
        } catch (Exception ex) {
            ex.getMessage();
        } finally {
            out.close();
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
