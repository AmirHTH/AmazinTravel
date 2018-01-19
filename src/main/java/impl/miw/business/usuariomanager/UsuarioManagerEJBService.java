package impl.miw.business.usuariomanager;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;

import com.miw.business.UsuarioManagerService;
import com.miw.business.ViajeManagerService;
import com.miw.model.ParamBusquedaViaje;
import com.miw.model.Usuario;
import com.miw.model.Viaje;

public class UsuarioManagerEJBService implements UsuarioManagerService{

	@Autowired
	private UsuarioManager usuarioManager;

	private Integer times=0;
	
	public void setTimes(Integer times) {
		System.out.println("setting times to "+times);
		this.times = times;
	}
	
	public void setUsuarioManager(UsuarioManager um) {
		this.usuarioManager = um;
	}

	
	@Override
	public Usuario getUsuario(Usuario usuario) throws Exception
	{
		return usuarioManager.getUsuario(usuario);
	}
	
	@Override
	public Usuario getUsuarioById(Usuario usuario) throws Exception
	{
		return usuarioManager.getUsuarioById(usuario);
	}
	
	@Override
	public Usuario crearUsuario(Usuario usuario) throws Exception
	{
		return usuarioManager.crearUsuario(usuario);
	}

	
}
