<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.maven.flight.FlightDetails" %>
<%@ page import="com.maven.flight.FlightDao" %>
<%@ page import="java.util.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="css/mdb.min.css" type="text/css" rel="stylesheet">
</head>
<body>
	<form method="get" action="FlightServlet" class="table-responsive p-3">
		<table class="">
			<tr>
				<td><input type="text" placeholder="Source" name="source" style="border:none;border-bottom: 1px solid #654321"> &nbsp; TO &nbsp; </td>  
				<td><input type="text" placeholder="Destination" name="destination" style="border:none;border-bottom: 1px solid #654321"></td> 
			</tr> 
			<tr>
				<td><button type="submit" class="btn btn-default btn-md">Submit</button></td>
			</tr>
		</table>
	</form>
	<div class="container-fluid">
		<table class="table table-striped table-bordered">
			<thead><b>
				<th>FlightNo</th>
				<th>Arrival</th>
				<th>Departure</th>
				<th>Source</th>
				<th>Destination</th>
				<th>Airways</th>
			</b></thead>
			<tbody>
				<tr>
				<% 
					List<FlightDetails> flight = (List<FlightDetails>) request.getAttribute("currentFlight");
					if(flight != null){
						for(FlightDetails details: flight){
				%>
						<td><%=details.getFlightno() %></td>
						<td><%=details.getSource() %></td>
						<td><%=details.getDestination() %></td>
						<td><%=details.getArrival() %></td>
						<td><%=details.getDeparture() %></td>
						<td><%=details.getAirways() %></td>
					<%
						} 
					}
				%>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>