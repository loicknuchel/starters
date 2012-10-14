package org.knuchel.selenium.pages.global;

import org.knuchel.selenium.extentions.MyWebDriver;

public class State {
	private static State INSTANCE = new State();
	private MyWebDriver webdriver;
	// private MyAbstractPage currentPage;
	private ILoadState currentState;

	private State() {
	}

	public static State getInstance() {
		return INSTANCE;
	}

	public void setWebDriver(MyWebDriver webdriver) {
		this.webdriver = webdriver;
	}

	public void reloadState() {
		currentState.load(this, webdriver);
	}

	private void isWebDriver() {
		if (webdriver == null) {
			throw new IllegalStateException("You have to set a webdriver before using this class !");
		}
	}

	public MyWebDriver getWebDriver() {
		return webdriver;
	}
}
