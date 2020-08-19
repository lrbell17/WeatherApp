<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.weatherapp.model.State"%>
<%@page import="com.weatherapp.model.Country"%>
<%@page import="java.util.List"%>
<%@page import="com.weatherapp.service.LocationService"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Weather App</title>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
		integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	
	<style>
	
		body {
			margin: 50px 50px;
		}
		
	</style>
</head>
<body>
	<h1 style="text-align:center">Welcome to WeatherApp!</h1><hr>
	
	<h4>Please enter your location</h4>
	
	<p style="color:red"> ${errorMessage} </p>
	
	<!-- initializing some values for dropdown -->
	<%
		LocationService locationService = new LocationService();
		List<State> states = locationService.getAllStates();
		List<Country> countries = locationService.getAllCoutries();
	
		request.setAttribute("states", states);
		request.setAttribute("countries", countries);
	%>
	
	<div >
		<form method ="post" action="/weather">
	
			City <input type="text" name="city" required>

			&nbsp;
			<label for="state">   State (U.S. only) </label>
			 <select name="state" id="state">
			 	
			 	<option value="none">None</option>
			 	
			 	<c:forEach items="${states}" var="state">
					<option value="${state.stateCode}"> <c:out value="${state.stateName}"/> </option>
				</c:forEach>
			</select>
			
			&nbsp;
			<label for="country">   Country </label>
			 <select name="country" id="country">
			 	
			 	<option value="none">None</option>
			 	
			 	<c:forEach items="${countries}" var="country">
					<option value="${country.countryCode}"> <c:out value="${country.countryName}"/> </option>
				</c:forEach>
			</select>
			
			&nbsp;
			<button type="submit" class="btn btn-outline-primary">Submit</button>
		</form>
	</div>
</body>
</html>