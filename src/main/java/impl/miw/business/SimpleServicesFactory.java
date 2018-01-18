package impl.miw.business;

import impl.miw.business.viajemanager.ViajeManager;

import com.miw.business.ServicesFactory;
import com.miw.business.ViajeManagerService;

public class SimpleServicesFactory implements ServicesFactory {


	@Override
	public ViajeManagerService getViajeManagerService() {
		return new ViajeManager();
	}


}
