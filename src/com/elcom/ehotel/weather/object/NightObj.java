package com.elcom.ehotel.weather.object;

public class NightObj {

//	 "Icon": 34,
//   "IconPhrase": "Mostly clear",
//   "HasPrecipitation": false
	String Icon,IconPhrase,HasPrecipitation;

	public String getIcon() {
		return Icon;
	}

	public void setIcon(String icon) {
		Icon = icon;
	}

	public String getIconPhrase() {
		return IconPhrase;
	}

	public void setIconPhrase(String iconPhrase) {
		IconPhrase = iconPhrase;
	}

	public String getHasPrecipitation() {
		return HasPrecipitation;
	}

	public void setHasPrecipitation(String hasPrecipitation) {
		HasPrecipitation = hasPrecipitation;
	}
}
