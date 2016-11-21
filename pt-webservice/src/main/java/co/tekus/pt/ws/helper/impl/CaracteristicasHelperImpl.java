/**
 * 
 */
package co.tekus.pt.ws.helper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.tekus.pt.core.exception.PtCoreException;
import co.tekus.pt.core.service.ICaracteristicaService;
import co.tekus.pt.dao.modelo.Caracteristica;
import co.tekus.pt.dao.modelo.Servicio;
import co.tekus.pt.ws.dto.CaracteristicaDto;
import co.tekus.pt.ws.dto.ServicioDto;
import co.tekus.pt.ws.exception.PtWsException;
import co.tekus.pt.ws.helper.ICaracteristicasHelper;
import co.tekus.pt.ws.support.Constantes.CodigosRespuestasRest;
import co.tekus.pt.ws.support.Constantes.MetodosHttp;

/**
 * @author gtorress
 *
 */
@Component
public class CaracteristicasHelperImpl implements ICaracteristicasHelper {

	/**
	 * 
	 */
	@Autowired
	ICaracteristicaService iCaracteristicaService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.tekus.pt.ws.helper.IServiciosHelper#getListaServicios()
	 */
	@Override
	public List<CaracteristicaDto> getListaCaracteristicas(ServicioDto servicioDto) throws PtWsException {
		List<CaracteristicaDto> caracteristicasDto = null;
		try {
			//TODO consultar las caracteristicas por Servicio
			List<Caracteristica> caracteristicas = iCaracteristicaService.findAll();
			if (caracteristicas != null) {
				caracteristicasDto=new ArrayList<>();
				for (Caracteristica caracteristica : caracteristicas) {
					CaracteristicaDto caracteristicaDto=new CaracteristicaDto();
					caracteristicaDto.setId(caracteristica.getId());
					caracteristicaDto.setNombre(caracteristica.getNombre());
					caracteristicaDto.setValor(caracteristica.getValor());
					caracteristicasDto.add(caracteristicaDto);
				}
			}
		} catch (PtCoreException e) {
			throw new PtWsException(e);
		}
		return caracteristicasDto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.tekus.pt.ws.helper.IServiciosHelper#actualizarORegistrarServicio(co.
	 * tekus.pt.ws.dto.ServicioDto)
	 */
	@Override
	public void actualizarRegistrarYEliminarCaracteristica(CaracteristicaDto caracteristicaDto) throws PtWsException {
		Caracteristica caracteristicaAux = null, caracteristica = new Caracteristica();
		caracteristica.setId(caracteristicaDto.getId());
		caracteristica.setNombre(caracteristicaDto.getNombre());
		caracteristica.setValor(caracteristicaDto.getValor());
		Servicio servicio = new Servicio();
		servicio.setId(new Long(caracteristicaDto.getIdServicio()));
		caracteristica.setServicio(servicio);
		try {
			if(MetodosHttp.DELETE.toString().toLowerCase().equals(caracteristicaDto.getMetodoHttp())){
				iCaracteristicaService.delete(caracteristica);
			}else{
				if (caracteristica.getId() != null) {
					iCaracteristicaService.update(caracteristica);
				} else {
					iCaracteristicaService.create(caracteristica);
					caracteristicaDto.setId(caracteristica.getId());
				}
			}
		} catch (PtCoreException e) {
			e.printStackTrace();
			throw new PtWsException(e);
		}

	}
}
