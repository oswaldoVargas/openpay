/**
 * Openpay
 *
 * Creado el 1 mar. 2020 14:10:27 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.model;

import java.io.Serializable;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay.model
 * @Clase : CuentaUsuarioResponseBean.java. <br/>
 *        Clase DTO que contiene los atributos necesarios para los datos de la
 *        cuenta del usuario
 * @version 1.0.0
 * @juan.vargas
 *
 */
public class CuentaUsuarioResponseBean implements Serializable {

	/**
	 * serial version de la clase
	 */
	private static final long serialVersionUID = -1052107943073913051L;
	/**
	 * Inidca el objeto que contiene los datos del usuario
	 */
	private UsuarioDTO usuario;

	/**
	 * Obtener valor.
	 * 
	 * @return El valor de usuario.
	 */
	public UsuarioDTO getUsuario() {
		return usuario;
	}

	/**
	 * Fija el valor.
	 *
	 * @param usuario el valor de usuario a colocar
	 */
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

}
