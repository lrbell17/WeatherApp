package com.weatherapp.model;

public class WeatherData {

	private String description;
	private double currentTemp;
	private double feelsLike;
	private double maxTemp;
	private double minTemp;
	private int pressure;
	private int humidity;
	private double windSpeed;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCurrentTemp() {
		return currentTemp;
	}
	public void setCurrentTemp(double currentTemp) {
		this.currentTemp = currentTemp;
	}
	public double getFeelsLike() {
		return feelsLike;
	}
	public void setFeelsLike(double feelsLike) {
		this.feelsLike = feelsLike;
	}
	public double getMaxTemp() {
		return maxTemp;
	}
	public void setMaxTemp(double maxTemp) {
		this.maxTemp = maxTemp;
	}
	public double getMinTemp() {
		return minTemp;
	}
	public void setMinTemp(double minTemp) {
		this.minTemp = minTemp;
	}
	public int getPressure() {
		return pressure;
	}
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
	
	@Override
	public String toString() {
		return "WeatherData [description=" + description + ", currentTemp=" + currentTemp + ", feelsLike=" + feelsLike
				+ ", maxTemp=" + maxTemp + ", minTemp=" + minTemp + ", pressure=" + pressure + ", humidity=" + humidity
				+ ", windspeed=" + windSpeed + "]";
	}
	
	
	
}
