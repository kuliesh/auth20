package auth.dev.net.alltests.BaseClassesForTests;

import org.apache.log4j.Logger;
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

    }
}
