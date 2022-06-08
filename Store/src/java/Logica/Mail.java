package Logica;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {

    private String correo, mensaje, asunto;
    private Properties props;
    private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

    public Mail(String correo, String mensaje, String asunto) {
        this.correo = correo;
        this.mensaje = mensaje;
        this.asunto = asunto;

    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public static void MailSender() {
        System.out.println("Enviando Mail");

        final String sender = "zeusred022020@gmail.com"; // The sender email
        final String urpass = "Rmejia2020"; //keep it secure
        Properties set = new Properties();
        //Set values to the property
        set.put("mail.smtp.starttls.enable", "true");
        set.put("mail.smtp.auth", "true");
        set.put("mail.smtp.host", "smtp.gmail.com");
        set.put("mail.smtp.port", "587");
        set.put("mail.debug", "true");

        /*set.put("mail.smtp.host", "smtp.gmail.com");
        set.put("mail.smtp.auth", "true");
        set.put("mail.debug", "true");
        set.put("mail.smtp.port", 465);
        set.put("mail.smtp.socketFactory.port",465);
        set.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        set.put("mail.smtp.socketFactory.fallback", "false");
        set.put("mail.smtp.starttls.enable", "true");*/
        Session session;
        session = Session.getInstance(set, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, urpass);
            }
        });

        try {
            //email extends Java's Message Class, check out javax.mail.Message class to read more
            Message email = new MimeMessage(session);
            email.setFrom(new InternetAddress("senderEmail")); //sender email address here
            email.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("reynaldo0295@gmail.com")); //Receiver email address here
            email.setSubject("I am learning how to send emails using java"); //Email Subject and message
            email.setText("Hi, have a nice day! ");
            Transport.send(email);
            System.out.println(" Mail enviado");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public static String sendMail(String id, String to, String from,
            String subject, String body, boolean content,
            String password) throws UnsupportedEncodingException {
        String status = null;
        try {
            // acquire a secure SMTPs session
            Properties pros = new Properties();
            pros.put("mail.transport.protocol", "smtps");
            pros.put("mail.smtps.host", "smtp.gmail.com");
            pros.put("mail.smtps.port", 465);
            pros.put("mail.smtps.auth", "true");
            pros.put("mail.smtps.quitwait", "false");
            Session session
                    = Session.getDefaultInstance(pros);
            session.setDebug(true);
            // Wrap a message in session
            Message message = new MimeMessage(session);
            message.setSubject(subject);

            if (content) {
                message.setContent(body, "text/html");
            } else {
                message.setText(body);
            }
            // specify E-mail address of Sender and Receiver
            Address sender = new InternetAddress(from, id);
            Address receiver = new InternetAddress(to);
            message.setFrom(sender);
            message.setRecipient(Message.RecipientType.TO,
                    receiver);
            // sending an E-mail
             Transport tt = session.getTransport(); 
                // acqruiring a connection to remote server
                tt.connect(from, password);
                tt.sendMessage(message,
                        message.getAllRecipients());
                status = "E-Mail Sent Successfully";
            
        } catch (MessagingException e) {
            status = e.toString();
        } catch (UnsupportedEncodingException e) {
            status = e.toString();
        }
        // return the status of email
        return status;
    }
}
