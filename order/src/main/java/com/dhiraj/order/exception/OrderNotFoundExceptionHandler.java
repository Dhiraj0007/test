package com.dhiraj.order.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dhiraj.order.util.Response;


/**
 * @author Dhiraj
 *
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@ControllerAdvice
public class OrderNotFoundExceptionHandler {

	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<Response<Object>> errorHAndler(OrderNotFoundException ex) {
		ex.printStackTrace();
		return ResponseEntity.badRequest().body(new Response<>(ex.getMessage()));
	}
}
