package com.dhiraj.order.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
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
public class OrderDTO {
	@NotEmpty(message="customerName can't be Blank")
	private String customerName;
	
	@NotNull(message="orderDate can't be null")
	private LocalDate orderDate;
	
	@NotEmpty(message="shippingAddress can't be Blank")
	private String shippingAddress;
	
	@NotNull(message="total can't be null")
	private Integer total;
	
	private List<@Valid OrderItemDTO> orderItemDTO;
}
