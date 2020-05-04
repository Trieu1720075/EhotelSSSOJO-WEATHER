package com.elcom.ehotel.weather.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

	private String dbiHost = "";
	private String dbiPort = "";

	private String daynum = "";
	private String key = "";
	private String pathimage = "";
	private String pathapi = "";
	private String user = "";
	private String pass = "";


	public String getDbiHost() {
		return dbiHost;
	}

	public void setDbiHost(String dbiHost) {
		this.dbiHost = dbiHost;
	}

	public String getDbiPort() {
		return dbiPort;
	}

	public void setDbiPort(String dbiPort) {
		this.dbiPort = dbiPort;
	}

	public String getDaynum() {
		return daynum;
	}

	public void setDaynum(String daynum) {
		this.daynum = daynum;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	

	public String getPath() {
		return pathimage;
	}

	public void setPath(String pathimage) {
		this.pathimage = pathimage;
	}

	
	
	public String getPathimage() {
		return pathimage;
	}

	public void setPathimage(String pathimage) {
		this.pathimage = pathimage;
	}

	public String getPathapi() {
		return pathapi;
	}

	public void setPathapi(String pathapi) {
		this.pathapi = pathapi;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Config [dbiHost=" + dbiHost + ", dbiPort=" + dbiPort + "]";
	}

	public Config() {
		String path = "Config/config.properties";
		System.out.println(path);
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(path);
			prop.load(input);
			dbiHost = prop.getProperty("dbi.host");
			dbiPort = prop.getProperty("dbi.port");
			daynum = prop.getProperty("data.daynum");
			key = prop.getProperty("data.key");
			pathimage = prop.getProperty("data.path");
			pathapi = prop.getProperty("data.pathapi");
			user = prop.getProperty("data.user");
			pass = prop.getProperty("data.pass");
			System.out.println(toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
