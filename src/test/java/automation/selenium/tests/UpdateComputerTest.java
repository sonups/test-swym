package automation.selenium.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.matchesPattern;

import org.junit.Test;

import automation.pages.MainPage;
import automation.utils.WaitHelper;

public class UpdateComputerTest extends AutomationContextContainer {

	private MainPage mainPage;

	public UpdateComputerTest() {
		super();
		this.mainPage = super.getMainPage();
	}
	
	@Test
	public void updateFirstComputerInHTMLTable() {
		assertThat("Incorrect Global Label", mainPage.GlobalHeader().getText(),
				containsString("Play sample application — Computer database"));

		assertThat("Incorrect heading label ", mainPage.ViewComputers().HeadingLabel().getText(),
				matchesPattern("^[0-9]+ computers found$"));
		mainPage.ViewComputers().ComputerDataGrid().getReportRow(0).ComputerName().click();
		assertThat("Error reaching edit computer page", mainPage.EditComputer().HeadingLabel().getText(),
				matchesPattern("^Edit computer$"));
		mainPage.EditComputer().ComputerName().SendKeys("AAAAA - updated");
		mainPage.EditComputer().IntroducedDate().SendKeys("2019-01-01");
		mainPage.EditComputer().DiscontinuedDate().SendKeys("2019-01-30");
		mainPage.EditComputer().SelectComputerType().selectItemByIndex(1);
		mainPage.EditComputer().CreateComputer().click();
		assertThat("Error in updating computer details", mainPage.ViewComputers().AlertMessage().getText(),
				containsString("has been updated"));
		WaitHelper.waitInSeconds(5);
	}
}
