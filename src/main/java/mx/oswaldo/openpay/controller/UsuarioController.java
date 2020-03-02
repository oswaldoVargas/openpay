/**
 * Openpay
 *
 * Creado el 29 feb. 2020 22:42:04 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.oswaldo.openpay.exceptions.ServiceException;
import mx.oswaldo.openpay.model.AltaCuentaUsuarioReqBean;
import mx.oswaldo.openpay.model.CuentaUsuarioResponseBean;
import mx.oswaldo.openpay.model.ModificaUsuarioReqBean;
import mx.oswaldo.openpay.model.NuevaCuentaUsuarioReqBean;
import mx.oswaldo.openpay.model.ResponseGenericBean;
import mx.oswaldo.openpay.service.ICuentaUsuarioService;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay.controller
 * @Clase : UsuarioController.java. <br/>
 *        Clase controller que expone los mservicios para CRUD de cuentas de
 *        usuarios
 * @version 1.0.0
 * @juan.vargas
 *
 */
@Api(value = "Usuario Controller")
@RestController
@RequestMapping("/cuentas")
public class UsuarioController {

	/**
	 * Permite realizar el logging de la clase
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);
	/**
	 * cadena statica que indica el codigo exitoso de una respuesta
	 */
	private static final String COD_EXITO_200 = "CODOPY000";

	/**
	 * accessorMessage para codigos de error y mensajes
	 */
	@Autowired
	private MessageSource accessorMessage;
	/**
	 * instancia del service de usuarios
	 */
	@Autowired
	private ICuentaUsuarioService cuentaUsuarioService;

