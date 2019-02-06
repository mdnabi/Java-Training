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
import org.springframework.stereotype.Component;

import com.lti.training.exception.DataAccessException;
import com.lti.training.main.CarPart;

@Component("carPartDao1")
public class CarPartsDaoImpl1 implements CarPartsDao {

	//Dependency Injection
	@Autowired
	@Qualifier("oracleDataSource")
	private DataSource dataSource; //Creating the variable of DataSource
		
	public void addNewPart(CarPart carPart) throws DataAccessException {
		Connection conn = null;
		PreparedStatement pstmt = null; //Precompiled SQL Comments
		try {
			
			//It uses the connection from pool and connect to the database. Hence, DataSource is used for fast connection
			conn = dataSource.getConnection();		
			
			pstmt = conn.prepareStatement("insert into carparts values(?,?,?,?,?)"); //To add value in the runtime '?' is added inside values
			
			//Syntax for inserting data "pstmt.setString(column_no,object.method())"
			pstmt.setString (1, carPart.getPartName());
			pstmt.setString(2, carPart.getCarModel());
			pstmt.setInt(3, carPart.getPartNo());
			pstmt.setDouble(4, carPart.getPrice());
			pstmt.setInt(5, carPart.getQuantity());
			
			pstmt.executeUpdate(); //Inserting data in table and updating table
			
			System.out.println("Data inserted");
		}catch(SQLException e) {
			throw new DataAccessException ("Data cannot be Accessed", e);
		}

		finally {
			try {
				pstmt.close();
			}catch(Exception e){
				
			}
			try {
				conn.close();
			}
			catch(Exception e) {
				
			}
			
		}
	}

	public List<CarPart> getAvailableParts() {
		// TODO Auto-generated method stub
		return null;
	}

}
