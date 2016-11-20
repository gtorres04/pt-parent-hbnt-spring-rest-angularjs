package co.tekus.pt.dao.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author gtorress
 *
 */
@Entity
@Table(name = "SERVICIOS")
public class Servicio implements Serializable{
	
	/**
	 * 
	 */
	@Id
	@Column(name = "ID")
	/*@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	*/
	private Long id;
	/**
	 * 
	 */
	@Column(name = "NOMBRE")
	private String nombre;
	/**
	 * 
	 */
	@Column(name = "DESCRIPCION")
	private String descripcion;
	/**
	 * 
	 */
	@Column(name = "IMAGEN")
	private String rutaImagen;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param nombre
	 *            the nombre to set
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
	 * @param descripcion
	 *            the descripcion to set
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
	 * @param rutaImagen
	 *            the rutaImagen to set
	 */
	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

}
