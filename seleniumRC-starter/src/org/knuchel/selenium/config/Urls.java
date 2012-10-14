package org.knuchel.selenium.config;

import java.util.HashMap;
import java.util.Map;

import org.knuchel.selenium.beans.Env;

public class Urls {
	private static final Map<Env, String> BASE_URL = new HashMap<Env, String>();

	static {
		BASE_URL.put(Env.LOCAL, "https://www.google.fr/"); // url locale
		BASE_URL.put(Env.DEV, "https://www.google.fr/"); // url de dev
		BASE_URL.put(Env.TEST, "https://www.google.fr/"); // url de test
		BASE_URL.put(Env.RECETTE, "https://www.google.fr/"); // url de recette
		BASE_URL.put(Env.PREPROD, "https://www.google.fr/"); // url de preprod
		BASE_URL.put(Env.PROD, "https://www.google.fr/"); // url de prod
	}

	public static String getBaseUrl() {
		return BASE_URL.get(Config.ENV);
	}
}
