/**
 * 
 */
package co.tekus.pt.dao;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.transaction.annotation.Transactional;

import co.tekus.pt.dao.exception.PtDaoException;
import co.tekus.pt.dao.support.Constantes;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


/**
 * @author gerlin.torres
 *
 * @param <T>
 */
@Transactional
public abstract class ADaoGenericImpl<T> extends ADaoGenericImplTransaccional<T> {
	
	/**
	 * 
	 */
	private static final Logger LOGGER = Logger.getLogger(ADaoGenericImpl.class);
	
	/**
	 * Se inicializa la configuracion de log4j para esta clase
	 */
	public ADaoGenericImpl() {
		BasicConfigurator.configure();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.g2eo.softventory.dao.core.Dao#create(java.lang.Object)
	 */
	@Override
	public void create(T object) throws PtDaoException{
		try{
			super.create(object);
		}catch(ConstraintViolationException e){
			LOGGER.debug(e);
			PtDaoException.relanzarExceptionDAOConstraintViolation(e.getCause().toString());
		}catch (Exception e) {
			LOGGER.error(e);
			throw new PtDaoException(Constantes.MSN_ERROR_NO_GESTIONADO);
		}
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.g2eo.softventory.dao.core.Dao#update(java.lang.Object)
	 */
	@Override
	public void update(T object) throws PtDaoException {
		super.update(object);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.g2eo.softventory.dao.core.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(T object) throws PtDaoException {
		super.update(object);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.g2eo.softventory.dao.core.Dao#findById(java.lang.Object)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T findById(T object) throws PtDaoException {
		return super.findById(object);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.g2eo.softventory.dao.core.Dao#findAll(java.lang.Class)
	 */
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> findAll(Class clase) throws PtDaoException {
		return super.findAll(clase);
	}
	
}
