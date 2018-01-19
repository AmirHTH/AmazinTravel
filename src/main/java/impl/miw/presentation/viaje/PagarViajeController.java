package impl.miw.presentation.viaje;

import impl.miw.business.billetemanager.BilleteManager;

import java.util.Vector;

import javax.validation.Valid;









import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.miw.business.BilleteManagerService;
import com.miw.business.ViajeManagerService;
import com.miw.model.Billete;
import com.miw.model.ParamBusquedaViaje;
import com.miw.model.Usuario;
import com.miw.model.Viaje;

@Controller
@SessionAttributes({"billete", "usuario"})
public class PagarViajeController {

	@Autowired 
	BilleteManagerService billeteManagerService;
	
	
	public BilleteManagerService getBilleteManagerService() {
		return billeteManagerService;
	}


	public void setBilleteManagerService(BilleteManagerService billeteManagerService) {
		this.billeteManagerService = billeteManagerService;
	}
	
	
	@RequestMapping(value="pagarViaje", method=RequestMethod.GET)
    public String pagarBillete(Model model){
		System.out.println("----- GET Datos Cobro ------");
		model.addAttribute("usuario", new Usuario());
		return "viaje/pagarViaje";
    }


	@RequestMapping(value="pagarViaje", method = RequestMethod.POST)
	public String pagarBillete(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model) throws Exception
	{
		if ( result.hasErrors())
		{
			System.out.println("---- Has Errors -----");
			return "viaje/pagarViaje";
			
		}else{
			//new ParamBusquedaViaje();
			System.out.println("----- POST Pagar Billete------");
			System.out.println("Usuario: " + usuario.toString());
			model.addAttribute("usuario", usuario);			
        	
		return "viaje/confirmarViaje";
		}
	}	
	
}
