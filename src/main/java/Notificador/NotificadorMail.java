package Notificador;
//import Utils.Exceptions.MailNoEnviadoException;

import Users.Persona;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;

public class NotificadorMail implements Notifier{
    final String name = "INFO FIT TRACKER";
    final String emailAddress = "fittracker.info@gmail.com";
    final String password = "Letstrain!";

    public void notify(Persona aPerson, Notification message) {

        Session sesion = Session.getDefaultInstance(getProperties(), getAutenticador());

        try {
            Message msg = createMessage(message, aPerson, sesion);
            Transport.send(msg);

        } catch (MessagingException | UnsupportedEncodingException e) {
          //  throw new MailNoEnviadoException(mensaje, unContacto); todo
        }
    }

    private Message createMessage(Notification message, Persona receiver, Session auth) throws MessagingException, UnsupportedEncodingException {
        Message msg = new MimeMessage(auth);
                msg.setFrom(new InternetAddress(emailAddress, name));
                msg.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver.getMail(), receiver.getName()));
                msg.setSubject(message.getSubject());
                msg.setText(message.getBody());

        return msg;
    }

    private Properties getProperties(){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        return props;
    }

    private Authenticator getAutenticador(){
        return new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailAddress, password);
            }
        };
    }
}

