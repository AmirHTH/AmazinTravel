/**
 * 
 */
package com.miw.persistence;


import java.util.LinkedHashMap;
import java.util.Vector;

import com.miw.model.Billete;
import com.miw.model.Usuario;


/**
 * @author Amir H. Tofigh Halati UO240753
 *
 */
public interface BilleteDataService {
	public Billete crearBillete(Billete billete) throws Exception;
	public Billete cancelarReserva(Billete billete) throws Exception;
	public Billete getBilleteByIdAndUser(Billete billete) throws Exception;
	public Vector<Billete> getBilletesUsuario(Usuario usuario) throws Exception;
	public Vector<Billete> getAllBilletes() throws Exception;
	public LinkedHashMap<Integer, String> getDestinosMasPopulares(int numeroResultados) throws Exception;
	

}
