package impl.miw.presentation.login;

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
import com.miw.business.UsuarioManagerService;
import com.miw.model.Billete;
import com.miw.model.ParamBusquedaViaje;
import com.miw.model.Usuario;

@Controller
@SessionAttributes({"billete", "usuario"})
public class LoginController {
	

	@Autowired 
	UsuarioManagerService usuarioManagerService;
	
	public UsuarioManagerService getUsuarioManagerService(){
		return usuarioManagerService;
	}
	
	public void setUsuarioManagerService(UsuarioManagerService usaurioManagerService){
		this.usuarioManagerService = usaurioManagerService;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		System.out.println("Entrando en login");
		return "login_page";
	}
	
	
	@RequestMapping(value = "registroEnCompra", method = RequestMethod.POST)
	public String registrarUsuario(@ModelAttribute Billete billete, @Valid @ModelAttribute Usuario usuario, BindingResult result,  Model model){
		System.out.println("---------------- Entrando en Registro --------------");
		
		if ( result.hasErrors()){
			System.out.println("---- Has Errors -----");
			return "/registro";
		}
		
		Usuario usuarioCreado;
		try {
			usuarioCreado = usuarioManagerService.crearUsuario(usuario);
			model.addAttribute("usuario", usuarioCreado);	
		} catch (Exception e) {
			model.addAttribute("usuario", usuario);	
			e.printStackTrace();
		}
			
	
		model.addAttribute("billete", billete);	
		
		
		return "viaje/confirmarViaje";
	}


}
