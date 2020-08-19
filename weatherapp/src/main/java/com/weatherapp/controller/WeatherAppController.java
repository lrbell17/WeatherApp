package com.weatherapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weatherapp.service.ExchangeService;
import com.weatherapp.service.LocationService;
import com.weatherapp.service.UtilService;

@Controller
public class WeatherAppController {

	@Autowired
	LocationService locationService;
	
	@Autowired 
	ExchangeService exchangeService;
	
	@Autowired
	UtilService utilService;
	
	@GetMapping("/welcome")
	public String getLocationForm(ModelMap model) {
		
		return "locationform";
	}
	
	@PostMapping("/weather")
	public String getWeather(ModelMap model, @RequestParam String city, @RequestParam String state, 
			@RequestParam String country) {

		// checks if state was entered for non-U.S. country (but allows city-state format)
		if (!country.equals("US") && !state.equals("none") && !country.equals("none")) {
			model.put("errorMessage", "Error! States are only valid for the U.S.");
			return "locationform";
		}
		else {
			String greeting = utilService.getGreeting(city, state, country);
			model.put("greeting", greeting);
			
			//
			try {
				String response = exchangeService.callOpenWeather(city, state, country);
				model.put("response", response);
				return "weather";
			}
			catch (Exception e) {
				model.put("errorMessage", "Error! We couldn't find the city you were looking for.");
				return "locationform";
			}
		}

	}
}
