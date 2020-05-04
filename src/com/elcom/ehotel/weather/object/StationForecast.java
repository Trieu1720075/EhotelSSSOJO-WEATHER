package com.elcom.ehotel.weather.object;

public class StationForecast {
	ObjReturnDataSet ReturnDataSet;
//	"station_code" : 00205719,
//	"min_date" : 2019-09-26 00:00:00,
//	"max_date" : 2019-10-03 07:00:00
	String station_code, min_date, max_date;
	public ObjReturnDataSet getReturnDataSet() {
		return ReturnDataSet;
	}
	public void setReturnDataSet(ObjReturnDataSet returnDataSet) {
		ReturnDataSet = returnDataSet;
	}
	public String getStation_code() {
		return station_code;
	}
	public void setStation_code(String station_code) {
		this.station_code = station_code;
	}
	public String getMin_date() {
		return min_date;
	}
	public void setMin_date(String min_date) {
		this.min_date = min_date;
	}
	public String getMax_date() {
		return max_date;
	}
	public void setMax_date(String max_date) {
		this.max_date = max_date;
	}
	
	
}
