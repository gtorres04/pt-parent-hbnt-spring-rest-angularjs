package co.tekus.pt.core.service;

import java.util.List;

import co.tekus.pt.core.exception.PtCoreException;

public interface IService<T> {
	/**
	 * Envia al DAO un objeto de tipo T para su persistencia
	 * @param object de tipo T enviado al DAO
	 * @throws SoftventoryCoreException
	 */
	void create(T object) throws PtCoreException;
	/**
	 * Consulta al DAO un objeto de T por su ID
	 * @param object de tipo T con solo el campo ID setiado
	 * @return un objeto de tipo T
	 * @throws SoftventoryCoreException
	 */
	T findById(T object) throws PtCoreException;
	/**
	 * Consulta al DAO todos los objetos de tipo T persistidos
	 * @return listado de objetos de tipo T
	 * @throws SoftventoryCoreException
	 */
	List<T> findAll() throws PtCoreException;
	/**
	 * Envia al DAO un objeto de tipo T para su modificacion
	 * @param object de tipo T
	 * @throws SoftventoryCoreException
	 */
	void update(T object) throws PtCoreException;
	/**
	 * Envia al DAO un objeto de tipo T para su eliminacion
	 * @param object de tipo T con solo el campo ID setiado
	 * @throws Exception
	 */
	void delete(T object) throws PtCoreException;
}
