package com.accolite.courseManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.accolite.courseManagement.models.Participants;

@Service
public class EmailService {
	
	@Autowired
    private JavaMailSender emailSender;
	
	public void sendMailToParticipant(Participants participant) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(participant.getEmail());
        mailMessage.setSubject(participant.getSubject()+" details");
        mailMessage.setText(participant.getBody());
        try
        {
            emailSender.send(mailMessage);
        }
        catch (Exception e) {
            System.out.print(e);
        }
	}


}
