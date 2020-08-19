package com.weatherapp.service;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class UtilService {

	public String getGreeting(String city, String state, String country) {
		
		if (state.equals("none") && country.equals("none")) {
			
			return "Weather for " + city +  " on "+ new Date();
		}
		else if (state.equals("none")) {
			return "Weather for " + city +  ", " + country + " on " + new Date();
		}
		else if (state.equals("none")){
			return "Weather for " + city + ", " + state + " on " + new Date();
		}
		else {
			return "Weather for " + city + ", " + state.toUpperCase() + ", " + country + " on "
					+ new Date();
		}
	}
}
