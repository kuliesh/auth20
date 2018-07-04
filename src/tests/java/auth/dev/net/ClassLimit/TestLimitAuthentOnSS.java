package auth.dev.net.ClassLimit;

import auth.dev.net.alltests.BaseClassesForTests.BaseTestsChrome;
import com.codeborne.selenide.Selectors;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class TestLimitAuthentOnSS extends BaseTestsChrome {
    Logger logger = Logger.getLogger(TestLimitAuthentOnSS.class);

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page of registration");
        open("http://accounts.ukr.net/login"); //відкриваємо сторінку входу до поштової скриньки

        //Виконуємо вхід до поштового акаунту
        $(By.cssSelector("#id-1")).sendKeys("s.kuliesh ");
        $(By.cssSelector("#id-2")).sendKeys(",fhvfktq!!2018CC");
        $(By.cssSelector(".form__submit")).click();
        Thread.sleep(2000);
    }

    @Test
    public void InputPassword() throws InterruptedException {
        $(By.cssSelector(".login-button__menu-icon")).click();

        $(new Selectors.ByText("Контакти для відновлення")).click();

        $(By.xpath("//article[1]/ul/div/div/div[2]/button[1]")).click();
        Thread.sleep(500);

        int i=1;
        while (i<=100) {

            Random r = new Random();
            char c = (char)('a' + r.nextInt(32));
            String inputPass = ",fhvfktq"+c;

            $(By.cssSelector("#id-privilege-password")).sendKeys(""+inputPass+"");
            $(By.xpath("//section/div[2]/button[1]")).click();

            assertEquals("Неправильний пароль", $(By.cssSelector(".input-text__error")).getText());
            logger.info(i+" раз(а) введено невірни пароль.");
            $(By.cssSelector("#id-privilege-password")).clear();
            i++;
        }
        assertTrue(($(".form")).isDisplayed());
        logger.info("Тест пройщов успішно");
    }
}
