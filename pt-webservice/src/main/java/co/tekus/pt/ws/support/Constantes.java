package co.tekus.pt.ws.support;

/**
 * Define las constantes de la aplicación
 * 
 * @author gerlin.torres
 * 
 */
public class Constantes {

	private static Constantes instance;
	/**
	 * Codigos de respuestas del Web Service
	 * @author gtorress
	 *
	 */
	public static enum CodigosRespuestasRest{
		EXITO("1"), FALLIDO("-1");
		
		CodigosRespuestasRest(String codigo){
			this.codigo=codigo;
		}
		private String codigo;
		public String getCodigo(){
			return codigo;
		}
		
	}
	
	public static final String MENSAJE_ERROR_GENERICO = "Lo sentimos, se ha presentado un error inesperado. Vuelva a intentarlo más tarde";
	public static final String MENSAJE_EXITO_GENERICO = "La operacion se realizo con exito";
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
