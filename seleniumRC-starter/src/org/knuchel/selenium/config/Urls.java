package org.knuchel.selenium.config;

import java.util.HashMap;
import java.util.Map;

import org.knuchel.selenium.beans.Env;

public class Urls {
	private static final Map<Env, String> BASE_URL = new HashMap<Env, String>();

	static {
		BASE_URL.put(Env.LOCAL, "url locale");
		BASE_URL.put(Env.DEV, "url de dev");
		BASE_URL.put(Env.TEST, "url de test");
		BASE_URL.put(Env.RECETTE, "url de recette");
		BASE_URL.put(Env.PREPROD, "url de preprod");
		BASE_URL.put(Env.PROD, "url de prod");
	}

	public static String getBaseUrl() {
		return BASE_URL.get(Config.ENV);
	}
}
