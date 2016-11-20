/**
 * 
 */
package co.tekus.pt.ws.exception;

/**
 * @author gtorress
 *
 */
public class PtWsException extends Exception{
	/**
	 * @param e
	 */
	public PtWsException(Exception e){
		super(e);
	}
	
	/**
	 * Constructor mensaje estandar, usa constructor del padre "Exception(String message)"
	 * @param message
	 */
	public PtWsException(String message){
		super(message);
	}
}
