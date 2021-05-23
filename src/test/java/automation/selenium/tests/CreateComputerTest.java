package automation.selenium.tests;



import org.junit.Test;

import automation.pages.MainPage;
import automation.utils.WaitHelper;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;

public class CreateComputerTest extends AutomationContextContainer {

	private MainPage mainPage;

	public CreateComputerTest() {
		super();
		this.mainPage = super.getMainPage();
	}

	@Test
	public void createComputer() {
		assertThat("Incorrect Global Label", mainPage.GlobalHeader().getText(),
				containsString("Play sample application � Computer database"));

		assertThat("Incorrect heading label ", mainPage.ViewComputers().HeadingLabel().getText(),
				matchesPattern("^[0-9]+ computers found$"));
		mainPage.ViewComputers().AddNewComputer().click();
		assertThat("Error reaching add computer page", mainPage.AddComputerPage().HeadingLabel().getText(),
				matchesPattern("^Add a computer$"));
		mainPage.AddComputerPage().ComputerName().SendKeys("New Computer");
		mainPage.AddComputerPage().IntroducedDate().SendKeys("2019-01-01");
		mainPage.AddComputerPage().DiscontinuedDate().SendKeys("2019-01-30");
		mainPage.AddComputerPage().SelectComputerType().selectItemByIndex(20);
		mainPage.AddComputerPage().CreateComputer().click();
		assertThat("Error during adding a new computer", mainPage.ViewComputers().AlertMessage().getText(),
				containsString("has been created"));
		WaitHelper.waitInSeconds(5);
	}

}
