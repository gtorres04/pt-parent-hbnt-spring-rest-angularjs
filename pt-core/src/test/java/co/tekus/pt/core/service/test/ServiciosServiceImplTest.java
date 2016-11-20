/**
 * 
 */
package co.tekus.pt.core.service.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.tekus.pt.core.exception.PtCoreException;
import co.tekus.pt.core.service.IServiciosService;
import co.tekus.pt.dao.modelo.Servicio;
import junit.framework.Assert;




/**
 * @author gerlinorlandotorressaavedra
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContextCore.xml" })
public class ServiciosServiceImplTest{
	
	@Autowired
	IServiciosService iServerciosService;
	
	/**
	 * prueba el registro de una entidad
	 */
	@Test
	public void registrar() {
		Servicio servicio = new Servicio();
		servicio.setId(new Long(3));
		servicio.setNombre("Servicio3");
		servicio.setDescripcion("Desc3");
		try {
			iServerciosService.create(servicio);
		} catch (PtCoreException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR REGISTRAR ENTIDAD-->"+e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
	}
}
