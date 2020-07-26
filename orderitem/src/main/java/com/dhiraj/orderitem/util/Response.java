package com.dhiraj.orderitem.util;

import java.util.Date;
import java.util.Map;

import org.springframework.lang.Nullable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Dhiraj
 *
 * @param <T>
 */
@Getter
@Setter
public class Response<T> {

	private T data;

	private String message;

	private Map<String, Object> fieldError;

	private final Date timeStamp = new Date();

	public Response() {

	}

	public Response(T data, String message, Map<String, Object> fieldError) {
		this.data = data;
		this.message = message;
		this.fieldError = fieldError;
	}

	public Response(T data, String message) {
		this.data = data;
		this.message = message;
	}

	public Response(T data, Map<String, Object> fieldError) {
		this.data = data;
		this.fieldError = fieldError;
	}

	public Response(T data) {
		this.data = data;
	}

	public Response(String message) {
		this.data = null;
		this.message = message;
	}

	public Response(Map<String, Object> fieldError) {
		this.fieldError = fieldError;
	}

	public Response(Map<String, Object> fieldError, String message) {
		this.fieldError = fieldError;
		this.message = message;
	}

	public static <T> Response<T> ok(@Nullable T data, String message) {
		return new Response<>(data, message);
	}

	public static <T> Response<T> ok(String message) {
		return new Response<>(message);
	}

}
