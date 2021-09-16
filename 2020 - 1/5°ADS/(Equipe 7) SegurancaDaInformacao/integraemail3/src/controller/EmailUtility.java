package controller;


import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtility {
	
	
    public static void sendEmailWithAttachment(String host, String port, final String userName, final String password, String toAddress,
            String subject)
                    throws AddressException, MessagingException {
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", userName);
        properties.put("mail.password", password);
        
        
        String path = "C:/Users/rmsil/Desktop/biblioteca1/informeBiblioteca.pdf";
        
        //Aplicando o hash ao arquivo
        try {
			PdfHash.ChecksumFile(path);
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
        
        // criando  nova sessão  autenticada
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);
 
       
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject("Relatório descritivo sobre o uso de seus dados pessoais.");
        msg.setSentDate(new Date());
 
       
        Multipart multipart = new MimeMultipart();
       
        
        //attachment
        try {
        MimeBodyPart pdfAttachment = new MimeBodyPart();
		pdfAttachment.attachFile(path);
		
		
		
		
		multipart.addBodyPart(pdfAttachment);
		
        } catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        
        msg.setContent(multipart);
 
        //sending email
        Transport.send(msg);
    }
	
}

