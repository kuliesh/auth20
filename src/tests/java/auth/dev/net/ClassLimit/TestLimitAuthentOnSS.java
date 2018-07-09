package auth.dev.net.ClassLimit;

import auth.dev.net.alltests.BaseClassesForTests.BaseTestsChrome;
import com.codeborne.selenide.Selectors;
import org.openqa.selenium.By;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class TestLimitAuthentOnSS extends BaseTestsChrome {
    final static Logger logger = Logger.getLogger(TestLimitAuthentOnSS.class);

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Login to account");
        open("http://accounts-new.dev.ukr.net/login"); //відкриваємо сторінку входу до поштової скриньки

        //Виконуємо вхід до поштового акаунту
        $(By.cssSelector("#id-l")).sendKeys("rest21_final_001");
        $(By.cssSelector("#id-p")).sendKeys(",fhvfktq!!");
        $(By.cssSelector(".form__submit")).click();
        Thread.sleep(2000);
    }

    @Test
    public void InputPassword() throws InterruptedException {
        $(By.cssSelector(".login-button__menu-icon")).click();
        $(new Selectors.ByText("Контакти для відновлення")).click();

        By iframeContacts = By.cssSelector(".security__iframe");
        switchTo().frame($(iframeContacts));

        $(new Selectors.ByText("Замінити")).click();
        Thread.sleep(500);

        int intr=1;
        while (intr<=99) {

            String inputPass = ",fhvfktq"+intr;

            $(By.cssSelector("#id-privilege-password")).clear();
            $(By.cssSelector("#id-privilege-password")).sendKeys(""+inputPass+"");
            $(By.xpath("//section/div[2]/button[1]")).click();
            logger.info(intr+" раз(а) введено невірний пароль. "+inputPass+"");

            //Thread.sleep(2000);
            assertEquals("Неправильний пароль", $(By.cssSelector(".input-text__error")).getText());
            System.out.println(intr+" раз(а) введено невірний пароль. "+inputPass+"");
            intr++;
        }

        $(By.cssSelector("#id-privilege-password")).clear();
        $(By.cssSelector("#id-privilege-password")).sendKeys("fhvfktq");
        $(By.xpath("//section/div[2]/button[1]")).click();
        System.out.println("100 раз(а) введено невірний пароль - 'fhvfktq' ");
        switchTo().defaultContent();
        Thread.sleep(4000);
        assertTrue(($(".form")).isDisplayed());
        logger.info("Тест пройщов успішно");
    }

    @Test
    public void InputPasswordReset() throws InterruptedException {
        $(By.cssSelector(".login-button__menu-icon")).click();
        $(new Selectors.ByText("Контакти для відновлення")).click();

        By iframeContacts = By.cssSelector(".security__iframe");
        switchTo().frame($(iframeContacts));

        $(new Selectors.ByText("Замінити")).click();
        Thread.sleep(500);


        int intr=1;
        while (intr<=50) {

            String inputPass = ",fhvfktq"+intr;

            $(By.cssSelector("#id-privilege-password")).clear();
            $(By.cssSelector("#id-privilege-password")).sendKeys(""+inputPass+"");
            $(By.xpath("//section/div[2]/button[1]")).click();
            logger.info(intr+" раз(а) введено невірний пароль. "+inputPass+"");

            //Thread.sleep(2000);
            assertEquals("Неправильний пароль", $(By.cssSelector(".input-text__error")).getText());
            System.out.println(intr+" раз(а) введено невірний пароль. "+inputPass+"");
            intr++;
        }
        $(By.xpath("//section/div[2]/button[2]")).click();

        $(new Selectors.ByText("Замінити")).click();

        int intb=1;
        while (intb<=99) {

            String inputPass = ",fhvfktq"+intb;

            $(By.cssSelector("#id-privilege-password")).clear();
            $(By.cssSelector("#id-privilege-password")).sendKeys(""+inputPass+"");
            $(By.xpath("//section/div[2]/button[1]")).click();
            logger.info(intb+" раз(а) введено невірний пароль. "+inputPass+"");

            //Thread.sleep(2000);
            assertEquals("Неправильний пароль", $(By.cssSelector(".input-text__error")).getText());
            System.out.println(intr+" раз(а) введено невірний пароль. "+inputPass+"");
            intr++;
        }

        $(By.cssSelector("#id-privilege-password")).clear();
        $(By.cssSelector("#id-privilege-password")).sendKeys("eeeeeeee");
        $(By.xpath("//section/div[2]/button[1]")).click();
        System.out.println("100 раз(а) введено невірний пароль - 'eeeeeeee' ");
        switchTo().defaultContent();
        Thread.sleep(4000);
        assertTrue(($(".form")).isDisplayed());
        logger.info("Тест пройшов успішно");
    }
}
