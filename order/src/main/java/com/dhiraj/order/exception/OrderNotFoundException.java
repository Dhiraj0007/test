package com.dhiraj.order.exception;

/**
 * @author Dhiraj
 *
 */
public class OrderNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7502684771449325330L;

	public OrderNotFoundException() {
		super();
	}

	public OrderNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public OrderNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public OrderNotFoundException(String arg0) {
		super(arg0);
	}

	public OrderNotFoundException(Throwable arg0) {
		super(arg0);
	}
	
}
