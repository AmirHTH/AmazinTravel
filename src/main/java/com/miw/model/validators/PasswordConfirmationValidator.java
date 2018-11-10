package com.miw.model.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.miw.model.ParamBusquedaViaje;
import com.miw.model.Usuario;

public class PasswordConfirmationValidator implements ConstraintValidator<PasswordConfirmationConstraint, Usuario> {
 
    @Override
    public void initialize(PasswordConfirmationConstraint contactNumber) {
    }
 
    @Override
    public boolean isValid(Usuario usuario, ConstraintValidatorContext cxt) {
    	boolean isValid = false;
    	System.out.println("------------------------ VALIDATOR --------------------");
    	if(usuario.getPassword() != null){
	        if(usuario.getPassword().equals(usuario.getPasswordConfirmation())){
	        	isValid = true;        	
	        }
        }else{
        	isValid = true;
        }
    	
        return isValid;
    }


}
