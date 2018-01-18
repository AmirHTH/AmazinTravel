package impl.miw.presentation.reserva;

import impl.miw.business.billetemanager.BilleteManager;

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
import org.springframework.web.bind.support.SessionAttributeStore;
import org.springframework.web.context.request.WebRequest;

import com.miw.business.BilleteManagerService;
import com.miw.business.ViajeManagerService;
import com.miw.model.Billete;
import com.miw.model.ParamBuscarReserva;
import com.miw.model.ParamBusquedaViaje;
import com.miw.model.Usuario;
import com.miw.model.Viaje;

@Controller
@SessionAttributes({"billete", "usuario", /* "reservaBuscada", */ "paramBuscarReserva"})
public class BuscarReservaController {

	@Autowired 
	BilleteManagerService billeteManagerService;
	
	
	public BilleteManagerService getBilleteManagerService() {
		return billeteManagerService;
	}


	public void setBilleteManagerService(BilleteManagerService billeteManagerService) {
		this.billeteManagerService = billeteManagerService;
	}	
	
	
	@RequestMapping(value="buscarReserva", method=RequestMethod.GET)
    public String buscarReserva(Model model){
		System.out.println("----- GET BuscarReserva ------");
		model.addAttribute("paramBuscarReserva", new ParamBuscarReserva());
		//model.addAttribute("reservaBuscada", new Billete());
		return "reserva/buscarReserva";
    }
	

	
	@RequestMapping(value="buscarReserva", method = RequestMethod.POST)
	public String buscarReserva(@Valid @ModelAttribute ParamBuscarReserva paramBuscarReserva, BindingResult result, Model model ) throws Exception
	{
		if ( result.hasErrors())
		{
			System.out.println("---- Has Errors -----");
			return "reserva/buscarReserva";
			
		}else{
			Billete billete = billeteManagerService.getReserva(paramBuscarReserva);
			model.addAttribute("reservaBuscada", billete);
			model.addAttribute("paramBuscarReserva", paramBuscarReserva);
			//Subimos al modelo los parámetros de búsqueda por si se nos ordena una cancelación
			//model.addAttribute("paramBuscarReserva", paramBuscarReserva);
	     	
			return "reserva/buscarReserva";
		}
	}	
	
}
