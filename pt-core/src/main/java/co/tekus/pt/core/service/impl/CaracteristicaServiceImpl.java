/**
 * 
 */
package co.tekus.pt.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.tekus.pt.core.exception.PtCoreException;
import co.tekus.pt.core.service.ICaracteristicaService;
import co.tekus.pt.dao.IDaoGeneric;
import co.tekus.pt.dao.exception.PtDaoException;
import co.tekus.pt.dao.modelo.Caracteristica;

/**
 * @author gtorress
 *
 */
@Service
public class CaracteristicaServiceImpl implements ICaracteristicaService {

	/**
	 * 
	 */
	@Autowired
	@Qualifier("CaracteristicasDaoImpl")
	IDaoGeneric<Caracteristica> aCaracteristicaDao;

	/* (non-Javadoc)
	 * @see co.tekus.pt.core.service.IService#create(java.lang.Object)
	 */
	@Override
	public void create(Caracteristica object) throws PtCoreException {
		try {
			aCaracteristicaDao.create(object);
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
	public Caracteristica findById(Caracteristica object) throws PtCoreException {
		Caracteristica Caracteristica = null;
		try {
			Caracteristica = aCaracteristicaDao.findById(object);
		} catch (PtDaoException e) {
			throw new PtCoreException(e.getMessage());
		} catch (Exception e) {
			throw new PtCoreException("Error desconocido: " + e.getMessage());
		}
		return Caracteristica;
	}

	/* (non-Javadoc)
	 * @see co.tekus.pt.core.service.IService#findAll()
	 */
	@Override
	public List<Caracteristica> findAll() throws PtCoreException {
		List<Caracteristica> Caracteristicas = null;
		try {
			Caracteristicas = aCaracteristicaDao.findAll(Caracteristica.class);
		} catch (PtDaoException e) {
			throw new PtCoreException(e.getMessage());
		} catch (Exception e) {
			throw new PtCoreException("Error desconocido: " + e.getMessage());
		}
		return Caracteristicas;
	}

	/* (non-Javadoc)
	 * @see co.tekus.pt.core.service.IService#update(java.lang.Object)
	 */
	@Override
	public void update(Caracteristica object) throws PtCoreException {
		try {
			aCaracteristicaDao.update(object);
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
	public void delete(Caracteristica object) throws PtCoreException {
		try {
			aCaracteristicaDao.delete(object);
		} catch (PtDaoException e) {
			throw new PtCoreException(e.getMessage());
		} catch (Exception e) {
			throw new PtCoreException("Error desconocido: " + e.getMessage());
		}
	}
}
