package automation.selenium.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.text.IsEmptyString.emptyOrNullString;

import org.junit.Test;

import automation.pages.MainPage;

public class SortByColumnTest extends AutomationContextContainer {

	private MainPage mainPage;

	public SortByColumnTest() {
		super();
		this.mainPage = super.getMainPage();
	}
	
	@Test
	public void verifySortByComputerNameColumn() {

		assertThat("sorted Up Coloumn Unexpected", mainPage.ViewComputers().ComputerDataGrid().Header().getCurrentSortedUpColumn(),containsString("Computer name"));
		assertThat("sorted Down Coloumn Unexpected", mainPage.ViewComputers().ComputerDataGrid().Header().getCurrentSortedDownColumn(),is(emptyOrNullString()));
		mainPage.ViewComputers().ComputerDataGrid().Header().ComputerName().click();
		
		assertThat("sorted Up Coloumn Unexpected", mainPage.ViewComputers().ComputerDataGrid().Header().getCurrentSortedUpColumn(),is(emptyOrNullString()));
		assertThat("sorted Down Coloumn Unexpected", mainPage.ViewComputers().ComputerDataGrid().Header().getCurrentSortedDownColumn(),containsString("Computer name"));
	}

	@Test
	public void verifySortByIntrducedDateColumn() {
		mainPage.ViewComputers().ComputerDataGrid().Header().Introduced().click();

		assertThat("sorted Up Coloumn Unexpected", mainPage.ViewComputers().ComputerDataGrid().Header().getCurrentSortedUpColumn(),containsString("Introduced"));
		assertThat("sorted Down Coloumn Unexpected", mainPage.ViewComputers().ComputerDataGrid().Header().getCurrentSortedDownColumn(),is(emptyOrNullString()));
		mainPage.ViewComputers().ComputerDataGrid().Header().Introduced().click();
		
		assertThat("sorted Up Coloumn Unexpected", mainPage.ViewComputers().ComputerDataGrid().Header().getCurrentSortedUpColumn(),is(emptyOrNullString()));
		assertThat("sorted Down Coloumn Unexpected", mainPage.ViewComputers().ComputerDataGrid().Header().getCurrentSortedDownColumn(),containsString("Introduced"));
	

	}

	@Test
	public void verifySortByDiscountedDateColumn() {
		mainPage.ViewComputers().ComputerDataGrid().Header().Discontinued().click();

		assertThat("sorted Up Coloumn Unexpected", mainPage.ViewComputers().ComputerDataGrid().Header().getCurrentSortedUpColumn(),containsString("Discontinued"));
		assertThat("sorted Down Coloumn Unexpected", mainPage.ViewComputers().ComputerDataGrid().Header().getCurrentSortedDownColumn(),is(emptyOrNullString()));
		mainPage.ViewComputers().ComputerDataGrid().Header().Discontinued().click();
		
		assertThat("sorted Up Coloumn Unexpected", mainPage.ViewComputers().ComputerDataGrid().Header().getCurrentSortedUpColumn(),is(emptyOrNullString()));
		assertThat("sorted Down Coloumn Unexpected", mainPage.ViewComputers().ComputerDataGrid().Header().getCurrentSortedDownColumn(),containsString("Discontinued"));
	

	}

	@Test
	public void verifySortByCompanyColumn() {
		
		mainPage.ViewComputers().ComputerDataGrid().Header().Company().click();

		assertThat("sorted Up Coloumn Unexpected", mainPage.ViewComputers().ComputerDataGrid().Header().getCurrentSortedUpColumn(),containsString("Company"));
		assertThat("sorted Down Coloumn Unexpected", mainPage.ViewComputers().ComputerDataGrid().Header().getCurrentSortedDownColumn(),is(emptyOrNullString()));
		mainPage.ViewComputers().ComputerDataGrid().Header().Company().click();
		
		assertThat("sorted Up Coloumn Unexpected", mainPage.ViewComputers().ComputerDataGrid().Header().getCurrentSortedUpColumn(),is(emptyOrNullString()));
		assertThat("sorted Down Coloumn Unexpected", mainPage.ViewComputers().ComputerDataGrid().Header().getCurrentSortedDownColumn(),containsString("Company"));
	

	}
	
}
