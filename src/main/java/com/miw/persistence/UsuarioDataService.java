/**
 * 
 */
package com.miw.persistence;

import java.util.Vector;

import com.miw.model.ParamBusquedaViaje;
import com.miw.model.Usuario;
import com.miw.model.Viaje;

/**
 * @author Amir H. Tofigh Halati UO240753
 *
 */
public interface UsuarioDataService {
	public Usuario crearUsuario(Usuario usuario) throws Exception;
	public Usuario getUsuario(Usuario usuario) throws Exception;
	public Usuario getUsuarioById(Usuario usuario) throws Exception;
	public Vector<Usuario> getAllUsuarios() throws Exception;
	
}
