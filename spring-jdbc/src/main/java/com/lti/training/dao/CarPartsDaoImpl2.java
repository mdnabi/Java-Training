package com.lti.training.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.springframework.stereotype.Component;

import com.lti.training.exception.DataAccessException;
import com.lti.training.main.CarPart;

@Component("carPartDao2")
public class CarPartsDaoImpl2 implements CarPartsDao {

	public void addNewPart(CarPart carPart) throws DataAccessException {
		Connection conn = null;
		PreparedStatement pstmt = null; //Precompiled SQL Comments
		try {
			
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("dev-db.properties");
			Properties dbProperties = new Properties();
			
			dbProperties.load(is);
			
			String driverClassName = dbProperties.getProperty("driverClassName");
			String url = dbProperties.getProperty("url");
			String username = dbProperties.getProperty("username");
			String password = dbProperties.getProperty("password");
			
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url,username,password);		
			
			pstmt = conn.prepareStatement("insert into carparts values(?,?,?,?,?)"); //To add value in the runtime '?' is added inside values
			
			//Syntax for inserting data "pstmt.setString(column_no,object.method())"
			pstmt.setString (1, carPart.getPartName());
			pstmt.setString(2, carPart.getCarModel());
			pstmt.setInt(3, carPart.getPartNo());
			pstmt.setDouble(4, carPart.getPrice());
			pstmt.setInt(5, carPart.getQuantity());
			
			pstmt.executeUpdate(); //Inserting data in table and updating table
			
			System.out.println("Data inserted");
		}catch(ClassNotFoundException | IOException | SQLException e) {
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
