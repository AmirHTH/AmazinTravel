package com.miw.model.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.miw.business.UsuarioManagerService;
import com.miw.model.ParamBusquedaViaje;
import com.miw.persistence.BilleteDataService;
import com.miw.persistence.ViajeDataService;

public class DestinoValidator implements ConstraintValidator<DestinoConstraint, String> {

	
	@Autowired
	private ViajeDataService viajeDataService;
	
	
	public void setViajeDataService(ViajeDataService viajeDataService) {
		this.viajeDataService = viajeDataService;
	}
 
    @Override
    public void initialize(DestinoConstraint constraintAnotation) {
    }
 
    @Override
    public boolean isValid(String destino, ConstraintValidatorContext cxt) {
    	boolean isValid = true;
    	System.out.println("------------------------ VALIDATOR --------------------");
      
    	try {
			if (viajeDataService.viajesDestino(destino) == 0){
				isValid = false;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
        		
        return isValid;
    }


}
