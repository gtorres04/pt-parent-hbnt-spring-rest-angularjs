package co.tekus.pt.ws.support;

/**
 * Define las constantes de la aplicación
 * 
 * @author gerlin.torres
 * 
 */
public class Constantes {

	private static Constantes instance;
	
	
	public static final String MENSAJE_ERROR_GENERICO = "Lo sentimos, se ha presentado un error inesperado. Vuelva a intentarlo más tarde";

	/**
	 * Private constructor
	 */
	private Constantes() {
		super();
	}

	/**
	 * @return the constates
	 */
	public static Constantes getInstance() {
		if (null == Constantes.instance) {
			instance = new Constantes();
		}
		return instance;
	}
	
}
