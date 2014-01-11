package org.cdac.model;

import javax.validation.constraints.Size;

import org.cdac.validation.Confirm;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

@Confirm(field="newPassword", message="Both passwords doesn't match. ")
public class UpdatePassword {

	@SafeHtml
	@Size(min=8,message="Password must be at least {min} characters long")
	private String currentPassword;
	
	@SafeHtml
	@Size(min=8,message="Password must be at least {min} characters long")
	private String newPassword;
	
	@SafeHtml
	@NotEmpty(message="Re-enter the password")
	private String confirmPassword;
	
	
	public String getCurrentPassword() {
		return currentPassword;
	}
	
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	
	public String getNewPassword() {
		return newPassword;
	}
	
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
