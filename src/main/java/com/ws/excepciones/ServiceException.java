package com.ws.excepciones;

public class ServiceException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public ServiceException() { super(); }

	/**
	 * Constructor con parametro.
	 * @param message
	 */
	public ServiceException(String message) { super(message); }

	/**
	 * Constructor con parametro excepcion.
	 * @param e
	 */
	public ServiceException(Exception e) { super(e); }
}
