package com.dhiraj.order.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dhiraj.order.dto.OrderDTO;
import com.dhiraj.order.dto.OrderItemDTO;
import com.dhiraj.order.dto.OrderItemResponseDTO;
import com.dhiraj.order.dto.OrderResponseDTO;
import com.dhiraj.order.exception.OrderNotCreatedException;
import com.dhiraj.order.feign.OrderItemFeign;
import com.dhiraj.order.model.Order;
import com.dhiraj.order.repository.OrderDAO;
import com.dhiraj.order.repository.OrderRepository;
import com.dhiraj.order.service.OrderService;
import com.dhiraj.order.util.Response;

/**
 * @author Dhiraj
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6491689180910408361L;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private OrderItemFeign orderItemfeign;
	
	@Override
	public ResponseEntity<Response<OrderResponseDTO>> getOrder(Long id) {
		OrderResponseDTO orderResponseDTO = orderDAO.findById(id);
		
		ResponseEntity<Response<List<OrderItemResponseDTO>>> orderItem = orderItemfeign
				.getOrderItem(null,orderResponseDTO.getId());
		if (orderItem.getStatusCode().is2xxSuccessful()) {
			orderResponseDTO.setOrderItem(orderItem.getBody().getData());
		}

		return ResponseEntity.ok(Response.ok(orderResponseDTO,"order fetched successfully."));
	}

	@Override
	public ResponseEntity<Response<Order>> createOrder(OrderDTO orderDTO) {
		Order order = new Order();
		order.setCustomerName(orderDTO.getCustomerName());
		order.setTotal(orderDTO.getTotal());
		order.setShippingAddress(orderDTO.getShippingAddress());
		order.setOrderDate(orderDTO.getOrderDate());
		Order save = orderRepository.save(order);
		List<OrderItemDTO> orderItemDTO = orderDTO.getOrderItemDTO();
		orderItemDTO.forEach(orderItem->orderItem.setOrderId(save.getId()));
		ResponseEntity<Response<String>> createOrderItem = orderItemfeign.createOrderItem(orderItemDTO);
		if(createOrderItem.getStatusCode().is2xxSuccessful()) {
			return ResponseEntity.ok(Response.ok(save,"order created successfully."));
		}
		throw new OrderNotCreatedException("unable to create order");
	}

}
