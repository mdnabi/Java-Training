package com.lti.training.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.lti.training.exception.DataAccessException;
import com.lti.training.main.CarPart;

@Component("carPartDao3")
public class CarPartsDaoImpl3 implements CarPartsDao {

	//Dependency Injection
	@Autowired
	@Qualifier("oracleDataSource")
	private DataSource dataSource; //Creating the variable of DataSource
	
	public void addNewPart(CarPart carPart) throws DataAccessException {
			//JDBC template
			JdbcTemplate jdbt = new JdbcTemplate(dataSource);
			String sql = "insert into carparts values(?,?,?,?,?)";
			jdbt.update(sql,
					carPart.getPartName(),
					carPart.getCarModel(),
					carPart.getPartNo(),
					carPart.getPrice(),
					carPart.getQuantity());		
	}

	public List<CarPart> getAvailableParts() {
		// TODO Auto-generated method stub
		return null;
	}

}
