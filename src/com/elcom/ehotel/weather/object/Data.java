package com.elcom.ehotel.weather.object;

public class Data {
	
//	"latitude" : 11.928703,
//	"longitude" : 108.452795,
//	"timezone" : Asia/Ho_Chi_Minh,
//	"currently" : +{ ... },
//	"hourly" : +{ ... },
//	"daily" : -{
	
	String latitude,longitude,timezone;
	DailyForecast daily;
	CurrentlyForecast currently;
	
	public CurrentlyForecast getCurrently() {
		return currently;
	}
	
	public void setCurrently(CurrentlyForecast currently) {
		this.currently = currently;
	}
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public DailyForecast getDaily() {
		return daily;
	}
	public void setDaily(DailyForecast daily) {
		this.daily = daily;
	}
	
	
}
