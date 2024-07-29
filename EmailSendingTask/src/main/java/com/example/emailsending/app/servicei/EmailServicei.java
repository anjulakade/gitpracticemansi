package com.example.emailsending.app.servicei;

import com.example.emailsending.app.model.EmailSender;

public interface EmailServicei 
{

	  public void sendEmail(EmailSender e);
	 public void  sendEmailAttachment(EmailSender e, String filename);

}
