package automation.stepDefinition;

import automation.core.DriverFactory;
import automation.core.WebDriverHelper;
import automation.pages.twitter.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class CommonSteps {

    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("^I login to twitter$")
    public void loginToTwitter(DataTable credTable) {
        List<Map<String, String>> credList = credTable.asMaps();
        String userName = credList.get(0).get("username");
        String password = credList.get(0).get("password");

        DriverFactory.getDriver()
                .get("https://twitter.com");
        WebDriverHelper.waitForPageLoad();
        loginPage.clickLoginButton();
        WebDriverHelper.waitForPageLoad();
        loginPage.typerUserNameAndPassword(userName, password);
        loginPage.clickLoginSecondButton();
        WebDriverHelper.waitForPageLoad();
    }

    @Then("^The page contains title (.*?)$")
    public void verifyPageTitle(String title) {
        WebDriverHelper.waitForPageLoad();
        String pageTitle = WebDriverHelper.getPageTitle(DriverFactory.getDriver());
        Assert.assertTrue("The title page is not as expected, expeced:" + title + " actual: " +pageTitle, pageTitle.contains(title));
    }

    @Then("^I navigate to the uri (.*?) in the current site$")
    public void navigateToURlFromCurrentSite(String uri) {
        String currentWebSiteURL = WebDriverHelper.getCurrentWebSiteURL(DriverFactory.getDriver());
        DriverFactory.getDriver()
                .get(currentWebSiteURL+ uri);
    }

}
