package impl.miw.infrastructure;

import impl.miw.business.viajemanager.ViajeManager;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;

import com.miw.business.BookManagerService;
import com.miw.business.ViajeManagerService;
import com.miw.infrastructure.SendMailManagerService;
import com.miw.model.Book;
import com.miw.model.ParamBusquedaViaje;
import com.miw.model.Viaje;

public class SendMailManagerEJBService implements SendMailManagerService{
	
	@Autowired
	private SendMailManager sendMailManager;

	
	@Override
	public boolean sendMail(String to) {
		return sendMailManager.sendMail(to);
	}
	
	
	
}
