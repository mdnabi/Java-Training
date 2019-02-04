package com.maven.flight.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maven.flight.FlightDao;
import com.maven.flight.FlightDetails;

@WebServlet("/FlightServletAngular")
public class FlightServletAngular extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String source=request.getParameter("source"); //user input from front end
		String destination=request.getParameter("destination");
		
		FlightDao fd=new FlightDao();
		
		FlightDetails fde = new FlightDetails();
		
		List<FlightDetails> flight = fd.fetchFlight(source, destination);
		ObjectMapper mapper = new ObjectMapper();
		String productsJSON = mapper.writeValueAsString(flight);
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin","http://localhost:4200"); //Server contacting the angular server and setting header to link
		response.setHeader("Access-Control-Allow-Methods","GET"); //Setting the method as GET
		PrintWriter out = response.getWriter();
		out.write(productsJSON);
	}
	

}
