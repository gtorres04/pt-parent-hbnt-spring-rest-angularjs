/**
 * 
 */
package co.tekus.pt.ws.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.tekus.pt.dao.modelo.Servicio;
import co.tekus.pt.ws.dto.ListaServiciosDto;
import co.tekus.pt.ws.exception.PtWsException;
import co.tekus.pt.ws.helper.IServiciosHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author gtorress
 *
 */
@Controller
@RequestMapping("/api")
public class ServiciosWSController {

	private static final Logger LOGGER = Logger.getLogger(ServiciosWSController.class);

	@Autowired
	IServiciosHelper iServiciosHelper;

	@RequestMapping(value = "/services", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<ListaServiciosDto> getListadoServicios(HttpServletRequest request) {
		ResponseEntity<ListaServiciosDto> response;
		ListaServiciosDto listaServiciosDto = new ListaServiciosDto();
		List<Servicio> servicios = null;
		String resultado = "";
		try {
			servicios = iServiciosHelper.getListaServicios();
			listaServiciosDto.setServicios(servicios);
			listaServiciosDto.setEjecucion(true);
			listaServiciosDto.setCodigo("1");
			listaServiciosDto.setDescripcion(resultado);
		} catch (PtWsException e) {
			listaServiciosDto.setEjecucion(false);
			listaServiciosDto.setCodigo("-1");
			listaServiciosDto.setDescripcion(e.getMessage());
		}
		response = new ResponseEntity<ListaServiciosDto>(listaServiciosDto, HttpStatus.OK);
		return response;
	}
}
