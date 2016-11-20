/**
 * 
 */
package co.tekus.pt.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.tekus.pt.core.exception.PtCoreException;
import co.tekus.pt.core.service.IServiciosService;
import co.tekus.pt.dao.IDaoGeneric;
import co.tekus.pt.dao.exception.PtDaoException;
import co.tekus.pt.dao.modelo.Servicio;

/**
 * @author gtorress
 *
 */
@Service
public class ServiciosServiceImpl implements IServiciosService {

	/**
	 * 
	 */
	@Autowired
	@Qualifier("ServiciosDaoImpl")
	IDaoGeneric<Servicio> aServiciosDao;

	/* (non-Javadoc)
	 * @see co.tekus.pt.core.service.IService#create(java.lang.Object)
	 */
	@Override
	public void create(Servicio object) throws PtCoreException {
		try {
			aServiciosDao.create(object);
		} catch (PtDaoException e) {
			throw new PtCoreException(e.getMessage());
		} catch (Exception e) {
			throw new PtCoreException("Error desconocido: " + e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see co.tekus.pt.core.service.IService#findById(java.lang.Object)
	 */
	@Override
	public Servicio findById(Servicio object) throws PtCoreException {
		Servicio servicio = null;
		try {
			servicio = aServiciosDao.findById(object);
		} catch (PtDaoException e) {
			throw new PtCoreException(e.getMessage());
		} catch (Exception e) {
			throw new PtCoreException("Error desconocido: " + e.getMessage());
		}
		return servicio;
	}

	/* (non-Javadoc)
	 * @see co.tekus.pt.core.service.IService#findAll()
	 */
	@Override
	public List<Servicio> findAll() throws PtCoreException {
		List<Servicio> servicios = null;
		try {
			servicios = aServiciosDao.findAll(Servicio.class);
		} catch (PtDaoException e) {
			throw new PtCoreException(e.getMessage());
		} catch (Exception e) {
			throw new PtCoreException("Error desconocido: " + e.getMessage());
		}
		return servicios;
	}

	/* (non-Javadoc)
	 * @see co.tekus.pt.core.service.IService#update(java.lang.Object)
	 */
	@Override
	public void update(Servicio object) throws PtCoreException {
		try {
			aServiciosDao.update(object);
		} catch (PtDaoException e) {
			throw new PtCoreException(e.getMessage());
		} catch (Exception e) {
			throw new PtCoreException("Error desconocido: " + e.getMessage());
		}

	}

	/* (non-Javadoc)
	 * @see co.tekus.pt.core.service.IService#delete(java.lang.Object)
	 */
	@Override
	public void delete(Servicio object) throws PtCoreException {
		try {
			aServiciosDao.delete(object);
		} catch (PtDaoException e) {
			throw new PtCoreException(e.getMessage());
		} catch (Exception e) {
			throw new PtCoreException("Error desconocido: " + e.getMessage());
		}
	}
}
