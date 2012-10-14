package org.knuchel.selenium.pages.components.form;

import java.util.List;

import org.knuchel.selenium.extentions.MyWebElement;
import org.knuchel.selenium.pages.components.MyAbstractComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormSelect extends MyAbstractComponent {
	protected Select select;

	public FormSelect(MyWebElement webElement) {
		super(webElement);
	}

	public void loadComponent(WebElement webElement) {
		this.component = new MyWebElement(webElement);
		if (!"select".equalsIgnoreCase(webElement.getTagName())) {
			throw new IllegalArgumentException("Element is not a select (it's a " + webElement.getTagName() + ") !");
		}
		this.select = new Select(webElement);
	}

	public boolean isMultiple() {
		return select.isMultiple();
	}

	public List<MyWebElement> getOptions() {
		return MyWebElement.convert(select.getOptions());
	}

	public List<MyWebElement> getSelectedOptions() {
		return MyWebElement.convert(select.getAllSelectedOptions());
	}

	public MyWebElement getFirstSelectedOption() {
		return new MyWebElement(select.getFirstSelectedOption());
	}

	public String getValue() {
		return component.getAttribute("value");
	}

	public String getVisibleText() {
		return getFirstSelectedOption().getText();
	}

	public Integer getSelectedIndex() {
		Integer ret = 0;
		for (WebElement option : select.getOptions()) {
			if (getValue().equals(option.getAttribute("value"))) {
				return ret;
			}
			ret++;
		}
		return -1;
	}

	public void selectByIndex(int index) {
		select.selectByIndex(index);
	}

	public void selectByValue(String value) {
		select.selectByValue(value);
	}

	public void selectByVisibleText(String text) {
		select.selectByVisibleText(text);
	}

	public void deselectAll() {
		select.deselectAll();
	}

	public void deselectByIndex(int index) {
		select.deselectByIndex(index);
	}

	public void deselectByValue(String value) {
		select.deselectByValue(value);
	}

	public void deselectByVisibleText(String text) {
		select.deselectByVisibleText(text);
	}

	public MyWebElement getElement() {
		return component;
	}
}
