package com.miw.model.validators;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.TYPE})
@Constraint(validatedBy = PasswordConfirmationValidator.class)
public @interface PasswordConfirmationConstraint {
	
	 String message() default "La contraseña y su confirmación deben coincidir.";
	 Class<?>[] groups() default {};
	 Class<? extends Payload>[] payload() default {};
	 
}