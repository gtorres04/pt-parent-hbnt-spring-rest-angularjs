/**
 * 
 */
package co.tekus.pt.dao.support;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gerlinorlandotorressaavedra
 *
 */
public class Utilidades {
	private Utilidades(){}
	/**
	 * Elimina los objetos nulos que existan en la lista recivida por el parametro
	 * @param listado
	 * @return
	 */
	public static List eliminarObjetosNulos(List listado){
		List listadoAux=listado;
		if(listado!=null){
			List objetosNoNulos=new ArrayList<>(0);
			for (int i = 0; i < listado.size(); i++) {
				Object objeto=listado.get(i);
				if(null!=objeto){
					objetosNoNulos.add(objeto);
				}
			}
			listadoAux=objetosNoNulos;
		}
		return listadoAux;
	}
}
