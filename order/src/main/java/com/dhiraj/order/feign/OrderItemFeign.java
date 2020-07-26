package com.dhiraj.order.feign;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.dhiraj.order.dto.OrderItem;
import com.dhiraj.order.dto.OrderItemDTO;
import com.dhiraj.order.dto.OrderItemResponseDTO;
import com.dhiraj.order.util.Response;


/**
 * @author Dhiraj
 *
 */
@FeignClient(value="${order.item.service-id}")
public interface OrderItemFeign extends Serializable{
	
	@PostMapping("/order-item")
	ResponseEntity<Response<OrderItem>> createOrderItem(@RequestBody @Valid OrderItemDTO orderItemDTO);
	
	@PostMapping("/order-item-bulk")
	ResponseEntity<Response<String>> createOrderItem(@RequestBody @Valid List< @Valid OrderItemDTO> createOrderItem);
	
	@GetMapping("/order-item")
	ResponseEntity<Response<List<OrderItemResponseDTO>>> getOrderItem(@RequestParam(required=false) Long id,@RequestParam(required=false) Long orderId);
}
