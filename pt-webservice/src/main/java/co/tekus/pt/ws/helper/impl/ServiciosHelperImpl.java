/**
 * 
 */
package co.tekus.pt.ws.helper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import co.tekus.pt.core.exception.PtCoreException;
import co.tekus.pt.core.service.IServiciosService;
import co.tekus.pt.dao.modelo.Caracteristica;
import co.tekus.pt.dao.modelo.Servicio;
import co.tekus.pt.ws.dto.CaracteristicaDto;
import co.tekus.pt.ws.dto.ServicioDto;
import co.tekus.pt.ws.exception.PtWsException;
import co.tekus.pt.ws.helper.IServiciosHelper;
import co.tekus.pt.ws.support.Constantes.MetodosHttp;

/**
 * @author gtorress
 *
 */
@Component
public class ServiciosHelperImpl implements IServiciosHelper {

	/**
	 * 
	 */
	@Autowired
	IServiciosService iServiciosService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.tekus.pt.ws.helper.IServiciosHelper#getListaServicios()
	 */
	@Override
	public List<ServicioDto> getListaServicios() throws PtWsException {
		List<ServicioDto> serviciosDto = null;
		List<Servicio> servicios = null;
		try {
			servicios = iServiciosService.findAll();
			if (servicios != null) {
				serviciosDto = new ArrayList<ServicioDto>();
				for (Servicio servicio : servicios) {
					ServicioDto servicioDto = new ServicioDto();
					servicioDto.setId(servicio.getId());
					servicioDto.setNombre(servicio.getNombre());
					servicioDto.setDescripcion(servicio.getDescripcion());
					List<Caracteristica> caracteristicas = servicio.getCaracteristicas();
					if (caracteristicas != null) {
						List<CaracteristicaDto> caracteristicasDtos = new ArrayList<>();
						for (Caracteristica caracteristica : caracteristicas) {
							CaracteristicaDto caracteristicaDto = new CaracteristicaDto();
							caracteristicaDto.setId(caracteristica.getId());
							caracteristicaDto.setNombre(caracteristica.getNombre());
							caracteristicaDto.setValor(caracteristica.getValor());
							caracteristicasDtos.add(caracteristicaDto);
						}
						servicioDto.setCaracteristicas(caracteristicasDtos);
					}
					serviciosDto.add(servicioDto);
				}
			}
		} catch (PtCoreException e) {
			throw new PtWsException(e);
		}
		return serviciosDto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.tekus.pt.ws.helper.IServiciosHelper#actualizarORegistrarServicio(co.
	 * tekus.pt.ws.dto.ServicioDto)
	 */
	@Override
	public void actualizarRegistrarYEliminarServicio(ServicioDto servicioDto) throws PtWsException {
		Servicio servicioAux = null, servicio = new Servicio();
		servicio.setId(servicioDto.getId());
		servicio.setNombre(servicioDto.getNombre());
		servicio.setDescripcion(servicioDto.getDescripcion());
		servicio.setRutaImagen(servicioDto.getRutaImagen());

		try {
			if (MetodosHttp.DELETE.toString().toLowerCase().equals(servicioDto.getMetodoHttp())) {
				iServiciosService.delete(servicio);
			} else {
				
				if (servicio.getId() != null) {
					iServiciosService.update(servicio);
				} else {
					iServiciosService.create(servicio);
					servicioDto.setId(servicio.getId());
				}
			}
		} catch (PtCoreException e) {
			e.printStackTrace();
			throw new PtWsException(e);
		}

	}
}
