package org.knuchel.selenium.pages.components;

import org.knuchel.selenium.extentions.MyWebElement;
import org.openqa.selenium.WebElement;

public abstract class MyAbstractComponent {
	protected MyWebElement component;

	public MyAbstractComponent(WebElement webElement) {
		this.component = new MyWebElement(webElement);
		loadComponent(webElement);
	}

	public abstract void loadComponent(WebElement webElement);
}
