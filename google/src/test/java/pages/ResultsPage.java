package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import pagesUrls.PagesUrls;

import java.util.Arrays;
import java.util.List;

public class ResultsPage extends Base {

    By allTab = By.xpath("//span[contains(text(), 'Все')]");
    By videoTab = By.xpath("//a[contains(text(), 'Видео')]");
    By buysTab = By.xpath("//a[contains(text(), 'Покупки')]");
    By imagesTab = By.xpath("//a[contains(text(), 'Картинки')]");
    By mapsTab = By.xpath("//a[contains(text(), 'Карты')]");
    By newsTab = By.xpath("//a[contains(text(), 'Новости')]");
    By booksTab = By.xpath("//a[contains(text(), 'Книги')]");
    By instTab = By.xpath("//a[contains(text(), 'Инструменты поиска')]");
    By field = By.xpath("//input[@name='q']");

    private final List<By> elements;

    public ResultsPage() {
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(allTab, videoTab, buysTab, imagesTab, mapsTab, newsTab, booksTab, instTab, field);
    }

    public void resultsPageIsDisplayed() {
        try {
            waitForPageLoaded(PagesUrls.resultsPageUrl());
        } catch (Exception e) {
            refreshPage();
            int count = 1;
            sa.assertTrue(count > 0, "Loaded with second step");
            waitForPageLoaded(PagesUrls.resultsPageUrl());
        }
    }
}
