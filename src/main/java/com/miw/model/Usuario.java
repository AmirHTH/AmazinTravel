/**
 * 
 */
package com.miw.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.miw.model.validators.PasswordConfirmationConstraint;
import com.miw.model.validators.PasswordSecurityConstraint;

/**
 * @author Amir H. Tofigh Halati UO240753
 *
 */
@PasswordConfirmationConstraint
@PasswordSecurityConstraint
public class Usuario {
	private int usuarioId;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellidos;
	
	@NotEmpty
	private String dni;
	
	@Email
	@NotEmpty
	private String mail;
	
	private String tipoDocumento;
	
	public final static String NIF = "pagar.nif";
	public final static String PASAPORTE = "pagar.pasaporte";
	public final static String NIE = "pagar.nie";
	
	private String password;
	
	private String passwordConfirmation;
	
	
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	
	
	
	public String getNif() {
		return NIF;
	}

	public String getPasaporte() {
		return PASAPORTE;
	}

	public String getNie() {
		return NIE;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Usuario [usuarioId=" + usuarioId + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", dni=" + dni + ", mail="
				+ mail + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + usuarioId;
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
		Usuario other = (Usuario) obj;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (usuarioId != other.usuarioId)
			return false;
		return true;
	}


	
	
	
	

}
