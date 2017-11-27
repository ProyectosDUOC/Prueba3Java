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
import java.util.concurrent.TimeUnit;
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
        Date fechaActual = new Date();    
        Date fechaEmision; 
        long duracion;
        ArrayList<Alumno> listaAlumnos = (new AlumnoDAO().mostrarDatos()); 
        
        for (Inasistencia xx : faltasAlumno) {
            fechaEmision = xx.getFecha();
            duracion = fechaActual.getTime() - fechaEmision.getTime();
            long horas = TimeUnit.MILLISECONDS.toHours(duracion);
            if ((horas/24)>=7) {
                for (Alumno alum: listaAlumnos){
                    if (alum.getRutAlumno() == xx.getRutAlumno()) { //solo para buscar el correo
                        
                        StringBuilder mensaje = new StringBuilder();
                        mensaje.append("Estimado Profesor ");
                        mensaje.append(alum.getPnombre());
                        mensaje.append(" ");
                        mensaje.append(alum.getAppaterno());
                        mensaje.append("\n");
                        mensaje.append(" Nuestro sistema registra que usted tiene inasistencias, y que no ha respondido hace una semana");
                        mensaje.append(" favor de dirigirse al sitio www.miinasistencia.cl y justificarlas.\n");
                    }
                }
                //RF8	Después de una semana de enviar los mails a los alumnos,
                //se debe hacer un segundo envío, a todos los alumnos que no justificaron.
                
            }            
        }
        String correo = "controlinasistencia@gmail.com";
        String pass = "abcd14abcd";
        String asunto = "Reenvio: Aviso de inasistencias";

       
    }

}
