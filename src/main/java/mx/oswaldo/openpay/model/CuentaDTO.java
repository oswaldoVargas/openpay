/**
 * Openpay
 *
 * Creado el 1 mar. 2020 14:12:33 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.model;

import java.io.Serializable;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay.model
 * @Clase : CuentaDTO.java. <br/>
 *        Clase DTO que contiene los atributos necesarios para los datos de la
 *        cuenta
 * @version 1.0.0
 * @juan.vargas
 *
 */
public class CuentaDTO implements Serializable {

	/**
	 * serial version de la clase
	 */
	private static final long serialVersionUID = -6315959244973674165L;

	/**
	 * indica el id del usuario
	 */
	private Long id;

	/**
	 * indica el producto del usuario
	 */
	private String producto;

	/**
	 * indica la cuenta clabe
	 */
	private String cuentaClabe;

	/**
	 * Constructor de la clase
	 */
	public CuentaDTO() {
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param id
	 * @param producto
	 * @param cuentaClabe
	 */
	public CuentaDTO(Long id, String producto, String cuentaClabe) {
		super();
		this.id = id;
		this.producto = producto;
		this.cuentaClabe = cuentaClabe;
	}

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

	/**
	 * Obtener valor.
	 * 
	 * @return El valor de cuentaClabe.
	 */
	public String getCuentaClabe() {
		return cuentaClabe;
	}

	/**
	 * Fija el valor.
	 *
	 * @param cuentaClabe el valor de cuentaClabe a colocar
	 */
	public void setCuentaClabe(String cuentaClabe) {
		this.cuentaClabe = cuentaClabe;
	}

}
