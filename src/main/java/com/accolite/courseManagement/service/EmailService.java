package com.accolite.courseManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.accolite.courseManagement.entities.CourseEntity;
import com.accolite.courseManagement.entities.Participants;

import java.util.stream.Collectors;

import javax.persistence.Entity;

@Component
public class EmailService {
	
	@Autowired
    private JavaMailSender emailSender;
	
    public void sendSimpleMessage(String subject,String body)
    {
    	
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("rajputneeraj6798@gmail.com");
        mailMessage.setSubject(subject+" course details are given in the body");
        mailMessage.setText(body);
        try
        {
            emailSender.send(mailMessage);
        }
        catch (Exception e) {
            System.out.print(e);
        }
    }


}
