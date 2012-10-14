package org.knuchel.selenium.pages.global;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.knuchel.selenium.config.Config;
import org.knuchel.selenium.extentions.MyWebDriver;
import org.knuchel.selenium.utils.MyStringUtils;

public class State {
	private static State INSTANCE = new State();
	private MyWebDriver webDriver;
	// private MyAbstractPage currentPage;
	private ILoadState currentState;

	private State() {
	}

	public static State getInstance() {
		return INSTANCE;
	}

	public void setWebDriver(MyWebDriver webdriver) {
		this.webDriver = webdriver;
	}

	public void logError(Exception e) {
		isWebDriver();
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss.S");
			String fileName = Config.ASSETS + Config.SEP + "error_" + df.format(new Date());
			webDriver.takeScreenshot(fileName + ".png");
			FileUtils.writeStringToFile(new File(fileName + ".txt"), MyStringUtils.convert(e));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void reloadState() {
		currentState.load(this, webDriver);
	}

	private void isWebDriver() {
		if (webDriver == null) {
			throw new IllegalStateException("You have to set a webdriver before using this class !");
		}
	}

	public MyWebDriver getWebDriver() {
		isWebDriver();
		return webDriver;
	}
}
