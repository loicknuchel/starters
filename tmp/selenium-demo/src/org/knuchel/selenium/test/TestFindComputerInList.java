package org.knuchel.selenium.test;

import junit.framework.Assert;

import org.knuchel.selenium.beans.Computer;
import org.knuchel.selenium.pages.ComputerEditPage;
import org.knuchel.selenium.pages.ComputerListPage;
import org.knuchel.selenium.pages.global.State;

public class TestFindComputerInList implements ITestcase {

	/**
	 * the test must start on login page and will stop at the same point
	 * 
	 * @return null if all the test is OK, an error message otherwise
	 */
	public void start() {
		State state = State.getInstance();
		Computer computer = new Computer("Apple I", "1976-04-01", "1977-10-01", "Apple Inc."); // found on page 5
		// Computer computer = new Computer("HP TouchPad", "2011-02-09", "", "Hewlett-Packard"); // found on page 21

		ComputerListPage computerListPage = (ComputerListPage) state.getPage();
		while (computerListPage.getComputer(computer) == null && computerListPage.hasNextPage()) {
			computerListPage.moveNextPage();
		}
		computerListPage.getComputer(computer).edit();

		ComputerEditPage computerEditPage = (ComputerEditPage) state.getPage();
		Computer foundComputer = computerEditPage.getComputer();

		Assert.assertEquals(computer, foundComputer);

		computerEditPage.cancel();
	}
}
