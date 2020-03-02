/**
 * Openpay
 *
 * Creado el 1 mar. 2020 2:15:53 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay.entity
 * @Clase : Usuario.java. <br/>
 *        Clase entity que contiene las columnas de la entidad Usuario por
 *        atributo mapeado
 * @version 1.0.0
 * @juan.vargas
 *
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

	/**
	 * serial version de la clase
	 */
	private static final long serialVersionUID = -6481334655275857371L;
	/**
	 * indica la columna USUARIO_ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USUARIO_ID", unique = true, nullable = false)
	private Long id;
	/**
	 * indica la columna NOMBRE
	 */
	@Column(name = "NOMBRE", nullable = false, unique = false)
	private String nombre;
	/**
	 * indica la columna APELLIDO_PATERNO
	 */
	@Column(name = "APELLIDO_PATERNO", nullable = true, unique = false)
	private String apellidoPaterno;
	/**
	 * indica la columna APELLIDO_MATERNO
	 */
	@Column(name = "APELLIDO_MATERNO", nullable = true, unique = false)
	private String apellidoMaterno;
	/**
	 * indica la columna EDAD
	 */
	@Column(name = "EDAD", nullable = false, unique = false)
	private Integer edad;
	/**
	 * indica la columna CELULAR
	 */
	@Column(name = "CELULAR", nullable = false, unique = false)
	private String celular;
	/**
	 * indica la columna cuentas
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.PERSIST)
	private List<Cuenta> cuentas;

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
	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	/**
	 * Fija el valor.
	 *
	 * @param cuentas el valor de cuentas a colocar
	 */
	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

}
