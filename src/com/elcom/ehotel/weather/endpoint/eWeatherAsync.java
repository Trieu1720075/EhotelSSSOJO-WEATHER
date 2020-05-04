package com.elcom.ehotel.weather.endpoint;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

import org.json.JSONArray;

import com.elcom.ehotel.weather.bus.eWeatherImpl;
import com.elcom.ehotel.weather.object.CurrentlyForecast;
import com.elcom.ehotel.weather.object.DailyForecast;
import com.elcom.ehotel.weather.object.Data;
import com.elcom.ehotel.weather.object.LoginReponse;
import com.elcom.ehotel.weather.object.ObjCountry;
import com.elcom.ehotel.weather.object.ObjReturnDataSet;
import com.elcom.ehotel.weather.object.ResponseData;
import com.elcom.ehotel.weather.object.Station;
import com.elcom.ehotel.weather.object.StationForecast;
import com.elcom.ehotel.weather.object.WeatherDB;
import com.elcom.ehotel.weather.object.WeatherData;
import com.elcom.ehotel.weather.util.Config;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.weatherlibrary.datamodel.WeatherModel;
import com.weatherlibraryjava.IRepository;
import com.weatherlibraryjava.Repository;
import com.weatherlibraryjava.RequestBlocks;

public class eWeatherAsync {

	static String imagePath = "https://darksky.net/images/weather-icons/%s";
	static String baseUrl = "https://api.darksky.net/forecast/%s/%s?units=si";

	public static void main(String[] args) {
		Config config = new Config();
		eWeatherImpl daily = new eWeatherImpl();
		eWeatherImpl current = new eWeatherImpl();

		List<WeatherDB> lstDailyWeather = new ArrayList<>();
		List<WeatherDB> lstCurentWeather = new ArrayList<>();
		// System.out.println(login.getApiKey());
		List<ObjCountry> countries = daily.getCountries();
		System.out.println("---------------------------------------Start async data----------------------------------");
		// for (int i = 0; i < stations.size(); i++) {
		// System.out.println(stations.get(i).getProvince_name());
		// }

		for (int i = 0; i < countries.size(); i++) {
			// System.out.println(countries.get(i).getWeathercode());
			try {
				List<WeatherData> dataDaily = getDataDailyWeather(config.getKey(), countries.get(i).getWeathercode());
				CurrentlyForecast dataCurrent = getDataCurrentWeather(config.getKey(), countries.get(i).getWeathercode());
				// System.out.println(data.getReturnDataSet().getData().get(0).getSens_aver_0_110005000());
				lstDailyWeather = processDailyData(dataDaily, countries.get(i).getId());
				lstCurentWeather = processCurrentlyData(dataCurrent, countries.get(i).getId());
			} catch (Exception ex) {
				ex.printStackTrace();

			}
		}

		if (lstCurentWeather.size() > 0) {
			System.out.println(
					"---------------------------------------Delete Daily old data----------------------------------");
			daily.deleteOldData();
			for (int i = 0; i < lstCurentWeather.size(); i++) {
				WeatherDB dailyItem = lstCurentWeather.get(i);
				System.out.println(dailyItem.toString());
				try {
					String des_file = dailyItem.getImage();
					// save image to local
					saveImage(String.format(imagePath, dailyItem.getImage()), config.getPath() + "/" + des_file);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				daily.asyncWeather(dailyItem.getCountryID(), dailyItem.getSday(), dailyItem.getTemp(), dailyItem.getTempmax(),
						dailyItem.getTempmin(), dailyItem.getDescription(), dailyItem.getImage(), dailyItem.getWeatherdate(),
						dailyItem.getImagelocation(), dailyItem.getWindSpeed(), dailyItem.getHumidity());
			}
			
		

			System.out.println(
					"---------------------------------------Async data done----------------------------------");

		}else {
			System.out
					.println("---------------------------------------No data found----------------------------------");

		}

		// List<ObjCountry> countries = a.getCountries();
		// System.out.println("---------------------------------------Start
		// async data----------------------------------");
		// List<WeatherModel> arraydata = AsynWeatherData(config.getKey(),
		// countries,
		// Integer.parseInt(config.getDaynum()));
		//
		//
		// if (arraydata.size() > 0) {
		// System.out.println(
		// "---------------------------------------Delete old
		// data----------------------------------");
		// a.deleteOldData();
		// for (int i = 0; i < arraydata.size(); i++) {
		// WeatherModel obj = arraydata.get(i);
		// System.out.println(obj.toString());
		// for (int j = 0; j < Integer.parseInt(config.getDaynum()); j++) {
		//
		// String sdayin =
		// convertToDayOfWeek(obj.forecast.forecastday.get(j).date);
		// String tempin =
		// parse(obj.forecast.forecastday.get(j).getDay().avgtemp_c);
		// String tempmaxin =
		// parse(obj.forecast.forecastday.get(j).getDay().maxtemp_c);
		// String tempminin =
		// parse(obj.forecast.forecastday.get(j).getDay().mintemp_c);
		// String descriptionin =
		// obj.forecast.forecastday.get(j).getDay().getCondition().text;
		// String imageurlin =
		// obj.forecast.forecastday.get(j).getDay().getCondition().icon;
		// String weatherdatein = obj.forecast.forecastday.get(j).date;
		//
		// try {
		// String des_file = imageurlin.substring(imageurlin.lastIndexOf("/") +
		// 1, imageurlin.length());
		// // save image to local
		// saveImage("http:" + imageurlin, config.getPath() + "/" + des_file);
		// } catch (Exception e) {
		// // TODO: handle exception
		// e.printStackTrace();
		// }
		// String urllocalin = imageurlin.substring(imageurlin.lastIndexOf("/")
		// + 1, imageurlin.length());
		// a.asyncWeather(countries.get(i).getId(), sdayin, tempin, tempmaxin,
		// tempminin, descriptionin,
		// imageurlin, weatherdatein, urllocalin);
		// }
		// }
		// System.out.println(
		// "---------------------------------------Async data
		// done----------------------------------");
		//
		// } else {
		// System.out
		// .println("---------------------------------------No data
		// found----------------------------------");
		//
		// }
	}

	private static void saveImage(String imageUrl, String destinationFile) throws Exception {
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}
		is.close();
		os.close();
	}

