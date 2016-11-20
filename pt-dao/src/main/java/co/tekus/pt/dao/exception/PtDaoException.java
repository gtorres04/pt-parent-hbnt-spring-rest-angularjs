/**
 * 
 */
package co.tekus.pt.dao.exception;

import co.tekus.pt.dao.support.Constantes.CONSTRAINT;
import co.tekus.pt.dao.support.Constantes.MSN_EXCEPTION_CONSTRAINT;

/**
 * @author gtorress
 *
 */
public class PtDaoException extends Exception{
	private String nombreColumna;
	/**
	 * 
	 */
	private String datoProblema;
	/**
	 * 
	 */
	private String restriccion;
	/**
	 * 
	 */
	private String mensaje;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param e
	 */
	public PtDaoException(Exception e){
		super(e);
	}
	
	/**
	 * Constructor mensaje estandar, usa constructor del padre "Exception(String message)"
	 * @param message
	 */
	public PtDaoException(String message){
		super(message);
	}

	/**
	 * @param nombreColumna
	 * @param datoProblema
	 * @param restriccion
	 * @param mensaje
	 */
	public PtDaoException(String nombreColumna, String datoProblema, String restriccion) {
		this.nombreColumna = nombreColumna;
		this.datoProblema = datoProblema;
		this.restriccion = restriccion;
	}

	/**
	 * @return the nombreColumna
	 */
	public String getNombreColumna() {
		return nombreColumna;
	}

	/**
	 * @param nombreColumna the nombreColumna to set
	 */
	public void setNombreColumna(String nombreColumna) {
		this.nombreColumna = nombreColumna;
	}

	/**
	 * @return the datoProblema
	 */
	public String getDatoProblema() {
		return datoProblema;
	}

	/**
	 * @param datoProblema the datoProblema to set
	 */
	public void setDatoProblema(String datoProblema) {
		this.datoProblema = datoProblema;
	}

	/**
	 * @return the restriccion
	 */
	public String getRestriccion() {
		return restriccion;
	}

	/**
	 * @param restriccion the restriccion to set
	 */
	public void setRestriccion(String restriccion) {
		this.restriccion = restriccion;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	
	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public static void relanzarExceptionDAOConstraintViolation(String causaException) throws PtDaoException{
		String causaMensajeMysql=causaException;
		PtDaoException daoException=null;
		if(causaMensajeMysql.contains(CONSTRAINT.UNIQUE.toString())){
			String nombreColumna=causaMensajeMysql.substring(causaMensajeMysql.lastIndexOf(CONSTRAINT.UNIQUE.toString()), causaMensajeMysql.length()-1);
			nombreColumna=nombreColumna.replace(CONSTRAINT.UNIQUE.getNombreGuion(), "").toLowerCase();
			int posicionInicial=causaException.indexOf("'");
			int posicionFinal=causaException.indexOf("'", posicionInicial+1);
			String datoProblema=causaException.substring(posicionInicial+1, posicionFinal);
			daoException = new PtDaoException(nombreColumna,datoProblema, CONSTRAINT.UNIQUE.toString());
			daoException.setMensaje(MSN_EXCEPTION_CONSTRAINT.UNIQUE.getMensaje());
			throw daoException;
		}
	}
}
