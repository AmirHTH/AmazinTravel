/**
 * 
 */
package com.miw.persistence;

import java.util.ArrayList;
import java.util.Vector;
import com.miw.model.ParamBusquedaViaje;
import com.miw.model.Viaje;



/**
 * @author Amir H. Tofigh Halati UO240753
 *
 */


public interface ViajeDataService {
	public Vector<Viaje> getViajes() throws Exception;
	public Vector<Viaje> getViajesIda(ParamBusquedaViaje paramBusquedaViaje) throws Exception;
	public Vector<Viaje> getViajesVuelta(ParamBusquedaViaje paramBusquedaViaje) throws Exception;
	public boolean hayViajesConPlazasLibres(ParamBusquedaViaje paramBusquedaViaje) throws Exception;
	public int getPlazasLibresViaje(Viaje viaje) throws Exception;
	
	public Viaje getViaje(Viaje viaje) throws Exception;
	
	public boolean restarPlazas(Viaje viaje, int plazas) throws Exception;
	public boolean agregarPlazas(Viaje viaje, int plazas) throws Exception;
	
	//public boolean creaViaje(Viaje viaje) throws Exception;
	
}