	public static String parse(double num) {
		if ((int) num == num)
			return Integer.toString((int) num);
		return String.valueOf(num);
	}

	public static List<WeatherModel> AsynWeatherData(String key, List<ObjCountry> countries, int numday) {
		List<WeatherModel> rs = new ArrayList<>();
		for (int i = 0; i < countries.size(); i++) {
			// try {
			// Thread.sleep(20000);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			rs.add(AsynWeatherWeb(key, countries.get(i).getWeathercode(), numday));
		}
		return rs;
	}

	public static WeatherModel AsynWeatherWeb(String key, String namecity, int numday) {

		IRepository repo = new Repository();

		try {
			WeatherModel weatherModel = repo.GetWeatherData(key, RequestBlocks.GetBy.CityName, namecity, numday);
			// System.out.println("WeatherTestJava : location
			// name==============>" + weatherModel.location.name + ", "
			// + weatherModel.location.country);
			// System.out.println("WeatherTestJava : last update==============>"
			// + weatherModel.current.last_updated);
			// System.out.println("WeatherTestJava : Temp==============>" +
			// weatherModel.current.temp_c);
			// for (int i = 0; i < numday; i++) {
			// System.out.println(
			// "WeatherTestJava : Day==============>" +
			// weatherModel.forecast.forecastday.get(i).date);
			// System.out.println("WeatherTestJava : Temp==============>"
			// + weatherModel.forecast.forecastday.get(i).getDay().avgtemp_c);
			// System.out.println("WeatherTestJava : Temp MAX==============>"
			// + weatherModel.forecast.forecastday.get(i).getDay().maxtemp_c);
			// System.out.println("WeatherTestJava : Temp MIN==============>"
			// + weatherModel.forecast.forecastday.get(i).getDay().mintemp_c);
			// System.out.println("WeatherTestJava : Temp
			// Description==============>"
			// +
			// weatherModel.forecast.forecastday.get(i).getDay().getCondition().text);
			// System.out.println("WeatherTestJava : Temp Image==============>"
			// +
			// weatherModel.forecast.forecastday.get(i).getDay().getCondition().icon);
			// }
			return weatherModel;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 2019-09-27 00:00:00

	public static String convertToDayOfWeek(String datein) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
		Date date = null;
		try {
			date = format.parse(datein);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.US);
		calendar.setTime(date);
		String dateString = date.toString().split(" ")[0];
		if (dateString.toLowerCase().compareTo("sun") == 0)
			return "8";
		else if (dateString.toLowerCase().compareTo("sat") == 0)
			return "7";
		else if (dateString.toLowerCase().compareTo("fri") == 0)
			return "6";
		else if (dateString.toLowerCase().compareTo("thu") == 0)
			return "5";
		else if (dateString.toLowerCase().compareTo("wed") == 0)
			return "4";
		else if (dateString.toLowerCase().compareTo("tue") == 0)
			return "3";
		else
			return "2";
	}

	static List<WeatherData> getDataDailyWeather(String token, String stationcode) {
		// http://dataservice.accuweather.com/forecasts/v1/daily/5day/01?apikey=RIxIfBd6UA7smSGyIsfAsMbFWm5QxGg4&unit=17

		String request = String.format(baseUrl, token, stationcode);
		String response = getRequest(request);

		System.out.println(request);
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		System.out.println(response);

		JsonObject object = (JsonObject) parser.parse(response);
		Data emp = gson.fromJson(object, Data.class);

		List<WeatherData> rs = emp.getDaily().getData();

		return rs;
	}
	
	static CurrentlyForecast getDataCurrentWeather(String token, String stationcode) {

		String request = String.format(baseUrl, token, stationcode);
		String response = getRequest(request);

		System.out.println(request);
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		System.out.println(response);

		JsonObject object = (JsonObject) parser.parse(response);
		Data emp = gson.fromJson(object, Data.class);

		CurrentlyForecast rs = emp.getCurrently();

		return rs;
	}
	
	static String getRequest(String baseUrl) {
		String rs = "";
		try {
			// String url = "http://api.agrimedia.vn/WeatherServices.asmx";
			// http://dataservice.accuweather.com/forecasts/v1/daily/5day/01?apikey=RIxIfBd6UA7smSGyIsfAsMbFWm5QxGg4&unit=17
			String url = baseUrl;
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
			con.setDoOutput(true);

			String responseStatus = con.getResponseMessage();
			// System.out.println(responseStatus);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// System.out.println("response:" + response.toString());
			rs = response.toString();
		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}

	static List<WeatherDB> listWeatherDB = new ArrayList<>();

	static List<WeatherDB> processDailyData(List<WeatherData> datas, String countryID) {
		for (int i = 0; i < datas.size(); i++) {
			WeatherData data = datas.get(i);
			String time = convertToTime(data.getTime());
//			if (compareTime(getCurrentTime(), time) <= 0) {
				WeatherDB db = new WeatherDB();
				db.setCountryID(countryID);
				db.setDescription(data.getSummary());
				db.setImage(getImage(data));
				db.setImagelocation(getImage(data));
				System.out.println(time);
				db.setSday(convertToDayOfWeek(time));
				db.setTemp(data.getTemperatureHigh());
				db.setTempmax(data.getTemperatureMax());
				db.setTempmin(data.getTemperatureMin());
				db.setWeatherdate(getStringDate(time));
				db.setHumidity(data.getHumidity());
				db.setWindSpeed(data.getWindSpeed());
				listWeatherDB.add(db);
//			}
		}
		return listWeatherDB;
	}
	
	static List<WeatherDB> processCurrentlyData(CurrentlyForecast datas, String countryID) {
//			if (compareTime(getCurrentTime(), time) <= 0) {
				WeatherDB db = new WeatherDB();
				db.setCountryID(countryID);
				db.setHumidity(datas.getHumidity());
				db.setTemp(datas.getTemperature());
				db.setWindSpeed(datas.getWindSpeed());
//				db.setDescription(data.getSummary());
//				db.setImage(getImage(data));
//				db.setImagelocation(getImage(data));
//				System.out.println(time);
//				db.setSday(convertToDayOfWeek(time));
//				db.setTemp(data.getTemperatureHigh());
//				db.setTempmax(data.getTemperatureMax());
//				db.setTempmin(data.getTemperatureMin());
//				db.setWeatherdate(getStringDate(time));
//				db.setHumidity(data.getHumidity());
//				db.setWindSpeed(data.getWindSpeed());
				listWeatherDB.add(db);
//			}
		
		return listWeatherDB;
	}

	public static String convertToTime(String milisecon) {
		// Creating date format
		DateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// Creating date from milliseconds
		// using Date() constructor
		Date result = new Date(Long.parseLong(milisecon + "000"));

		// Formatting Date according to the
		// given format
		return simple.format(result);
	}

	public static String FahrenheitToCelsius(String fTemp) {
		double celsius = (Double.parseDouble(fTemp) - 32) * 5 / 9;
		double roundOff = Math.round(celsius * 100) / 100;
		return roundOff + "";
	}

	static String getCurrentTime() {
		// 2019-09-27 00:00:00
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return formatter.format(date);
	}

	static String getStringAddHourDate(String strDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

		Date date = null;
		try {
			date = format.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		long hour = 3600 * 1000; // 3600 seconds times 1000 milliseconds
		Date anotherDate = new Date(date.getTime() + hour);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDateRs = formatter.format(anotherDate);
		return strDateRs;
	}

	static private int compareTime(String time1, String time2) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
		try {
			Date date1 = df.parse(time1);
			Date date2 = df.parse(time2);
			return date1.compareTo(date2);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -2;
	}

	static int getPosition(WeatherDB weather) {
		for (int i = 0; i < listWeatherDB.size(); i++) {
			WeatherDB item = listWeatherDB.get(i);
			if (weather.getCountryID().compareTo(item.getCountryID()) == 0) {
				if (weather.getWeatherdate().compareTo(item.getWeatherdate()) == 0) {
					return i;
				}
			}
		}
		return -1;
	}

	static String getStringDate(String strDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

		Date date = null;
		try {
			date = format.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String strDateRs = formatter.format(date);
		return strDateRs;
	}

	static String getImage(WeatherData data) {
		// String
		// img=String.format("https://www.accuweather.com/images/weathericons/%s.svg",
		// data.getDay().getIcon());
		return data.getIcon() + ".png";
	}
}
