package auth.dev.net.alltests.BaseClassesForTests;

import com.codeborne.selenide.WebDriverRunner;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

public class BaseTestsChrome {
    final static Logger logger = Logger.getLogger(BaseTestsChrome.class);

    @BeforeTest
    public static void setup() {
        logger.info("Run browser...");
        System.setProperty("selenide.browser", "chrome");
        System.setProperty("webdriver.chrome.driver", "D:/AutomationTest/auth20/driver/chromedriver.exe");
    }

    public void turnToUA(){
        open("https://alpha.dev.ukr.net/desktop#settings/interface");
        //open("https://mail.betadev.ukr.net/desktop#settings/interface");
        $(By.xpath("//table/tbody/tr[2]/td[2]/label/span")).click();
        $(By.xpath("//table/tbody/tr[2]/td[2]/div/div/a[text()='Українська']")).click();
        $(By.cssSelector(".accept")).click();
        refresh();
    }

    public void turnToRU(){
        open("https://alpha.dev.ukr.net/desktop#settings/interface");
        $(By.xpath("//table/tbody/tr[2]/td[2]/label/span")).click();
        $(By.xpath("//table/tbody/tr[2]/td[2]/div/div/a[text()='Русский']")).click();
        $(By.cssSelector(".accept")).click();
        refresh();
    }

    public void turnToEN(){
        open("https://alpha.dev.ukr.net/desktop#settings/interface");
        $(By.xpath("//table/tbody/tr[2]/td[2]/label/span")).click();
        $(By.xpath("//table/tbody/tr[2]/td[2]/div/div/a[text()='English']")).click();
        $(By.cssSelector(".accept")).click();
        refresh();
    }

    public void isRunFrame(){
        By iframeSecSec = By.cssSelector(".security__iframe");
        switchTo().frame($(iframeSecSec));
    }

    public void isStopFrame(){
        switchTo().defaultContent();
    }

    @AfterTest
    public static void tearDown(){
        logger.info("tearDown()");

        WebDriver webDriver = WebDriverRunner.getWebDriver();
        logger.info(webDriver.getClass());
        webDriver.quit();
    }
}
