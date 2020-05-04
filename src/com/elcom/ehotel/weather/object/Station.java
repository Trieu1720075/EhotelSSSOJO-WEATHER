package com.elcom.ehotel.weather.object;

public class Station {

//	"id" : 78,
//	"station_name" : Hai Phong - Cat Ba - Flamigo Cat Ba,
//	"station_code" : 00205719,
//	"latitude" : 20.8,
//	"longtitude" : 106.999,
//	"altitude" : 84.48,
//	"current_date" : 2019-09-26T17:00:07,
//	"forecast" : 1,
//	"msisdn" : ,
//	"topup_value" : 0,
//	"expired_date" : 2018-01-01T00:00:00,
//	"operator" : VTL,
//	"topup_status" : 0,
//	"rain24h" : 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
//	"rain7days" : 0,0,0,0,0,0,0,
//	"station_type" : PESSL,
//	"province_code" : HPG,
//	"province_name" : Hải Phòng,
//	"note" : Hai Phong-HaiPhong-HPG,
	
	String id,station_name,station_code,latitude,longtitude, altitude,current_date,forecast,msisdn,
	topup_value,expired_date,operator,topup_status,rain24h,rain7days, station_type,province_code,province_name,note;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStation_name() {
		return station_name;
	}

	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}

	public String getStation_code() {
		return station_code;
	}

	public void setStation_code(String station_code) {
		this.station_code = station_code;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public String getCurrent_date() {
		return current_date;
	}

	public void setCurrent_date(String current_date) {
		this.current_date = current_date;
	}

	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getTopup_value() {
		return topup_value;
	}

	public void setTopup_value(String topup_value) {
		this.topup_value = topup_value;
	}

	public String getExpired_date() {
		return expired_date;
	}

	public void setExpired_date(String expired_date) {
		this.expired_date = expired_date;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getTopup_status() {
		return topup_status;
	}

	public void setTopup_status(String topup_status) {
		this.topup_status = topup_status;
	}

	public String getRain24h() {
		return rain24h;
	}

	public void setRain24h(String rain24h) {
		this.rain24h = rain24h;
	}

	public String getRain7days() {
		return rain7days;
	}

	public void setRain7days(String rain7days) {
		this.rain7days = rain7days;
	}

	public String getStation_type() {
		return station_type;
	}

	public void setStation_type(String station_type) {
		this.station_type = station_type;
	}

	public String getProvince_code() {
		return province_code;
	}

	public void setProvince_code(String province_code) {
		this.province_code = province_code;
	}

	public String getProvince_name() {
		return province_name;
	}

	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
}
