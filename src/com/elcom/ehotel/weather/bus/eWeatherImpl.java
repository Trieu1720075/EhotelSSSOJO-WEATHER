package com.elcom.ehotel.weather.bus;

import java.util.List;

import com.elcom.ehotel.weather.dao.eWeatherDao;
import com.elcom.ehotel.weather.object.ObjCountry;

public class eWeatherImpl implements eWeatherBus {
	private eWeatherDao eWeather = new eWeatherDao();

	@Override
	public String deleteOldData() {
		// TODO Auto-generated method stub
		int rs = eWeather.clearDataOld();
		return rs + "";
	}

	@Override
	public List<ObjCountry> getCountries() {
		// TODO Auto-generated method stub
		List<ObjCountry> lst = eWeather.getCountry();
		return lst;
	}

	@Override
	public String asyncWeather(String countryidin, String sdayin, String tempin, String tempmaxin, String tempminin,
			String descriptionin, String imageurlin, String weatherdatein, String urllocalin, String humidity, String windSpeed) {
		// TODO Auto-generated method stub
		int rs = eWeather.asynDataWeather(countryidin, sdayin, tempin, tempmaxin, tempminin, descriptionin, imageurlin,
				weatherdatein, urllocalin, humidity, windSpeed);
		return rs + "";
	}

}
