package com.dhiraj.orderitem.exception;

/**
 * @author Dhiraj
 *
 */
public class OrderItemNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3543952356129858734L;

	public OrderItemNotFoundException() {
		super();
	}

	public OrderItemNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public OrderItemNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public OrderItemNotFoundException(String arg0) {
		super(arg0);
	}

	public OrderItemNotFoundException(Throwable arg0) {
		super(arg0);
	}
	

}
