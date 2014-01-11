package org.cdac.model;

import javax.validation.constraints.Size;

import org.cdac.validation.Confirm;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

@Confirm(field="password", message="Both passwords doesn't match. ")
public class Register {

	@SafeHtml
	@NotEmpty(message="Enter your first name")
	private String firstName;
	
	@SafeHtml
	@NotEmpty(message="Enter your last name")
	private String lastName;
	
	@NotEmpty(message="Email must not be empty")
	@Email(message="Please give correct email id")
	private String email;
	
	@SafeHtml
	@NotEmpty(message="Please select your gender")
	private String gender;
		
	@SafeHtml
	@Size(min=8,message="Password must be at least {min} characters long")
	private String password;
	
	@SafeHtml
	@NotEmpty(message="Re-enter the password")
	private String confirmPassword;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	
}
