package impl.miw.presentation.billete;

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
import com.miw.model.DatosCobro;
import com.miw.model.ParamBusquedaViaje;
import com.miw.model.Usuario;

@Controller
@SessionAttributes("billete")
public class ShowBilleteController {

	@Autowired 
	BilleteManagerService billeteManagerService;
		
	
	public BilleteManagerService getBilleteManagerService() {
		return billeteManagerService;
	}


	public void setBilleteManagerService(BilleteManagerService billeteManagerService) {
		this.billeteManagerService = billeteManagerService;
	}

	
	@ModelAttribute
	ParamBusquedaViaje getParamBusquedaViaje()
	{
		return new ParamBusquedaViaje();
	}
	
	@RequestMapping("private/showBillete")
	public String showBillete(Model model) throws Exception {
		System.out.println("Ejecutado ShowBillete.");

		// Colocamos la lista de libros en el modelo.
		//model.addAttribute("viajesList", viajeManagerService.getViajes());
		// Levantamos el evento success para especificar que todo ha ido bien
		return "private/showBillete";	
	}
	
	@RequestMapping("private/showBilleteConfirmacion")
	public String showBilleteConfirmacion(Model model) throws Exception {
		System.out.println("Ejecutado ShowBilleteConfirmacion.");
		
		//new ParamBusquedaViaje();
		System.out.println("----- POST Billete Confirmación------");
		//System.out.println("Billete: " + billete.toString());
		//System.out.println("Usuario: " + usuario.toString());
		
		
		model.addAttribute("estaConfirmado", "Confirmado");
		
		return "private/showBilleteConfirmacion";	
	}
	
}
