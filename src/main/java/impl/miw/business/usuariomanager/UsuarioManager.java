/* Generated by Together */

package impl.miw.business.usuariomanager;

import java.util.Map;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;

import com.miw.business.UsuarioManagerService;
import com.miw.business.ViajeManagerService;
import com.miw.model.Iva;
import com.miw.model.ParamBusquedaViaje;
import com.miw.model.Usuario;
import com.miw.model.Viaje;
import com.miw.persistence.IvaDataService;
import com.miw.persistence.UsuarioDataService;
import com.miw.persistence.ViajeDataService;

public class UsuarioManager implements UsuarioManagerService {

	@Autowired
	private UsuarioDataService usuarioDataService;
	
	
	public void setUsuarioDataService(UsuarioDataService usuarioDataService) {
		this.usuarioDataService = usuarioDataService;
	}


	public Usuario crearUsuario(Usuario usuario) throws Exception {
		return this.usuarioDataService.crearUsuario(usuario);
	}
	
	public Usuario getUsuario(Usuario usuario) throws Exception{
		return this.usuarioDataService.getUsuario(usuario);
	}


	
	
}
