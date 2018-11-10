package com.miw.model.validators;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.FIELD})
@Constraint(validatedBy = DestinoValidator.class)
public @interface DestinoConstraint {
	
	 String message() default "No tenemos ningún viaje para el destino indicado.";
	 Class<?>[] groups() default {};
	 Class<? extends Payload>[] payload() default {};
	 
}