package impl.miw.presentation.billete;

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
import com.miw.model.ParamBusquedaViaje;
import com.miw.model.Usuario;
import com.miw.model.Viaje;

@Controller
@SessionAttributes({"billete", "usuario"})
public class CancelarBilleteController {

	@Autowired 
	BilleteManagerService billeteManagerService;
	
	
	public BilleteManagerService getBilleteManagerService() {
		return billeteManagerService;
	}


	public void setBilleteManagerService(BilleteManagerService billeteManagerService) {
		this.billeteManagerService = billeteManagerService;
	}	
	
	
	@RequestMapping(value="private/cancelarReserva", method=RequestMethod.GET)
    public void facturar(){
		System.out.println("----- GET CancelarReserva ------");
    }
	

	
	@RequestMapping(value="private/cancelarReserva", method = RequestMethod.POST)
	public String alquilarCoche(Billete billete, Usuario usuario, Model model, BindingResult result ) throws Exception
	{
		billeteManagerService.cancelarReserva(billete, usuario);
		
        	
		return "private/cancelarReserva";
	}	
	
}
