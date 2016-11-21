/**
 * 
 */
package co.tekus.pt.ws.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author gtorress
 *
 */
/**
 * @author gtorress
 *
 */
public class CaracteristicaDto  extends ResponseWs implements Serializable{
	/**
	 * 
	 */
	private Long id;
	/**
	 * 
	 */
	private String nombre;
	/**
	 * 
	 */
	private String valor;
	
	/**
	 * 
	 */
	private String metodoHttp;

	/**
	 * 
	 */
	private boolean seEstaEditando;
	
	/**
	 * 
	 */
	private int idServicio;
	/**
	 * @return the idServicio
	 */
	public int getIdServicio() {
		return idServicio;
	}

	/**
	 * @param idServicio the idServicio to set
	 */
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	/**
	 * @return the seEstaEditando
	 */
	public boolean isSeEstaEditando() {
		return seEstaEditando;
	}

	/**
	 * @param seEstaEditando the seEstaEditando to set
	 */
	public void setSeEstaEditando(boolean seEstaEditando) {
		this.seEstaEditando = seEstaEditando;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * @return the metodoHttp
	 */
	public String getMetodoHttp() {
		return metodoHttp;
	}

	/**
	 * @param metodoHttp the metodoHttp to set
	 */
	public void setMetodoHttp(String metodoHttp) {
		this.metodoHttp = metodoHttp;
	}
	
	
	
}
