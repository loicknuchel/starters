package org.knuchel.selenium.test;

import org.knuchel.selenium.extentions.MyWebDriver;
import org.knuchel.selenium.pages.global.State;

public class TestSample {
	private MyWebDriver webDriver;

	public TestSample(MyWebDriver webDriver) {
		this.webDriver = webDriver;
	}

	/**
	 * the test must start on login page and will stop at the same point
	 * 
	 * @return null if all the test is OK, an error message otherwise
	 */
	public String start() {
		State state = State.getInstance();
		try {

		} catch (Exception e) {
			state.logError(e);
			e.printStackTrace();
			return e.getMessage();
		}
		return null;

	}
}
