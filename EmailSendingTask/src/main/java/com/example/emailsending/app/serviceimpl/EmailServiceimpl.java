package com.example.emailsending.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.emailsending.app.model.EmailSender;
import com.example.emailsending.app.servicei.EmailServicei;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceimpl implements EmailServicei
{
 
	@Autowired
	private JavaMailSender sender;
	
	@Override
	public void sendEmail(EmailSender e) 
	{
		SimpleMailMessage message =new  SimpleMailMessage();
		message.setFrom(e.getFromMail());
		message.setTo(e.getToEmail());
		message.setSubject(e.getSubject());
		message.setText(e.getTextMsg());
		sender.send(message);
		
	}

	@Override
	public void sendEmailAttachment(EmailSender e, String filename) {
		MimeMessage mm=sender.createMimeMessage();// we can send attachement also simple msg
		try {
		 MimeMessageHelper  helper =new  MimeMessageHelper(mm, true);
		 helper.setTo(e.getToEmail());
		 helper.setSubject(e.getSubject());
		 helper.setText(e.getTextMsg());
		 helper.addAttachment(filename, new ByteArrayResource(e.getAttachment()));
		 sender.send(mm);
		
	}
	catch(MessagingException e1) 
		{
		 e1.printStackTrace();
			 
			}
		}

}
