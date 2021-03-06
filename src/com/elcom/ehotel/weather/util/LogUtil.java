package com.elcom.ehotel.weather.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import com.elcom.DBI.SubProParam;

public class LogUtil {

	/*
	 * public static void logControl(String cla, String action, String rq) { System.out.print("{Log [" + new
	 * SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "] [" + cla + "] [action=" + action + "] with request ["); if
	 * (rq.equals("none")) { System.out.println("none]}"); return; }
	 * 
	 * String[] arr = rq.split(",,,"); int size = arr.length; if (size % 2 != 0) size--; for (int i = 0; i < size; i = i + 2) { if (i > 0)
	 * System.out.print(" "); System.out.print(arr[i] + "=" + arr[i + 1] + ""); if (i == size - 2) System.out.println("]}"); } }
	 */
	public static void logControl(String cla, String action, String rq) {
		System.out.print("{Log [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "] [" + cla + "] [action=" + action
				+ "] with request [");
		if (rq.equals("none")) {
			System.out.println("none]}");
			return;
		}

		String[] arr = rq.split("\\|");
		int size = arr.length;
		if (size % 2 != 0)
			size--;
		for (int i = 0; i < size; i = i + 2) {
			if (i > 0)
				System.out.print(" ");
			System.out.print(arr[i] + "=" + arr[i + 1] + "");
			if (i == size - 2)
				System.out.println("]}");
		}
	}

	public static void logDao(String cla, String function, Vector<SubProParam> params, String tt, int rt) {
		System.out.print("{Log [" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "] [" + cla + "] [proc=" + function
				+ "] with params [");
		if (tt.equals("none")) {
			System.out.print("none]");
			System.out.println(" return value: " + rt + "]}");
			return;
		}
		String[] arr = tt.split(",");
		for (int i = 0; i < params.size() - 1; i++) {
			if (i > 0)
				System.out.print(" ");
			System.out.print(arr[i] + "=" + params.get(i).getValue().toString());
		}
		System.out.println(" return value: " + rt + "]}");
	}

	public static void main(String[] args) {
	}
}
