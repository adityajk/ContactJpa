package org.cdac.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.cdac.validation.Year;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.DateTimeFormat;

public class CreateEvent {

	@NotEmpty(message="Email must not be empty")
	@Email(message="Please give correct email id")
	private String attendeeEmail;
	
	@SafeHtml
	@NotEmpty(message="Please give summary")
	private String summary;
	
	@SafeHtml
	@NotEmpty(message="Please give description")
	private String description;
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@NotNull(message="Date is required")	
	@Year(2012)
	private Date when;

	public Date getWhen() {
		return when;
	}

	public void setWhen(Date when) {
		this.when = when;
	}

	public String getAttendeeEmail() {
		return attendeeEmail;
	}

	public void setAttendeeEmail(String attendeeEmail) {
		this.attendeeEmail = attendeeEmail;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
