/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.AlumnoDAO;
import dao.InasistenciaDAO;
import dao.JustificacionDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import modelo.Alumno;
import modelo.Inasistencia;
import modelo.Justificacion;

/**
 *
 * @author benja
 */
public class ControladorCorreo {

    public static int Enviar(String miCorreo, String pass, String Destino, String asunto, String texto) {
        String Username = miCorreo;
        String PassWord = pass;
        String Subject = asunto;
        String Mensaje = texto;
        Date date = new Date();

        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

        String To = Destino; //correo destinatario       

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session;

        session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Username, PassWord);
            }
        }
        );

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To));
            message.setSubject(Subject);
            message.setText(Mensaje);

            Transport.send(message);

        } catch (MessagingException e) {
            return -1;
        }
        return 1;
    }

    public static int EnviarProfesor(String CorreoProfesor, String mensaje, String asunto) {
        String Username = "controlinasistencia@gmail.com";
        String PassWord = "abcd14abcd";
        String Subject = asunto;
        String Mensaje = mensaje;
        Date date = new Date();

        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

        String To = CorreoProfesor; //correo destinatario       

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session;

        session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Username, PassWord);
            }
        }
        );

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To));
            message.setSubject(Subject);
            message.setText(Mensaje);

            Transport.send(message);

        } catch (MessagingException e) {
            return -1;
        }
        return 1;
    }

    public static void ChequeoAlumnos() {
        //enviarme mensaje a todos los correo no enviado
        
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        ArrayList<Inasistencia> faltasAlumno = (new InasistenciaDAO().mostrarInjustificadas());
        
     
        InasistenciaDAO faltas = new InasistenciaDAO();
        Justificacion justi = new Justificacion();
        //ArrayList<Inasistencia> faltasAlumno;
        ArrayList<Alumno> arrayAlumnos = new AlumnoDAO().mostrarDatos();
        
        faltasAlumno = faltas.mostrarInjustificadas();
        
        
        
        
        Date fechaActual = new Date();

        String correo = "controlinasistencia@gmail.com";
        String pass = "abcd14abcd";
        String asunto = "Reenvio: Aviso de inasistencias";
        
        
        for (Alumno alumno : arrayAlumnos) {

            faltasAlumno = faltas.buscarNuevos(alumno.getRutAlumno());
            if (faltasAlumno.size() > 0) {
                StringBuilder mensaje = new StringBuilder();
                mensaje.append("Estimado Alumno ");
                mensaje.append(alumno.getPnombre());
                mensaje.append(" ");
                mensaje.append(alumno.getAppaterno());
                mensaje.append("\n");
                mensaje.append(" Nuestro sistema registra que usted tiene inasistencias pendientes que aun no ha repondido,");
                mensaje.append(" favor de dirigirse al sitio www.miinasistencia.cl y justificarlas.\n");

                for (Inasistencia falta : faltasAlumno) {
                    mensaje.append(falta.getFecha());
                    mensaje.append(" ");
                    mensaje.append(falta.getIdSeccion());
                    mensaje.append("\n");

                    faltas.actualizarEnviadoAlumnos(falta.getIdInasistencia(), 1);
                    justi = new Justificacion(falta.getIdInasistencia(), fechaActual, 0, " ", 0, 1);
                  //  justificaciones.agregar(justi);
                }

                mensaje.append("Saluda atentamente\n Coordinador.");

                ControladorCorreo.Enviar(correo, pass, alumno.getEmail(), asunto, mensaje.toString());
            }
        }
           
    }

}
