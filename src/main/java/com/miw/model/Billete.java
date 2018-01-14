/**
 * 
 */
package com.miw.model;

/**
 * @author Amir H. Tofigh Halati UO240753
 *
 */
public class Billete {
	
	private int billeteId;
	private int viajeId;
	private int usuarioId;
	private int plazas;
	private int numMaletas15;
	private int numMaletas20;
	private String cocheTipo = COCHE_ALQUILER_NINGUNO; //Al crear un billete no habrá ningún tipo de coche seleccionado, lo seleccionará el usuario después.
	private double precioFinal;
	private int billeteVueltaId;
	
	private boolean confirmado;
	
	private Viaje viajeIda;
	private Viaje viajeVuelta;
	
	private String tipo = SOLO_IDA ;
	
	public final static double PRECIO_MALETA_15 = 15.0;
	public final static double PRECIO_MALETA_20 = 20.0;
	
	public final static double PRECIO_COCHE_ALQUILER_UTILITARIO = 30.0;
	public final static double PRECIO_COCHE_ALQUILER_FURGONETA = 45.0;
	
	public final static String VUELTA = "vuelta";
	public final static String SOLO_IDA = "solo_ida";
	
	public final static String COCHE_ALQUILER_NINGUNO = "Ninguno";
	public final static String COCHE_ALQUILER_UTILITARIO = "Utilitario";
	public final static String COCHE_ALQUILER_FURGONETA = "Furgoneta";
	
	
	
	
	public int getBilleteVueltaId() {
		return billeteVueltaId;
	}
	public void setBilleteVueltaId(int billeteVueltaId) {
		this.billeteVueltaId = billeteVueltaId;
	}
	/**
	 * @return the billeteId
	 */
	public int getBilleteId() {
		return billeteId;
	}
	/**
	 * @param billeteId the billeteId to set
	 */
	public void setBilleteId(int billeteId) {
		this.billeteId = billeteId;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the viajeId
	 */
	public int getViajeId() {
		return viajeId;
	}
	/**
	 * @param viajeId the viajeId to set
	 */
	public void setViajeId(int viajeId) {
		this.viajeId = viajeId;
	}
	/**
	 * @return the usuarioId
	 */
	public int getUsuarioId() {
		return usuarioId;
	}
	/**
	 * @param usuarioId the usuarioId to set
	 */
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	/**
	 * @return the numMaletas15
	 */
	public int getNumMaletas15() {
		return numMaletas15;
	}
	/**
	 * @param numMaletas15 the numMaletas15 to set
	 */
	public void setNumMaletas15(int numMaletas15) {
		this.numMaletas15 = numMaletas15;
	}
	/**
	 * @return the numMaletas20
	 */
	public int getNumMaletas20() {
		return numMaletas20;
	}
	/**
	 * @param numMaletas20 the numMaletas20 to set
	 */
	public void setNumMaletas20(int numMaletas20) {
		this.numMaletas20 = numMaletas20;
	}
	/**
	 * @return the plazasCompradas
	 */
	public int getPlazas() {
		return plazas;
	}
	/**
	 * @param plazasCompradas the plazasCompradas to set
	 */
	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	/**
	 * @return the cocheTipo
	 */
	public String getCocheTipo() {
		return cocheTipo;
	}
	/**
	 * @param cocheTipo the cocheTipo to set
	 */
	public void setCocheTipo(String cocheTipo) {
		this.cocheTipo = cocheTipo;
	}
	/**
	 * @return the precioFinal
	 */
	public double getPrecioFinal() {
		return precioFinal;
	}
	/**
	 * @param precioFinal the precioFinal to set
	 */
	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	public Viaje getViajeIda() {
		return viajeIda;
	}
	public void setViajeIda(Viaje viajeIda) {
		this.viajeIda = viajeIda;
	}
	public Viaje getViajeVuelta() {
		return viajeVuelta;
	}
	public void setViajeVuelta(Viaje viajeVuelta) {
		this.viajeVuelta = viajeVuelta;
	}
	
	public boolean isConfirmado() {
		return confirmado;
	}
	
	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}
	
	
	@Override
	public String toString() {
		return "Billete [billeteId=" + billeteId + ", viajeId=" + viajeId
				+ ", usuarioId=" + usuarioId + ", plazasCompradas="
				+ plazas + ", numMaletas15=" + numMaletas15
				+ ", numMaletas20=" + numMaletas20 + ", cocheTipo=" + cocheTipo
				+ ", precioFinal=" + precioFinal 
				+ " Billete de vuelta="+ billeteVueltaId +"]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + billeteId;
		result = prime * result
				+ ((cocheTipo == null) ? 0 : cocheTipo.hashCode());
		result = prime * result + numMaletas15;
		result = prime * result + numMaletas20;
		result = prime * result + plazas;
		result = prime * result + usuarioId;
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
		Billete other = (Billete) obj;
		if (billeteId != other.billeteId)
			return false;
		if (cocheTipo == null) {
			if (other.cocheTipo != null)
				return false;
		} else if (!cocheTipo.equals(other.cocheTipo))
			return false;
		if (numMaletas15 != other.numMaletas15)
			return false;
		if (numMaletas20 != other.numMaletas20)
			return false;
		if (plazas != other.plazas)
			return false;
		if (usuarioId != other.usuarioId)
			return false;
		if (viajeId != other.viajeId)
			return false;
		return true;
	}
	

	
	
	
	
	
	
	


}
