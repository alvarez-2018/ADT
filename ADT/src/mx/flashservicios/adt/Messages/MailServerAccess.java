/*
 * MailServerAccess.java
 */
package mx.flashservicios.adt.Messages;

import java.security.NoSuchProviderException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 *
 * @author giancarlo
 */
public class MailServerAccess {
    public static void send(String subject , String body , String to , MailServer server) throws NoSuchProviderException, AddressException, MessagingException{
        Properties props = new Properties();
        props.put("mail.smtp.host", server.getHost());
        props.put("mail.smtp.port", server.getPort());    
        
        Session session = null;
        session = Session.getInstance(props);
        
        if(session != null){
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(server.getFrom()));
            message.setRecipients(Message.RecipientType.TO , InternetAddress.parse(to)); 
            message.setSubject(subject);
            message.setText(body);   

            Transport transport = session.getTransport("smtp");
            transport.connect();
            Transport.send(message);
        }
        
        else{
            System.out.append("Mail Server session is null!!");
        }
    }
    
    public static void sendHTML(String subject , String body , String to , MailServer server) throws NoSuchProviderException, AddressException, MessagingException, EmailException{
        HtmlEmail email = new HtmlEmail();
        email.setHostName(server.getHost());
        email.setSmtpPort(server.getPort());
        email.setFrom(server.getFrom());
        email.addTo(to);
        email.setSubject(subject);
        email.setHtmlMsg(body);

        email.send();
    }   
    
    public static void sendHTMLAttachment(String subject , String body , String to , MailServer server , List<EmailAttachment> attachments) throws NoSuchProviderException, AddressException, MessagingException, EmailException{
        HtmlEmail email = new HtmlEmail();
        email.setHostName(server.getHost());
        email.setSmtpPort(server.getPort());
        email.setFrom(server.getFrom());
        email.addTo(to);
        email.setSubject(subject);
        email.setHtmlMsg(body);
        
        Iterator<EmailAttachment> attachIt = attachments.iterator();
        
        while(attachIt.hasNext()){
            EmailAttachment attachment = attachIt.next();
            email.attach(attachment);
        }

        email.send();
    }    
}
