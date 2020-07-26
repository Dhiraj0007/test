package com.dhiraj.order.exception;

/**
 * @author Dhiraj
 *
 */
public class OrderNotCreatedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7981791326668407383L;

	public OrderNotCreatedException() {
		super();
	}

	public OrderNotCreatedException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public OrderNotCreatedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public OrderNotCreatedException(String arg0) {
		super(arg0);
	}

	public OrderNotCreatedException(Throwable arg0) {
		super(arg0);
	}
	
}
