package com.example.emailsending.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.emailsending.app.model.EmailSender;
import com.example.emailsending.app.servicei.EmailServicei;
import com.fasterxml.jackson.databind.ObjectMapper;
@CrossOrigin("*")
@RestController
public class EmailController 
{ 
	// my emailcontroller 
	@Autowired
	EmailServicei si;
	@PostMapping("/sendEmail")
	public String sendEmail(@RequestBody EmailSender e)
	{
		 si.sendEmail(e);
		
		return "Send email...!";
	}
  @PostMapping("/sendAttachment")
  public String SendAttachment(@RequestPart ("attachment") MultipartFile file,@RequestPart ("jsondata") String json)
  {
	   ObjectMapper om =new ObjectMapper();
	   EmailSender s1=new EmailSender();
	   try {
		EmailSender s2=om.readValue(json, EmailSender.class);
		s1.setToEmail(s2.getToEmail());
		s1.setSubject(s2.getSubject());
		s1.setTextMsg(s2.getTextMsg());
		s1.setAttachment(file.getBytes());
		String filename= file.getOriginalFilename();
		si.sendEmailAttachment(s1, filename);
		return "email Attachment";
		
		
	} 
	   catch (Exception e) 
	   {
		
		e.printStackTrace();
		return " Failed to send email Attchent";
		
	
	}

	   
  }
}
