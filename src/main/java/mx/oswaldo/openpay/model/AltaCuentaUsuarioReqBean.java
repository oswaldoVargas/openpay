/**
 * Openpay
 *
 * Creado el 29 feb. 2020 22:59:06 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay.model
 * @Clase : AltaCuentaUsuarioReqBean.java. <br/>
 *        Clase bean que contiene los atributos necsarios para los parametros de
 *        entrada de un alta de cuenta de usuario
 * @version 1.0.0
 * @juan.vargas
 *
 */
public class AltaCuentaUsuarioReqBean extends UsuarioReqBean implements Serializable {

	/**
	 * serial version de la clase
	 */
	private static final long serialVersionUID = -8572683205399917728L;
	/**
	 * indica el producto a dar de alta
	 */
	@NotNull(message = "El campo producto oficina no debe ser nulo")
	@NotBlank(message = "El campo producto no debe ser vacio")
	private String producto;

	/**
	 * Constructor de la clase
	 */
	public AltaCuentaUsuarioReqBean() {
	}

	/**
	 * Obtener valor.
	 * 
	 * @return El valor de producto.
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * Fija el valor.
	 *
	 * @param producto el valor de producto a colocar
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}
}
