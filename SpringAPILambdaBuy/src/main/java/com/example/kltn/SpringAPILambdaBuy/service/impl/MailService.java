package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.common.interfaces.MailSender;

@Service
public class MailService implements MailSender {
	
	@Override
	@Async
	public void send(String to, String template) {
		final String email_host = "contact.lambdabuy@gmail.com";
		final String password = "yydapcylhthcvzyu";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(email_host, password);
                    }
                });
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email_host));
			message.setRecipients(
					Message.RecipientType.TO, 
					InternetAddress.parse(to)
			);
			message.setSubject("CONFIRM YOUR EMAIL");
			message.setContent(template, "text/html; charset=UTF-8");
			Transport.send(message);
			System.out.println("Sent mail");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
