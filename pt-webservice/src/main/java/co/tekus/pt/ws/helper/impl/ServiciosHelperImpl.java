/**
 * 
 */
package co.tekus.pt.ws.helper.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import co.tekus.pt.core.exception.PtCoreException;
import co.tekus.pt.core.service.IServiciosService;
import co.tekus.pt.dao.modelo.Servicio;
import co.tekus.pt.ws.exception.PtWsException;
import co.tekus.pt.ws.helper.IServiciosHelper;

/**
 * @author gtorress
 *
 */
@Component
public class ServiciosHelperImpl implements IServiciosHelper {

	@Autowired
	IServiciosService iServiciosService;

	
	/* (non-Javadoc)
	 * @see co.tekus.pt.ws.helper.IServiciosHelper#getListaServicios()
	 */
	@Override
	public List<Servicio> getListaServicios() throws PtWsException {
		List<Servicio> servicios = null;
		try {
			servicios = iServiciosService.findAll();
		} catch (PtCoreException e) {
			throw new PtWsException(e);
		}
		return servicios;
	}

}
