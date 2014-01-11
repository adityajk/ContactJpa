package org.cdac.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.cdac.validation.YearConstraintValidator;

@Documented
@Constraint(validatedBy = YearConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Year {

	int value();
	
	String message() default "Year should be greater than 2012";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	 
}