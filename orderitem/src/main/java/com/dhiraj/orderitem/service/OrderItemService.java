package com.dhiraj.orderitem.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dhiraj.orderitem.dto.OrderItemDTO;
import com.dhiraj.orderitem.dto.OrderItemResponseDTO;
import com.dhiraj.orderitem.model.OrderItem;
import com.dhiraj.orderitem.util.OrderItemSearchUtil;
import com.dhiraj.orderitem.util.Response;

/**
 * @author Dhiraj
 *
 */
public interface OrderItemService extends Serializable{

	ResponseEntity<Response<OrderItem>> createOrderItem(OrderItemDTO orderItemDTO);

	ResponseEntity<Response<List<OrderItemResponseDTO>>> getOrderItem(OrderItemSearchUtil orderItemSearchUtil);

	ResponseEntity<Response<OrderItemResponseDTO>> getOrderItem(Long id);

	ResponseEntity<Response<String>> createOrderItem(List<OrderItemDTO> createOrderItem);
}
