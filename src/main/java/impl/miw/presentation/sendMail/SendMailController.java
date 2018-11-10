package impl.miw.presentation.sendMail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.miw.business.UsuarioManagerService;
import com.miw.infrastructure.SendMailManagerService;
import com.miw.model.Billete;


@Controller
@SessionAttributes({"billete", "usuario"})
public class SendMailController {
	@Autowired 
	SendMailManagerService sendMailManagerService;
	
	@Autowired 
	UsuarioManagerService usuarioManagerService;
	
	public UsuarioManagerService getUsuarioManagerService(){
		return usuarioManagerService;
	}
	
	public void setUsuarioManagerService(UsuarioManagerService usuarioManagerService){
		this.usuarioManagerService = usuarioManagerService;
	}
	

	
	public SendMailManagerService getSendMailManagerService() {
		return sendMailManagerService;
	}

	public void setSendMailManagerService(SendMailManagerService sendMailManagerService) {
		this.sendMailManagerService = sendMailManagerService;
	}
	
	@RequestMapping(value="enviarCorreo")
	public String enviarCorreo(@RequestParam(value="mail", required=true)String mail, @ModelAttribute Billete billete, Model model, BindingResult result ) throws Exception {	
		//Usuario usuario = new Usuario();
		//usuario.setUsuarioId(billete.getUsuarioId());
		//usuario = usuarioManagerService.getUsuarioById(usuario);
		if(!mail.equals("")){
			sendMailManagerService.sendMail(mail, billete);	
			model.addAttribute("reservaBuscada", billete);
			model.addAttribute("mensajeCorreoEnviado", "reserva.envioEmail.correcto");
		}
		return "reserva/mostrarReserva";
	}
	
	
}
