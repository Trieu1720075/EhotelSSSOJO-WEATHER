package com.elcom.ehotel.weather.util;

import com.elcom.ehotel.weather.dbi.IMBroker;

public class SQL {
	public static IMBroker broker = IMBroker.getInstance();
	public static final String GET_COUNTRIES = "{call WEATHER.getCountryList(?)}";
	public static final String CLEAR_OLDDATA = "{call WEATHER.clearOldData(?)}";
	public static final String ASYN_WEATHER = "{call WEATHER.asyncWeather(?,?,?,?,?,?,?,?,?,?)}";
}
