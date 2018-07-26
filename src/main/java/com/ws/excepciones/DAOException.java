package com.ws.excepciones;

public class DAOException extends Exception {
	private static final long serialVersionUID = 1L;

	public DAOException() { super(); }

	/**
	 * Constructor con parametro.
	 * @param message
	 */
	public DAOException(String message) { super(message); }

	/**
	 * Constructor con parametro excepcion.
	 * @param e
	 */
	public DAOException(Exception e) { super(e); }

}
