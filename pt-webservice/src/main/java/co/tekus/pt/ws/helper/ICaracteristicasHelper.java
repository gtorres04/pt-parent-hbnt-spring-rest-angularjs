package co.tekus.pt.ws.helper;

import java.util.List;
import co.tekus.pt.dao.modelo.Servicio;
import co.tekus.pt.ws.dto.CaracteristicaDto;
import co.tekus.pt.ws.dto.ServicioDto;
import co.tekus.pt.ws.exception.PtWsException;

/**
 * @author gtorress
 *
 */
public interface ICaracteristicasHelper {
	/**
	 * Consulta todo el listado de servicios.
	 * @return
	 */
	public List<CaracteristicaDto> getListaCaracteristicas(ServicioDto servicioDto) throws PtWsException;
	
	/**
	 * Registra una caracteristica, Actualiza una caracteristica y elimina una caracteristica
	 * @param servicioDto
	 * @throws PtWsException
	 */
	public void actualizarRegistrarYEliminarCaracteristica(CaracteristicaDto caracteristicaDto) throws PtWsException;
}
