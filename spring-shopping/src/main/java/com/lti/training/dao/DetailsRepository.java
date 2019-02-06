package com.lti.training.dao;

import java.util.List;

import javax.persistence.Query;

import com.lti.training.entity.Order;

public class DetailsRepository extends GenericRepository {

	public List<Order> order(int order_id){
		Query q = entityManager.createQuery("select ord from Order as ord");
		return q.getResultList();
	}
}
