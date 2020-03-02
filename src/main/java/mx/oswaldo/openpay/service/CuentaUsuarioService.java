/**
 * Openpay
 *
 * Creado el 1 mar. 2020 1:01:45 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import mx.oswaldo.openpay.entity.Cuenta;
import mx.oswaldo.openpay.entity.Usuario;
import mx.oswaldo.openpay.exceptions.ServiceException;
import mx.oswaldo.openpay.model.AltaCuentaUsuarioReqBean;
import mx.oswaldo.openpay.model.CuentaUsuarioResponseBean;
import mx.oswaldo.openpay.model.ModificaUsuarioReqBean;
import mx.oswaldo.openpay.model.NuevaCuentaUsuarioReqBean;
import mx.oswaldo.openpay.utils.Utils;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay.service
 * @Clase : CuentaUsuarioService.java. <br/>
 *        CLase Service que se encarga del negocio para las operaciones de las
 *        cuentas del Usuario	
 * @version 1.0.0
 * @juan.vargas
 *
 */
@Service
public class CuentaUsuarioService extends CuentaUsuarioBaseService implements ICuentaUsuarioService {

	/**
	 * Permite realizar el logging de la clase
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CuentaUsuarioService.class);


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.oswaldo.openpay.service.ICuentaUsuarioService#altaCuentaUsuario(mx.oswaldo
	 * .openpay.model.AltaCuentaUsuarioReqBean)
	 */
	@Override
	public CuentaUsuarioResponseBean altaCuentaUsuario(AltaCuentaUsuarioReqBean requestBody) throws ServiceException {
		LOGGER.info("Inicia altaCuentaUsuario");
		CuentaUsuarioResponseBean response = new CuentaUsuarioResponseBean();
		Usuario usuario = null;
		try {
			LOGGER.debug("Invocando validaExistenciaUsuario: {}", requestBody.getCelular());
			usuario = this.validaExistenciaUsuario(requestBody.getCelular());
			LOGGER.info("Invocando preparaDatosInsercion");
			usuario = this.preparaDatosInsercion(requestBody);
			LOGGER.debug("Guardando los datos del usuario");
			usuario = usuarioDAO.save(usuario);
			response.setUsuario(this.preparaDatosResponseUsuario(usuario));

			LOGGER.info("Finaliza altaCuentaUsuario");
			return response;
		} catch (DataAccessException e) {
			LOGGER.error("Ocurrio un error en Base de datos");
			throw new ServiceException("COPER100");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.oswaldo.openpay.service.ICuentaUsuarioService#eliminUsuario(java.lang.
	 * Long)
	 */
	@Override
	public Boolean eliminUsuario(Long id) throws ServiceException {
		LOGGER.info("Inicia eliminUsuario");
		try {
			LOGGER.debug("Validando Usuario: {}", id);
			this.validaId(id);
			this.validaUsuarioPorId(id);
			LOGGER.info("Eliminando usuario");
			usuarioDAO.deleteById(id);

			LOGGER.info("Finaliza eliminUsuario");
			return Boolean.TRUE;
		} catch (DataAccessException e) {
			LOGGER.error("Ocurrio un error en Base de datos");
			throw new ServiceException("COPER100");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.oswaldo.openpay.service.ICuentaUsuarioService#listaDatosUsuario(java.lang.
	 * Long)
	 */
	@Override
	public CuentaUsuarioResponseBean listaDatosUsuario(Long id) throws ServiceException {
		LOGGER.info("Inicia listaDatosUsuario");
		CuentaUsuarioResponseBean response = new CuentaUsuarioResponseBean();
		try {
			LOGGER.debug("Validando Usuario: {}", id);
			this.validaId(id);
			Optional<Usuario> usuario = this.validaUsuarioPorId(id);

			response.setUsuario(this.preparaDatosResponseUsuario(usuario.get()));
			LOGGER.info("Finaliza listaDatosUsuario");
			return response;
		} catch (DataAccessException e) {
			LOGGER.error("Ocurrio un error en Base de datos");
			throw new ServiceException("COPER100");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.oswaldo.openpay.service.ICuentaUsuarioService#agregaCuentaUsuario(mx.
	 * oswaldo.openpay.model.NuevaCuentaUsuarioReqBean)
	 */
	@Override
	public CuentaUsuarioResponseBean agregaCuentaUsuario(NuevaCuentaUsuarioReqBean requestBody)
			throws ServiceException {
		LOGGER.info("Inicia agregaCuentaUsuario");
		CuentaUsuarioResponseBean response = new CuentaUsuarioResponseBean();
		try {
			LOGGER.debug("Validando Usuario: {}", requestBody.getId());
			Optional<Usuario> usuario = this.validaUsuarioPorId(requestBody.getId());
			LOGGER.debug("Cerando datos de nueva cuenta: {}", requestBody.getProducto());
			Cuenta cuenta = new Cuenta();
			cuenta.setCuentaClabe(String.valueOf(Utils.getRandomNumber()));
			cuenta.setProducto(requestBody.getProducto());
			cuenta.setUsuario(usuario.get());
			LOGGER.info("Guardando informacion de la cuenta");
			cuentaDAO.save(cuenta);

			usuario = usuarioDAO.findById(requestBody.getId());
			response.setUsuario(this.preparaDatosResponseUsuario(usuario.get()));

			LOGGER.info("Finaliza agregaCuentaUsuario");
			return response;
		} catch (DataAccessException e) {
			LOGGER.error("Ocurrio un error en Base de datos");
			throw new ServiceException("COPER100");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.oswaldo.openpay.service.ICuentaUsuarioService#modificaUsuario(mx.oswaldo.
	 * openpay.model.ModificaUsuarioReqBean)
	 */
	@Override
	public CuentaUsuarioResponseBean modificaUsuario(ModificaUsuarioReqBean requestBody) throws ServiceException {
		LOGGER.info("Inicia modificaUsuario");
		CuentaUsuarioResponseBean response = new CuentaUsuarioResponseBean();
		try {
			LOGGER.debug("Validando Usuario: {}", requestBody.getId());
			Optional<Usuario> usuario = this.validaUsuarioPorId(requestBody.getId());

			usuario.get().setApellidoMaterno(requestBody.getApellidoMaterno());
			usuario.get().setApellidoPaterno(requestBody.getApellidoPaterno());
			usuario.get().setCelular(requestBody.getCelular());
			usuario.get().setEdad(requestBody.getEdad());
			usuario.get().setNombre(requestBody.getNombre());
			LOGGER.info("Guardando informacion del usuario");
			Usuario userResp = usuarioDAO.save(usuario.get());

			response.setUsuario(this.preparaDatosResponseUsuario(userResp));

			LOGGER.info("Finaliza modificaUsuario");
			return response;
		} catch (DataAccessException e) {
			LOGGER.error("Ocurrio un error en Base de datos");
			throw new ServiceException("COPER100");
		}
	}

}
