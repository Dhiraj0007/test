package com.dhiraj.order.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Dhiraj
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class OrderResponseDTO {
	private Long id;
	
	private String customerName;
	
	private LocalDate orderDate;
	
	private String shippingAddress;
	
	private Integer total;
	
	private List<OrderItemResponseDTO> orderItem;

	public OrderResponseDTO(Long id, String customerName, LocalDate orderDate, String shippingAddress, Integer total) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
		this.total = total;
	}
}
