package com.dhiraj.order.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.dhiraj.order.dto.OrderResponseDTO;
import com.dhiraj.order.exception.OrderNotFoundException;
import com.dhiraj.order.model.Order;
import com.dhiraj.order.repository.OrderDAO;

/**
 * @author Dhiraj
 *
 */
@Repository
public class OrderDAOImpl implements OrderDAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9140237499232609298L;
	@Autowired
	private transient EntityManager entityManager;

	@Override
	public OrderResponseDTO findById(Long id) {
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OrderResponseDTO> query = queryBuilder.createQuery(OrderResponseDTO.class);
		Root<Order> orderItemRoot = query.from(Order.class);

		query.select(queryBuilder.construct(OrderResponseDTO.class, orderItemRoot.get("id"),
				orderItemRoot.get("customerName"), orderItemRoot.get("orderDate"), 
				orderItemRoot.get("shippingAddress"),orderItemRoot.get("total")));
			
		query.where(queryBuilder.equal(orderItemRoot.get("id"),id));

		TypedQuery<OrderResponseDTO> typedQuery = entityManager.createQuery(query);
		try {
			return typedQuery.getSingleResult();
		} catch (EmptyResultDataAccessException | NoResultException e) {
			throw new OrderNotFoundException("Order item detail not found",e);
		}
	}

}
