package com.elcom.ehotel.weather.object;

import java.util.List;

public class WeatherData {

//	"time" : 1571072400,
//	"summary" : Possible light rain in the afternoon.,
//	"icon" : rain,
//	"sunriseTime" : 1571092614,
//	"sunsetTime" : 1571135369,
//	"moonPhase" : 0.55,
//	"precipIntensity" : 0.1474,
//	"precipIntensityMax" : 0.7605,
//	"precipIntensityMaxTime" : 1571126400,
//	"precipProbability" : 0.61,
//	"precipType" : rain,
//	"temperatureHigh" : 23.9,
//	"temperatureHighTime" : 1571112000,
//	"temperatureLow" : 15.02,
//	"temperatureLowTime" : 1571169600,
//	"apparentTemperatureHigh" : 24.01,
//	"apparentTemperatureHighTime" : 1571112000,
//	"apparentTemperatureLow" : 15.58,
//	"apparentTemperatureLowTime" : 1571169600,
//	"dewPoint" : 17.73,
//	"humidity" : 0.97,
//	"pressure" : 1011.9,
//	"windSpeed" : 1.54,
//	"windGust" : 4.88,
//	"windGustTime" : 1571108400,
//	"windBearing" : 65,
//	"cloudCover" : 0.91,
//	"uvIndex" : 7,
//	"uvIndexTime" : 1571112000,
//	"visibility" : 15.073,
//	"ozone" : 261.8,
//	"temperatureMin" : 14.68,
//	"temperatureMinTime" : 1571083200,
//	"temperatureMax" : 23.9,
//	"temperatureMaxTime" : 1571112000,
//	"apparentTemperatureMin" : 15.21,
//	"apparentTemperatureMinTime" : 1571083200,
//	"apparentTemperatureMax" : 24.01,
//	"apparentTemperatureMaxTime" : 1571112000
	
	String time, summary,icon,sunriseTime,moonPhase,precipIntensity,precipIntensityMax,precipIntensityMaxTime, precipProbability,
	precipType,temperatureHigh,temperatureHighTime,temperatureLow,temperatureLowTime,apparentTemperatureHigh,apparentTemperatureHighTime,
	apparentTemperatureLow,apparentTemperatureLowTime,dewPoint,humidity,pressure,windSpeed,windGust,windGustTime,windBearing,
	cloudCover,uvIndex,uvIndexTime,visibility,ozone,temperatureMin,temperatureMinTime,temperatureMax,temperatureMaxTime,
	apparentTemperatureMin,apparentTemperatureMinTime,apparentTemperatureMax,apparentTemperatureMaxTime;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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

	public String getSunriseTime() {
		return sunriseTime;
	}

	public void setSunriseTime(String sunriseTime) {
		this.sunriseTime = sunriseTime;
	}

	public String getMoonPhase() {
		return moonPhase;
	}

	public void setMoonPhase(String moonPhase) {
		this.moonPhase = moonPhase;
	}

	public String getPrecipIntensity() {
		return precipIntensity;
	}

	public void setPrecipIntensity(String precipIntensity) {
		this.precipIntensity = precipIntensity;
	}

	public String getPrecipIntensityMax() {
		return precipIntensityMax;
	}

	public void setPrecipIntensityMax(String precipIntensityMax) {
		this.precipIntensityMax = precipIntensityMax;
	}

	public String getPrecipIntensityMaxTime() {
		return precipIntensityMaxTime;
	}

	public void setPrecipIntensityMaxTime(String precipIntensityMaxTime) {
		this.precipIntensityMaxTime = precipIntensityMaxTime;
	}

	public String getPrecipProbability() {
		return precipProbability;
	}

	public void setPrecipProbability(String precipProbability) {
		this.precipProbability = precipProbability;
	}

	public String getPrecipType() {
		return precipType;
	}

	public void setPrecipType(String precipType) {
		this.precipType = precipType;
	}

	public String getTemperatureHigh() {
		return temperatureHigh;
	}

	public void setTemperatureHigh(String temperatureHigh) {
		this.temperatureHigh = temperatureHigh;
	}

	public String getTemperatureHighTime() {
		return temperatureHighTime;
	}

	public void setTemperatureHighTime(String temperatureHighTime) {
		this.temperatureHighTime = temperatureHighTime;
	}

