package com.miw.model.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.miw.business.UsuarioManagerService;
import com.miw.model.ParamBusquedaViaje;
import com.miw.persistence.BilleteDataService;
import com.miw.persistence.ViajeDataService;

public class OrigenValidator implements ConstraintValidator<OrigenConstraint, String> {

	
	@Autowired
	private ViajeDataService viajeDataService;
	
	
	public void setViajeDataService(ViajeDataService viajeDataService) {
		this.viajeDataService = viajeDataService;
	}
 
    @Override
    public void initialize(OrigenConstraint constraintAnotation) {
    }
 
    @Override
    public boolean isValid(String origen, ConstraintValidatorContext cxt) {
    	boolean isValid = true;
    	System.out.println("------------------------ VALIDATOR --------------------");
      
    	try {
			if (viajeDataService.viajesOrigen(origen) == 0){
				isValid = false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        		
        return isValid;
    }


}
