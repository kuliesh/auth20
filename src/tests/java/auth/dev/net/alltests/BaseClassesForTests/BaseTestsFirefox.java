package net.ukr.dev.BasesClassesForTests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestsFirefox {
    final static Logger logger = Logger.getLogger(BaseTests.class);

    @BeforeTest
    public static void setup() {
        logger.info("Run browser...");
//        System.setProperty("selenide.browser", "firefox");
//        System.setProperty("webdriver.chrome.driver", "D:/AutomationTest/authtest/geckodriver.exe");
        System.setProperty("selenide.browser", "opera");
        System.setProperty("webdriver.opera.driver", "D:/AutomationTest/authtest/operadriver.exe");
    }

    @AfterTest
    public static void tearDown(){

    }
}