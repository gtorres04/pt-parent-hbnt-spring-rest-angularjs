package co.tekus.pt.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.tekus.pt.dao.AServiciosDao;
import co.tekus.pt.dao.IDaoGeneric;
import co.tekus.pt.dao.exception.PtDaoException;
import co.tekus.pt.dao.impl.ServiciosDaoImpl;
import co.tekus.pt.dao.modelo.Caracteristica;
import co.tekus.pt.dao.modelo.Servicio;

/**
 * Unit test for ServiciosDao.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContextDao.xml" })
public class CaracteristicaDaoImplTest {
	
	@Autowired
	@Qualifier("CaracteristicasDaoImpl")
	IDaoGeneric<Caracteristica> aCaracteristicasDao;
   
    
    @Test
	/**
	 * prueba el registro de una entidad
	 */
	@Transactional
	//@Rollback(false)
	public void registrar() {
		Servicio pro=new Servicio();
		pro.setId(new Long(478));
		Caracteristica caracteristica = new Caracteristica();
		caracteristica.setId(new Long(1));
		caracteristica.setNombre("caracterisitica 1jv");
		caracteristica.setValor("valorkkh");
		caracteristica.setServicio(pro);
		try {
			aCaracteristicasDao.create(caracteristica);
		} catch (PtDaoException e) {
			e.printStackTrace();
		}
	}
}
