package com.miw.model.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.miw.model.ParamBusquedaViaje;

public class VueltaValidator implements ConstraintValidator<VueltaConstraint, ParamBusquedaViaje> {
 
    @Override
    public void initialize(VueltaConstraint contactNumber) {
    }
 
    @Override
    public boolean isValid(ParamBusquedaViaje paramBusquedaViaje, ConstraintValidatorContext cxt) {
    	boolean isValid = true;
    	System.out.println("------------------------ VALIDATOR --------------------");
        if (paramBusquedaViaje.getTipo().equals(ParamBusquedaViaje.VUELTA) && paramBusquedaViaje.getFechaVuelta() == null){
        	isValid = false;
        
        }
        return isValid;
    }


}
