package impl.miw.business;

import impl.miw.business.bookmanager.BookManager;

import com.miw.business.BookManagerService;
import com.miw.business.ServicesFactory;

public class SimpleServicesFactory implements ServicesFactory {

	@Override
	public BookManagerService getBookManagerService() {
		return new BookManager();
	}



}
