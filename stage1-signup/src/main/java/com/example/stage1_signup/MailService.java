package com.example.stage1_signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {
@Autowired
private JavaMailSender emailSender;
//public String testMail() throws Exception{
//	MimeMessage mimeMessage = emailSender.createMimeMessage();
//	MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
//	String htmlMsg = "<h1><a href='https://google.com'>Hi Pavaniji, how are you?</a></h1>";
//	helper.setText(htmlMsg, true);
//	helper.setTo("pavanimadireddy3@gmail.com");
//	helper.setSubject("Pavani ji mail vachinda");
//	emailSender.send(mimeMessage);
//	return "success";
//}
public String sendMail(String username, String verificationCode) throws Exception{
	MimeMessage mimeMessage = emailSender.createMimeMessage();
	MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
	StringBuffer htmlMsg = new StringBuffer();
	htmlMsg.append("<h1> Pls activate your email by clicking below </h1>");
	htmlMsg.append("<a href='http://localhost:9090/person/verifyEmail?email="+ username + "&verificationCode=" + verificationCode+"'>Verify Email</a>");
	helper.setText(htmlMsg.toString(), true);
	helper.setTo(username);
	helper.setSubject("verify/actiavte email id");
	emailSender.send(mimeMessage);
	return "success";
}
}
