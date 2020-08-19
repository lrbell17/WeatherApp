package com.weatherapp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExchangeService {

	private static final String KEY = "";
			
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	// Get info from OpenWeatherMap API
	public String callOpenWeather(String city, String state, String country) {
		
		// city, country format
		if (state.isBlank()) {
			
			String response = restTemplate.exchange("http://api.openweathermap.org/data/2.5/weather?"
					+ "q={city},{country}&units=imperial&appid=" + KEY, 
					HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, city, country).getBody();
			
			System.out.println(response);
			return "Weather data for " + city + ", " + country + " for " + new Date() + "\n" + response;
		}
		
		// city only format
		else if (state.isBlank() && country.isBlank()) {

			String response = restTemplate.exchange("http://api.openweathermap.org/data/2.5/weather?"
					+ "q={city}&units=imperial&appid=" + KEY, 
					HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, city).getBody();
			
			System.out.println(response);
			return "Weather data for " + city + " for " + new Date() + "\n" + response;
		}
		
		// city, state, country format
		else {
			String response = restTemplate.exchange("http://api.openweathermap.org/data/2.5/weather?"
					+ "q={city},{state},{country}&units=imperial&appid=" + KEY, 
					HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, city, state, country).getBody();
			
			System.out.println(response);
			return "Weather data for " + city + ", " + state + ", " + country + " for " + new Date() + "\n" + response;
		}
	}
	
}