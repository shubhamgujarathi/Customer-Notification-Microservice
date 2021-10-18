package com.nm2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(String emailId, String message1) {

		String from = "your mail id";

		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(from);
		message.setTo(emailId);
		message.setSubject("User Registration Successfully");
		message.setText(message1);

		mailSender.send(message);

	}

}
