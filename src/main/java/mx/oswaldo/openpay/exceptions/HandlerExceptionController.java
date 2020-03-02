/**
 * Openpay
 *
 * Creado el 1 mar. 2020 0:50:34 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay.exceptions
 * @Clase : HandlerExceptionController.java. <br/>
 *        Clase que se encarga de cachar las excepciones generadas en el
 *        aplicativo
 * @version 1.0.0
 * @juan.vargas
 *
 */
@ControllerAdvice
public class HandlerExceptionController {
	/** Constante LOG. */
	private static final Logger LOGGER = LoggerFactory.getLogger(HandlerExceptionController.class);
	/**
	 * accessorMessage para codigos de error y mensajes
	 */
	@Autowired
	private MessageSource accessorMessage;

	/**
	 * Metodo que se encarga de validar las excepciones genericas
	 * 
	 * @param ex excepcion que se produce sin ser manejada
	 * @return Response con respuesta estandar http
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleAllException(Exception ex) {
		LOGGER.error("Ha ocurrido un error inesperado. Exception {} {}", ex.getMessage(), ex);
		return new ResponseEntity<>(accessorMessage.getMessage("CODBOPY000", null, LocaleContextHolder.getLocale()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Metodo que se encarga de cachar las excepciones por bad request
	 * 
	 * @param ex parametro de entrada que contiene el valor de la excepcion generada
	 * @return retorna los errores del bean
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		LOGGER.error("Ha ocurrido un error inesperado. MethodArgumentNotValidException {} {}", ex.getMessage(), ex);
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
}
