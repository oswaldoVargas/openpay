/**
 * Openpay
 *
 * Creado el 1 mar. 2020 2:22:37 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.oswaldo.openpay.entity.Usuario;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay.repository
 * @Clase : IUsuarioDAO.java. <br/>
 *        Interfaz DAO que contiene las firmas necesarias para el CRUD de la
 *        entidad de Usuario
 * @version 1.0.0
 * @juan.vargas
 *
 */
public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {

	/**
	 * interfaz que se encraga de encontrar el usuario filtrado por el celular
	 * 
	 * @param celular parametro de entrada que contiene el valor de el celular a
	 *                buscar
	 * @return retorna el Ussuario
	 */
	Usuario findByCelular(String celular);

	/**
	 * Metodo que se encarga de encontar el usuario por ID
	 */
	Optional<Usuario> findById(Long id);

	/**
	 * Metodo que se encarga de eliminar el usuario por ID
	 */
	void deleteById(Long id);
}
