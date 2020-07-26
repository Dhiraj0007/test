package com.dhiraj.order.controller;

import java.io.Serializable;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dhiraj.order.dto.OrderDTO;
import com.dhiraj.order.dto.OrderResponseDTO;
import com.dhiraj.order.model.Order;
import com.dhiraj.order.service.OrderService;
import com.dhiraj.order.util.Response;

/**
 * @author Dhiraj
 *
 */
@RestController
public class OrderController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1629944573169972896L;
	@Autowired
	private OrderService orderService;
	
	@PostMapping("order")
	public ResponseEntity<Response<Order>> createOrder(@RequestBody @Valid OrderDTO orderItemDTO){
		return orderService.createOrder(orderItemDTO);
	}
	
	
	@GetMapping("order/{id}")
	public ResponseEntity<Response<OrderResponseDTO>> getOrder(Long id){
		
		return orderService.getOrder(id);
	}
}
