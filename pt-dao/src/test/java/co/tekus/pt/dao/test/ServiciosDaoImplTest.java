package co.tekus.pt.dao.test;

import java.util.List;

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
import co.tekus.pt.dao.modelo.Servicio;

/**
 * Unit test for ServiciosDao.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContextDao.xml" })
public class ServiciosDaoImplTest {

	@Autowired
	@Qualifier("ServiciosDaoImpl")
	IDaoGeneric<Servicio> aServiciosDao;

	@Test
	/**
	 * prueba el registro de una entidad
	 */
	@Transactional
	@Rollback(false)
	public void registrar() {
		Servicio pro = new Servicio();
		pro.setNombre("asdfasdf");
		pro.setDescripcion("asdfasdf");
		try {
			aServiciosDao.create(pro);
		} catch (PtDaoException e) {
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * prueba el listado de una entidad
	 */
	@Transactional
	// @Rollback(false)
	public void listar() {
		String s=null;
		System.out.println(s);
		try {
			List<Servicio> servicios = aServiciosDao.findAll(Servicio.class);
			System.out.println(servicios);
		} catch (PtDaoException e) {
			e.printStackTrace();
		}
	}
}
