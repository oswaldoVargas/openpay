/**
 * Openpay
 *
 * Creado el 29/02/2020 20:54:33 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @Proyecto: openpay-service
 * @Paquete : openpayservice
 * @Clase : OpenpayServiceApplication.java. <br/>
 *        Clase principal que contiene el metodo de arranque del micriservicio
 * @version 1.0.0
 * @juan.vargas
 *
 */
@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
@ComponentScan(basePackages = "mx.oswaldo.openpay")
public class OpenpayServiceApplication {
	/**
	 * Inicializacion de la aplicacion mediante spring-boot
	 * 
	 * @param args argumentos para inicializacion
	 */
	public static void main(String[] args) {
		SpringApplication.run(OpenpayServiceApplication.class, args);
	}
}
