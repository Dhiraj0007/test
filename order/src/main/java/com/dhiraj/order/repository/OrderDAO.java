package com.dhiraj.order.repository;

import java.io.Serializable;

import com.dhiraj.order.dto.OrderResponseDTO;

/**
 * @author Dhiraj
 *
 */
public interface OrderDAO extends Serializable{

	OrderResponseDTO findById(Long id);

}
