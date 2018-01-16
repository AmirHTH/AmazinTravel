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

import com.miw.business.BilleteManagerService;
import com.miw.business.ViajeManagerService;
import com.miw.model.Billete;
import com.miw.model.ParamBuscarReserva;
import com.miw.model.ParamBusquedaViaje;
import com.miw.model.Usuario;
import com.miw.model.Viaje;

@Controller
@SessionAttributes({"billete", "usuario", "paramBuscarReserva"})
public class CancelarReservaController {

	@Autowired 
	BilleteManagerService billeteManagerService;
	
	
	public BilleteManagerService getBilleteManagerService() {
		return billeteManagerService;
	}


	public void setBilleteManagerService(BilleteManagerService billeteManagerService) {
		this.billeteManagerService = billeteManagerService;
	}	
	
	/*
	@RequestMapping(value="private/cancelarReserva", method=RequestMethod.GET)
    public void facturar(){
		System.out.println("----- GET CancelarReserva ------");
		billeteManagerService.cancelarReserva(paramBuscarReserva);
    }
	*/
	

	
	@RequestMapping(value="cancelarReserva", method = RequestMethod.GET)
	public String cancelarReserva(ParamBuscarReserva paramBuscarReserva, Model model, BindingResult result ) throws Exception
	{
		Billete billete = billeteManagerService.cancelarReserva(paramBuscarReserva);
		model.addAttribute("reservaBuscada", billete);

		return "reserva/cancelarReserva";
	}	
	
}
