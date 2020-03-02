/**
 * Openpay
 *
 * Creado el 1 mar. 2020 0:48:49 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package mx.oswaldo.openpay.exceptions;

/**
 * @Proyecto: openpay-service
 * @Paquete : mx.oswaldo.openpay.exceptions
 * @Clase   : ServiceException.java.
 * <br/>
 * Clase que se encarga de cachar las excepciones de negocio
 * @version 1.0.0
 * @juan.vargas
 *
 */
public class ServiceException extends RuntimeException {
    
    /** Constante serialVersionUID. */
    private static final long serialVersionUID = -1027406315281207478L;
    
    /** Variable intrenal code. */
    private String intrenalCode;
       
    
    /** Variable parametros. */
    private String[] parametros;

    /**
     * Getter intrenal code.
     *
     * @return Variable intrenal code
     */
    public String getIntrenalCode() {
        return intrenalCode;
    }

    /**
     * Setter intrenal code.
     *
     * @param intrenalCode Variable intrenal code
     */
    public void setIntrenalCode(String intrenalCode) {
        this.intrenalCode = intrenalCode;
    }

    /**
     * Instancia un nuevo service exception.
     */
    public ServiceException() {
        super();
    }

    /**
     * Instancia un nuevo service exception.
     *
     * @param message Variable message
     */
    public ServiceException(String message) {
        super(message);
        setIntrenalCode(message);
    }

    /**
     * Instancia un nuevo service exception.
     *
     * @param codigo Variable codigo
     * @param parametros Variable parametros
     */
    public ServiceException(String codigo, String[] parametros) {
    	this.intrenalCode = codigo;
    	this.parametros = parametros.clone();
    }

	/**
	 * Getter parametros.
	 *
	 * @return Variable parametros
	 */
	public String[] getParametros() {
		return parametros;
	}

	/**
	 * Setter parametros.
	 *
	 * @param parametros Variable parametros
	 */
	public void setParametros(String[] parametros) {
		this.parametros = parametros.clone();
	}
}
