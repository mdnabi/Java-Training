package com.lti.training.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lti.training.exception.DataAccessException;
import com.lti.training.main.CarPart;

@Component("carPartDao4")
public class CarPartsDaoImpl4 implements CarPartsDao {
	//Since @Autowired doesn't work in injecting EntityManager object, we use @PersistenceContext
	//DependencyInjection of EntityManager
	@PersistenceContext 
	private EntityManager entityManager;
	
	//Transaction Support annotation
	@Transactional
	public void addNewPart(CarPart carPart){
			entityManager.persist(carPart);
	}
	
	public List<CarPart> getAvailableParts() {
		
		Query q = entityManager.createQuery("select carp from CarPart as carp");
		return q.getResultList();
		
	}

}
