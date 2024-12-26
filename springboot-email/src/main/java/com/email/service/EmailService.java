package com.email.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.email.dto.EmailRequest;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;

	public String sendSimpleEmail(EmailRequest request) {
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(sender);
			mailMessage.setTo(request.getToEMail());
			mailMessage.setSubject(request.getSubject());
			mailMessage.setText(request.getMessageBody());
			javaMailSender.send(mailMessage);
			return "email successfully send to : " + request.getToEMail();
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public String sendEmail(String recipient, String body, String subject) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(sender);
		mailMessage.setTo(recipient);
		mailMessage.setSubject(body);
		mailMessage.setText(subject);
		javaMailSender.send(mailMessage);
		return "email successfully send to : " + recipient;
	}


	
	  public String sendEmailWithAttachment(EmailRequest request) throws MessagingException {
	        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

	        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

	        helper.setFrom(sender);
	        helper.setTo(request.getToEmails());
	        helper.setSubject(request.getSubject());
	        helper.setText(request.getMessageBody());

	        FileSystemResource file = new FileSystemResource(new File(request.getAttachment()));
	        helper.addAttachment(file.getFilename(), file);

	        javaMailSender.send(mimeMessage);
	        return "Mail sent successfully with attachment " + file.getFilename();
	        
//	        {
//	            "toEMail":"nareshchitti87@gmail.com",
//	            "subject": "Simple Text Mail ",
//	            "messageBody":"The body of an email is the content that is contained in the message.\n\n It can include text, images, videos, or GIF animations. \n\nThere are several elements in an email message, including the subject line, introduction, main content, CTA,\n\n and contact information with links to social media.",
//	            "attachment":"/Users/Nikhil/OneDrive/Desktop/business.csv"
//	        }
	        
//	        s
//	        {
//	            "toEmails":["nareshchitti87@gmail.com","nanonikhil6@gmail.com"],
//	            "subject": "Simple Text Mail ",
//	            "messageBody":"The body of an email is the content that is contained in the message.\n\n It can include text, images, videos, or GIF animations. \n\nThere are several elements in an email message, including the subject line, introduction, main content, CTA,\n\n and contact information with links to social media.",
//	            "attachment":"/Users/Nikhil/OneDrive/Desktop/business.csv"
//	        }
	    }

}
