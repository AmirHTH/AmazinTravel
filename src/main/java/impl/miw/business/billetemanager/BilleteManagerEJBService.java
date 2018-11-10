package impl.miw.business.billetemanager;

import java.util.LinkedHashMap;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;

import com.miw.business.BilleteManagerService;
import com.miw.business.ViajeManagerService;
import com.miw.model.Billete;
import com.miw.model.ParamBuscarReserva;
import com.miw.model.ParamBusquedaViaje;
import com.miw.model.Usuario;
import com.miw.model.Viaje;

public class BilleteManagerEJBService implements BilleteManagerService{

	@Autowired
	private BilleteManager billeteManager;

private Integer times=0;
	
	public void setTimes(Integer times) {
		System.out.println("setting times to "+times);
		this.times = times;
	}
	
	public void setBilleteManager(BilleteManager bm) {
		this.billeteManager = bm;
	}

	@Override
	public Billete crearBillete(Billete billete, Usuario usuario) throws Exception {
		return billeteManager.crearBillete(billete, usuario);
	}

	@Override
	public void agregarViajesABillete(Billete billete) throws Exception {
		billeteManager.agregarViajesABillete(billete);
	}

	@Override
	public int calcularPrecioFinal(Billete billete) throws Exception {
		return billeteManager.calcularPrecioFinal(billete);
	}
	
	@Override
	public Billete cancelarReserva(ParamBuscarReserva paramBuscarReserva) throws Exception{
		return billeteManager.cancelarReserva(paramBuscarReserva);
	}

	@Override
	public Billete getBillete(Billete billete) throws Exception {
		return billeteManager.getBillete(billete);
	}
	
	@Override
	public Billete getReserva(ParamBuscarReserva paramBuscarReserva) throws Exception{
		return billeteManager.getReserva(paramBuscarReserva);
	}
	
	@Override
	public Vector<Billete> getBilletesUsuario(Usuario usuario) throws Exception{
		return billeteManager.getBilletesUsuario(usuario);
	}
	
	public LinkedHashMap<Integer, String> getDestinosMasPopulares() throws Exception{
		return billeteManager.getDestinosMasPopulares();
	}


	/*
	@Override
	public Vector<Viaje> getViajes() throws Exception {
		for (int i = 0 ; i < times ; i++)
			System.out.println("Devolviendo la lista de viajes desde el EJB Service");
		return viajeManager.getViajes();
	}
	*/

	/*
	@Override
	public Vector<Viaje> getViajesIda(ParamBusquedaViaje paramBusquedaViaje) throws Exception {
		for (int i = 0 ; i < times ; i++)
			System.out.println("Devolviendo la lista de viajes desde el EJB Service");
		
		return viajeManager.getViajesIda(paramBusquedaViaje);
	}
	*/
	
	/*
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
	*/
	
	
	
	
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
