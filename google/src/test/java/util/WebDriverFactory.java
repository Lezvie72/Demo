package util;

import hooks.Hooks;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverFactory {
    public static WebDriver getDriver(Browsers browserType) {
        WebDriver driver = null;
        switch (browserType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(Hooks.chromeOptions());
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case CHROME_CLEAR:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                break;
        }
        return driver;
    }

}
