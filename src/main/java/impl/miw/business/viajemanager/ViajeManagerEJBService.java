package impl.miw.business.viajemanager;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;

import com.miw.business.BookManagerService;
import com.miw.business.ViajeManagerService;
import com.miw.model.Book;
import com.miw.model.ParamBusquedaViaje;
import com.miw.model.Viaje;

public class ViajeManagerEJBService implements ViajeManagerService{

	@Autowired
	private ViajeManager viajeManager;

	private Integer times=0;
	
	public void setTimes(Integer times) {
		System.out.println("setting times to "+times);
		this.times = times;
	}
	
	public void setViajeManager(ViajeManager vm) {
		this.viajeManager = vm;
	}

	@Override
	public Vector<Viaje> getViajes() throws Exception {
		for (int i = 0 ; i < times ; i++)
			System.out.println("Devolviendo la lista de viajes desde el EJB Service");
		return viajeManager.getViajes();
	}

	@Override
	public Vector<Viaje> getViajesIda(ParamBusquedaViaje paramBusquedaViaje) throws Exception {
		for (int i = 0 ; i < times ; i++)
			System.out.println("Devolviendo la lista de viajes desde el EJB Service");
		
		return viajeManager.getViajesIda(paramBusquedaViaje);
	}
	
	@Override
	public Vector<Viaje> getViajesVuelta(ParamBusquedaViaje paramBusquedaViaje) throws Exception {
		for (int i = 0 ; i < times ; i++)
			System.out.println("Devolviendo la lista de viajes desde el EJB Service");
		
		return viajeManager.getViajesVuelta(paramBusquedaViaje);
	}
	
	@Override
	public boolean hayViajesConPlazasLibres(ParamBusquedaViaje paramBusquedaViaje) throws Exception {		
		return viajeManager.hayViajesConPlazasLibres(paramBusquedaViaje);
	}
	
	@Override
	public int getPlazasLibresViaje(Viaje viaje) throws Exception {
		return viajeManager.getPlazasLibresViaje(viaje);
	}
	
	@Override
	public Viaje getViaje(Viaje viaje) throws Exception {
		return viajeManager.getViaje(viaje);
	}
	
	
/*
	@Override
	public Book getSpecialOffer() throws Exception {
		for (int i = 0 ; i < times ; i++)
			System.out.println("Devolviendo la oferta de libros desde el EJB Service");
		return bookManager.getSpecialOffer();
	}
	
	public Book newBook(Book book ) throws Exception
	{
		return bookManager.newBook(book);
	}
*/
	
}
