/**
 * 
 */
package co.tekus.pt.core.exception;

/**
 * @author gtorress
 *
 */
public class PtCoreException extends Exception{
	/**
	 * @param e
	 */
	public PtCoreException(Exception e){
		super(e);
	}
	
	/**
	 * Constructor mensaje estandar, usa constructor del padre "Exception(String message)"
	 * @param message
	 */
	public PtCoreException(String message){
		super(message);
	}
}