	/**
	 * Metodo que expone la firma para dar de alta un usuario
	 * 
	 * @param requestBody   parametro de entrada que contiene el valor de el request
	 *                      enviado del cliente
	 * @param request       parametro de entrada que contiene el valor de el http
	 *                      request
	 * @param locale        parametro de entrada que contiene el valor de la
	 *                      informacion del lenguaje
	 * @param bindingResult parametro de entrada que contiene el valor de el binding
	 *                      results
	 * @return retorna la respuesta al cliente
	 */
	@CrossOrigin
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.POST, path = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Da de alta Usuario", notes = "Se da de alta el usuario asi como su cuenta")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Peticion mal formada."),
			@ApiResponse(code = 500, message = "En caso de que se presente un eror inesperado.") })
	public ResponseEntity<?> altaUsuario(final HttpServletRequest request, @Valid @RequestBody AltaCuentaUsuarioReqBean requestBody, final Locale locale, BindingResult bindingResult) {
		LOGGER.info("Inicia altaUsuario");
		// instancia de los objetos
		ResponseGenericBean<CuentaUsuarioResponseBean> response = new ResponseGenericBean<>();

		try {
			LOGGER.info("Invoca altaCuentaUsuario");
			response.exito(cuentaUsuarioService.altaCuentaUsuario(requestBody), COD_EXITO_200);
		} catch (ServiceException e) {
			// se cacha la excecion de negocio para su retorno
			LOGGER.error("Error al realizar la operacion de negocio | altaCuentaUsuario {} {}", e.getMessage(), e);
			response.error(accessorMessage.getMessage(e.getIntrenalCode(), null, locale));

		}
		LOGGER.info("Finaliza altaUsuario");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Metodo que expone la firma para la eliminacion de un usuario
	 * 
	 * @param id      parametro de entrada que contiene el valor de el id del
	 *                usuario
	 * @param request parametro de entrada que contiene el valor de el http request
	 * @param locale  parametro de entrada que contiene el valor de la informacion
	 *                del lenguaje
	 * @return retorna la respuesta al cliente
	 */
	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/usuarios_{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ApiOperation(value = "Eliminar Usuario", notes = "Elimina un usuario y sus cuentas")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Ocurri\u00f3 un error al realizar la operaci\u00f3n."),
			@ApiResponse(code = 400, message = "No se recibieron los par\u00e1metros correctos.") })
	public ResponseEntity<?> eliminaUsuario(@ApiParam(name = "id") @PathVariable(name = "id") final Long id,
			final HttpServletRequest request, final Locale locale) {
		LOGGER.info("Inicia eliminaUsuario");
		// instancia de los objetos
		ResponseGenericBean<Boolean> response = new ResponseGenericBean<>();

		try {
			LOGGER.info("Invoca eliminUsuario");
			response.exito(cuentaUsuarioService.eliminUsuario(id), COD_EXITO_200);
		} catch (ServiceException e) {
			// se cacha la excecion de negocio para su retorno
			LOGGER.error("Error al realizar la operacion de negocio | eliminaUsuario {} {}", e.getMessage(), e);
			response.error(accessorMessage.getMessage(e.getIntrenalCode(), null, locale));

		}
		LOGGER.info("Finaliza eliminaUsuario");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Metodo que expone la firma para obtener los datos del usuario
	 * 
	 * @param id      parametro de entrada que contiene el valor de el id del
	 *                usuario
	 * @param request parametro de entrada que contiene el valor de el http request
	 * @param locale  parametro de entrada que contiene el valor de la informacion
	 *                del lenguaje
	 * @return retorna la respuesta al cliente
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/usuarios_{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Obtiene el usuario y sus cuentas", notes = "Obtiene los datos del usuario y sus cuentas")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Ocurri\u00f3 un error al realizar la operaci\u00f3n."),
			@ApiResponse(code = 400, message = "No se recibieron los par\u00e1metros correctos.") })
	public ResponseEntity<?> getUsuario(@ApiParam(name = "id") @PathVariable(name = "id") final Long id,
			final HttpServletRequest request, final Locale locale) {
		LOGGER.info("Inicia getUsuario");
		// instancia de los objetos
		ResponseGenericBean<CuentaUsuarioResponseBean> response = new ResponseGenericBean<>();

		try {
			LOGGER.info("Invoca listaDatosUsuario");
			response.exito(cuentaUsuarioService.listaDatosUsuario(id), COD_EXITO_200);
		} catch (ServiceException e) {
			// se cacha la excecion de negocio para su retorno
			LOGGER.error("Error al realizar la operacion de negocio | getUsuario {} {}", e.getMessage(), e);
			response.error(accessorMessage.getMessage(e.getIntrenalCode(), null, locale));

		}
		LOGGER.info("Finaliza getUsuario");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Metodo que expone la forma para agregar una cuenta a un usuario
	 * 
	 * @param requestBody   parametro de entrada que contiene el valor de el request
	 *                      enviado del cliente
	 * @param request       parametro de entrada que contiene el valor de el http
	 *                      request
	 * @param locale        parametro de entrada que contiene el valor de la
	 *                      informcacion del lenguaje
	 * @param bindingResult parametro de entrada que contiene el valor de el binfing
	 *                      results
	 * @return retorna la respuesta al cliente
	 */
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, value = "/usuarios_cuentas")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Agrega cuenta a usuario", notes = "Agrega una cuenta al suaurio indicado")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Ocurri\u00f3 un error al realizar la operaci\u00f3n."),
			@ApiResponse(code = 400, message = "No se recibieron los par\u00e1metros correctos.") })
	public ResponseEntity<?> agregaCuentaUsuario(@Valid @RequestBody NuevaCuentaUsuarioReqBean requestBody,
			final HttpServletRequest request, final Locale locale, BindingResult bindingResult) {
		LOGGER.info("Inicia agregaCuentaUsuario");
		// instancia de los objetos
		ResponseGenericBean<CuentaUsuarioResponseBean> response = new ResponseGenericBean<>();

		try {
			LOGGER.info("Invoca agregaCuentaUsuario");
			response.exito(cuentaUsuarioService.agregaCuentaUsuario(requestBody), COD_EXITO_200);
		} catch (ServiceException e) {
			// se cacha la excecion de negocio para su retorno
			LOGGER.error("Error al realizar la operacion de negocio | agregaCuentaUsuario {} {}", e.getMessage(), e);
			response.error(accessorMessage.getMessage(e.getIntrenalCode(), null, locale));

		}
		LOGGER.info("Finaliza agregaCuentaUsuario");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Metodo que expone la firma para modificar los datos de un usuario
	 * 
	 * @param requestBody   parametro de entrada que contiene el valor de el request
	 *                      enviado del cliente
	 * @param request       parametro de entrada que contiene el valor de el http
	 *                      request
	 * @param locale        parametro de entrada que contiene el valor de la
	 *                      informcacion del lenguaje
	 * @param bindingResult parametro de entrada que contiene el valor de el binfing
	 *                      results
	 * @return retorna la respuesta al cliente
	 */
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, value = "/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Modificar los datos de un usuario", notes = "Modificar los datos de un usuario")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Ocurri\u00f3 un error al realizar la operaci\u00f3n."),
			@ApiResponse(code = 400, message = "No se recibieron los par\u00e1metros correctos.") })
	public ResponseEntity<?> modificaUsuario(@Valid @RequestBody ModificaUsuarioReqBean requestBody,
			final HttpServletRequest request, final Locale locale, BindingResult bindingResult) {
		LOGGER.info("Inicia modificaUsuario");
		// instancia de los objetos
		ResponseGenericBean<CuentaUsuarioResponseBean> response = new ResponseGenericBean<>();

		try {
			LOGGER.info("Invoca modificaUsuario");
			response.exito(cuentaUsuarioService.modificaUsuario(requestBody), COD_EXITO_200);
		} catch (ServiceException e) {
			// se cacha la excecion de negocio para su retorno
			LOGGER.error("Error al realizar la operacion de negocio | modificaUsuario {} {}", e.getMessage(), e);
			response.error(accessorMessage.getMessage(e.getIntrenalCode(), null, locale));

		}
		LOGGER.info("Finaliza modificaUsuario");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
