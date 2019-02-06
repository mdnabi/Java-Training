package com.lti.training.dao;
import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.training.entity.Product;

@Repository
public class GenericRepository {
	@PersistenceContext 
	protected EntityManager entityManager;
	
	//Transaction Support annotation
	@Transactional
	public void store(Object obj){
			entityManager.merge(obj);
	}
	
	public <E> E fetchById(Class<E> classname, Object pk) {
		E e = entityManager.find(classname, pk); //Select query
		return e;
	}
}
