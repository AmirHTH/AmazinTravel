package com.miw.model;



import org.hibernate.validator.constraints.NotEmpty;

import com.miw.model.validators.VueltaConstraint;

@VueltaConstraint
public class ParamBuscarReserva {
	
	@NotEmpty
	private int idReserva;
	
	@NotEmpty
	private String mail;

	
	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int codigoReserva) {
		this.idReserva = codigoReserva;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	

}
