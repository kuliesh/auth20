package auth.dev.net.alltests.ClassesSettings;

import auth.dev.net.alltests.BaseClassesForTests.BaseTestsChrome;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

public class TestAllSettingsText extends BaseTestsChrome {
    public static Logger logger = Logger.getLogger(TestAllSettingsText.class);

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Login to account");
        open("http://accounts.betadev.ukr.net/login"); //відкриваємо сторінку входу до поштової скриньки
        $(By.cssSelector("#id-l")).sendKeys("rest21_final_001");
        $(By.cssSelector("#id-p")).sendKeys(",fhvfktq!!");
        $(By.cssSelector(".form__submit")).click();
        Thread.sleep(2000);
        refresh();
    }

    @Test //Перевірка для Української локалізації
    public void TestVerifiedTextUA(){

        turnToUA();

        open("http://mail.betadev.ukr.net/desktop");



        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertAll();

    }

    @Test //Перевірка для Російської локалізації
    public void TestVerifiedTextRU() throws InterruptedException {

        turnToRU();

        open("http://mail.betadev.ukr.net/desktop");

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertAll();

        turnToUA();
    }

    @Test //Перевірка для Англійської локалізації
    public void TestVerifiedTextEN(){
        turnToEN();

        open("http://mail.betadev.ukr.net/desktop");

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertAll();

        turnToUA();
    }
}
