package impl.miw.presentation.billete;

import impl.miw.business.billetemanager.BilleteManager;

import java.util.Vector;

import javax.validation.Valid;








import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.miw.business.BilleteManagerService;
import com.miw.business.ViajeManagerService;
import com.miw.model.Billete;
import com.miw.model.ParamBusquedaViaje;
import com.miw.model.Usuario;
import com.miw.model.Viaje;

@Controller
@SessionAttributes({"billete", "usuario"})
public class BilleteController {

	@Autowired 
	BilleteManagerService billeteManagerService;
	
	@Autowired 
	ViajeManagerService viajeManagerService;

	
	
	public BilleteManagerService getBilleteManagerService() {
		return billeteManagerService;
	}


	public void setBilleteManagerService(BilleteManagerService billeteManagerService) {
		this.billeteManagerService = billeteManagerService;
	}
	
	public ViajeManagerService getViajeManagerService() {
		return viajeManagerService;
	}


	public void setViajeManagerService(ViajeManagerService viajeManagerService) {
		this.viajeManagerService = viajeManagerService;
	}
	
	
	
	/*
	@RequestMapping(value="private/facturar", method = RequestMethod.GET)
	public void get()
	{
		System.out.println("----- GET ------");
	}*/
	
	
	
	@RequestMapping(value="/facturar", method=RequestMethod.GET)
    public void facturar(){
		System.out.println("----- GET Facturar ------");
    }
	
	@RequestMapping(value="private/alquilarCoche", method=RequestMethod.GET)
    public void alquilarCoche(){
		System.out.println("----- GET Facturar ------");
    }
	
	@RequestMapping(value="private/pagarBillete", method=RequestMethod.GET)
    public void pagarBillete(Model model){
		System.out.println("----- GET Datos Cobro ------");
		model.addAttribute("usuario", new Usuario());
    }
	
	@RequestMapping(value="private/alquilarCoche", method = RequestMethod.POST)
	public String alquilarCoche(@ModelAttribute Billete billete, Model model, BindingResult result ) throws Exception
	{
			//new ParamBusquedaViaje();
			System.out.println("----- POST Alquilar Coche------");
			System.out.println("Contenido: " + billete.toString());
			
			billeteManagerService.agregarViajesABillete(billete);
			billeteManagerService.calcularPrecioFinal(billete);
			
			model.addAttribute("billete", billete);
		
        	
		return "private/showBillete";
	}

	
	@RequestMapping(value="private/facturar", method = RequestMethod.POST)
	public String facturar(@ModelAttribute Billete billete, Model model, BindingResult result ) throws Exception
	{
			//new ParamBusquedaViaje();
			System.out.println("----- POST Facturar------");
			System.out.println("Contenido: " + billete.toString());
			
			billeteManagerService.agregarViajesABillete(billete);
			billeteManagerService.calcularPrecioFinal(billete);
			
			model.addAttribute("billete", billete);
        	
		return "private/showBillete";
	}
	
	@RequestMapping(value="private/pagarBillete", method = RequestMethod.POST)
	public String pagarBillete(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model) throws Exception
	{
		if ( result.hasErrors())
		{
			System.out.println("---- Has Errors -----");
			return "private/pagarBillete";
			
		}else{
			//new ParamBusquedaViaje();
			System.out.println("----- POST Pagar Billete------");
			System.out.println("Usuario: " + usuario.toString());
			model.addAttribute("usuario", usuario);			
        	
		return "private/showBilleteConfirmacion";
		}
	}

	
	@RequestMapping(value="private/processForm", params="facturar",  method = RequestMethod.POST)
	public String procesarFormularioBusquedaFacturar(@ModelAttribute Billete billete, Model model, BindingResult result ) throws Exception
	{			
	

		billeteManagerService.agregarViajesABillete(billete);
		billeteManagerService.calcularPrecioFinal(billete);
			model.addAttribute("billete", billete);
			
		return "private/facturar";
	}
	
	@RequestMapping(value="private/processForm", params="alquilarCoche",  method = RequestMethod.POST)
	public String procesarFormularioBusquedaAlquilar(@ModelAttribute Billete billete, Model model, BindingResult result ) throws Exception
	{
			//new ParamBusquedaViaje();
			System.out.println("----- POST ------");
			System.out.println("Contenido: " + billete.toString());
			

			billeteManagerService.agregarViajesABillete(billete);
			billeteManagerService.calcularPrecioFinal(billete);
			model.addAttribute("billete", billete);
			
			
		return "private/alquilarCoche";
	}
	
	@RequestMapping(value="private/processForm", params="confirmar",  method = RequestMethod.POST)
	public String procesarFormularioBusquedaConfirmar(@ModelAttribute Billete billete, Model model, BindingResult result ) throws Exception
	{
			//new ParamBusquedaViaje();
			System.out.println("----- POST ------");
			System.out.println("Contenido: " + billete.toString());
		

			billeteManagerService.agregarViajesABillete(billete);
			billeteManagerService.calcularPrecioFinal(billete);
			model.addAttribute("billete", billete);
			
			
		return "private/showBillete";
	}
	
	
	/*
	@ModelAttribute
	ParamBusquedaViaje getParamBusquedaViaje()
	{
		return new ParamBusquedaViaje();
	}
	*/
	
	/*
	@ModelAttribute
	Usuario getUsuario()
	{
		return new Usuario();
	}*/
	
	
	@RequestMapping("private/procesarBillete")
	public String procesarBillete(Usuario usuario, Billete billete, Model model  )
	{
		try {
			System.out.println("Billete: " + billete.toString());
			System.out.println("Usuario: " + usuario.toString());
			int resultado = this.billeteManagerService.crearBillete(billete, usuario);
			String mensajeResultado = "";
			switch(resultado){
				case BilleteManager.RESULTADO_CORRECTO:
					mensajeResultado = "";
					model.addAttribute("estaConfirmado", "Confirmado");
					break;
				case BilleteManager.RESULTADO_ERROR_VUELO_IDA_LLENO:
					mensajeResultado = "";
					break;
				case BilleteManager.RESULTADO_ERROR_VUELO_VUELTA_LLENO:
					mensajeResultado = "";
					break;
				default:
					mensajeResultado = "";
					break;
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return "private/showBilleteConfirmacion";
	}
	
	
	
}
