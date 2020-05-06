package com.elcom.ehotel.weather.dao;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.CORBA.INITIALIZE;

import com.elcom.DBI.SubProParam;
import com.elcom.ehotel.weather.object.ObjCountry;
import com.elcom.ehotel.weather.util.LogUtil;
import com.elcom.ehotel.weather.util.Param;
import com.elcom.ehotel.weather.util.SQL;

public class eWeatherDao {

	@SuppressWarnings("unchecked")
	public List<ObjCountry> getCountry() {
		List<ObjCountry> list = new ArrayList<>();
		Vector<SubProParam> params = new Vector<SubProParam>();
		Vector<String> outParam = new Vector<String>();
		SubProParam subOut = new SubProParam(outParam, "STRING_ARR", 1);
		params.add(subOut);
		try {
			params = SQL.broker.executeSubPro(SQL.GET_COUNTRIES, params);
			if ((params != null) & (params.size() > 0)) {
				subOut = (SubProParam) params.get(0);
				outParam = subOut.getVector();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (outParam.size() > 0) {
			LogUtil.logDao(eWeatherDao.class.toString(), SQL.GET_COUNTRIES, params, "none", outParam.size() / 3);
			for (int i = 0; i < outParam.size(); i = i + 3) {
				ObjCountry country = new ObjCountry(outParam.get(i), outParam.get(i + 1), outParam.get(i + 2));
				list.add(country);
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public int clearDataOld() {
		int rs = 0;
		Vector<SubProParam> params = new Vector<SubProParam>();
		Vector<String> outParam = new Vector<String>();

		SubProParam subOut = new SubProParam(outParam, "STRING_ARR", 1);
		params.add(subOut);
		try {
			params = SQL.broker.executeSubPro(SQL.CLEAR_OLDDATA, params);
			if ((params != null) & (params.size() > 0)) {
				subOut = (SubProParam) params.get(0);
				outParam = subOut.getVector();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (outParam.size() > 0) {
			LogUtil.logDao(eWeatherDao.class.toString(), SQL.CLEAR_OLDDATA, params, "none", outParam.size() / 1);
			for (int i = 0; i < outParam.size(); i = i + 1) {
				rs = Integer.parseInt(outParam.get(i));
			}
		}
		return rs;
	}
	
	@SuppressWarnings("unchecked")
	public String insertWeather(String countryidin, String sdayin, String tempin, String tempmaxin, String tempminin,
			String descriptionin, String imageurlin, String weatherdatein, String urllocalin, String humidity, String windSpeed) {
		String rs = "-1";
		Vector<SubProParam> params = new Vector<SubProParam>();

		SubProParam param = new SubProParam(new String(countryidin), SubProParam.IN);
		params.add(param);
		param = new SubProParam(new String(sdayin), SubProParam.IN);
		params.add(param);
		param = new SubProParam(new String(tempin), SubProParam.IN);
		params.add(param);
		param = new SubProParam(new String(tempmaxin), SubProParam.IN);
		params.add(param);
		param = new SubProParam(new String(tempminin), SubProParam.IN);
		params.add(param);
		param = new SubProParam(new String(descriptionin), SubProParam.IN);
		params.add(param);
		param = new SubProParam(new String(imageurlin), SubProParam.IN);
		params.add(param);
		param = new SubProParam(new String(weatherdatein), SubProParam.IN);
		params.add(param);
		param = new SubProParam(new String(urllocalin), SubProParam.IN);
		params.add(param);
		param = new SubProParam(new String(humidity), SubProParam.IN);
		params.add(param);
		param = new SubProParam(new String(windSpeed), SubProParam.IN);
		params.add(param);

		String outParam = new String();
		SubProParam subOut = new SubProParam(outParam, 1);
		params.add(subOut);
		try {
			params = SQL.broker.executeSubPro(SQL.INSERT_WEATHER, params);
			if ((params != null) & (params.size() > 0)) {
				SubProParam paramOut = (SubProParam) params.get(params.size() - 1);
				rs = paramOut.getString().trim();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return rs;
	}

}
