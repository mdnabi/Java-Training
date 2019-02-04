package com.maven.flight;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class FlightDao {
		public List<FlightDetails> fetchFlight (String source,String destination){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try {
			InputStream is= this.getClass().getClassLoader().getResourceAsStream("dev-db.properties");
			Properties pt=new Properties();
			pt.load(is);
			
			String driverClassName=pt.getProperty("driverClassName");
			String url=pt.getProperty("url");
			String username=pt.getProperty("username");
			String password=pt.getProperty("password");
			
			Class.forName(driverClassName);
			conn =DriverManager.getConnection(url,username,password);
			
			String sql = "select *from flight where source=? and destination=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, source);
			pstmt.setString(2, destination);
			rs = pstmt.executeQuery();
			
			List<FlightDetails> flights= new ArrayList<FlightDetails>();
			while(rs.next()) {
				FlightDetails fde = new FlightDetails();
				fde.setFlightno(rs.getInt(1));
				fde.setArrival(rs.getString(2));
				fde.setDeparture(rs.getString(3));
				fde.setSource(rs.getString(4));
				fde.setDestination(rs.getString(5));
				fde.setAirways(rs.getString(6));
				
				System.out.println(fde.getFlightno());
				flights.add(fde);
			}
			return flights;			
		}
		catch(ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
			//if it running on a remote server and its executed and errors occur .. we wont be able to understand the error
			return null;
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
}