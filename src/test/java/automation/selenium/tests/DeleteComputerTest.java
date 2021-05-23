package automation.selenium.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.matchesPattern;

import org.junit.Test;

import automation.pages.MainPage;
import automation.utils.WaitHelper;

public class DeleteComputerTest extends AutomationContextContainer {

	private MainPage mainPage;

	public DeleteComputerTest() {
		super();
		this.mainPage = super.getMainPage();
	}
	
	@Test
	public void deleteFirstComputerInReportGrid() {
		assertThat("Incorrect Global Label", mainPage.GlobalHeader().getText(),
				containsString("Play sample application — Computer database"));

		assertThat("Incorrect heading label ", mainPage.ViewComputers().HeadingLabel().getText(),
				matchesPattern("^[0-9]+ computers found$"));
		mainPage.ViewComputers().ComputerDataGrid().getReportRow(0).ComputerName().click();
		assertThat("Error reaching edit computer page", mainPage.EditComputer().HeadingLabel().getText(),
				matchesPattern("^Edit computer$"));
		mainPage.EditComputer().DeleteComputer().click();
		assertThat("Alert message retrived after deleting computer is unexpcted",
				mainPage.ViewComputers().AlertMessage().getText(), containsString("Computer has been deleted"));
		WaitHelper.waitInSeconds(5);
	}
	
}
