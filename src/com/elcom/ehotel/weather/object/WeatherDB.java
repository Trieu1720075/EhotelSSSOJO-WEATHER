package com.elcom.ehotel.weather.object;

public class WeatherDB {
	String countryID, sday, temp, tempmax, tempmin,humidity,windSpeed, description, image, weatherdate, imagelocation;

	public String getHumidity() {
		return humidity;
	}
	
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getWindSpeed() {
		return windSpeed;
	}
	
	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getCountryID() {
		return countryID;
	}

	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}

	public String getSday() {
		return sday;
	}

	public void setSday(String sday) {
		this.sday = sday;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getTempmax() {
		return tempmax;
	}

	public void setTempmax(String tempmax) {
		this.tempmax = tempmax;
	}

	public String getTempmin() {
		return tempmin;
	}

	public void setTempmin(String tempmin) {
		this.tempmin = tempmin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getWeatherdate() {
		return weatherdate;
	}

	public void setWeatherdate(String weatherdate) {
		this.weatherdate = weatherdate;
	}

	public String getImagelocation() {
		return imagelocation;
	}

	public void setImagelocation(String imagelocation) {
		this.imagelocation = imagelocation;
	}	
	
	public String toString() {
	    return countryID+" "+sday+" "+temp+" "+tempmax+" "+tempmin+" "+description+" "+humidity+" "+windSpeed+" "+image+" "+weatherdate+" "+imagelocation;
	}
}
