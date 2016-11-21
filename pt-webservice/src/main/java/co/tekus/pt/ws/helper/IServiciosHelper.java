package co.tekus.pt.ws.helper;

import java.util.List;
import co.tekus.pt.dao.modelo.Servicio;
import co.tekus.pt.ws.dto.ServicioDto;
import co.tekus.pt.ws.exception.PtWsException;

/**
 * @author gtorress
 *
 */
public interface IServiciosHelper {
	/**
	 * Consulta todo el listado de servicios.
	 * @return
	 */
	public List<ServicioDto> getListaServicios() throws PtWsException;
	
	/**
	 * Registra un nuevo Servicio o Actualiza un nuevo servicio
	 * @param servicioDto
	 * @throws PtWsException
	 */
	public void actualizarRegistrarYEliminarServicio(ServicioDto servicioDto) throws PtWsException;
}
