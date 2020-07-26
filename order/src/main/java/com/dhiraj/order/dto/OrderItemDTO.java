package com.dhiraj.order.dto;

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
	
	private Long orderId;
	
}
