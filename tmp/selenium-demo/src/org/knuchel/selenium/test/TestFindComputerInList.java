package org.knuchel.selenium.test;

import org.knuchel.selenium.beans.Computer;
import org.knuchel.selenium.pages.ComputerEditPage;
import org.knuchel.selenium.pages.ComputerListPage;
import org.knuchel.selenium.pages.global.State;
import org.knuchel.selenium.utils.Assert;

public class TestFindComputerInList implements ITestcase {

	/**
	 * Test start and stop on computer list page with no search and on page 1
	 */
	public void start() {
		State state = State.getInstance();
		Computer computer = new Computer("Apple I", "1976-04-01", "1977-10-01", "Apple Inc."); // found on page 5

		ComputerListPage computerListPage = (ComputerListPage) state.getPage();
		// on parcourt toutes les pages justqu'à trouver celle avec l'ordinateur ci-dessus
		while (computerListPage.getComputer(computer) == null && computerListPage.hasNextPage()) {
			computerListPage.moveNextPage();
		}
		// quand on a trouvé l'ordianateur, on va sur la page d'édition
		computerListPage.getComputer(computer).edit();

		ComputerEditPage computerEditPage = (ComputerEditPage) state.getPage();
		Computer foundComputer = computerEditPage.getComputer();

		// on vérifie que l'ordinateur de la page d'édition est bien celui qu'on cherchait
		Assert.isEqual(computer, foundComputer);

		// on clique sur annuler pour revenir sur la liste
		computerEditPage.cancel();
	}
}
