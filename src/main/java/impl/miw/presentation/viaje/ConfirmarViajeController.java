package impl.miw.presentation.viaje;

import impl.miw.business.billetemanager.BilleteManager;

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
import com.miw.model.Usuario;


@Controller
@SessionAttributes({"billete", "usuario"})
public class ConfirmarViajeController {

	@Autowired 
	BilleteManagerService billeteManagerService;
	
	
	public BilleteManagerService getBilleteManagerService() {
		return billeteManagerService;
	}


	public void setBilleteManagerService(BilleteManagerService billeteManagerService) {
		this.billeteManagerService = billeteManagerService;
	}	

	
	@RequestMapping("procesarReserva")
	public String procesarBillete(Usuario usuario, Billete billete, Model model  )
	{
		try {
			System.out.println("Billete: " + billete.toString());
			System.out.println("Usuario: " + usuario.toString());
			billete = this.billeteManagerService.crearBillete(billete, usuario);
			model.addAttribute("reservaBuscada", billete);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return "reserva/mostrarReserva";
	}
	
	
}
