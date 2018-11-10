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
import com.miw.business.UsuarioManagerService;
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
	
	@Autowired 
	UsuarioManagerService usuarioManagerService;
	
	
	public BilleteManagerService getBilleteManagerService() {
		return billeteManagerService;
	}


	public void setBilleteManagerService(BilleteManagerService billeteManagerService) {
		this.billeteManagerService = billeteManagerService;
	}
	
	public UsuarioManagerService getUsuarioManagerService(){
		return usuarioManagerService;
	}
	
	public void setUsuarioManagerService(UsuarioManagerService usaurioManagerService){
		this.usuarioManagerService = usaurioManagerService;
	}
	
	
	@RequestMapping(value="pagarViaje", method=RequestMethod.GET)
    public String pagarBillete(Model model){
		System.out.println("----- GET Datos Cobro ------");
		model.addAttribute("usuario", new Usuario());
		return "viaje/pagarViaje";
    }


	@RequestMapping(value="pagarViaje", method = RequestMethod.POST)
	public String pagarBillete(@Valid @ModelAttribute Usuario usuario, @ModelAttribute Billete billete, BindingResult result, Model model) throws Exception
	{
		if ( result.hasErrors())
		{
			System.out.println("---- Has Errors -----");
			return "viaje/pagarViaje";
			
		}else{
			
			model.addAttribute("usuario", usuario);	
			model.addAttribute("billete", billete);
			
			//Revisamos si el usuario existe, sino, tendremos que enviarlo a la página de registro.
			
			
			Usuario usuarioEncontrado = usuarioManagerService.getUsuario(usuario);
			if(usuarioEncontrado != null){
				//new ParamBusquedaViaje();
				System.out.println("----- POST Pagar Billete------");
				System.out.println("Usuario: " + usuario.toString());
				
        	
				return "viaje/confirmarViaje";
			}
			else{
				//model.addAttribute("usuario", usuario);	
				//model.addAttribute("billete", billete);				
				return "/registro";
			}
		}
	}	
	
}
