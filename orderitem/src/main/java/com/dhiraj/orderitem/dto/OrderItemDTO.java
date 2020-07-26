package com.dhiraj.orderitem.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Dhiraj
 *
 */
@Getter
@Setter
public class OrderItemDTO {
	
	@NotEmpty(message="productName can't be Blank")
	private String productName;
	
	@NotEmpty(message="productCode can't be Blank")
	private String productCode;
	
	@NotNull(message="quantity can't be null")
	private Integer quantity;
	
	@NotNull(message="orderId can't be null")
	private Long orderId;
}
