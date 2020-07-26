package com.dhiraj.orderitem.repository;

import java.io.Serializable;
import java.util.List;

import com.dhiraj.orderitem.dto.OrderItemResponseDTO;
import com.dhiraj.orderitem.model.OrderItem;
import com.dhiraj.orderitem.util.OrderItemSearchUtil;

/**
 * @author Dhiraj
 *
 */
public interface OrderItemDAO extends Serializable{

	List<OrderItemResponseDTO> getOrderItem(OrderItemSearchUtil orderItemSearchUtil);

	OrderItemResponseDTO findById(Long id);

	void saveAll(List<OrderItem> orderItems);
}
