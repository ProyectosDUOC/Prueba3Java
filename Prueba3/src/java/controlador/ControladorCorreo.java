/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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

    public static int EnviarMensaje(String[] resultado, int motivo) {
        String Username = "pbdchatsoporte@gmail.com";
        String PassWord = "abcd14abcd";
        String Subject = "";
        String Mensaje = "";
        Date date = new Date();

        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

        String To = resultado[2]; //correo destinatario
        if (motivo == 0) //recuperacion de clave
        {
            Subject = "Solicitud de recuperación de contraseña (PDB CHAT)"; //
            Mensaje = "Has solicitado la recuperación de tu contraseña "
                    + "Si no solicitaste esto, ignora este correo electrónico \n \n CHAT PDB "
                    + "\n Solicitud realizada a las  " + hourdateFormat.format(date)
                    + "\n \n Usuario: " + resultado[0]
                    + "\n Contraseña: " + resultado[1]
                    + "\n \n                Atentamente SOPORTE CHAT PBD";
        }
        if (motivo == 1) // new registro
        {
            Subject = "Gracias por registrarte a PBD CHAT  -"; //
            Mensaje = "Te has registro de CHAT PBD "
                    + "\n Solicitud del registro realizada a las  " + hourdateFormat.format(date)
                    + "\n \n Usuario: " + resultado[0]
                    + "\n Contraseña: " + resultado[1]
                    + "\n \n Atentamente SOPORTE CHAT PBD";
        }

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
}
