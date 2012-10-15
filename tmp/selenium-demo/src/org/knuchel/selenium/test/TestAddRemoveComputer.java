package org.knuchel.selenium.test;

import junit.framework.Assert;

import org.knuchel.selenium.beans.Computer;
import org.knuchel.selenium.pages.ComputerEditPage;
import org.knuchel.selenium.pages.ComputerListPage;
import org.knuchel.selenium.pages.global.State;

public class TestAddRemoveComputer implements ITestcase {

	/**
	 * the test must start on login page and will stop at the same point
	 * 
	 * @return null if all the test is OK, an error message otherwise
	 */
	public void start() {
		State state = State.getInstance();
		Computer computer = new Computer("new computer", "1900-12-15", "2000-01-12", "IBM");

		ComputerListPage computerListPage = (ComputerListPage) state.getPage();
		Integer nbComputerInit = computerListPage.getNbComputerFound();
		computerListPage.createComputer().withComputer(computer).save();

		Assert.assertTrue(computerListPage.isComputerAdded(computer));
		Assert.assertEquals(Integer.valueOf(nbComputerInit + 1), computerListPage.getNbComputerFound());

		computerListPage.filter(computer.getName()).getComputer(computer.getName()).edit();
		ComputerEditPage computerEditPage = (ComputerEditPage) state.getPage();

		Assert.assertTrue(computerEditPage.getComputer().equals(computer));

		computerEditPage.delete();

		Assert.assertTrue(computerListPage.isComputerDeleted());
		Assert.assertEquals(nbComputerInit, computerListPage.getNbComputerFound());
	}
}
