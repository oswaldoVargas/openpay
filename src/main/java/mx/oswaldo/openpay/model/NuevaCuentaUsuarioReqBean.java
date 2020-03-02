/**
 * Openpay
 *
 * Creado el 1 mar. 2020 16:42:14 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay.model
 * @Clase : NuevaCuentaUsuarioReqBean.java. <br/>
 *        Clase DTO que contiene los atributos necesarios para la creacion de
 *        una nueva cuenta del usuario indicado
 * @version 1.0.0
 * @juan.vargas
 *
 */
public class NuevaCuentaUsuarioReqBean implements Serializable {

	/**
	 * serial version de la clase
	 */
	private static final long serialVersionUID = 8220295995688943054L;

	/**
	 * indica el id del usuario
	 */
	@Min(value = 0, message = "El id no debe ser menor a 18")
	@NotNull(message = "El campo id no debe ser nulo")
	private Long id;
	/**
	 * indica el producto a ser dado de alta
	 */
	@NotNull(message = "El campo producto oficina no debe ser nulo")
	@NotBlank(message = "El campo producto no debe ser vacio")
	private String producto;

	/**
	 * Obtener valor.
	 * 
	 * @return El valor de id.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Fija el valor.
	 *
	 * @param id el valor de id a colocar
	 */
	public void setId(Long id) {
		this.id = id;
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
