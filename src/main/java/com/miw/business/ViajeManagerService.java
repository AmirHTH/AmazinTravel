package com.miw.business;

import java.util.Vector;

import com.miw.model.ParamBusquedaViaje;
import com.miw.model.Viaje;

public interface ViajeManagerService {
	public Vector<Viaje> getViajes() throws Exception;
	
	public Vector<Viaje> getViajesIda(ParamBusquedaViaje paramBusquedaViaje) throws Exception;
	public Vector<Viaje> getViajesVuelta(ParamBusquedaViaje paramBusquedaViaje) throws Exception;
	public boolean hayViajesConPlazasLibres(ParamBusquedaViaje paramBusquedaViaje) throws Exception;
	public int getPlazasLibresViaje(Viaje viaje) throws Exception;
	
	public Viaje getViaje(Viaje viaje) throws Exception;
	
	public boolean restarPlazas(Viaje viaje, int plazas) throws Exception;
	public boolean agregarPlazas(Viaje viaje, int plazas) throws Exception;
	
	public int viajesOrigen(String origen) throws Exception;
	public int viajesDestino(String destino) throws Exception;

	//public abstract Viaje getSpecialOffer() throws Exception;	
	
	//public Book newBook(Book book) throws Exception;
}
