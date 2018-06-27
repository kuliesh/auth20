package net.ukr.dev.BasesClassesForTests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTests {
    final static Logger logger = Logger.getLogger(BaseTests.class);

    @BeforeTest
    public static void setup() {
        logger.info("Run browser...");
        System.setProperty("selenide.browser", "chrome");
        System.setProperty("webdriver.chrome.driver", "D:/AutomationTest/authtest");
    }

    @AfterTest
    public static void tearDown(){

    }
}
