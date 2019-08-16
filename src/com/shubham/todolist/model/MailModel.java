package com.shubham.todolist.model;

import java.time.LocalDate;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public interface MailModel {
	public static  boolean sendMail(String taskName,String desc, LocalDate startdate, LocalDate enddate, String smail, String spwd,String rmail) {
		 final String username = smail;
	        final String password = spwd;

	        Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.port", "587");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.starttls.enable", "true"); //TLS
	        
	        
	        // Step - 1 Authenticate
	        Session session = Session.getInstance(prop,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username,password);
	                    }
	                });

	        // Step-2 From , to , Subject, Content
	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(username));
	            message.setRecipients(
	                    Message.RecipientType.TO,
	                    InternetAddress.parse(rmail)
	            );
	            message.setSubject("A New ToDo Assign to All");
	            message.setText("Dear User , Your Task for today is  " + taskName+" Description "+desc+ "Start by this Date" + startdate + " and End by this Date "+enddate);
	            
	            // Step-3 Send the Message
	            Transport.send(message);

	            System.out.println("Done Mailed Successfully");
	            return true;

	        } catch (MessagingException e) {
	            e.printStackTrace();
	            return false;
	        }

	}
}
