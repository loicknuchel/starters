package org.knuchel.selenium.pages.components.form;

import java.util.ArrayList;
import java.util.List;

import org.knuchel.selenium.extentions.MyWebElement;
import org.openqa.selenium.WebElement;

public class FormMultiSelect extends FormSelect {

	public FormMultiSelect(MyWebElement webElement) {
		super(webElement);
	}

	public void loadComponent(WebElement webElement) {
		super.loadComponent(webElement);
		if (!select.isMultiple()) {
			throw new IllegalArgumentException("Element is not a multiple select !");
		}
	}

	public List<String> getValues() {
		List<MyWebElement> selectedOptions = getSelectedOptions();
		List<String> values = new ArrayList<String>();
		if (selectedOptions != null) {
			for (MyWebElement option : selectedOptions) {
				if (option.isSelected()) {
					values.add(option.getAttribute("value"));
				}
			}
		}
		return values;
	}

	public void selectByIndex(int... indexes) {
		if (indexes != null) {
			for (int index : indexes) {
				select.selectByIndex(index);
			}
		}
	}

	public void selectByValue(String... values) {
		if (values != null) {
			for (String value : values) {
				select.selectByValue(value);
			}
		}
	}

	public void selectByVisibleText(String... textes) {
		if (textes != null) {
			for (String text : textes) {
				select.selectByVisibleText(text);
			}
		}
	}
}
