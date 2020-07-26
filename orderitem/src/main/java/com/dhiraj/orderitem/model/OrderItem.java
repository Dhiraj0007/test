package com.dhiraj.orderitem.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Dhiraj
 *
 */
@Getter
@Setter
@Entity
@Table(name="order_item")
@NoArgsConstructor
public class OrderItem {
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String productName;
	
	private String productCode;
	
	private Integer quantity;
	
	private Long orderId;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
	
	public OrderItem(String productName, String productCode, Integer quantity, Long orderId) {
		this.productName=productName;
		this.productCode=productCode;
		this.quantity=quantity;
		this.orderId=orderId;
	}
}
