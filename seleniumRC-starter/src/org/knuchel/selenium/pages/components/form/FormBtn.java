package org.knuchel.selenium.pages.components.form;

import org.knuchel.selenium.extentions.MyWebDriver;
import org.knuchel.selenium.extentions.MyWebElement;
import org.knuchel.selenium.pages.components.MyAbstractComponent;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

public class FormBtn extends MyAbstractComponent {

	public FormBtn(MyWebElement webElement) {
		super(webElement);
	}

	public void loadComponent(WebElement webElement) {
		this.component = new MyWebElement(webElement);
	}

	public FormBtn click() {
		component.click();
		return this;
	}

	public FormBtn clickAndConfirm(MyWebDriver webdriver) {
		component.click();
		if (webdriver.switchTo().alert() != null) {
			Alert alert = webdriver.switchTo().alert();
			alert.accept();
		}
		return this;
	}

	public FormBtn clickAndDismiss(MyWebDriver webdriver) {
		component.click();
		if (webdriver.switchTo().alert() != null) {
			Alert alert = webdriver.switchTo().alert();
			alert.dismiss();
		}
		return this;
	}

	public MyWebElement getElement() {
		return component;
	}
}
