package co.tekus.pt.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.tekus.pt.web.support.ConstantesMappingURL;

/**
 * @author gtorress
 *
 */
@Controller
public class GeneralController {
	//TODO asignar a la documentacion de javaDoc de cada metodo el tag @see para la clase de constantes
	/**
	 * Captura la peticion mapeada por la URL relacionada a la constante ConstantesMappingURL.HOME_PAG
	 * cuando se intenta acceder al HOME de la aplicacion. Ademas esta valida de que exista eun usuario en sesion, si no es asiç
	 * lo redirecciona a la pagina de loggin
	 * @see com.gtorresoft.smartket.web.support.ConstantesMappingURL
	 * @param model
	 * @param request
	 * @return un String con el nombre del JSP a mostrar
	 */
	@RequestMapping(value=ConstantesMappingURL.HOME_URL_MAPPING)
	public String inicio(Model model, HttpServletRequest request){
		String views=ConstantesMappingURL.HOME_PAG;
		return views;
	}
	
	@RequestMapping(value=ConstantesMappingURL.LISTAR_SERVICIOS_URL_MAPPING)
	public String listarServicios(Model model, HttpServletRequest request){
		String views=ConstantesMappingURL.LISTAR_SERVICIOS_PAG;
		return views;
	}
	
	@RequestMapping(value=ConstantesMappingURL.DETALLE_SERVICIO_URL_MAPPING)
	public String detalleServicios(Model model, HttpServletRequest request){
		String views=ConstantesMappingURL.DETALLE_SERVICIO_PAG;
		return views;
	}
}
