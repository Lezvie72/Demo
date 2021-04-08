package hooks;

import org.openqa.selenium.*;
import base.Base;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.asserts.SoftAssert;
import properties.BaseProperties;
import util.Browsers;
import util.WebDriverFactory;

import java.io.File;
import java.util.HashMap;

public class Hooks extends Base {
    private static Integer yandexBotActivated = 0; // 0 - обычный профиль, 1 - яндекс бот

    public static void deleteAllFilesFolder(String path) {
        for (File myFile : new File(path).listFiles())
            if (myFile.isFile()) myFile.delete();
    }

    @Before(order = 0)
    public void before(Scenario scenario) {
        System.out.println(scenario.getName());
        if (scenario.getName().contains("ЯндексБот")){
            yandexBotActivated = 1;
        }
        System.out.println(scenario.getSourceTagNames());
    }


    @Before (order = 1)
    public void setup() {
        BaseProperties.createDownloadDirURL();
        driver = WebDriverFactory.getDriver(Browsers.CHROME);
        driver.manage().window().maximize();
        if (SystemUtils.IS_OS_LINUX) {
            BaseProperties.createDownloadDir();
            deleteAllFilesFolder(BaseProperties.createDownloadDirURL());

        } else {
            BaseProperties.createDownloadDir();
            deleteAllFilesFolder(BaseProperties.createDownloadDirURL());
        }
    }

    public static ChromeOptions chromeOptions() {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", BaseProperties.createDownloadDirURL());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--no-sandbox");
        if (yandexBotActivated.equals(1)) {
            chromeOptions.addArguments("user-agent=yandexbot");
            System.out.println("Test used YandexBot");
        } else {
            System.out.println("Test used NOT yandexbot");
        }
        return chromeOptions;
    }

    @Before
    public void setUpAssert() {
        sa = new SoftAssert();
    }

    @After(order = 20000)
    public void test() {
        sa.assertAll();
        sa = new SoftAssert();
    }

    @After(order = 20000)
    public void makeScreenshot(Scenario s) {
        if (s.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            s.embed(screenshot, "image/png");
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
