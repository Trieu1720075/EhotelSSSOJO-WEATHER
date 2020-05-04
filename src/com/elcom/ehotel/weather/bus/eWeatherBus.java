package com.elcom.ehotel.weather.bus;

import java.util.List;

import com.elcom.ehotel.weather.object.ObjCountry;

public interface eWeatherBus {

	String deleteOldData();

	List<ObjCountry> getCountries();

	String asyncWeather(String countryidin, String sdayin, String tempin, String tempmaxin, String tempminin,
			String descriptionin, String imageurlin, String weatherdatein, String urllocalin, String humidity, String windSpeed);
}
