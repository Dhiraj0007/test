package com.dhiraj.order.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dhiraj.order.util.Response;

/**
 * @author Dhiraj
 *
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class MethodArgumentNotValidExceptionHandler {
	private static final Logger LOGGER = LogManager.getLogger(MethodArgumentNotValidExceptionHandler.class);

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Response<Map<String, Object>>> errorHAndler(MethodArgumentNotValidException ex) {
		LOGGER.catching(ex);
		BindingResult result = ex.getBindingResult();
		List<FieldError> errors = result.getFieldErrors();
		Map<String, Object> response = new HashMap<>();
		for (FieldError error : errors)
			response.put(error.getField(), messageSource.getMessage(error, LocaleContextHolder.getLocale()));
		return new ResponseEntity<>(new Response<>(response), HttpStatus.BAD_REQUEST);
	}

}
