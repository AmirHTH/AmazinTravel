/* Generated by Together */

package impl.miw.business.billetemanager;

import java.util.Map;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;

import com.miw.business.BilleteManagerService;
import com.miw.business.UsuarioManagerService;
import com.miw.business.ViajeManagerService;
import com.miw.model.Billete;
import com.miw.model.Iva;
import com.miw.model.ParamBusquedaViaje;
import com.miw.model.Usuario;
import com.miw.model.Viaje;
import com.miw.persistence.BilleteDataService;
import com.miw.persistence.BookDataService;
import com.miw.persistence.IvaDataService;
import com.miw.persistence.UsuarioDataService;
import com.miw.persistence.ViajeDataService;

public class BilleteManager implements BilleteManagerService {
	public final static int RESULTADO_CORRECTO = 0;
	public final static int RESULTADO_ERROR_VUELO_IDA_LLENO = 1;
	public final static int RESULTADO_ERROR_VUELO_VUELTA_LLENO = 2;
	public final static int RESULTADO_PROCESO_NO_INICIADO = 3;
	
	public final static int RESULTADO_RESERVA_NO_ENCONTRADA = 4;
	public final static int RESULTADO_USUARIO_NO_ENCONTRADO = 5;
	public final static int RESULTADO_RESERVA_NO_ENCONTRADA_PARA_ESE_USUARIO = 6;
	
	@Autowired
	private BilleteDataService billeteDataService;
	
	@Autowired
	private ViajeDataService viajeManagerService;
	
	@Autowired
	private UsuarioDataService usuarioManagerService;
	
	public void setBilleteDataService(BilleteDataService billeteDataService) {
		this.billeteDataService = billeteDataService;
	}

	
	public int crearBillete(Billete billete, Usuario usuario) throws Exception{
		int codigoResultadoOperacion  = RESULTADO_PROCESO_NO_INICIADO;
		
		//Tenemos que revisar primero que siga habiendo sitio en los vuelos que el usuario desea comprar, pudo pasar que en el tiempo que pasa entre que busc� los vuelos y los confirma
		//las plazas hayan sido reservadas por otra persona.
		Viaje viaje = new Viaje();
		viaje.setViajeId(billete.getViajeId());
		int plazasLibresIda = viajeManagerService.getPlazasLibresViaje(viaje);
		if(plazasLibresIda >= billete.getPlazas()){
			
			//Hay plazas libres en el billete de ida. Revisamos si se ha escogido vuelta
			if(billete.getTipo().equals(Billete.VUELTA)){
				viaje = new Viaje();
				viaje.setViajeId(billete.getBilleteVueltaId());
				int plazasLibresVuelta = viajeManagerService.getPlazasLibresViaje(viaje);
				
				if(plazasLibresVuelta < billete.getPlazas()){
					//Si no hay plazas ya en el vuelo de vuelta.
					codigoResultadoOperacion = RESULTADO_ERROR_VUELO_VUELTA_LLENO;
					return codigoResultadoOperacion;
				}
			}	
			
			//Revisamos si el usuario existe
			Usuario usuarioEnSistema = usuarioManagerService.getUsuario(usuario);
			if(usuarioEnSistema == null){
				//El usuario no existe en el sistema y debemos crearlo
				usuarioEnSistema = usuarioManagerService.crearUsuario(usuario);
			}
			billete.setUsuarioId(usuarioEnSistema.getUsuarioId());
			
			//Una vez comprobado todo podemos crear el billete
			billete = billeteDataService.crearBillete(billete);
			//Y restamos el n�mero de Plazas Libres en los vuelos
			viajeManagerService.restarPlazas(billete.getViajeIda(), billete.getPlazas());
			
			if(billete.getTipo().equals(Billete.VUELTA)){
				viajeManagerService.restarPlazas(billete.getViajeVuelta(), billete.getPlazas());
			}
			
			
			if(billete != null){
				codigoResultadoOperacion = RESULTADO_CORRECTO;
				billete.setConfirmado(true);
			}
			
		}else{
			//Si no hay plazas libres en el vuelo de ida
			codigoResultadoOperacion = RESULTADO_ERROR_VUELO_IDA_LLENO;
		}
		
		return codigoResultadoOperacion;
	}
	
