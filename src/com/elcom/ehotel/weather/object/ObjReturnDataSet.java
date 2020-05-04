package com.elcom.ehotel.weather.object;

import java.util.List;

public class ObjReturnDataSet {
	List<Sensor> sensors;
	List<Data> data;
	Date dates;
	public List<Sensor> getSensors() {
		return sensors;
	}
	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}
	public List<Data> getData() {
		return data;
	}
	public void setData(List<Data> data) {
		this.data = data;
	}
	public Date getDates() {
		return dates;
	}
	public void setDates(Date dates) {
		this.dates = dates;
	}
	
}
