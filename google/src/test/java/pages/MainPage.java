package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import pagesUrls.PagesUrls;

import java.util.Arrays;
import java.util.List;

public class MainPage extends Base {

    By titleImg = By.id("hplogo");
    By firstBTN = By.xpath("//input[@name='btnG']");
    By secondBTN = By.xpath("//input[@name='btnI']");
    By field = By.xpath("//input[@name='q']");
    By searchBTN = By.xpath("//input[@value='Поиск в Google']");

    private final List<By> elements;

    public MainPage() {
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(titleImg, firstBTN, secondBTN, field);
    }

    public void onMainPage() {
        driver.get(PagesUrls.mainPage);
        waitForPageLoaded(PagesUrls.mainPage);
    }

    public void mainPageIsDisplayed() {
            try {
                waitForPageLoaded(PagesUrls.mainPage);
            } catch (Exception e) {
                refreshPage();
                int count = 1;
                sa.assertTrue(count > 0, "Loaded with second step");
                waitForPageLoaded(PagesUrls.mainPage);
            }
    }

    public void firstBtnClick() {
        click(firstBTN);
    }

    public void secondBTNClick() { // клик на левый скрол главного баннера
        click(secondBTN);
    }

    public void searchInputAndClick(String textForSearch) {
        typeIntoField(textForSearch, field);
        click(searchBTN);
    }

}
