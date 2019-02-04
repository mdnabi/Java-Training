package com.maven.flight.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.maven.flight.FlightDao;
import com.maven.flight.FlightDetails;

//@WebServlet("/FlightServlet")
public class FlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String source=request.getParameter("source"); //user input from front end
		String destination=request.getParameter("destination");
		
		FlightDao fd=new FlightDao();
		FlightDetails fde = new FlightDetails();
		
		List<FlightDetails> flight = fd.fetchFlight(source, destination);
		request.setAttribute("currentFlight",flight);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("flight.jsp");
		dispatcher.forward(request, response);
	}
	

}
