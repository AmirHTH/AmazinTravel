package impl.miw.presentation.sendMail;

import impl.miw.infrastructure.SendMailManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.miw.business.BilleteManagerService;
import com.miw.infrastructure.SendMailManagerService;
import com.miw.model.Billete;

@Controller
@SessionAttributes({"billete", "usuario"})
public class SendMailController {
	@Autowired 
	SendMailManagerService sendMailManagerService;
	

	
	public SendMailManagerService getSendMailManagerService() {
		return sendMailManagerService;
	}

	public void setSendMailManagerService(SendMailManagerService sendMailManagerService) {
		this.sendMailManagerService = sendMailManagerService;
	}
	
	@RequestMapping(value="private/enviarCorreo")
	public String enviarCorreo(@ModelAttribute Billete billete, Model model, BindingResult result ) throws Exception
	{			
		//sendMailManagerService.getInstance();
		sendMailManagerService.sendMail("amirht@gmail.com", billete);	
			
		return "private/showBilleteConfirmacion";
	}
	
	
}
