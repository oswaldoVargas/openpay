/**
 * Openpay
 *
 * Creado el 1 mar. 2020 17:04:26 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.model;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay.model
 * @Clase : UsuarioReqBean.java. <br/>
 *        Clase DTO que contiene los atributos necesarios para los datos del
 *        usuario
 * @version 1.0.0
 * @juan.vargas
 *
 */
public class UsuarioReqBean implements Serializable {

	/**
	 * serial version de la clase
	 */
	private static final long serialVersionUID = -8999957267694473682L;
	/**
	 * indica el nombre de usuario
	 */
	@NotNull(message = "El campo nombre no debe ser nulo")
	@NotBlank(message = "El campo nombre no debe ser vacio")
	private String nombre;
	/**
	 * indica el apellido del usuario
	 */
	@NotNull(message = "El campo apellidos no debe ser nulo")
	@NotBlank(message = "El campo apellidos no debe ser vacio")
	private String apellidoMaterno;

	/**
	 * indica el apellido del usuario
	 */
	@NotNull(message = "El campo apellidos no debe ser nulo")
	@NotBlank(message = "El campo apellidos no debe ser vacio")
	private String apellidoPaterno;
	/**
	 * indica la edad del usuario
	 */
	@Min(value = 18, message = "La edad no debe ser menor a 18")
	@Max(value = 150, message = "La edad no debe ser mayor a 150")
	@NotNull(message = "El campo edad no debe ser nulo")
	private Integer edad;
	/**
	 * indica el celular del usuario
	 */
	@NotNull(message = "El campo celular oficina no debe ser nulo")
	@NotBlank(message = "El campo celular no debe ser vacio")
	@Pattern(regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$", message = "El campo celular no cumple con un patron valido")
	private String celular;
	/**
	 * inidica la direccion del usuario
	 */
	@NotNull(message = "El campo direccion oficina no debe ser nulo")
	@NotBlank(message = "El campo direccion no debe ser vacio")
	private String direccion;

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
	 * @return El valor de direccion.
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Fija el valor.
	 *
	 * @param direccion el valor de direccion a colocar
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
}
