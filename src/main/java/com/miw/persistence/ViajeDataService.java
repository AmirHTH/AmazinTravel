/**
 * 
 */
package com.miw.persistence;

import java.util.ArrayList;

import com.miw.model.Viaje;



/**
 * @author Amir H. Tofigh Halati UO240753
 *
 */


public interface ViajeDataService {
	public ArrayList<Viaje> getAllViajes() throws Exception;
	public boolean creaViaje(Viaje viaje) throws Exception;

}
