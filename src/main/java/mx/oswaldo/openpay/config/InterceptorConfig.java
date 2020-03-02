/**
 * Openpay
 *
 * Creado el 1 mar. 2020 18:51:03 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import mx.oswaldo.openpay.interceptor.CustomInterceptor;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay.config
 * @Clase : InterceptorConfig.java. <br/>
 *        Clase de configuracion para un interceptor customizado
 * @version 1.0.0
 * @juan.vargas
 *
 */
@SuppressWarnings("deprecation")
@Component
public class InterceptorConfig extends WebMvcConfigurerAdapter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#
	 * addInterceptors(org.springframework.web.servlet.config.annotation.
	 * InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CustomInterceptor());
	}
}
