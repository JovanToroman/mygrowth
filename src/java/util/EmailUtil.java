/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import action.RegisterTeacherAction;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author solstinger
 */
public class EmailUtil {

    public static void sendEmail(String emailAdd, String body, String subject, String emailFrom) {
        String fromEmail = "megroweducation@gmail.com"; //requires valid gmail id
        String password = "MeGrow.2017"; // correct password for gmail id

        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);

        MimeMessage email = new MimeMessage(session);
        try {
            email.setFrom(new InternetAddress(emailFrom, "MeGrow"));
            email.setReplyTo(InternetAddress.parse(emailFrom, false));
            email.setSubject(subject, "UTF-8");
            email.setText(body);
            email.setSentDate(new Date());
            email.setRecipients(Message.RecipientType.TO, emailAdd);
            Transport.send(email);
        } catch (UnsupportedEncodingException | MessagingException ex) {
            Logger.getLogger(RegisterTeacherAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
