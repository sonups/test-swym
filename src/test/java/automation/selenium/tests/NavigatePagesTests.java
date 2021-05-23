package automation.selenium.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import automation.pages.MainPage;
import automation.utils.WaitHelper;

public class NavigatePagesTests extends AutomationContextContainer {

	private MainPage mainPage;

	public NavigatePagesTests() {
		super();
		this.mainPage = super.getMainPage();
	}
	
	@Test
	public void verifyNavigateThroughPagesAndTenItemsPerPage() {
		assertThat("Incorrect Global Label", mainPage.GlobalHeader().getText(),
				containsString("Play sample application — Computer database"));

		assertThat("Display label on first page is incorrect", mainPage.NavigationPanel().DisplayLabel().getText(),
				containsString("Displaying 1 to 10"));
		assertThat("Previous Link of Navigation panel on first Page is not disabled",
				mainPage.NavigationPanel().Previous().isLinkDisabled(), is(true));
		assertThat("Next Link of Navigation panel on first Page is not enabled",
				mainPage.NavigationPanel().Next().isLinkDisabled(), is(false));

		for (int i = 0; i < 10; i++) {
			assertThat("Computer name is empty which is not expected",
					mainPage.ViewComputers().ComputerDataGrid().getReportRow(i).ComputerName().getText().isEmpty(),
					is(false));
		}

		mainPage.NavigationPanel().Next().clickInnerLink();

		assertThat("Display label on second page is incorrect", mainPage.NavigationPanel().DisplayLabel().getText(),
				containsString("Displaying 11 to 20"));
		assertThat("Previous Link of Navigation panel on first Page is not enabled",
				mainPage.NavigationPanel().Previous().isLinkDisabled(), is(false));
		assertThat("Next Link of Navigation panel on first Page is not enabled",
				mainPage.NavigationPanel().Next().isLinkDisabled(), is(false));

		for (int i = 0; i < 10; i++) {
			assertThat("Computer name is empty which is not expected",
					mainPage.ViewComputers().ComputerDataGrid().getReportRow(0).ComputerName().getText().isEmpty(),
					is(false));
		}
		WaitHelper.waitInSeconds(5);
	}
}
