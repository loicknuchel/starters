package org.knuchel.selenium.test;

import org.knuchel.selenium.extentions.MyWebDriver;
import org.knuchel.selenium.pages.global.State;

public class TestSample {
	private MyWebDriver webdriver;

	public TestSample(MyWebDriver webdriver) {
		this.webdriver = webdriver;
	}

	/**
	 * the test must start on login page and will stop at the same point
	 * 
	 * @return null if all the test is OK, an error message otherwise
	 */
	public String start() {
		try {
			State state = State.getInstance();

		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return null;

	}
}
