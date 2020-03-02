/**
 * Openpay
 *
 * Creado el 29 feb. 2020 21:06:31 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay.config
 * @Clase : AppConfig.java. <br/>
 *        Clase de confgiracion que contiene los bean de configuracion principal
 *        del aplicativo
 * @version 1.0.0
 * @juan.vargas
 *
 */
@Configuration
public class AppConfig {

	/**
	 * Inicia LocaleResolver
	 * 
	 * @return LocaleResolver
	 */
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(new Locale("es", "MX"));
		return slr;
	}

	/**
	 * Bean que inicia la onfiguracion para los mensajes del aplicativo
	 * 
	 * @return retorna un messageSource
	 */
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasenames("i18n/messages");
		source.setDefaultEncoding("UTF-8");
		source.setCacheSeconds(20);
		return source;
	}

}
