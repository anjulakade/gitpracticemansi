package com.example.emailsending.app.model;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailSender 
{
	@Value("$spring.mail.username")
  private String fromMail;
  private String toEmail;
  private String subject;
  private String textMsg;
  private byte[] attachment;
  

}
