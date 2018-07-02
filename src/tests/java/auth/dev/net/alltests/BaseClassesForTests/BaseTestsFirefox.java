package auth.dev.net.alltests.BaseClassesForTests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestsFirefox {
    final static Logger logger = Logger.getLogger(BaseTestsFirefox.class);

    @BeforeTest
    public static void setup() {
        logger.info("Run browser...");
        System.setProperty("selenide.browser", "firefox");
        System.setProperty("webdriver.chrome.driver", "D:/AutomationTest/auth20/driver/resources");
    }

    @AfterTest
    public static void tearDown(){

    }
}