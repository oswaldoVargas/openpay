/**
 * Openpay
 *
 * Creado el 29 feb. 2020 21:52:11 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.config;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay.config
 * @Clase : AsyncConfig.java. <br/>
 *        Clase de configuracion que contiene el bean de configuracion para los
 *        hilos asyncornos de la aplicaciob
 * @version 1.0.0
 * @juan.vargas
 *
 */
@Configuration
@EnableAsync
public class AsyncConfig {

	/**
	 * indica el tamaño del core pool
	 */
	@Value("${thread-config.corePoolSize}")
	private String corePoolSize;
	/**
	 * indica el tamaño maximo del pool
	 */
	@Value("${thread-config.maxPoolSize}")
	private String maxPoolSize;
	/**
	 * indica el tamaño del queue
	 */
	@Value("${thread-config.queueCapacity}")
	private String queueCapacity;
	/**
	 * indica la cantidad de segundos que se mantiene abierto el keepalive
	 */
	@Value("${thread-config.keepAliveSeconds}")
	private String keepAliveSeconds;
	/**
	 * indica la cantidad de segundos de espera antes de terminar el hilo
	 */
	@Value("${thread-config.awaitTerminationSeconds}")
	private String awaitTerminationSeconds;

	/**
	 * Bean para inicializar el pool de hilos asyncronos
	 * 
	 * @return Executor
	 */
	@Bean("threadPoolTaskExecutor")
	public Executor asyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(Integer.parseInt(corePoolSize));
		executor.setMaxPoolSize(Integer.parseInt(maxPoolSize));
		executor.setQueueCapacity(Integer.parseInt(queueCapacity));
		executor.setThreadNamePrefix("OpenPay-Async");
		executor.setKeepAliveSeconds(Integer.parseInt(keepAliveSeconds));
		executor.setAwaitTerminationSeconds(Integer.parseInt(awaitTerminationSeconds));
		executor.initialize();
		return executor;
	}
}
