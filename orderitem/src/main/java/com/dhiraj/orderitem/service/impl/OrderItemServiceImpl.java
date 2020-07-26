package com.dhiraj.orderitem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhiraj.orderitem.dto.OrderItemDTO;
import com.dhiraj.orderitem.dto.OrderItemResponseDTO;
import com.dhiraj.orderitem.exception.OrderItemNotFoundException;
import com.dhiraj.orderitem.model.OrderItem;
import com.dhiraj.orderitem.repository.OrderItemDAO;
import com.dhiraj.orderitem.repository.OrderItemRepository;
import com.dhiraj.orderitem.service.OrderItemService;
import com.dhiraj.orderitem.util.OrderItemSearchUtil;
import com.dhiraj.orderitem.util.Response;

/**
 * @author Dhiraj
 *
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1798365710381609784L;

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private OrderItemDAO orderItemDAO;
	
	@Transactional
	@Override
	public ResponseEntity<Response<OrderItem>> createOrderItem(OrderItemDTO orderItemDTO) {
		OrderItem orderItem=new OrderItem();
		orderItem.setOrderId(orderItemDTO.getOrderId());
		orderItem.setProductName(orderItemDTO.getProductName());
		orderItem.setProductCode(orderItemDTO.getProductCode());
		orderItem.setQuantity(orderItemDTO.getQuantity());
		OrderItem save = orderItemRepository.save(orderItem);
		return ResponseEntity.ok(Response.ok(save,"order item created successfully."));
	}
	
	@Transactional
	@Override
	public ResponseEntity<Response<String>> createOrderItem(List<OrderItemDTO> createOrderItem) {
		List<OrderItem> orderItems = createOrderItem.stream().map(orderItem -> new OrderItem(orderItem.getProductName(),
				orderItem.getProductCode(), orderItem.getQuantity(), orderItem.getOrderId()))
				.collect(Collectors.toList());
		orderItemDAO.saveAll(orderItems);
		return ResponseEntity.ok(Response.ok("order items created successfully."));
	}

	@Transactional(readOnly=true)
	@Override
	public ResponseEntity<Response<List<OrderItemResponseDTO>>> getOrderItem(OrderItemSearchUtil orderItemSearchUtil) {
		List<OrderItemResponseDTO> orderItems=orderItemDAO.getOrderItem(orderItemSearchUtil);
		if(orderItems.isEmpty())
			throw new OrderItemNotFoundException("Order item detail not found");
		return ResponseEntity.ok(Response.ok(orderItems, "Order item fetched successfully."));
	}

	@Transactional(readOnly=true)
	@Override
	public ResponseEntity<Response<OrderItemResponseDTO>> getOrderItem(Long id) {
		
		return ResponseEntity.ok(Response.ok(orderItemDAO.findById(id), "Order item detail fetched successfully."));
	}
}
