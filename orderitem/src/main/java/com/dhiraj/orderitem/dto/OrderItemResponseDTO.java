package com.dhiraj.orderitem.dto;

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
public class OrderItemResponseDTO {
	
	private Long id;
	
	private String productName;
	
	private String productCode;
	
	private Integer quantity;
	
	public OrderItemResponseDTO(Long id, String productName, String productCode, Integer quantity) {
		super();
		this.id = id;
		this.productName = productName;
		this.productCode = productCode;
		this.quantity = quantity;
	}
}
