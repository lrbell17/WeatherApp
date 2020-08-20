# WeatherApp

A Spring Boot REST application that consumes the OpenWeatherMap API to provide current weather data based on location.  
A user interface is provided with JSP/Bootstrap so the user can enter the details on their location, then the OpenWeatherApp API is called, 
and the JSON response is parsed through to display readable, user-friendly results.

**Note:** 
* the data may not be 100% accurate, as I am using the trial version of OpenWeatherMap
* I left out my API key in ExchangeService.java --> to run, you need your own API key (free when you register an account to OpenWeatherApp)

**Execution:** add an API key to ExchangeService.java, then run WeatherappApplication.java
