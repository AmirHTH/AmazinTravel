package com.miw.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.miw.model.validators.VueltaConstraint;

@VueltaConstraint
public class ParamBusquedaViaje {
	@NotEmpty(message="Debe indicar un Origen.")
	private String origen;
	
	@NotEmpty(message="Debe indicar un Destino.")
	private String destino;
	
	@NotNull(message="Debe indicar una Fecha de Salida.")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fechaIda;
	
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fechaVuelta;
	
	@NotNull(message="Debe indicar un número de Plazasl.")
	private Integer plazas;
	
	@NotEmpty
	private String tipo;
	
	public final static String VUELTA = "vuelta";
	public final static String SOLO_IDA = "solo_ida";
	
	
	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public Date getFechaIda() {
		return fechaIda;
	}

	public void setFechaIda(Date fechaIda) {
		this.fechaIda = fechaIda;
	}

	public Date getFechaVuelta() {
		return fechaVuelta;
	}

	public void setFechaVuelta(Date fechaVuelta) {
		//Hay navegadores como Firefox que fuerzan el formato de fecha a tener / en lugar de -. 
		
		 Date date = null;
		 /*
	     try {
	    	 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	         date = sdf.parse(fechaVuelta.toString());
	            if (!fechaVuelta.equals(sdf.format(date))) {
	                fechaVuelta = sdf.parse(fechaVuelta.toString());
	            }
	        } catch (ParseException ex) {
	            ex.printStackTrace();
	        }
	        */
		this.fechaVuelta = fechaVuelta;
	}

	public Integer getPlazas() {
		return plazas;
	}

	public void setPlazas(Integer plazas) {
		this.plazas = plazas;
	}


	@Override
	public String toString() {
		return "ParamBusquedaViaje [Origen=" + origen + 
								", Destino=" + destino + 
								", Fecha Ida =" + fechaIda + 
								", Fecha Vuelta =" + fechaVuelta + 
								", Plazas =" + plazas + 
								", Tipo=" + tipo + 
								"]";
	}
	
	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
