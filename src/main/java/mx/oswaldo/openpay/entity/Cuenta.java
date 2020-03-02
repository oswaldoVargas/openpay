/**
 * Openpay
 *
 * Creado el 1 mar. 2020 2:35:13 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay.entity
 * @Clase : Cuenta.java. <br/>
 *        Clase entity que contiene las columnas de la entidad Cuenta por
 *        atributo mapeado
 * @version 1.0.0
 * @juan.vargas
 *
 */
@Entity
@Table(name = "CUENTA")
public class Cuenta implements Serializable {

	/**
	 * serial version de la clase
	 */
	private static final long serialVersionUID = 2991897550117238668L;
	/**
	 * indica la columna idCUENTA
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idCUENTA", unique = true, nullable = false)
	private Long id;
	/**
	 * indica la columna PRODUCTO
	 */
	@Column(name = "PRODUCTO", nullable = false, unique = false)
	private String producto;
	/**
	 * indica la columna CUENTA_CLABE
	 */
	@Column(name = "CUENTA_CLABE", nullable = false, unique = false)
	private String cuentaClabe;
	/**
	 * indica la columna USUARIO_ID
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIO_ID")
	private Usuario usuario;

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

	/**
	 * Obtener valor.
	 * 
	 * @return El valor de usuario.
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Fija el valor.
	 *
	 * @param usuario el valor de usuario a colocar
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
