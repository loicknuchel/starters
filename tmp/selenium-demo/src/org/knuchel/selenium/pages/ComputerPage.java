package org.knuchel.selenium.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.knuchel.selenium.beans.Computer;
import org.knuchel.selenium.extentions.MyWebDriver;
import org.knuchel.selenium.extentions.MyWebElement;
import org.knuchel.selenium.pages.elements.form.FormBtn;
import org.knuchel.selenium.pages.elements.form.FormInput;
import org.knuchel.selenium.pages.elements.form.FormSelect;
import org.openqa.selenium.By;

public class ComputerPage extends MyAbstractPage {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	public ComputerPage(MyWebDriver webDriver) {
		super(webDriver);
	}

	@Override
	public void loadDatas() {

	}

	public ComputerPage withName(String name) {
		if (name != null) {
			getComputerNameField().setValue(name);
		}
		return this;
	}

	public ComputerPage withIntroduced(String introduced) {
		if (introduced != null) {
			getComputerIntroducedField().setValue(introduced);
		}
		return this;
	}

	public ComputerPage withIntroduced(Date introduced) {
		if (introduced != null) {
			getComputerIntroducedField().setValue(DATE_FORMAT.format(introduced));
		}
		return this;
	}

	public ComputerPage withDiscontinued(String discontinued) {
		if (discontinued != null) {
			getComputerDiscontinuedField().setValue(discontinued);
		}
		return this;
	}

	public ComputerPage withDiscontinued(Date discontinued) {
		if (discontinued != null) {
			getComputerDiscontinuedField().setValue(DATE_FORMAT.format(discontinued));
		}
		return this;
	}

	public ComputerPage withCompany(String visibleText) {
		if (visibleText != null) {
			getComputerCompanyField().selectByVisibleText(visibleText);
		}
		return this;
	}

	public ComputerPage withCompany(Integer index) {
		if (index != null) {
			getComputerCompanyField().selectByIndex(index);
		}
		return this;
	}

	public ComputerPage with(String name, String introduced, String discontinued, String company) {
		withName(name);
		withIntroduced(introduced);
		withDiscontinued(discontinued);
		withCompany(company);
		return this;
	}

	public ComputerPage withComputer(Computer computer) {
		return with(computer.getName(), computer.getIntroduced(), computer.getDiscontinued(), computer.getCompany());
	}

	public void save() {
		MyWebElement globalPage = DOM.getGlobalPage(webDriver);
		MyWebElement computerForm = DOM.getComputerForm(globalPage);
		FormBtn computerFormSubmit = DOM.getComputerFormSubmit(computerForm);
		computerFormSubmit.click();
	}

	public ComputerListPage cancel() {
		MyWebElement globalPage = DOM.getGlobalPage(webDriver);
		MyWebElement computerForm = DOM.getComputerForm(globalPage);
		FormBtn computerFormCancel = DOM.getComputerFormCancel(computerForm);
		computerFormCancel.click();
		return (ComputerListPage) state.getPage();
	}

	public String getName() {
		return getComputerNameField().getValue();
	}

	public String getIntroduced() {
		return getComputerIntroducedField().getValue();
	}

	public Date getIntroducedDate() {
		try {
			return DATE_FORMAT.parse(getComputerIntroducedField().getValue());
		} catch (ParseException e) {
			return null;
		}
	}

	public String getDiscontinued() {
		return getComputerDiscontinuedField().getValue();
	}

	public Date getDiscontinuedDate() {
		try {
			return DATE_FORMAT.parse(getComputerDiscontinuedField().getValue());
		} catch (ParseException e) {
			return null;
		}
	}

	public String getCompanyValue() {
		return getComputerCompanyField().getValue();
	}

	public String getCompany() {
		return getComputerCompanyField().getVisibleText();
	}

	public Computer getComputer() {
		return new Computer(getName(), getIntroduced(), getDiscontinued(), getCompany());
	}

	private FormInput getComputerNameField() {
		MyWebElement globalPage = DOM.getGlobalPage(webDriver);
		MyWebElement computerForm = DOM.getComputerForm(globalPage);
		return DOM.getComputerNameField(computerForm);
	}

	private FormInput getComputerIntroducedField() {
		MyWebElement globalPage = DOM.getGlobalPage(webDriver);
		MyWebElement computerForm = DOM.getComputerForm(globalPage);
		return DOM.getComputerIntroducedField(computerForm);
	}

	private FormInput getComputerDiscontinuedField() {
		MyWebElement globalPage = DOM.getGlobalPage(webDriver);
		MyWebElement computerForm = DOM.getComputerForm(globalPage);
		return DOM.getComputerDiscontinuedField(computerForm);
	}

	private FormSelect getComputerCompanyField() {
		MyWebElement globalPage = DOM.getGlobalPage(webDriver);
		MyWebElement computerForm = DOM.getComputerForm(globalPage);
		return DOM.getComputerCompanyField(computerForm);
	}

	public static class DOM {
		public static MyWebElement getGlobalPage(MyWebDriver webDriver) {
			return webDriver.findElement(By.tagName("body"));
		}

		public static MyWebElement getComputerForm(MyWebElement globalPage) {
			return globalPage.findElement("form");
		}

		public static FormInput getComputerNameField(MyWebElement computerForm) {
			return new FormInput(computerForm.findElement("#name"));
		}

		public static FormInput getComputerIntroducedField(MyWebElement computerForm) {
			return new FormInput(computerForm.findElement("#introduced"));
		}

		public static FormInput getComputerDiscontinuedField(MyWebElement computerForm) {
			return new FormInput(computerForm.findElement("#discontinued"));
		}

		public static FormSelect getComputerCompanyField(MyWebElement computerForm) {
			return new FormSelect(computerForm.findElement("#company_id"));
		}

		public static FormBtn getComputerFormSubmit(MyWebElement computerForm) {
			return new FormBtn(computerForm.findElement(".actions input"));
		}

		public static FormBtn getComputerFormCancel(MyWebElement computerForm) {
			return new FormBtn(computerForm.findElement(".actions a"));
		}
	}
}
