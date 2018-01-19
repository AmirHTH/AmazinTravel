package impl.miw.presentation.viaje;

import java.util.Vector;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.miw.business.ViajeManagerService;
import com.miw.model.Billete;
import com.miw.model.ParamBusquedaViaje;
import com.miw.model.Viaje;

@Controller
@SessionAttributes("billete")
public class BuscarViajesController {

	@Autowired 
	ViajeManagerService viajeManagerService;
	
	
	public ViajeManagerService getViajeManagerService() {
		return viajeManagerService;
	}


	public void setViajeManagerService(ViajeManagerService viajeManagerService) {
		this.viajeManagerService = viajeManagerService;
	}
	
	/*
	@RequestMapping(value="private/seekViajes", method = RequestMethod.GET)
	public void get()
	{
		System.out.println("----- GET ------");
	}*/

	@RequestMapping(value="buscarViaje", method = RequestMethod.POST)
	public String buscarViaje(@Valid @ModelAttribute ParamBusquedaViaje param,  BindingResult result, Model model )
	{
		if ( result.hasErrors()){
			System.out.println("---- Has Errors -----");
			//return "viaje/buscarViaje";
			return "index";
			
		}else{
			//new ParamBusquedaViaje();
			System.out.println("----- POST ------");
			System.out.println("Contenido: " + param.toString());
			
			model.addAttribute("param", param);
			
			Vector<Viaje> viajesIda;
			try {
				viajesIda = viajeManagerService.getViajesIda(param);
			
			// Colocamos la lista de viajes en el modelo
			model.addAttribute("viajesIdaList", viajesIda);
			Billete billete = new Billete();
			billete.setPlazas(param.getPlazas());
			model.addAttribute("billete", billete);
			
        	
        	if(viajesIda != null && viajesIda.isEmpty()){
        		boolean hayViajes = viajeManagerService.hayViajesConPlazasLibres(param);
        		if(hayViajes){ //Si hay viajes para esa fecha pero no se nos han devuelto resultados, es que no hay plazas libres.
        			model.addAttribute("mensajeViajesIda", "No hay " + param.getPlazas() + " plazas libres en los viajes disponibles.");
        		}else{
        			model.addAttribute("mensajeViajesIda", "No hay viajes para ese Origen, Destino y fecha de salida.");
        		}
        	}
        	
        	if(param.getTipo().equals(ParamBusquedaViaje.VUELTA)){
        		ParamBusquedaViaje paramVuelta = new ParamBusquedaViaje();
        		paramVuelta.setOrigen(param.getOrigen());
        		paramVuelta.setDestino(param.getDestino());
        		paramVuelta.setFechaIda(param.getFechaIda());
        		paramVuelta.setFechaVuelta(param.getFechaVuelta());
        		paramVuelta.setTipo(param.getTipo());
        		paramVuelta.setPlazas(param.getPlazas());
        		
				Vector<Viaje> viajesVuelta = viajeManagerService.getViajesVuelta(param);
				model.addAttribute("viajesVueltaList", viajesVuelta);
				
				if(viajesVuelta != null && viajesVuelta.isEmpty()){
	        		boolean hayViajes = viajeManagerService.hayViajesConPlazasLibres(paramVuelta);
	        		if(hayViajes){ //Si hay viajes para esa fecha pero no se nos han devuelto resultados, es que no hay plazas libres.
	        			model.addAttribute("mensajeViajesVuelta", "No hay " + param.getPlazas() + " plazas libres en los viajes disponibles.");
	        		}else{
	        			model.addAttribute("mensajeViajesVuelta", "No hay viajes para ese Origen, Destino y fecha de salida.");
	        		}
	        	}
			}	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        	
		return "index";
	}
	
	/*
	@ModelAttribute
	ParamBusquedaViaje getParamBusquedaViaje()
	{
		return new ParamBusquedaViaje();
	}
	*/
	
	/*
	@RequestMapping("private/seekAllViajes")
	public String seekAllViajes(Model model) throws Exception {
		System.out.println("Ejecutado SeekAllViajes.");

		// Colocamos la lista de libros en el modelo.
		model.addAttribute("viajesList", viajeManagerService.getViajes());
		// Levantamos el evento success para especificar que todo ha ido bien
		return "private/seekAllViajes";	
	}*/
	
}
