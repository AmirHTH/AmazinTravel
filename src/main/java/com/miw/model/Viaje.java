/**
 * 
 */
package com.miw.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Amir H. Tofigh Halati UO240753
 *
 */
public class Viaje {
	
	private int viajeId;
	private String origen;
	private String destino;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	private Date f_salida;
	
	private int plazas_totales;
	private int plazas_quedan;
	private double precio;
	/**
	 * @return the viajeid
	 */
	public int getViajeId() {
		return viajeId;
	}
	/**
	 * @param viajeid the viajeid to set
	 */
	public void setViajeId(int viajeid) {
		this.viajeId = viajeid;
	}
	/**
	 * @return the origen
	 */
	public String getOrigen() {
		return origen;
	}
	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	/**
	 * @return the destino
	 */
	public String getDestino() {
		return destino;
	}
	/**
	 * @param destino the destino to set
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}
	/**
	 * @return the f_salida
	 */
	public Date getF_salida() {
		return f_salida;
	}
	/**
	 * @param f_salida the f_salida to set
	 */
	public void setF_salida(Date f_salida) {
		this.f_salida = f_salida;
	}
	
	/**
	 * @return the plazas_totales
	 */
	public int getPlazas_totales() {
		return plazas_totales;
	}
	/**
	 * @param plazas_totales the plazas_totales to set
	 */
	public void setPlazas_totales(int plazas_totales) {
		this.plazas_totales = plazas_totales;
	}
	/**
	 * @return the plazas_quedan
	 */
	public int getPlazas_quedan() {
		return plazas_quedan;
	}
	/**
	 * @param plazas_quedan the plazas_quedan to set
	 */
	public void setPlazas_quedan(int plazas_quedan) {
		this.plazas_quedan = plazas_quedan;
	}
	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result
				+ ((f_salida == null) ? 0 : f_salida.hashCode());
		result = prime * result + ((origen == null) ? 0 : origen.hashCode());
		result = prime * result + viajeId;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Viaje other = (Viaje) obj;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (f_salida == null) {
			if (other.f_salida != null)
				return false;
		} else if (!f_salida.equals(other.f_salida))
			return false;
		if (origen == null) {
			if (other.origen != null)
				return false;
		} else if (!origen.equals(other.origen))
			return false;
		if (viajeId != other.viajeId)
			return false;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Viaje [viajeId=" + viajeId + ", origen=" + origen
				+ ", destino=" + destino + ", f_salida=" + f_salida
				+ ", plazas_totales=" + plazas_totales + ", plazas_quedan="
				+ plazas_quedan + ", precio=" + precio + "]";
	}


	public String toStringEmail() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		
		return 
				  "\t\t\t " + "Origen: " + origen + "\n\r"
				+ "\t\t\t " + "Destino: " + destino + "\n\r"
				+ "\t\t\t " + "Fecha de Salida: " + dateFormat.format(f_salida) + "\n\r"
				;
	}	

}
