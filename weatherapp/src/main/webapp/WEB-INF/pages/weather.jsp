<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.weatherapp.model.WeatherData"%>
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
	<h5><c:out value="${greeting}"/></h5> <hr>
	
	<strong>Current Conditions:</strong>  <c:out value="${weatherData.description}"/> <br>
	<strong>Current Temperature:</strong> <c:out value="${weatherData.currentTemp}"/> <span>&#176;</span>F <br>
	<strong>Feels Like:</strong> <c:out value="${weatherData.feelsLike}"/> <span>&#176;</span>F <br>
	<strong>High:</strong> <c:out value="${weatherData.maxTemp}"/> <span>&#176;</span>F <br>
	<strong>Low:</strong> <c:out value="${weatherData.minTemp}"/> <span>&#176;</span>F <br>
	<strong>Air Pressure:</strong> <c:out value="${weatherData.pressure/10}"/> kPa<br>
	<strong>Humidity:</strong> <c:out value="${weatherData.humidity}"/>% <br>
	<strong>Wind Speed:</strong> <c:out value="${weatherData.windSpeed}"/> mph<br>
	
	 <hr>
	<a href="/weather"> Back to home page</a>
</body>
</html>