	public String getTemperatureLow() {
		return temperatureLow;
	}

	public void setTemperatureLow(String temperatureLow) {
		this.temperatureLow = temperatureLow;
	}

	public String getTemperatureLowTime() {
		return temperatureLowTime;
	}

	public void setTemperatureLowTime(String temperatureLowTime) {
		this.temperatureLowTime = temperatureLowTime;
	}

	public String getApparentTemperatureHigh() {
		return apparentTemperatureHigh;
	}

	public void setApparentTemperatureHigh(String apparentTemperatureHigh) {
		this.apparentTemperatureHigh = apparentTemperatureHigh;
	}

	public String getApparentTemperatureHighTime() {
		return apparentTemperatureHighTime;
	}

	public void setApparentTemperatureHighTime(String apparentTemperatureHighTime) {
		this.apparentTemperatureHighTime = apparentTemperatureHighTime;
	}

	public String getApparentTemperatureLow() {
		return apparentTemperatureLow;
	}

	public void setApparentTemperatureLow(String apparentTemperatureLow) {
		this.apparentTemperatureLow = apparentTemperatureLow;
	}

	public String getApparentTemperatureLowTime() {
		return apparentTemperatureLowTime;
	}

	public void setApparentTemperatureLowTime(String apparentTemperatureLowTime) {
		this.apparentTemperatureLowTime = apparentTemperatureLowTime;
	}

	public String getDewPoint() {
		return dewPoint;
	}

	public void setDewPoint(String dewPoint) {
		this.dewPoint = dewPoint;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getWindGust() {
		return windGust;
	}

	public void setWindGust(String windGust) {
		this.windGust = windGust;
	}

	public String getWindGustTime() {
		return windGustTime;
	}

	public void setWindGustTime(String windGustTime) {
		this.windGustTime = windGustTime;
	}

	public String getWindBearing() {
		return windBearing;
	}

	public void setWindBearing(String windBearing) {
		this.windBearing = windBearing;
	}

	public String getCloudCover() {
		return cloudCover;
	}

	public void setCloudCover(String cloudCover) {
		this.cloudCover = cloudCover;
	}

	public String getUvIndex() {
		return uvIndex;
	}

	public void setUvIndex(String uvIndex) {
		this.uvIndex = uvIndex;
	}

	public String getUvIndexTime() {
		return uvIndexTime;
	}

	public void setUvIndexTime(String uvIndexTime) {
		this.uvIndexTime = uvIndexTime;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getOzone() {
		return ozone;
	}

	public void setOzone(String ozone) {
		this.ozone = ozone;
	}

	public String getTemperatureMin() {
		return temperatureMin;
	}

	public void setTemperatureMin(String temperatureMin) {
		this.temperatureMin = temperatureMin;
	}

	public String getTemperatureMinTime() {
		return temperatureMinTime;
	}

	public void setTemperatureMinTime(String temperatureMinTime) {
		this.temperatureMinTime = temperatureMinTime;
	}

	public String getTemperatureMax() {
		return temperatureMax;
	}

	public void setTemperatureMax(String temperatureMax) {
		this.temperatureMax = temperatureMax;
	}

	public String getTemperatureMaxTime() {
		return temperatureMaxTime;
	}

	public void setTemperatureMaxTime(String temperatureMaxTime) {
		this.temperatureMaxTime = temperatureMaxTime;
	}

	public String getApparentTemperatureMin() {
		return apparentTemperatureMin;
	}

	public void setApparentTemperatureMin(String apparentTemperatureMin) {
		this.apparentTemperatureMin = apparentTemperatureMin;
	}

	public String getApparentTemperatureMinTime() {
		return apparentTemperatureMinTime;
	}

	public void setApparentTemperatureMinTime(String apparentTemperatureMinTime) {
		this.apparentTemperatureMinTime = apparentTemperatureMinTime;
	}

	public String getApparentTemperatureMax() {
		return apparentTemperatureMax;
	}

	public void setApparentTemperatureMax(String apparentTemperatureMax) {
		this.apparentTemperatureMax = apparentTemperatureMax;
	}

	public String getApparentTemperatureMaxTime() {
		return apparentTemperatureMaxTime;
	}

	public void setApparentTemperatureMaxTime(String apparentTemperatureMaxTime) {
		this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
	}
}
