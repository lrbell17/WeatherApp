package com.weatherapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.weatherapp.service.ExchangeService;

@RestController
public class WeatherController {

	@Autowired
	ExchangeService exchangeService;
	
	@GetMapping("/weather/{city}/{state}/{country}")
	public String getWeather(@PathVariable String city, @PathVariable String state, @PathVariable String country) {
		
		return exchangeService.callOpenWeather(city, state, country);
		
	}
}
