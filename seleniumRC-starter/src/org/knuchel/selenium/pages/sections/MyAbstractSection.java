package org.knuchel.selenium.pages.sections;

import org.knuchel.selenium.extentions.MyWebDriver;
import org.knuchel.selenium.extentions.MyWebElement;
import org.knuchel.selenium.pages.global.State;


public abstract class MyAbstractSection {
	protected MyWebDriver webdriver;
	protected State state;
	protected MyWebElement section;

	public MyAbstractSection() {
		this.state = State.getInstance();
		this.webdriver = state.getWebDriver();
		loadSection(webdriver);
	}

	protected abstract void loadSection(MyWebDriver webdriver);

	
}
