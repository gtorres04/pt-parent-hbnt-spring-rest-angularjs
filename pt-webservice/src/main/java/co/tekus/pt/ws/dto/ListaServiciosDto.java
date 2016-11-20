/**
 * 
 */
package co.tekus.pt.ws.dto;

import java.io.Serializable;
import java.util.List;

import co.tekus.pt.dao.modelo.Servicio;

/**
 * @author gtorress
 *
 */
public class ListaServiciosDto extends ResponseWs implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -272352559296927685L;
	/**
	 * 
	 */
	private List<Servicio> servicios;

	/**
	 * @return the servicios
	 */
	public List<Servicio> getServicios() {
		return servicios;
	}

	/**
	 * @param servicios the servicios to set
	 */
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
}
