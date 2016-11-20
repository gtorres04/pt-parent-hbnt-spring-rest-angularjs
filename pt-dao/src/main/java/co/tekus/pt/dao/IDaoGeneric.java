package co.tekus.pt.dao;

import java.util.List;

import co.tekus.pt.dao.exception.PtDaoException;

public interface IDaoGeneric<T> {
	/**
	 * Registra en la base de datos un objeto de tipo T
	 * 
	 * @param object
	 * @throws PtDaoException
	 */
	void create(T object) throws PtDaoException;

	/**
	 * consulta en la base de datos un objeto de tipo T teniendo en cuenta su ID
	 * 
	 * @param object
	 *            con solo el campo ID setiado
	 * @return objeto de tipo T correspondiente al ID
	 * @throws PtDaoException
	 */
	T findById(T object) throws PtDaoException;

	/**
	 * Consulta en la base de datos todos los objetos de tipo T
	 * 
	 * @return Listado de objetos de tipo T
	 * @throws PtDaoException
	 */
	List<T> findAll(Class clase) throws PtDaoException;

	/**
	 * Actualiza los valores de los atributos del objeto con ID digitado
	 * 
	 * @param object
	 *            con solo el campo ID setiado
	 * @throws PtDaoException
	 */
	void update(T object) throws PtDaoException;

	/**
	 * elimina de la base de datos el objeto con ID digitado
	 * 
	 * @param object
	 *            con solo el campo ID setiado
	 * @throws PtDaoException
	 */
	void delete(T object) throws PtDaoException;
}
