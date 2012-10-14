package org.knuchel.selenium.pages.global;

import org.knuchel.selenium.extentions.MyWebDriver;
import org.knuchel.selenium.pages.MyAbstractPage;

public interface ILoadState {
	void load(State state, MyWebDriver webdriver);

	MyAbstractPage getPage();
}
