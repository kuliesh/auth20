package auth.dev.net.alltests.ClassesSecSettings;

import auth.dev.net.alltests.BaseClassesForTests.BaseTestsChrome;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.*;

public class TestSecrLogText extends BaseTestsChrome {
    final static  Logger logger = Logger.getLogger(TestSecrLogText.class);

    private SelenideElement titleSecrLog = $(By.xpath("//main/section[2]/a/h1"));
    private String strTitleSecrLog = "Строка 'Журнал безпеки' не відображається в блоці зміни пароля";

    private SelenideElement secrLogBd = $(By.xpath("//main/section[2]/a/div[3]"));
    private String strSecrLogBd = "Строка 'Тут ви можете проглянути перелік подій, пов'язаних з безпекою вашої поштової скриньки – як успішних, так і неуспішних (наприклад, невдала спроба входу у скриньку, зміна пароля або контактів для відновлення і т.п.). А також коли, з якого пристрою і країни вони були здійснені. Ці дані допомагають виявити дії зловмисників і вчасно змінити пароль із міркувань безпеки.' не відображається в блоці зміни пароля";

    private SelenideElement secrLogIco = $(By.cssSelector(".app-tab__icon.app-tab__icon_events"));
    private String strSecrLogIco = "Іконка 'app-tab__icon_events' невідображається";

    private String strSecrLogBdTextUA = "Тут ви можете проглянути перелік подій, пов'язаних з безпекою вашої поштової скриньки – як успішних, так і неуспішних (наприклад, невдала спроба входу у скриньку, зміна пароля або контактів для відновлення і т.п.). А також коли, з якого пристрою і країни вони були здійснені. Ці дані допомагають виявити дії зловмисників і вчасно змінити пароль із міркувань безпеки.";
    private String strSecrLogBdTextRU = "Здесь вы можете просмотреть список событий, связанных с безопасностью вашего почтового ящика – как успешных, так и неуспешных (например, неудачная попытка входа в ящик, смена пароля или контактов для восстановления и т.п.). А также когда, с какого устройства и страны они были предприняты. Эти данные помогают обнаружить действия злоумышленников и вовремя сменить пароль из соображений безопасности.";
    private String strSecrLogBdTextEN = "Here you can see the list of security events related to your account – both successful and failed (such as failed sign-ins, changing your password or editing recovery contacts etc.). As well as when, wherefrom and from which devices they took place. These details help you reveal unauthorized users and change password to secure your account on time.";

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Login to account");
        open("https://accounts-alpha.dev.ukr.net/login");  //відкриваємо сторінку входу до поштової скриньки
        $(By.cssSelector("#id-l")).sendKeys("s.kuliesh");
        $(By.cssSelector("#id-p")).sendKeys(",fhvfktq!!2019");
        $(By.cssSelector(".button")).click();
        Thread.sleep(2000);
        refresh();
    }

    @Test //Перевірка для Української локалізації
    public void TestVerifiedTextUA(){

        turnToUA();

        open("http://alpha.dev.ukr.net/desktop#security/actions");

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals("Журнал безпеки", titleSecrLog.getText(), strTitleSecrLog);
        softAssertion.assertEquals(strSecrLogBdTextUA, secrLogBd.getText(), strSecrLogBd);
        softAssertion.assertTrue(secrLogIco.isDisplayed(), strSecrLogIco);

        softAssertion.assertAll();

        isStopFrame();
    }

    @Test //Перевірка для Російської локалізації
    public void TestVerifiedTextRU(){

        turnToRU();

        open("http://alpha.dev.ukr.net/desktop#security/actions");

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals("Журнал безопасности", titleSecrLog.getText(), strTitleSecrLog);
        softAssertion.assertEquals(strSecrLogBdTextRU, secrLogBd.getText(), strSecrLogBd);
        softAssertion.assertTrue(secrLogIco.isDisplayed(), strSecrLogIco);

        softAssertion.assertAll();

        isStopFrame();

        turnToUA();
    }

    @Test //Перевірка для Англійської локалізації
    public void TestVerifiedTextEN(){

        turnToEN();

        open("http://alpha.dev.ukr.net/desktop#security/actions");

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals("Security Log", titleSecrLog.getText(), strTitleSecrLog);
        softAssertion.assertEquals(strSecrLogBdTextEN, secrLogBd.getText(), strSecrLogBd);
        softAssertion.assertTrue(secrLogIco.isDisplayed(), strSecrLogIco);

        softAssertion.assertAll();

        isStopFrame();

        turnToUA();
    }
}
