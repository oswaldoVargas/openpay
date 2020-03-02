/**
 * Openpay
 *
 * Creado el 1 mar. 2020 17:07:45 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay.model
 * @Clase : ModificaUsuarioReqBean.java. <br/>
 *        Clase DTO que contiene los atributos necesarios para la modificacion
 *        de los datos del usuario
 * @version 1.0.0
 * @juan.vargas
 *
 */
public class ModificaUsuarioReqBean extends UsuarioReqBean implements Serializable {

	/**
	 * serial version de la clase
	 */
	private static final long serialVersionUID = 3103823081613248856L;
	/**
	 * indica el id del usuario
	 */
	@Min(value = 0, message = "El id no debe ser menor a 18")
	@NotNull(message = "El campo id no debe ser nulo")
	private Long id;

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
}
