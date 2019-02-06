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

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.lti.training.dao.CarPartsDaoImpl3.CarPartRowMapper;
import com.lti.training.exception.DataAccessException;
import com.lti.training.main.CarPart;

@Component("carPartDao3")
public class CarPartsDaoImpl3 implements CarPartsDao {

	//Dependency Injection
	@Autowired
	@Qualifier("oracleDataSource")
	private DataSource dataSource; //Creating the variable of DataSource
	
	public void addNewPart(CarPart carPart){
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
		JdbcTemplate jdbt = new JdbcTemplate(dataSource);
		String sql = "select * from carparts";
		List<CarPart> list = jdbt.query(sql, new CarPartRowMapper());
		return list;
	}
	
	class CarPartRowMapper implements RowMapper<CarPart> {

		@Override
		public CarPart mapRow(ResultSet rs, int index) throws SQLException {
			CarPart part = new CarPart();
			
			part.setPartName(rs.getString(1));
			part.setCarModel(rs.getString(2));
			part.setPartNo(rs.getInt(3));
			part.setPrice(rs.getDouble(4));
			part.setQuantity(rs.getInt(5));
			
			return part;
		}
		
	}

}
