package com.miw.business;


import com.miw.model.Usuario;


public interface UsuarioManagerService {
	
	public Usuario crearUsuario(Usuario usuario) throws Exception;
	public Usuario getUsuario(Usuario usuario) throws Exception;

	//public abstract Viaje getSpecialOffer() throws Exception;	
	
	//public Book newBook(Book book) throws Exception;
}
