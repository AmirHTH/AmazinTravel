package com.miw.model;



import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;


public class ParamBuscarReserva {
	
	@NotNull
	private Integer idReserva;
	
	@NotEmpty
	private String mail;

	
	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer codigoReserva) {
		this.idReserva = codigoReserva;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	

}
