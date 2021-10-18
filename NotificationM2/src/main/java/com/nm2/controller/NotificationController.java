package com.nm2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.nm2.model.Notification;
import com.nm2.service.NotificationService;

@RestController
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	@PostMapping("/send")
	public String sendEmail(@RequestBody Notification message) {

		try {

			notificationService.sendEmail(message.getEmailId(), message.getMessage());

			return "Mail Sent";

		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}

	}

}
