package com.weatherapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExchangeService {

	// API Key
	private static final String KEY = "";
			
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	// Get info from OpenWeatherMap API
	public String callOpenWeather(String city, String state, String country) {
		String response = restTemplate.exchange("http://api.openweathermap.org/data/2.5/weather?"
				+ "q={city},{state},{country}&units=imperial&appid=" + KEY, 
				HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, city, state, country).getBody();

		return response;

	}
	
}
