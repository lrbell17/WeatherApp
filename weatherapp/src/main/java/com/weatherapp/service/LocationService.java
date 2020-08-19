package com.weatherapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.weatherapp.model.Country;
import com.weatherapp.model.State;

@Service
public class LocationService {

	// list of all 50 states for dropdown menu 
	public List<State> getAllStates(){
		List<State> states = new ArrayList<State>();
		
		states.add(new State("Alabama", "al"));
		states.add(new State("Alaska", "ak"));
		states.add(new State("Arizona", "az"));
		states.add(new State("Arkansas", "ar"));
		states.add(new State("California", "ca"));
		states.add(new State("Colorado", "co"));
		states.add(new State("Connecticut", "ct"));
		states.add(new State("Delaware", "de"));
		states.add(new State("Florida", "fl"));
		states.add(new State("Georgia", "ga"));
		states.add(new State("Hawaii", "hi"));
		states.add(new State("Idaho", "id"));
		states.add(new State("Illinois", "il"));
		states.add(new State("Indiana", "id"));
		states.add(new State("Iowa", "ia"));
		states.add(new State("Kansas", "ks"));
		states.add(new State("Kentucky", "ky"));
		states.add(new State("Louisiana", "la"));
		states.add(new State("Maine", "me"));
		states.add(new State("Maryland", "md"));
		states.add(new State("Massachusetts", "ma"));
		states.add(new State("Michigan", "mi"));
		states.add(new State("Minnesota", "mn"));
		states.add(new State("Missouri", "mo"));
		states.add(new State("Mississippi", "ms"));
		states.add(new State("Montana", "mt"));
		states.add(new State("Nebraska", "ne"));
		states.add(new State("Nevada", "nv"));
		states.add(new State("New Hampshire", "nh"));
		states.add(new State("New Jersey", "nj"));
		states.add(new State("New Mexico", "nm"));
		states.add(new State("New York", "ny"));
		states.add(new State("North Carolina", "nc"));
		states.add(new State("North Dakota", "nd"));
		states.add(new State("Ohio", "oh"));
		states.add(new State("Oklahoma", "ok"));
		states.add(new State("Oregon", "or"));
		states.add(new State("Pennsylvania", "pa"));
		states.add(new State("Rhode Island", "ri"));
		states.add(new State("South Carolina", "sc"));
		states.add(new State("South Dakota", "sd"));
		states.add(new State("Tennesee", "tn"));
		states.add(new State("Texas", "tx"));
		states.add(new State("Utah", "ut"));
		states.add(new State("Vermont", "vt"));
		states.add(new State("Virginia", "va"));
		states.add(new State("Washington", "wa"));
		states.add(new State("West Virginia", "wv"));
		states.add(new State("Wisconsin", "wi"));
		states.add(new State("Wyoming", "wy"));
		
		return states;
		
	}
	
	// list of countries for dropdown
	public List<Country> getAllCoutries(){
		List<Country> countries = new ArrayList<Country>();
		
		countries.add(new Country("Unites States", "US"));
		countries.add(new Country("Canada", "CA"));
		countries.add(new Country("Mexico", "MX"));
		
		return countries;
	}
}
