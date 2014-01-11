package org.cdac.validation;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.cdac.validation.Year;

public class YearConstraintValidator implements ConstraintValidator<Year, Date> {

	private int annotationYear;
	
	@Override
	public void initialize(Year year) {
		this.annotationYear = year.value();
	}

	@Override
	public boolean isValid(Date target, ConstraintValidatorContext cxt) {
		if(target == null) {
			return true;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(target);
		int fieldYear = c.get(Calendar.YEAR);
		return fieldYear > annotationYear;
	}

}
