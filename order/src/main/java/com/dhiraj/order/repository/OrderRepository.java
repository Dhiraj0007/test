package com.dhiraj.order.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhiraj.order.model.Order;

/**
 * @author Dhiraj
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>,Serializable{

}
