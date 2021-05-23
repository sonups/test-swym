package automation.selenium.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.matchesPattern;

import org.junit.Test;

import automation.pages.MainPage;
import automation.utils.WaitHelper;

public class SearchComputerTest extends AutomationContextContainer {

	private MainPage mainPage;

	public SearchComputerTest() {
		super();
		this.mainPage = super.getMainPage();
	}
	
	@Test
	public void searchComputerByName() {
		assertThat("Incorrect Global Label", mainPage.GlobalHeader().getText(),
				containsString("Play sample application — Computer database"));

		assertThat("Incorrect heading label ", mainPage.ViewComputers().HeadingLabel().getText(),
				matchesPattern("^[0-9]+ computers found$"));
		mainPage.ViewComputers().FilterField().SendKeys("Intel");
		mainPage.ViewComputers().SearchSubmitButton().click();
		assertThat("Search by Computer name failed",
				mainPage.ViewComputers().ComputerDataGrid().getReportRow(1).ComputerName().getText(),
				containsString("Intel"));
		WaitHelper.waitInSeconds(5);
	}
	
	@Test
	public void searchAndDeleteComputer() {

		assertThat("Incorrect Global Label", mainPage.GlobalHeader().getText(),
				containsString("Play sample application — Computer database"));

		assertThat("Incorrect heading label ", mainPage.ViewComputers().HeadingLabel().getText(),
				matchesPattern("^[0-9]+ computers found$"));
		mainPage.ViewComputers().FilterField().SendKeys("AAAA");
		mainPage.ViewComputers().SearchSubmitButton().click();
		assertThat("Search by Computer name failed",
				mainPage.ViewComputers().ComputerDataGrid().getReportRow(1).ComputerName().getText(),
				containsString("AAAA"));
		mainPage.ViewComputers().ComputerDataGrid().getReportRow(1).ComputerName().click();
		assertThat("Error reaching edit computer page", mainPage.EditComputer().HeadingLabel().getText(),
				matchesPattern("^Edit computer$"));
		mainPage.EditComputer().DeleteComputer().click();
		assertThat("Alert message retrived after deleting computer is unexpcted",
				mainPage.ViewComputers().AlertMessage().getText(), containsString("Computer has been deleted"));
		WaitHelper.waitInSeconds(5);

	}

}
