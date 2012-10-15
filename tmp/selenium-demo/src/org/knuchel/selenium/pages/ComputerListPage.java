package org.knuchel.selenium.pages;

import java.util.ArrayList;
import java.util.List;

import org.knuchel.selenium.beans.Computer;
import org.knuchel.selenium.extentions.MyBy;
import org.knuchel.selenium.extentions.MyWebDriver;
import org.knuchel.selenium.extentions.MyWebElement;
import org.knuchel.selenium.pages.elements.ComputerListElement;
import org.knuchel.selenium.pages.elements.form.FormBtn;
import org.knuchel.selenium.pages.elements.form.FormInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ComputerListPage extends MyAbstractPage {
	private final List<ComputerListElement> computers = new ArrayList<ComputerListElement>();

	public ComputerListPage(MyWebDriver webDriver) {
		super(webDriver);
		loadDatas();
	}

	@Override
	public void loadDatas() {
		MyWebElement globalPage = DOM.getGlobalPage(webDriver);
		MyWebElement computersTable = DOM.getComputersTable(globalPage);
		MyWebElement computersTableContent = DOM.getComputersTableContent(computersTable);
		List<WebElement> findElements = computersTableContent.findElements(MyBy.tagName("tr"));
		computers.clear();
		for (WebElement elt : findElements) {
			computers.add(new ComputerListElement(elt));
		}
	}

	public List<ComputerListElement> getComputers() {
		return computers;
	}

	public ComputerListElement getComputer(String computerName) {
		for (ComputerListElement computer : computers) {
			if (computer.getName().equals(computerName)) {
				return computer;
			}
		}
		return null;
	}

	public ComputerListElement getComputer(Computer computer) {
		return getComputer(computer.getName());
	}

	public ComputerListElement getComputer(int index) {
		return computers.get(index);
	}

	public ComputerListPage filter(String text) {
		MyWebElement globalPage = DOM.getGlobalPage(webDriver);
		MyWebElement filterForm = DOM.getFilterForm(globalPage);
		FormInput filterInput = DOM.getFilterInput(filterForm);
		FormBtn filterBtn = DOM.getFilterBtn(filterForm);
		filterInput.setValue(text);
		filterBtn.click();
		loadDatas();
		return this;
	}

	public Integer getNbComputerFound() {
		MyWebElement globalPage = DOM.getGlobalPage(webDriver);
		MyWebElement title = DOM.getTitle(globalPage);
		String text = title.getText();
		String[] split = text.split(" ");
		return Integer.valueOf(split[0]);
	}

	public ComputerPage createComputer() {
		MyWebElement globalPage = DOM.getGlobalPage(webDriver);
		FormBtn addComputerBtn = DOM.getAddComputerBtn(globalPage);
		addComputerBtn.click();
		return (ComputerPage) state.getPage();
	}

	public boolean isComputerAdded(String computerName) {
		MyWebElement globalPage = DOM.getGlobalPage(webDriver);
		MyWebElement alertMsg = DOM.getAlertMsg(globalPage);
		String msg = alertMsg.getText();
		return msg.contains("Computer " + computerName + " has been created");
	}

	public boolean isComputerAdded(Computer computer) {
		return isComputerAdded(computer.getName());
	}

	public boolean isComputerDeleted() {
		MyWebElement globalPage = DOM.getGlobalPage(webDriver);
		MyWebElement alertMsg = DOM.getAlertMsg(globalPage);
		String msg = alertMsg.getText();
		return msg.contains("Computer has been deleted");
	}

	public boolean hasPreviousPage() {
		MyWebElement globalPage = DOM.getGlobalPage(webDriver);
		MyWebElement paginationBlock = DOM.getPaginationBlock(globalPage);
		MyWebElement previousPageBlock = DOM.getPreviousPageBlock(paginationBlock);
		return !previousPageBlock.getAttribute("class").contains("disabled");
	}

	public boolean hasNextPage() {
		MyWebElement globalPage = DOM.getGlobalPage(webDriver);
		MyWebElement paginationBlock = DOM.getPaginationBlock(globalPage);
		MyWebElement nextPageBlock = DOM.getNextPageBlock(paginationBlock);
		return !nextPageBlock.getAttribute("class").contains("disabled");
	}

	public ComputerListPage movePreviousPage() {
		MyWebElement globalPage = DOM.getGlobalPage(webDriver);
		MyWebElement paginationBlock = DOM.getPaginationBlock(globalPage);
		MyWebElement previousPageBlock = DOM.getPreviousPageBlock(paginationBlock);
		FormBtn previousPageBtn = DOM.getPreviousPageBtn(previousPageBlock);
		previousPageBtn.click();
		loadDatas();
		return this;
	}

	public ComputerListPage moveNextPage() {
		MyWebElement globalPage = DOM.getGlobalPage(webDriver);
		MyWebElement paginationBlock = DOM.getPaginationBlock(globalPage);
		MyWebElement nextPageBlock = DOM.getNextPageBlock(paginationBlock);
		FormBtn nextPageBtn = DOM.getNextPageBtn(nextPageBlock);
		nextPageBtn.click();
		loadDatas();
		return this;
	}

	public static class DOM {
		public static MyWebElement getGlobalPage(MyWebDriver webDriver) {
			return webDriver.findElement(By.tagName("body"));
		}

		public static MyWebElement getTitle(MyWebElement globalPage) {
			return globalPage.findElement("#homeTitle");
		}

		public static MyWebElement getAlertMsg(MyWebElement globalPage) {
			return globalPage.findElement(".alert-message");
		}

		public static MyWebElement getFilterForm(MyWebElement globalPage) {
			return globalPage.findElement("#actions form");
		}

		public static FormInput getFilterInput(MyWebElement filterForm) {
			return new FormInput(filterForm.findElement("#searchbox"));
		}

		public static FormBtn getFilterBtn(MyWebElement filterForm) {
			return new FormBtn(filterForm.findElement("#searchsubmit"));
		}

		public static FormBtn getAddComputerBtn(MyWebElement globalPage) {
			return new FormBtn(globalPage.findElement("#actions #add"));
		}

		public static MyWebElement getComputersTable(MyWebElement globalPage) {
			return globalPage.findElement(".computers");
		}

		public static MyWebElement getComputersTableHeaders(MyWebElement computersTable) {
			return computersTable.findElement("thead");
		}

		public static MyWebElement getComputersTableContent(MyWebElement computersTable) {
			return computersTable.findElement("tbody");
		}

		public static MyWebElement getPaginationBlock(MyWebElement globalPage) {
			return globalPage.findElement("#pagination");
		}

		public static MyWebElement getPreviousPageBlock(MyWebElement paginationBlock) {
			return paginationBlock.findElement(".prev");
		}

		public static FormBtn getPreviousPageBtn(MyWebElement previousPageBlock) {
			return new FormBtn(previousPageBlock.findElement("a"));
		}

		public static MyWebElement getNextPageBlock(MyWebElement paginationBlock) {
			return paginationBlock.findElement(".next");
		}

		public static FormBtn getNextPageBtn(MyWebElement nextPageBlock) {
			return new FormBtn(nextPageBlock.findElement("a"));
		}
	}
}
