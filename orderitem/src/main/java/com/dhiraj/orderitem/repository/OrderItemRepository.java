package com.dhiraj.orderitem.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhiraj.orderitem.model.OrderItem;

/**
 * @author Dhiraj
 *
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>,Serializable {

}
