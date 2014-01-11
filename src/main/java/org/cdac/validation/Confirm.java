package org.cdac.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy=ConfirmValidator.class)
@Documented
public @interface Confirm {

	String message() default "Does not match";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {}; 
	
	/**
	 * The name of the field to be confirmed. e.g. password
	 */
	String field();

	/**
	 * The name of the field whose value must match the value of {@link #field()} to satisfy this constraint.
	 * Optional. If not specified, defaults to "confirm${field}" e.g. confirmPassword.
	 */
	String matches() default "";
}
