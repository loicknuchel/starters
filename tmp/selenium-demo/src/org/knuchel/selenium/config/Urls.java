package org.knuchel.selenium.config;

import java.util.HashMap;
import java.util.Map;

import org.knuchel.selenium.beans.Env;

public class Urls {
	private static final Map<Env, String> BASE_URL = new HashMap<Env, String>();

	static {
		BASE_URL.put(Env.LOCAL, "http://localhost:9000"); // url locale
		BASE_URL.put(Env.DEV, "https://www.google.fr/"); // url de dev
		BASE_URL.put(Env.TEST, "https://www.google.fr/"); // url de test
		BASE_URL.put(Env.RECETTE, "https://www.google.fr/"); // url de recette
		BASE_URL.put(Env.PREPROD, "https://www.google.fr/"); // url de preprod
		BASE_URL.put(Env.PROD, "https://www.google.fr/"); // url de prod
	}

	public static String getBaseUrl() {
		return BASE_URL.get(Config.ENV);
	}

	public static String getComputerListUrl() {
		return "/computers";
	}

	public static boolean isComputerListUrl(String url) {
		return url.matches(getBaseUrl() + getComputerListUrl() + "(\\?f=[^&#]*)?");
	}

	public static String getNewComputerUrl() {
		return "/computers/new";
	}

	public static boolean isNewComputerUrl(String url) {
		return url.matches(getBaseUrl() + getNewComputerUrl());
	}

	public static String getComputerUrl(Integer computerId) {
		if (computerId != null) {
			return "/computers/" + computerId;
		}
		throw new IllegalArgumentException("computerId can't be null !!");
	}

	public static boolean isComputerUrl(String url) {
		return url.matches(getBaseUrl() + "/computers/[0-9]+");
	}

	private static String urlParams(String... paramNames) {
		// TODO paramètres facultatifs !
		String ret = "";
		if (paramNames != null) {
			boolean first = true;
			for (String param : paramNames) {
				if (first) {
					ret += "(\\?" + param + "=[^&#]*";
					first = false;
				} else {
					ret += "&" + param + "=[^&#]*";
				}
			}
			ret += ")?";
		}
		return ret;
	}

	private static String urlAnchor() {
		return "(#.*)?";
	}
}
