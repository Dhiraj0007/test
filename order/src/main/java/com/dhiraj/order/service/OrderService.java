package com.dhiraj.order.service;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;

import com.dhiraj.order.dto.OrderDTO;
import com.dhiraj.order.dto.OrderResponseDTO;
import com.dhiraj.order.model.Order;
import com.dhiraj.order.util.Response;

/**
 * @author Dhiraj
 *
 */
public interface OrderService extends Serializable{

	ResponseEntity<Response<OrderResponseDTO>> getOrder(Long id);

	ResponseEntity<Response<Order>> createOrder(OrderDTO orderItemDTO);

}
