package impl.miw.presentation;

import java.security.Principal;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.ServletContextAware;


@Controller
public class WelcomeController implements ServletContextAware{
	
	 @Autowired
	 private ServletContext servletContext;
	 
	 public void setServletContext(ServletContext servletContext) {
	        this.servletContext = servletContext;
	 }
	 
	 
	 

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
		
		incrementarContador();
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
		return "login_page";
	}
	
	private void incrementarContador(){
		LoginCounter loginCounter = (LoginCounter)servletContext.getAttribute("loginCounter");
		if(loginCounter == null){
			loginCounter = new LoginCounter();
		}
		loginCounter.inc();
		servletContext.setAttribute("loginCounter", loginCounter);
	}
}
