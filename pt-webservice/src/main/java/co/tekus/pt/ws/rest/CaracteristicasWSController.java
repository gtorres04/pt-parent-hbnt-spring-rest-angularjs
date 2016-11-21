/**
 * 
 */
package co.tekus.pt.ws.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.tekus.pt.ws.dto.CaracteristicaDto;
import co.tekus.pt.ws.dto.ListaCaracteristicasDto;
import co.tekus.pt.ws.dto.ServicioDto;
import co.tekus.pt.ws.exception.PtWsException;
import co.tekus.pt.ws.helper.ICaracteristicasHelper;
import co.tekus.pt.ws.support.Constantes;
import co.tekus.pt.ws.support.Constantes.CodigosRespuestasRest;

/**
 * @author gtorress
 *
 */
@Controller
@RequestMapping("/apic")
public class CaracteristicasWSController {
	private static final Logger LOGGER = Logger.getLogger(ServiciosWSController.class);

	@Autowired
	ICaracteristicasHelper iCaracteristicasHelper;

	/**
	 * Registra, elimina, y actualiza una caracteristica de un servicio
	 * 
	 * @param request
	 * @param servicio
	 * @return
	 */
	@RequestMapping(value = "/services/specs", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<CaracteristicaDto> actualizarCaracteristica(HttpServletRequest request,
			@RequestBody CaracteristicaDto caracteristicaDto) {
		ResponseEntity<CaracteristicaDto> response;
		try {
			iCaracteristicasHelper.actualizarRegistrarYEliminarCaracteristica(caracteristicaDto);
			caracteristicaDto.setEjecucion(true);
			caracteristicaDto.setCodigo(CodigosRespuestasRest.EXITO.getCodigo());
			caracteristicaDto.setDescripcion(Constantes.getInstance().MENSAJE_EXITO_GENERICO);
		} catch (PtWsException e) {
			caracteristicaDto.setEjecucion(false);
			caracteristicaDto.setCodigo(CodigosRespuestasRest.FALLIDO.getCodigo());
			caracteristicaDto.setDescripcion(e.getMessage());
		}
		response = new ResponseEntity<CaracteristicaDto>(caracteristicaDto, HttpStatus.OK);
		return response;
	}
}
