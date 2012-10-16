package org.knuchel.selenium.test;

import org.knuchel.selenium.beans.Computer;
import org.knuchel.selenium.pages.ComputerEditPage;
import org.knuchel.selenium.pages.ComputerListPage;
import org.knuchel.selenium.pages.global.State;
import org.knuchel.selenium.utils.Assert;

public class TestAddRemoveComputer implements ITestcase {

	/**
	 * Test start and stop on computer list page with no search and on page 1
	 */
	public void start() {
		State state = State.getInstance();
		Computer computer = new Computer("new computer", "1900-12-15", "2000-01-12", "IBM");

		ComputerListPage computerListPage = (ComputerListPage) state.getPage();
		// on enregistre le nombre total d'ordinateurs
		Integer nbComputerInit = computerListPage.getNbComputerFound();
		// on clique sur cr�er un nouvel ordinateur, on le rempli avec l'ordinateur ci-dessus et on sauvegarde
		computerListPage.createComputer().withComputer(computer).save();

		// on v�rifie qu'il est bien enregistr� et qu'il y a un ordinateur de plus
		Assert.isTrue(computerListPage.isComputerAdded(computer));
		Assert.isEqual(Integer.valueOf(nbComputerInit + 1), computerListPage.getNbComputerFound());

		// on va chercher le nouvel ordinateur et on va sur sa page d'�dition
		computerListPage.filter(computer.getName()).getComputer(computer.getName()).edit();

		ComputerEditPage computerEditPage = (ComputerEditPage) state.getPage();
		Assert.isTrue(computerEditPage.getComputer().equals(computer));

		// on le supprime
		computerEditPage.delete();

		// on v�rifie qu'il est bien supprim�
		Assert.isTrue(computerListPage.isComputerDeleted());
		Assert.isEqual(nbComputerInit, computerListPage.getNbComputerFound());
	}
}
