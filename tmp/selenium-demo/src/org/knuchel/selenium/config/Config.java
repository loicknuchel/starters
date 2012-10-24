package org.knuchel.selenium.config;

import org.knuchel.selenium.beans.Env;

public class Config {
	public static Env ENV = Env.LOCAL;
	public static String DRIVER = Driver.CHROME;
	// les captures d'écran seront stockées ici par défaut
	public static String ASSETS = "C:\\tmp";

	public static class LocalPathTo {
		// can be downloaded here : http://code.google.com/p/selenium/wiki/ChromeDriver
		public static final String CHROME_DRIVER = "C:\\Tools\\selenium\\chromedriver.exe";
		// can be downloaded here : http://code.google.com/p/selenium/wiki/InternetExplorerDriver
		public static final String IE_DRIVER = "C:\\Tools\\selenium\\IEDriverServer.exe";
		public static final String FIREFOX_BROWSER = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
	}

	public static class Driver {
		public static final String CHROME = "chrome";
		public static final String FIREFOX = "firefox";
		public static final String OPERA = "opera";
		public static final String IE = "ie";
	}
}
