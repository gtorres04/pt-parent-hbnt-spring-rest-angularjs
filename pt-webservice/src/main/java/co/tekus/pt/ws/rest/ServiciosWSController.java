/**
 * 
 */
package co.tekus.pt.ws.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.tekus.pt.dao.modelo.Servicio;
import co.tekus.pt.ws.dto.ListaServiciosDto;
import co.tekus.pt.ws.dto.ServicioDto;
import co.tekus.pt.ws.exception.PtWsException;
import co.tekus.pt.ws.helper.IServiciosHelper;
import co.tekus.pt.ws.support.Constantes;
import co.tekus.pt.ws.support.Constantes.CodigosRespuestasRest;

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
	
	@RequestMapping(value = "/services", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<ServicioDto> actualizarServicios(HttpServletRequest request, @RequestBody ServicioDto servicio) {
		ResponseEntity<ServicioDto> response;
		try {
			iServiciosHelper.actualizarORegistrarServicio(servicio);
			servicio.setEjecucion(true);
			servicio.setCodigo(CodigosRespuestasRest.EXITO.getCodigo());
			servicio.setDescripcion(Constantes.getInstance().MENSAJE_EXITO_GENERICO);
		} catch (PtWsException e) {
			servicio.setEjecucion(false);
			servicio.setCodigo(CodigosRespuestasRest.FALLIDO.getCodigo());
			servicio.setDescripcion(e.getMessage());
		}
		response = new ResponseEntity<ServicioDto>(servicio, HttpStatus.OK);
		return response;
	}
}
