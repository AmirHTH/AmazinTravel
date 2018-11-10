package com.miw.model.validators;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.TYPE})
@Constraint(validatedBy = PasswordSecurityValidator.class)
public @interface PasswordSecurityConstraint {
	
	 String message() default "La contraseña debe tener al menos 4 caracteres";
	 Class<?>[] groups() default {};
	 Class<? extends Payload>[] payload() default {};
	 
}