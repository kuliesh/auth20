package auth.dev.net.alltests.BaseClassesForTests;

import com.codeborne.selenide.WebDriverRunner;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestsChrome {
    final static Logger logger = Logger.getLogger(BaseTestsChrome.class);

    @BeforeTest
    public static void setup() {
        logger.info("Run browser...");
        System.setProperty("selenide.browser", "chrome");
        System.setProperty("webdriver.chrome.driver", "D:/AutomationTest/auth20/driver/chromedriver.exe");
    }

    @AfterTest
    public static void tearDown(){
        logger.info("tearDown()");

        WebDriver webDriver = WebDriverRunner.getWebDriver();
        logger.info(webDriver.getClass());
        webDriver.quit();
    }
}
