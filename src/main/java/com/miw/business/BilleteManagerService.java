package com.miw.business;

import java.util.Vector;

import com.miw.model.Billete;
import com.miw.model.ParamBusquedaViaje;
import com.miw.model.Usuario;
import com.miw.model.Viaje;

public interface BilleteManagerService {
	
	public int crearBillete(Billete billete, Usuario usuario) throws Exception;
	public void agregarViajesABillete(Billete billete) throws Exception;
	public int calcularPrecioFinal(Billete billete) throws Exception;
	
	public int cancelarReserva(Billete billete, Usuario usuario) throws Exception;
	public Billete getBillete(Billete billete) throws Exception;

}
