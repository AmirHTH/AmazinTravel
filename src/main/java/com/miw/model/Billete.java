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
	private int plazasCompradas;
	private int numMaletas15;
	private int numMaletas20;
	private String cocheTipo;
	private double precioFinal;
	private int billeteVueltaId;
	
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
	public int getPlazasCompradas() {
		return plazasCompradas;
	}
	/**
	 * @param plazasCompradas the plazasCompradas to set
	 */
	public void setPlazasCompradas(int plazasCompradas) {
		this.plazasCompradas = plazasCompradas;
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
	@Override
	public String toString() {
		return "Billete [billeteId=" + billeteId + ", viajeId=" + viajeId
				+ ", usuarioId=" + usuarioId + ", plazasCompradas="
				+ plazasCompradas + ", numMaletas15=" + numMaletas15
				+ ", numMaletas20=" + numMaletas20 + ", cocheTipo=" + cocheTipo
				+ ", precioFinal=" + precioFinal 
				+ "Billete de vuelta"+ billeteVueltaId +"]";
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
		result = prime * result + plazasCompradas;
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
		if (plazasCompradas != other.plazasCompradas)
			return false;
		if (usuarioId != other.usuarioId)
			return false;
		if (viajeId != other.viajeId)
			return false;
		return true;
	}
	
	
	
	


}
