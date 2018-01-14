package com.miw.model.validators;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.TYPE})
@Constraint(validatedBy = VueltaValidator.class)
public @interface VueltaConstraint {
	/*

@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
*/
	
	 String message() default "Si el viaje es de ida y vuelta debe seleccionar una fecha de vuelta.";
	 Class<?>[] groups() default {};
	 Class<? extends Payload>[] payload() default {};
	 
}