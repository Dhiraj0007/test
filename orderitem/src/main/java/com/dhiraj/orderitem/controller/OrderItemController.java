package com.dhiraj.orderitem.controller;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dhiraj.orderitem.dto.OrderItemDTO;
import com.dhiraj.orderitem.dto.OrderItemResponseDTO;
import com.dhiraj.orderitem.model.OrderItem;
import com.dhiraj.orderitem.service.OrderItemService;
import com.dhiraj.orderitem.util.OrderItemSearchUtil;
import com.dhiraj.orderitem.util.Response;

/**
 * @author Dhiraj
 *
 */
@RestController
public class OrderItemController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1094842177021232222L;
	@Autowired
	private OrderItemService orderItemService;
	
	@PostMapping("/order-item")
	public ResponseEntity<Response<OrderItem>> createOrderItem(@RequestBody @Valid OrderItemDTO orderItemDTO){
		return orderItemService.createOrderItem(orderItemDTO);
	}
	
	@PostMapping("/order-item-bulk")
	public ResponseEntity<Response<String>> createOrderItem(@RequestBody @Valid List< @Valid OrderItemDTO> createOrderItem){
		return orderItemService.createOrderItem(createOrderItem);
	}
	
	@GetMapping("/order-item")
	public ResponseEntity<Response<List<OrderItemResponseDTO>>> getOrderItem(OrderItemSearchUtil orderItemSearchUtil){
		
		return orderItemService.getOrderItem(orderItemSearchUtil);
	}
	
	@GetMapping("/order-item/{id}")
	public ResponseEntity<Response<OrderItemResponseDTO>> getOrderItem(Long id){
		
		return orderItemService.getOrderItem(id);
	}
}
