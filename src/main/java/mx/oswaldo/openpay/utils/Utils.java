/**
 * Openpay
 *
 * Creado el 1 mar. 2020 13:27:28 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.utils;

import java.util.Random;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay
 * @Clase : Utils.java. <br/>
 *        Clase de utileria con los metodo en comun para las operaciones del
 *        servicio
 * @version 1.0.0
 * @juan.vargas
 *
 */
public final class Utils {

	/**
	 * 
	 * Constructor de la clase
	 */
	private Utils() {
	}

	/**
	 * Metodo que genera un numero aleatroio
	 * 
	 * @return retorna un entero
	 */
	public static int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(100000);
	}
}
