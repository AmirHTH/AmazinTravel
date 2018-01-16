package impl.miw.presentation.viaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.miw.business.BilleteManagerService;
import com.miw.model.Billete;


@Controller
@SessionAttributes({"billete", "usuario"})
public class MostrarDetallesViajeController {

	@Autowired 
	BilleteManagerService billeteManagerService;
	
	
	public BilleteManagerService getBilleteManagerService() {
		return billeteManagerService;
	}


	public void setBilleteManagerService(BilleteManagerService billeteManagerService) {
		this.billeteManagerService = billeteManagerService;
	}	

	
	@RequestMapping(value="processForm", params="detalles",  method = RequestMethod.POST)
	public String procesarFormularioBusquedaConfirmar(@ModelAttribute Billete billete, Model model, BindingResult result ) throws Exception
	{		
		billeteManagerService.agregarViajesABillete(billete);
		billeteManagerService.calcularPrecioFinal(billete);
		model.addAttribute("billete", billete);
				
		return "viaje/mostrarDetallesViaje";
	}
	
}
