package stepDefinitions;

import base.Base;
import cucumber.api.java.ru.Тогда;
import pages.ResultsPage;

public class ResultsPageStepDefinitions extends Base {
    private final ResultsPage resultsPage = new ResultsPage();

    @Тогда("^results page is displayed$")
    public void mainPageIsDisplayed() {
        resultsPage.resultsPageIsDisplayed();
    }
}
