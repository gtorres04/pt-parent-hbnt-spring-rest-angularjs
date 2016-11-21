/**
 * 
 */
package co.tekus.pt.dao.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * @author gtorress
 *
 */
@Entity
@Table(name = "CARACTERISTICAS")
public class Caracteristica implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3153248282225405050L;
	
	/**
	 * 
	 */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CARACTERISTICAS_SEQ")
	@SequenceGenerator(name = "CARACTERISTICAS_SEQ", sequenceName = "CARACTERISTICAS_SEQ", allocationSize=1)
	private Long id;
	/**
	 * 
	 */
	@Column(name = "NOMBRE")
	private String nombre;
	
	/**
	 * 
	 */
	@Column(name = "VALOR")
	private String valor;
	
	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name="ID_SERVICIOS")
	private Servicio servicio;
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
	 * @return the servicio
	 */
	public Servicio getServicio() {
		return servicio;
	}

	/**
	 * @param servicio the servicio to set
	 */
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	

}
