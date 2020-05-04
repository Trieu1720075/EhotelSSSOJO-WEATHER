package com.elcom.ehotel.weather.object;

import java.util.List;

public class DailyForecast {
	
	List<WeatherData> data;
	String summary, icon;
	public List<WeatherData> getData() {
		return data;
	}
	public void setData(List<WeatherData> data) {
		this.data = data;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
}
