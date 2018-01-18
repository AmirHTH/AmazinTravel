package com.miw.business;

import java.util.Vector;

import com.miw.model.Billete;
import com.miw.model.ParamBuscarReserva;
import com.miw.model.Usuario;

public interface BilleteManagerService {
	
	public int crearBillete(Billete billete, Usuario usuario) throws Exception;
	public void agregarViajesABillete(Billete billete) throws Exception;
	public int calcularPrecioFinal(Billete billete) throws Exception;
	
	public Billete cancelarReserva(ParamBuscarReserva paramBuscarReserva) throws Exception;
	
	public Billete getReserva(ParamBuscarReserva paramBuscarReserva) throws Exception;
	public Billete getBillete(Billete billete) throws Exception;
	
	public Vector<Billete> getBilletesUsuario(Usuario usuario) throws Exception;

}
