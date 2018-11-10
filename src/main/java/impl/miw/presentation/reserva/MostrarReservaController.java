package impl.miw.presentation.reserva;

import java.util.Vector;

import javax.validation.Valid;









import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.miw.business.BilleteManagerService;
import com.miw.business.UsuarioManagerService;
import com.miw.business.ViajeManagerService;
import com.miw.model.Billete;
import com.miw.model.DatosCobro;
import com.miw.model.ParamBuscarReserva;
import com.miw.model.ParamBusquedaViaje;
import com.miw.model.Usuario;

@Controller
@SessionAttributes({"billete", "usuario"})
public class MostrarReservaController {

	@Autowired 
	BilleteManagerService billeteManagerService;
	
	
	@Autowired 
	UsuarioManagerService usuarioManagerService;
	
	public UsuarioManagerService getUsuarioManagerService(){
		return usuarioManagerService;
	}
	
	public void setUsuarioManagerService(UsuarioManagerService usuarioManagerService){
		this.usuarioManagerService = usuarioManagerService;
	}
	
	
		
	
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
	
	@RequestMapping("mostrarReserva")
	public String showBillete(Model model) throws Exception {
		return "reserva/mostrarReserva";	
	}
	
	/*
	@RequestMapping(value="mostrarReservasUsuario", method=RequestMethod.GET)
    public String buscarReservasUsuario(Model model){
		System.out.println("----- GET BuscarReserva ------");
		//model.addAttribute("paramBuscarReserva", new ParamBuscarReserva());
		//model.addAttribute("reservaBuscada", new Billete());
		return "reserva/mostrarReservasUsuario";
    }*/
	
	@RequestMapping("mostrarReservasUsuario")
	public String mostrarReservasUsuario(Model model) throws Exception {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String mail = auth.getName(); //get logged in username
		Usuario usuario = new Usuario();
		usuario.setMail(mail);
		
		usuario = usuarioManagerService.getUsuario(usuario);
		Vector<Billete> billetesUsuario = billeteManagerService.getBilletesUsuario(usuario);
		
		// Colocamos la lista de viajes en el modelo
		model.addAttribute("reservasUsuario", billetesUsuario);
		model.addAttribute("billete", new Billete());
		return "reserva/mostrarReservasUsuario";	
	}
	
}
