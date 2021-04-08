package stepDefinitions;

import base.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.*;

public class MainPageStepDeffinitions extends Base {

    private final MainPage mainPage = new MainPage();

    @Given("^user is on the main page$")
    public void onMainPage() {
        mainPage.onMainPage();
    }

    @Then("^all elements of page is displayed$")
    public void mainPageIsDisplayed() {
        mainPage.mainPageIsDisplayed();
    }

    @Then("^user input \"([^\"]*)\" to search field$")
    public void userClickTopLinksInFooter(String textForSearch) {
        mainPage.searchInputAndClick(textForSearch);
    }

    @Then("^user click button Search$")
    public void userClickFirstBTN() {
        mainPage.firstBtnClick();
    }

    @Then("^user click button Second$")
    public void userClickSecondBTN() {
        mainPage.secondBTNClick();
    }

    @Then("^user refresh page$")
    public void userRefreshPage() {
        Base.refreshPage();
    }

}
