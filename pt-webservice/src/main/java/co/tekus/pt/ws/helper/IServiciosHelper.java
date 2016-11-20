package co.tekus.pt.ws.helper;

import java.util.List;
import co.tekus.pt.dao.modelo.Servicio;
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
	public List<Servicio> getListaServicios() throws PtWsException;
}
