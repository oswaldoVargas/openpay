/**
 * Openpay
 *
 * Creado el 1 mar. 2020 14:32:10 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay.model
 * @Clase : ResponseGenericBean.java. <br/>
 *        Clase DTO que se encarga de genrar un modelo de respuesta comun para
 *        los servicios expuestos por el aplicativo
 * @version 1.0.0
 * @juan.vargas
 *
 */
public class ResponseGenericBean<R> implements Serializable {

	/**
	 * serial version de la clase
	 */
	private static final long serialVersionUID = -8341267530973067275L;
	/**
	 * inidca el codigo de operacion
	 */
	@ApiModelProperty(value = "Código de respuesta emitido, puede ser de éxito, error o validaciones", required = true)
	private String responseCode;
	/**
	 * inidca el cuerpo de la respuesta
	 */
	@ApiModelProperty(value = "Objeto de la respuesta", required = true)
	private transient R response;
	/**
	 * bandera que indica si es exitoso o no
	 */
	@ApiModelProperty(value = "Determina la respuesta es correcta o no", notes = "En caso de éxito : true, En caso de errores: false, En caso de validaciones: false", required = true)
	private boolean exito = false;

	/**
	 * Metodo que se encarga de asignar los objetos de respuesta exitosa
	 * 
	 * @param response     parametro de entrada que contiene el valor del response
	 * @param responseCode parametro de entrada que contiene el codigo exitoso
	 */
	public void exito(R response, String responseCode) {
		this.response = response;
		this.exito = true;
		this.responseCode = responseCode;
	}

	/**
	 * Metodo que se encarga de asignar los objetos de respuesta erronea
	 * 
	 * @param responseCode parametro de entrada que contiene el codigo de error
	 */
	public void error(String responseCode) {
		this.exito = false;
		this.response = null;
		this.responseCode = responseCode;
	}

	/**
	 * Obtener valor.
	 * 
	 * @return El valor de responseCode.
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * Fija el valor.
	 *
	 * @param responseCode el valor de responseCode a colocar
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * Obtener valor.
	 * 
	 * @return El valor de response.
	 */
	public R getResponse() {
		return response;
	}

	/**
	 * Fija el valor.
	 *
	 * @param response el valor de response a colocar
	 */
	public void setResponse(R response) {
		this.response = response;
	}

	/**
	 * Obtener valor.
	 * 
	 * @return El valor de exito.
	 */
	public boolean isExito() {
		return exito;
	}

	/**
	 * Fija el valor.
	 *
	 * @param exito el valor de exito a colocar
	 */
	public void setExito(boolean exito) {
		this.exito = exito;
	}
}
