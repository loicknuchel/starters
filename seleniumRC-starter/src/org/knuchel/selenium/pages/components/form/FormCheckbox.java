package org.knuchel.selenium.pages.components.form;

import org.knuchel.selenium.extentions.MyWebElement;
import org.knuchel.selenium.pages.components.MyAbstractComponent;
import org.openqa.selenium.WebElement;

public class FormCheckbox extends MyAbstractComponent {

	public FormCheckbox(MyWebElement webElement) {
		super(webElement);
	}

	public void loadComponent(WebElement webElement) {
		if (!("input".equalsIgnoreCase(webElement.getTagName()) && "checkbox".equalsIgnoreCase(webElement.getAttribute("type")))) {
			throw new IllegalArgumentException("Element is not a checkbox (it's a " + webElement.getTagName() + ") !");
		}
		this.component = new MyWebElement(webElement);
	}

	public void setValue(boolean val) {
		if (val != component.isSelected()) {
			component.click();
		}
	}

	public boolean isSelected() {
		return component.isSelected();
	}

	public String getValue() {
		if (component.isSelected()) {
			return component.getAttribute("value");
		}
		return null;
	}

	public void toogle() {
		component.click();
	}

	public void click() {
		component.click();
	}

	public MyWebElement getElement() {
		return component;
	}
}
