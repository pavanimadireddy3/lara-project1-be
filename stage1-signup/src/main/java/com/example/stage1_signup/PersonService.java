package com.example.stage1_signup;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
@Autowired
private PersonRepository personRepository;
@Autowired
private MailService mailService;

public Person save(Person person) throws Exception {
	String verificationCode = generateVerificationCode();
	person.setVerificationCode(verificationCode);
	person.setSignupStatus(0); // initial status
	person =personRepository.save(person);
	
	String username = person.getUserName();
	mailService.sendMail(username,verificationCode);
	return person;
}
	private String generateVerificationCode() {
		String src ="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuffer sb = new StringBuffer();
		int lengthSrc = src.length();
		Random random = new Random();
		for(int i = 1; i <= 15; i++) {
			sb.append(src.charAt((int)(random.nextDouble() * lengthSrc)));
		}
		return sb.toString();
	}
	public String verifyEmail(String emailId, String verificationCode) {
		Person person = personRepository.findByUsername(emailId);
		String msg = "Something went wrong ... pls try again";
		if(person.getVerificationCode().equals(verificationCode)) {
			msg = "successfully verified and you can do the login";
			person.setSignupStatus(1);
			personRepository.save(person);
		}
		return msg;
	}
}
