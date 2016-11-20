/**
 * 
 */
package co.tekus.pt.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import co.tekus.pt.dao.exception.PtDaoException;
import co.tekus.pt.dao.support.Utilidades;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * @author gerlin.torres
 *
 * @param <T>
 */
@Transactional
public abstract class ADaoGenericImplTransaccional<T> implements IDaoGeneric<T> {

	/**
	 * 
	 */
	private static final Logger LOGGER = Logger.getLogger(ADaoGenericImplTransaccional.class);

	/**
	 * 
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Se inicializa la configuracion de log4j para esta clase
	 */
	public ADaoGenericImplTransaccional() {
		BasicConfigurator.configure();
	}

	/**
	 * @return
	 */
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.g2eo.softventory.dao.core.Dao#create(java.lang.Object)
	 */
	@Override
	public void create(T object) throws PtDaoException{
		sessionFactory.getCurrentSession().save(object);
		sessionFactory.getCurrentSession().flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.g2eo.softventory.dao.core.Dao#update(java.lang.Object)
	 */
	@Override
	public void update(T object) throws PtDaoException{
		sessionFactory.getCurrentSession().update(object);
		sessionFactory.getCurrentSession().flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.g2eo.softventory.dao.core.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(T object) throws PtDaoException{
		sessionFactory.getCurrentSession().delete(object);
		sessionFactory.getCurrentSession().flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.g2eo.softventory.dao.core.Dao#findById(java.lang.Object)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T findById(T object) throws PtDaoException{
		Class claseGenerica = object.getClass();
		Method metodoGetId;
		T objectAux = null;
		try {
			metodoGetId = claseGenerica.getMethod("getId", null);
			objectAux = (T) sessionFactory.getCurrentSession().get(claseGenerica, (long) metodoGetId.invoke(object));
		} catch (HibernateException | InvocationTargetException | SecurityException | NoSuchMethodException
				| IllegalAccessException | IllegalArgumentException e) {
			LOGGER.error(e);
			// throw new PtDaoException(e);
		}
		return objectAux;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.g2eo.softventory.dao.core.Dao#findAll(java.lang.Class)
	 */
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> findAll(Class clase) throws PtDaoException{
		List<T> listado;
		// TODO mejorar la consulta para que no me liste objetos nulos
		Query query = sessionFactory.getCurrentSession().createQuery("from " + clase.getName());
		listado = query.list();
		// TODO eliminar el metodo de eliminar los nulos de la lista
		listado = Utilidades.eliminarObjetosNulos(listado);
		return listado;
	}

}
