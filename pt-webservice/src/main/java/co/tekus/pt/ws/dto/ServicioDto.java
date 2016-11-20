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
public class ServicioDto  extends ResponseWs implements Serializable{
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
	private String descripcion;
	/**
	 * 
	 */
	private String rutaImagen;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the rutaImagen
	 */
	public String getRutaImagen() {
		return rutaImagen;
	}
	/**
	 * @param rutaImagen the rutaImagen to set
	 */
	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	
}
