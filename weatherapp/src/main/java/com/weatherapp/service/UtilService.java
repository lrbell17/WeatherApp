package com.weatherapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Service;

import com.weatherapp.model.WeatherData;

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
	
	public String jsonParser(String jsonStr, String outerField, String innerField) {

		try {
		
			// get first (outer) field
			JSONParser parser = new JSONParser(jsonStr);
			LinkedHashMap<String, Object> items = parser.parseObject();
	
			// convert back to JSON format
			String main = items.get(outerField).toString().replace("=", ":").replace("_", "").replace("[", "")
					.replace("]", "");
			
			// 'weather' contains non-numerical data --> parsing is more tricky
			if (outerField.equals("weather")) {
				main = handleWeatherDescription(main);
			}

			// extract 2nd (inner) field
			JSONParser parserMain = new JSONParser(main);
			LinkedHashMap<String, Object> itemsMain = parserMain.parseObject();
			
			return itemsMain.get(innerField).toString();

		} catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	// Construct WeatherData object from json
	public WeatherData getWeatherDataObject(String jsonStr) {
		WeatherData weather = new WeatherData();
		
		// calling jsonParser() to extract desired fields from json response
		weather.setDescription(jsonParser(jsonStr, "weather", "description"));
		weather.setCurrentTemp(Double.parseDouble(jsonParser(jsonStr, "main", "temp")));
		weather.setFeelsLike(Double.parseDouble(jsonParser(jsonStr, "main", "feelslike")));
		weather.setFeelsLike(Double.parseDouble(jsonParser(jsonStr, "main", "feelslike")));
		weather.setMaxTemp(Double.parseDouble(jsonParser(jsonStr, "main", "tempmax")));
		weather.setMinTemp(Double.parseDouble(jsonParser(jsonStr, "main", "tempmin")));
		weather.setPressure(Integer.parseInt(jsonParser(jsonStr, "main", "pressure")));
		weather.setHumidity(Integer.parseInt(jsonParser(jsonStr, "main", "humidity")));
		weather.setWindSpeed(Double.parseDouble(jsonParser(jsonStr, "wind", "speed")));
		
		return weather;
	}
	
	public String handleWeatherDescription(String main) {
		String[] strArr = main.split(",");
		
		List<StringBuilder> sbList = new ArrayList<StringBuilder>();
		
		for (String str : strArr) {
			sbList.add(new StringBuilder(str));
		}
	
		// have to go through and re-insert quotes
		sbList.get(1).insert(6, "'");
		sbList.get(1).insert(sbList.get(1).length(), "'");
		
		sbList.get(2).insert(13, "'");
		sbList.get(2).insert(sbList.get(2).length(), "'");
		
		sbList.get(3).insert(6, "'");
		sbList.get(3).insert(sbList.get(3).length()-1, "'");
		
		return sbList.get(0).toString() + ", " + sbList.get(1) + ", " + sbList.get(2) + ", " + sbList.get(3);
		
	}
	
	
	
}









