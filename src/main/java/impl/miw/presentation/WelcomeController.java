package impl.miw.presentation;

import java.security.Principal;
import java.util.LinkedHashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.ServletContextAware;

import com.miw.business.BilleteManagerService;
import com.miw.model.ParamBusquedaViaje;


@Controller
@SessionAttributes("billete")
public class WelcomeController implements ServletContextAware{
	
	@Autowired 
	BilleteManagerService billeteManagerService;
	
	 @Autowired
	 private ServletContext servletContext;
	 
	 public void setServletContext(ServletContext servletContext) {
	        this.servletContext = servletContext;
	 }
	 
	 public BilleteManagerService getBilleteManagerService() {
			return billeteManagerService;
		}


	public void setBilleteManagerService(BilleteManagerService billeteManagerService) {
		this.billeteManagerService = billeteManagerService;
	}
		

	/*
	 * Setting / as request mapping url we are setting the default controller
	 * for the application.
	 *//*
	@RequestMapping("/")
	public String welcome(Model m) {
		System.out.println("Ejecutando controlador Welcome");
		return "redirect:/private/menu";
	}*/
	 
	 /*
		 * Setting / as request mapping url we are setting the default controller
		 * for the application.
		 */
	@RequestMapping("/")
	public String welcome(@ModelAttribute ParamBusquedaViaje param, Model model) throws Exception {
		LinkedHashMap<Integer, String> destinosPopulares = billeteManagerService.getDestinosMasPopulares();
		model.addAttribute("destinosPopulares", destinosPopulares);
		
		return "index";
	}
	
	@RequestMapping("/private/menu")
	public String index(Principal p) {
		
		//incrementarContador();

		System.out.println("Ejecutando controlador private menu con el usuario "+ p);
		return "private/index";
	}
	/*
	@RequestMapping("/private/menu")
	public String index(Principal p) {
		
		System.out.println("Ejecutando controlador private menu con el usuario "+ p);
		return "private/index";
	}*/
	
	
	@RequestMapping("loginError")
	public String loginError(ModelMap model)
	{
		model.addAttribute("error","true");
		return "errors/loginError";
	}
	
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}

}
