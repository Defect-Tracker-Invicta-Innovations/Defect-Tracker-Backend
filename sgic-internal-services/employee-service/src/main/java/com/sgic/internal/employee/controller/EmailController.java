package com.sgic.internal.employee.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.sgic.internal.employee.entities.Email;
import com.sgic.internal.employee.services.impl.NotificationService;

@CrossOrigin
@RestController
public class EmailController {

	
	
	@Autowired
	private NotificationService notificationService;
	
	@PostMapping("/sendmail")
	public Email sendMail(@RequestBody Email email) {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(email.getEmail());
		mail.setSubject(email.getSubject());
		mail.setText(email.getText());
		notificationService.sendNotofication(mail);
		System.out.println(email.getEmail());
		return email;
		
	}
	
}
