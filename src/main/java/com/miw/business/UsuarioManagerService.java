package com.miw.business;

import java.util.Vector;

import com.miw.model.ParamBusquedaViaje;
import com.miw.model.Usuario;
import com.miw.model.Viaje;

public interface UsuarioManagerService {
	
	public Usuario crearUsuario(Usuario usuario) throws Exception;
	public Usuario getUsuario(Usuario usuario) throws Exception;

	//public abstract Viaje getSpecialOffer() throws Exception;	
	
	//public Book newBook(Book book) throws Exception;
}
