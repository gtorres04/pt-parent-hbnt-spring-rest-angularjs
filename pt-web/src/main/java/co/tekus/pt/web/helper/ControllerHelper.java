/**
 * 
 */
package co.tekus.pt.web.helper;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;


/**
 * @author gerlinorlandotorressaavedra
 *
 */
public interface ControllerHelper {
	/**
	 * Gestiona el objeto para el envio de este al servicio de registro
	 * @param model
	 * @return String correpondiente al nombre del archivo JSP a desplegar
	 */
	String registrar(Model model, HttpServletRequest request);
	/**
	 * Gestiona el objeto para el envio de este al servicio de listado
	 * @param model
	 * @param request
	 * @return String correpondiente al nombre del archivo JSP a desplegar
	 */
	String listar(Model model, HttpServletRequest request);
	/**
	 * Gestiona el objeto para el envio de este al servicio de actualizacion de datos
	 * @param model
	 * @param request
	 * @return String correpondiente al nombre del archivo JSP a desplegar
	 */
	String editar(Model model, HttpServletRequest request);
		
}