	public void agregarViajesABillete(Billete billete) throws Exception{
		Viaje viaje = new Viaje();
		if(billete.getViajeIda() == null){		
			viaje.setViajeId(billete.getViajeId());
			billete.setViajeIda(viajeManagerService.getViaje(viaje));
		}
		if(billete.getTipo().equals(Billete.VUELTA) && billete.getViajeVuelta() == null){
			viaje = new Viaje();
			viaje.setViajeId(billete.getBilleteVueltaId());
			billete.setViajeVuelta(viajeManagerService.getViaje(viaje));
		}
	}
	
	
	public int calcularPrecioFinal(Billete billete){
		float precioFinal = 0.0f;
		
		if(billete.getViajeIda() != null){
			precioFinal += billete.getViajeIda().getPrecio()*billete.getPlazas();
		}
		if(billete.getTipo().equals(Billete.VUELTA) && billete.getViajeVuelta() != null){
			precioFinal += billete.getViajeVuelta().getPrecio()*billete.getPlazas();			
		}
		precioFinal += billete.getNumMaletas15() * Billete.PRECIO_MALETA_15;
		precioFinal += billete.getNumMaletas20() * Billete.PRECIO_MALETA_20;
		
		if(billete.getCocheTipo().equals(Billete.COCHE_ALQUILER_FURGONETA)){
			precioFinal += Billete.PRECIO_COCHE_ALQUILER_FURGONETA;
		}
		else if(billete.getCocheTipo().equals(Billete.COCHE_ALQUILER_UTILITARIO)){
			precioFinal += Billete.PRECIO_COCHE_ALQUILER_UTILITARIO;
		}
		
		billete.setPrecioFinal(precioFinal);
	
		return 0;		
	}
	
	public Billete getBillete(Billete billete) throws Exception{
		return billeteDataService.getBillete(billete);
	}
	

	public Billete getBilleteDeUsuario(Billete billete, Usuario usuario) throws Exception{
		
		//Me dan el codigo de la reserva
		//Obtener datos reserva completa
		billete = this.getBillete(billete);
		
		if(billete != null){
			//ObtenerDatosUsuario
			usuario = usuarioManagerService.getUsuario(usuario);
		
			if(usuario != null){
				if(billete.getUsuarioId() == usuario.getUsuarioId()){
					return billete;
				}
			}
		}
		return null;
	}
	
	public int cancelarReserva(Billete billete, Usuario usuario) throws Exception{
		int codigoResultadoOperacion = RESULTADO_PROCESO_NO_INICIADO;
		//Comprobamos de nuevo que esa reserva existe para ese usuario
		billete = this.getBilleteDeUsuario(billete, usuario);
		
		if(billete == null){
			return codigoResultadoOperacion = RESULTADO_RESERVA_NO_ENCONTRADA_PARA_ESE_USUARIO;
		}
		
		Viaje viaje = new Viaje();
		viaje.setViajeId(billete.getViajeId());
		viajeManagerService.agregarPlazas(viaje, billete.getPlazas());
		
		if(billete.getTipo().equals(Billete.VUELTA)){
			Viaje viajeVuelta = new Viaje();
			viajeVuelta.setViajeId(billete.getBilleteVueltaId());
			viajeManagerService.agregarPlazas(viajeVuelta, billete.getPlazas());
		}
		
		
		
	
		
		return codigoResultadoOperacion;

	}

	

	
/*
	public void setViajeDataService(ViajeDataService viajeDataService) {
		this.viajeDataService = viajeDataService;
	}

	public void setIvaDataService(IvaDataService ivaDataService) {
		this.ivaDataService = ivaDataService;
	}

	public Vector<Viaje> getViajes() throws Exception
	{
		
		Vector<Viaje> viajes = viajeDataService.getViajes();
		//Vector<Iva> ivas= ivaDataService.getIvas();
		/*
		for ( Viaje viaje: viajes)
		{
			for ( Iva iva:ivas)
			{
				if ( book.getFamily()==iva.getFamily())
				{
					//Aplicamos el descuento por familia al calcular el precio
					book.setPrice(book.getBasePrice()*iva.getValue()*(100-disccounts.get(book.getFamily() ) )/100 );
					
				}
			}
		}
		*//*
		return viajes;
	}

	@Override
	public Vector<Viaje> getViajesIda(ParamBusquedaViaje paramBusquedaViaje) throws Exception {
		Vector<Viaje> viajes = viajeDataService.getViajesIda(paramBusquedaViaje);
		return viajes;
	}
	
	@Override
	public Vector<Viaje> getViajesVuelta(ParamBusquedaViaje paramBusquedaViaje) throws Exception {
		Vector<Viaje> viajes = viajeDataService.getViajesVuelta(paramBusquedaViaje);
		return viajes;
	}
	
	public boolean hayViajesConPlazasLibres(ParamBusquedaViaje paramBusquedaViaje) throws Exception{
		return viajeDataService.hayViajesConPlazasLibres(paramBusquedaViaje);
	}
*/	
	
	
	/*
	@Override
	public Book getSpecialOffer() throws Exception
	{
		Vector<Book> books = getBooks();
		int number = (int) (Math.random()*books.size()-1);
		System.out.println("Aplicando descuento a "+books.elementAt(number).getTitle());
		books.elementAt(number).setPrice((double)books.elementAt(number).getPrice()*0.9);
		return books.elementAt(number);
	}

	public Book newBook(Book book) throws Exception {
		// TODO Auto-generated method stub
		return this.bookDataService.newBook(book);
	}
	*/
	
}
