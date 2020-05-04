package com.elcom.ehotel.weather.object;

public class ObjCountry {
	String id, name, weathercode;
	
	public ObjCountry(String id, String name, String code)
	{
		this.id=id;
		this.name=name;
		this.weathercode=code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeathercode() {
		return weathercode;
	}

	public void setWeathercode(String weathercode) {
		this.weathercode = weathercode;
	}
	
	
}
