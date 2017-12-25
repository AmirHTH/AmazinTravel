/**
 * 
 */
package com.miw.persistence;


import com.miw.model.Billete;


/**
 * @author Amir H. Tofigh Halati UO240753
 *
 */
public interface BilleteDataService {
	
	public boolean creaReserva(Billete billete) throws Exception;
	
	public boolean cancelaReserva(int reservaID, String email) throws Exception;
		

}
