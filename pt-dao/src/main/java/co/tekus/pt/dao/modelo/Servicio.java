package co.tekus.pt.dao.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SERVICIOS_SEQ")
	@SequenceGenerator(name = "SERVICIOS_SEQ", sequenceName = "SERVICIOS_SEQ", allocationSize=1)
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
	 * 
	 */
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_SERVICIOS")
	private List<Caracteristica> caracteristicas;
	
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

	/**
	 * @return the caracteristicas
	 */
	public List<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	/**
	 * @param caracteristicas the caracteristicas to set
	 */
	public void setCaracteristicas(List<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	
	
}
