package co.tekus.pt.dao.support;

public class Constantes {
	
	public static final String MSN_ERROR_NO_GESTIONADO="Estamos presentando problemas tecnicos";
	
	/**
	 * @author gerlinorlandotorressaavedra
	 *
	 */
	public static enum CONSTRAINT{
		UNIQUE;
		
		CONSTRAINT(){
			this.nombreGuion=this.toString()+"_";
		}
		private String nombreGuion;

		public String getNombreGuion(){
			return nombreGuion;
		}
	}
	
	/**
	 * @author gerlinorlandotorressaavedra
	 *
	 */
	public static enum MSN_EXCEPTION_CONSTRAINT{
		UNIQUE("Dato existente, intente con un dato diferente");
		MSN_EXCEPTION_CONSTRAINT(String mensaje){
			this.mensaje=mensaje;
		}
		private String mensaje;
		public String getMensaje(){
			return mensaje;
		}
	}
	
	/**
	 * 
	 */
	private Constantes() {}

}
