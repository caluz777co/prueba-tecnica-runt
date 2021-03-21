package com.pruebatecnica.pc.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException {
	
	/**
	 * @author clopez
	 */
	private static final long serialVersionUID = 6409618284172587324L;

	public ResourceNotFoundException(String mensaje) {
		super(mensaje);
	}
	
	public ResourceNotFoundException(String mensaje, Throwable throwable) {
		super(mensaje, throwable);
	}
}
