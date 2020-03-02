/**
 * Openpay
 *
 * Creado el 1 mar. 2020 0:45:42 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.service;

import mx.oswaldo.openpay.exceptions.ServiceException;
import mx.oswaldo.openpay.model.AltaCuentaUsuarioReqBean;
import mx.oswaldo.openpay.model.CuentaUsuarioResponseBean;
import mx.oswaldo.openpay.model.ModificaUsuarioReqBean;
import mx.oswaldo.openpay.model.NuevaCuentaUsuarioReqBean;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay.service
 * @Clase : ICuentaUsuarioService.java. <br/>
 *        Interfaz que contiene los metodos necesarios para el negocio de las
 *        cuentas y usuarios
 * @version 1.0.0
 * @juan.vargas
 *
 */
public interface ICuentaUsuarioService {

	/**
	 * Interfa de negocio que se encarga del negocio para dar de alta una cuenta de
	 * usuario
	 * 
	 * @param requestBody parametro de entrada que contiene el valor de el request
	 *                    enviado desde el cliente
	 * @return retorna la respuesta al cliente
	 * @throws ServiceException en caso de excepciones de negocio
	 */
	CuentaUsuarioResponseBean altaCuentaUsuario(AltaCuentaUsuarioReqBean requestBody) throws ServiceException;

	/**
	 * 
	 * 
	 * @param id requestBody parametro de entrada que contiene el valor de el id a
	 *           filtrar
	 * @return
	 * @throws ServiceException en caso de excepciones de negocio
	 */
	Boolean eliminUsuario(Long id) throws ServiceException;

	/**
	 * 
	 * 
	 * @param id requestBody parametro de entrada que contiene el valor de el id a
	 *           filtrar
	 * @return retorna la respuesta al cliente
	 * @throws ServiceException en caso de excepciones de negocio
	 */
	CuentaUsuarioResponseBean listaDatosUsuario(Long id) throws ServiceException;

	/**
	 * 
	 * 
	 * @param requestBody requestBody parametro de entrada que contiene el valor de
	 *                    el request enviado desde el cliente
	 * @return retorna la respuesta al cliente
	 * @throws ServiceException en caso de excepciones de negocio
	 */
	CuentaUsuarioResponseBean agregaCuentaUsuario(NuevaCuentaUsuarioReqBean requestBody) throws ServiceException;

	/**
	 * 
	 * 
	 * @param requestBody requestBody parametro de entrada que contiene el valor de
	 *                    el request enviado desde el cliente
	 * @return retorna la respuesta al cliente
	 * @throws ServiceException en caso de excepciones de negocio
	 */
	CuentaUsuarioResponseBean modificaUsuario(ModificaUsuarioReqBean requestBody) throws ServiceException;

}
