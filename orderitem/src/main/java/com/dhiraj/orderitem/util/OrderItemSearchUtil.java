package com.dhiraj.orderitem.util;

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
public class OrderItemSearchUtil {
	
	public OrderItemSearchUtil(Long id, Long orderId) {
		this.orderId=id;
		this.orderId=orderId;
	}

	private Long id;
	
	private Long orderId;
}
