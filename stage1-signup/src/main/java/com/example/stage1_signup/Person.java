package com.example.stage1_signup;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Person {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

private Integer id;	
private String firstName;	// 3 - 25 all lowercase
private String lastName;	// 2- 20
private String username;	// email id
private String password;	// uppercase, lowercase,digits,spl chars
private Integer signupStatus;	// 0-initial, 1-finish
private String verificationCode;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getUserName() {
	return username;
}
public void setUserName(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Integer getSignupStatus() {
	return signupStatus;
}
public void setSignupStatus(Integer signupStatus) {
	this.signupStatus = signupStatus;
}
public String getVerificationCode() {
	return verificationCode;
}
public void setVerificationCode(String verificationCode) {
	this.verificationCode = verificationCode;
}	


}
