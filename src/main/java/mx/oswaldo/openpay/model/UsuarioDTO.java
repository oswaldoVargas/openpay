/**
 * Openpay
 *
 * Creado el 1 mar. 2020 14:12:20 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.model;

import java.io.Serializable;
import java.util.List;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay.model
 * @Clase : UsuarioDTO.java. <br/>
 *        Clase DTO que contiene los atribitos necsarios para la informacion del
 *        usuario
 * @version 1.0.0
 * @juan.vargas
 *
 */
public class UsuarioDTO implements Serializable {

	/**
	 * serial version de la clase
	 */
	private static final long serialVersionUID = -238129866829053123L;
	/**
	 * indica el id del usuario
	 */
	private Long id;
	/**
	 * indica el nombre del usuario
	 */
	private String nombre;
	/**
	 * indica el apellido paterno del usuario
	 */
	private String apellidoPaterno;
	/**
	 * indica el apellido materno del usuario
	 */
	private String apellidoMaterno;
	/**
	 * indica la edad del usuario
	 */
	private Integer edad;
	/**
	 * indica el celular del usuario
	 */
	private String celular;
	/**
	 * indica la lista de cuentas del usuario
	 */
	private List<CuentaDTO> cuentas;

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
	 * @return El valor de nombre.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Fija el valor.
	 *
	 * @param nombre el valor de nombre a colocar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtener valor.
	 * 
	 * @return El valor de apellidoPaterno.
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * Fija el valor.
	 *
	 * @param apellidoPaterno el valor de apellidoPaterno a colocar
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * Obtener valor.
	 * 
	 * @return El valor de apellidoMaterno.
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * Fija el valor.
	 *
	 * @param apellidoMaterno el valor de apellidoMaterno a colocar
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * Obtener valor.
	 * 
	 * @return El valor de edad.
	 */
	public Integer getEdad() {
		return edad;
	}

	/**
	 * Fija el valor.
	 *
	 * @param edad el valor de edad a colocar
	 */
	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	/**
	 * Obtener valor.
	 * 
	 * @return El valor de celular.
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * Fija el valor.
	 *
	 * @param celular el valor de celular a colocar
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * Obtener valor.
	 * 
	 * @return El valor de cuentas.
	 */
	public List<CuentaDTO> getCuentas() {
		return cuentas;
	}

	/**
	 * Fija el valor.
	 *
	 * @param cuentas el valor de cuentas a colocar
	 */
	public void setCuentas(List<CuentaDTO> cuentas) {
		this.cuentas = cuentas;
	}
}
