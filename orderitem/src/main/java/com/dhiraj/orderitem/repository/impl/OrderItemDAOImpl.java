package com.dhiraj.orderitem.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.dhiraj.orderitem.dto.OrderItemResponseDTO;
import com.dhiraj.orderitem.exception.OrderItemNotFoundException;
import com.dhiraj.orderitem.model.OrderItem;
import com.dhiraj.orderitem.repository.OrderItemDAO;
import com.dhiraj.orderitem.util.OrderItemSearchUtil;

/**
 * @author Dhiraj
 *
 */
@Repository
public class OrderItemDAOImpl implements OrderItemDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3786070426164646032L;
	
	@Autowired
	private transient EntityManager entityManager;

	@Override
	public List<OrderItemResponseDTO> getOrderItem(OrderItemSearchUtil orderItemSearchUtil) {
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OrderItemResponseDTO> query = queryBuilder.createQuery(OrderItemResponseDTO.class);
		Root<OrderItem> orderItemRoot = query.from(OrderItem.class);
		List<Predicate> predicates = new ArrayList<>();
		if (null != orderItemSearchUtil.getOrderId()) {
			predicates.add(queryBuilder.equal(orderItemRoot.get("orderId"), orderItemSearchUtil.getOrderId()));
		}

		if (null != orderItemSearchUtil.getId()) {
			predicates.add(queryBuilder.equal(orderItemRoot.get("id"), orderItemSearchUtil.getId()));
		}

		query.select(queryBuilder.construct(OrderItemResponseDTO.class, orderItemRoot.get("id"),
				orderItemRoot.get("productName"), orderItemRoot.get("productCode"), orderItemRoot.get("quantity")));
			
		query.where(queryBuilder.and(predicates.toArray(new Predicate[predicates.size()])));

		TypedQuery<OrderItemResponseDTO> typedQuery = entityManager.createQuery(query);
		try {
			return typedQuery.getResultList();
		} catch (EmptyResultDataAccessException | NoResultException e) {
			throw new OrderItemNotFoundException("Order item detail not found",e);
		}
	}

	@Override
	public OrderItemResponseDTO findById(Long id) {
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OrderItemResponseDTO> query = queryBuilder.createQuery(OrderItemResponseDTO.class);
		Root<OrderItem> orderItemRoot = query.from(OrderItem.class);

		query.select(queryBuilder.construct(OrderItemResponseDTO.class, orderItemRoot.get("id"),
				orderItemRoot.get("productName"), orderItemRoot.get("productCode"), orderItemRoot.get("quantity")));
			
		query.where(queryBuilder.equal(orderItemRoot.get("id"),id));

		TypedQuery<OrderItemResponseDTO> typedQuery = entityManager.createQuery(query);
		try {
			return typedQuery.getSingleResult();
		} catch (EmptyResultDataAccessException | NoResultException e) {
			throw new OrderItemNotFoundException("Order item detail not found",e);
		}
	}

	@Override
	public void saveAll(List<OrderItem> orderItems) {
		orderItems.forEach(orderItem ->entityManager.merge(orderItem));
	}

}
