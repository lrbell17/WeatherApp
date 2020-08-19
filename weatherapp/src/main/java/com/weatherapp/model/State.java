package com.weatherapp.model;

public class State {

	private String stateName;
	private String stateCode;
	
	public State(String stateName, String stateCode) {
		super();
		this.stateName = stateName;
		this.stateCode = stateCode;
	}
	
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	
	
	
}
