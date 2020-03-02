/**
 * Openpay
 *
 * Creado el 1 mar. 2020 18:54:09 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay.interceptor
 * @Clase : CustomInterceptor.java. <br/>
 *        Clase Custom interceptor la cual extiende de HandlerInterceptorAdapter
 *        para el manejo de las peticiones http
 * @version 1.0.0
 * @juan.vargas
 *
 */
@Component
public class CustomInterceptor extends HandlerInterceptorAdapter {

	/**
	 * Permite realizar el logging de la clase
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomInterceptor.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LOGGER.info("Dentro de ---> preHandle");
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		localeResolver.setLocale(request, response, request.getLocale());

		LOGGER.info("Lenguaje Indicado: {}", request.getLocale().getLanguage());
		return super.preHandle(request, response, handler);
	}

}
