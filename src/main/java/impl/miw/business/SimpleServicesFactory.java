package impl.miw.business;

import impl.miw.business.bookmanager.BookManager;
import impl.miw.business.viajemanager.ViajeManager;

import com.miw.business.BookManagerService;
import com.miw.business.ServicesFactory;
import com.miw.business.ViajeManagerService;

public class SimpleServicesFactory implements ServicesFactory {

	@Override
	public BookManagerService getBookManagerService() {
		return new BookManager();
	}

	@Override
	public ViajeManagerService getViajeManagerService() {
		return new ViajeManager();
	}


}
