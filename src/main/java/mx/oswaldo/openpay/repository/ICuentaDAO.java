/**
 * Openpay
 *
 * Creado el 1 mar. 2020 13:48:44 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.oswaldo.openpay.entity.Cuenta;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay.repository
 * @Clase : ICuentaDAO.java. <br/>
 *        Interfaz DAO que contiene las firmas para el CRUD de la entidad de
 *        Cuenta
 * @version 1.0.0
 * @juan.vargas
 *
 */
public interface ICuentaDAO extends JpaRepository<Cuenta, Long> {

}
