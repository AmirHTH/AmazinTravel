package impl.miw.presentation;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	/*
	 * Setting / as request mapping url we are setting the default controller
	 * for the application.
	 */
	@RequestMapping("/")
	public String welcome(Model m) {
		System.out.println("Ejecutando controlador Welcome");
		return "redirect:/private/menu";
	}
	
	@RequestMapping("/private/menu")
	public String index(Principal p) {
		
		System.out.println("Ejecutando controlador private menu con el usuario "+ p);
		return "private/index";
	}
	
	
	@RequestMapping("loginError")
	public String loginError(ModelMap model)
	{
		model.addAttribute("error","true");
		return "login_page";
	}
}
