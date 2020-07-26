package com.dhiraj.order.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Dhiraj
 *
 */
@Getter
@Setter
public class OrderItem {
	
	private Long id;
	
	private String productName;
	
	private String productCode;
	
	private Integer quantity;
	
	private Long orderId;
	
	private Date createdAt;
	
	private Date updatedAt;
}
