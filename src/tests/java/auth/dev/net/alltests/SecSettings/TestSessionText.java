package auth.dev.net.alltests.SecSettings;

import auth.dev.net.alltests.BaseClassesForTests.BaseTestsChrome;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

public class TestSessionText extends BaseTestsChrome {
    final static  Logger logger = Logger.getLogger(TestSessionText.class);

    private SelenideElement titleSession = $(By.xpath("//main/section[1]/a/h1"));
    private String strTitleSession = "Строка 'Відкриті сесії' не відображається в блоці зміни пароля";

    private SelenideElement sessionBd = $(By.xpath("//main/section[1]/a/div[3]"));
    private String strSessionBd = "Строка 'Коли хтось входить у скриньку – створюється сесія. Список сесій відображено у цьому розділі. У ньому також міститься інформація про пристрої, на яких зараз відкрито вашу пошту: тип, операційна система, браузер і IP-адреса. Перевірте, чи всі сесії актуальні. Якщо якийсь пристрій більше вам недоступний чи окрема сесія здаватиметься вам підозрілою, закрийте її і змініть пароль.' не відображається в блоці зміни пароля";

    private SelenideElement sessionIco = $(By.cssSelector(".app-tab__icon.app-tab__icon_sessions"));
    private String strSessionIco = "Іконка 'app-tab__icon_sessions' невідображається";

    private String strSessionBdText = "Коли хтось входить у скриньку – створюється сесія. Список сесій відображено у цьому розділі. У ньому також міститься інформація про пристрої, на яких зараз відкрито вашу пошту: тип, операційна система, браузер і IP-адреса. Перевірте, чи всі сесії актуальні. Якщо якийсь пристрій більше вам недоступний чи окрема сесія здаватиметься вам підозрілою, закрийте її і змініть пароль.";

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Login to account");
        open("http://accounts.betadev.ukr.net/login"); //відкриваємо сторінку входу до поштової скриньки
        $(By.cssSelector("#id-l")).sendKeys("rest21_final_001");
        $(By.cssSelector("#id-p")).sendKeys(",fhvfktq!!");
        $(By.cssSelector(".form__submit")).click();
        //$(new Selectors.ByText("Увійти")).click();
        Thread.sleep(2000);
        refresh();
    }

    public void isRunFrame(){
        By iframePassCh = By.cssSelector(".security__iframe");
        switchTo().frame($(iframePassCh));
    }

    public void isStopFrame(){
        switchTo().defaultContent();
    }

    public void turnToUA(){
        open("http://mail.betadev.ukr.net/desktop#settings/interface");
        $(By.xpath("//table/tbody/tr[2]/td[2]/label/span")).click();
        $(By.xpath("//table/tbody/tr[2]/td[2]/div/div/a[text()='Українська']")).click();
        $(By.cssSelector(".accept")).click();
        refresh();
    }

    public void turnToRU(){
        open("http://mail.betadev.ukr.net/desktop#settings/interface");
        $(By.xpath("//table/tbody/tr[2]/td[2]/label/span")).click();
        $(By.xpath("//table/tbody/tr[2]/td[2]/div/div/a[text()='Русский']")).click();
        $(By.cssSelector(".accept")).click();
        refresh();
    }

    public void turnToEN(){
        open("http://mail.betadev.ukr.net/desktopp#settings/interface");
        $(By.xpath("//table/tbody/tr[2]/td[2]/label/span")).click();
        $(By.xpath("//table/tbody/tr[2]/td[2]/div/div/a[text()='English']")).click();
        $(By.cssSelector(".accept")).click();
        refresh();
    }

    @Test //Перевірка для Української локалізації
    public void TestVerifiedTextUA(){
        open("http://mail.betadev.ukr.net/desktop#security");
        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals("Відкриті сесії", titleSession.getText(), strTitleSession);
        softAssertion.assertEquals(strSessionBdText, sessionBd.getText(), strSessionBd);
        softAssertion.assertTrue(sessionIco.isDisplayed(), strSessionIco);

        softAssertion.assertAll();
        isStopFrame();
    }
}
