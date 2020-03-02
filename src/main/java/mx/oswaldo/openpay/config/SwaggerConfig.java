/**
 * Openpay
 *
 * Creado el 29 feb. 2020 21:42:13 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.config;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay.config
 * @Clase   : SwaggerConfig.java.
 * <br/>
 * Calse que contiene los beans de configuracion para el SWAGGER_2
 * @version 1.0.0
 * @juan.vargas
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	

	/**
	 * Bean de configuraion para la documentacion del API
	 * 
	 * @return retorna un objeto Docket
	 */
    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("openpay-service")
                .apiInfo(apiInfo())
                .directModelSubstitute(LocalDateTime.class, Date.class)
                .select()
                .paths(PathSelectors.regex("/.*"))
                .build();
    }
 
    /**
	 * Bean de configuraion para la documentacion he informacion  del API
	 * 
	 * @return retorna un objeto ApiInfo
	 */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API Servicios Openpay")
                .description("API Servicios Openpay")
                .version("1.0")
                .build();
    }

}
