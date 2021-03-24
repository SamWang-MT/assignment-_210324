package com.company.project.core;

/**
 *  ServiceException
 */
public class ServiceException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2531223836758388000L;

	public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
