/**
 * Openpay
 *
 * Creado el 1 mar. 2020 18:22:05 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.oswaldo.openpay.entity.Cuenta;
import mx.oswaldo.openpay.entity.Usuario;
import mx.oswaldo.openpay.exceptions.ServiceException;
import mx.oswaldo.openpay.model.AltaCuentaUsuarioReqBean;
import mx.oswaldo.openpay.model.CuentaDTO;
import mx.oswaldo.openpay.model.UsuarioDTO;
import mx.oswaldo.openpay.repository.ICuentaDAO;
import mx.oswaldo.openpay.repository.IUsuarioDAO;
import mx.oswaldo.openpay.utils.Utils;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay.service
 * @Clase : CuentaUsuarioBaseService.java. <br/>
 * 
 * @version 1.0.0
 * @juan.vargas
 *
 */
@Service
public class CuentaUsuarioBaseService {

	/**
	 * Permite realizar el logging de la clase
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CuentaUsuarioBaseService.class);
	/**
	 * instancia del DAO de usuarios
	 */
	@Autowired
	protected IUsuarioDAO usuarioDAO;
	/**
	 * instancia del DAO de Cuenta
	 */
	@Autowired
	protected ICuentaDAO cuentaDAO;

	/**
	 * Metodo que se encarga de validar el id del usuario
	 * 
	 * @param id paremtro de entrada que contiene el valor de el id del usuario
	 */
	protected void validaId(Long id) {
		if (Objects.isNull(id)) {
			LOGGER.warn("Id nulo");
			throw new ServiceException("CODBOPY002");
		}
	}

	/**
	 * Metod que se necraga de validar la existencia del usuario por id
	 * 
	 * @param id paremtro de entrada que contiene el valor de el id del usuario
	 * @return retorna los datos del usuario
	 */
	protected Optional<Usuario> validaUsuarioPorId(Long id) {
		Optional<Usuario> usuario = usuarioDAO.findById(id);
		if (!usuario.isPresent()) {
			LOGGER.warn("El usuario no existe");
			throw new ServiceException("CODBOPY003");
		}
		return usuario;
	}

	/**
	 * Metodo que se encarga de validar la existencia del usuario por celular
	 * 
	 * @param celular paremtro de entrada que contiene el valor de el lelular del
	 *                usuario
	 * @return retorna los datos del usuario
	 */
	protected Usuario validaExistenciaUsuario(String celular) {
		Usuario usuario = usuarioDAO.findByCelular(celular);
		if (Objects.nonNull(usuario)) {
			LOGGER.warn("El usuario ya tiene una cuenta");
			throw new ServiceException("CODBOPY001");
		}
		return usuario;
	}

	/**
	 * Metodo que se encarga de preparar los objetos entity para la insercion de los
	 * datos
	 * 
	 * @param requestBody paremtro de entrada que contiene el valor de el request
	 * @return retorna los datos del suaurio
	 */
	protected Usuario preparaDatosInsercion(AltaCuentaUsuarioReqBean requestBody) {
		Usuario usuario = new Usuario();
		usuario.setNombre(requestBody.getNombre());
		usuario.setApellidoPaterno(requestBody.getApellidoPaterno());
		usuario.setApellidoMaterno(requestBody.getApellidoMaterno());
		usuario.setCelular(requestBody.getCelular());
		usuario.setEdad(requestBody.getEdad());

		Cuenta cuenta = new Cuenta();
		cuenta.setCuentaClabe(String.valueOf(Utils.getRandomNumber()));
		cuenta.setProducto(requestBody.getProducto());

		List<Cuenta> cuentas = Stream.of(cuenta).collect(Collectors.toList());
		usuario.setCuentas(cuentas);
		cuenta.setUsuario(usuario);
		return usuario;
	}

	/**
	 * Metodo que se encarga de preparar la respuesta de los datos del suaurio
	 * 
	 * @param usuario paremtro de entrada que contiene el valor de los datos del
	 *                usuario
	 * @return retorna los datos del suaurio
	 */
	protected UsuarioDTO preparaDatosResponseUsuario(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setApellidoMaterno(usuario.getApellidoMaterno());
		usuarioDTO.setApellidoPaterno(usuario.getApellidoPaterno());
		usuarioDTO.setCelular(usuario.getCelular());
		usuarioDTO.setEdad(usuario.getEdad());
		usuarioDTO.setId(usuario.getId());
		usuarioDTO.setNombre(usuario.getNombre());

		List<CuentaDTO> cuentasDTO = new ArrayList<>();

		usuario.getCuentas().forEach(e -> {
			cuentasDTO.add(new CuentaDTO(e.getId(), e.getProducto(), e.getCuentaClabe()));
		});

		usuarioDTO.setCuentas(cuentasDTO);
		return usuarioDTO;
	}

}
