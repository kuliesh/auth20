package auth.dev.net.alltests.ClassesSettings;

import auth.dev.net.alltests.BaseClassesForTests.BaseTestsChrome;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.*;

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

    private SelenideElement speedKey = $(By.xpath("//header/div[1]//div[1]/div/a[1]"));
    private String strSpeedKey = "Tекст 'Швидкі клавіші' не відображаэться коректно для даної локалізації";

    private SelenideElement hellper = $(By.xpath("//header/div[1]//div[1]/div/a[2]"));
    private String strHellper = "Tекст 'Допомога' не відображаэться коректно для даної локалізації\"";

    private SelenideElement privat = $(By.xpath("//header/div[1]//div[1]/div/a[3]"));
    private String strPrivat = "Tекст 'Конфіденційність' не відображаэться коректно для даної локалізації";

    private SelenideElement exitBut = $(By.cssSelector("#login__logout>b"));
    private String strExitBut = "Tекст 'Вихід' не відображаэться коректно для даної локалізації";
    //============================================================================================

    private SelenideElement allSet = $(By.xpath("//header/div[1]//div[2]/p"));
    private String strAllSet = "Tекст 'Загальні налаштування' не відображаэться коректно для даної локалізації";

    private SelenideElement account = $(By.xpath("//header/div[1]//div[2]/a[1]"));
    private String strAccount = "Tекст 'Обліковий запис' не відображаэться коректно для даної локалізації";

    private SelenideElement answering = $(By.xpath("//header/div[1]//div[2]/a[2]"));
    private String strAnswering = "Tекст 'Автовідповідач' не відображаэться коректно для даної локалізації";

    private SelenideElement interF = $(By.xpath("//header/div[1]//div[2]/a[3]"));
    private String strInterF = "Tекст 'Інтерфейс' не відображаэться коректно для даної локалізації";

    private SelenideElement filters = $(By.xpath("//header/div[1]//div[2]/a[4]"));
    private String strFilters = "Tекст 'Фільтри' не відображаэться коректно для даної локалізації";

    private SelenideElement impor = $(By.xpath("//header/div[1]//div[2]/a[5]"));
    private String strImport = "Tекст 'Імпорт пошти' не відображаэться коректно для даної локалізації";

    private SelenideElement address = $(By.xpath("//header/div[1]//div[2]/a[6]"));
    private String strAddress = "Tекст 'Додаткові адреси' не відображаэться коректно для даної локалізації";

    private SelenideElement mailProg = $(By.xpath("//header/div[1]//div[2]/a[7]"));
    private String strMailProg = "Tекст 'Поштові програми' не відображаэться коректно для даної локалізації";

    private SelenideElement forward= $(By.xpath("//header/div[1]//div[2]/a[8]"));
    private String strForward = "Tекст 'Пересилання листів' не відображаэться коректно для даної локалізації";

    //============================================================================================
    private SelenideElement setSec = $(By.xpath("//header/div[1]//div[3]/p"));
    private String strSetSec = "Tекст 'Налаштування безпеки' не відображаэться коректно для даної локалізації";

    private SelenideElement review = $(By.xpath("//header/div[1]//div[3]/p/button"));
    private String strReview = "Tекст 'Огляд' не відображаэться коректно для даної локалізації";

    private SelenideElement openSession = $(By.xpath("//header/div[1]//div[3]/a[1]"));
    private String strOpenSession = "Tекст 'Відкриті сесії' не відображаэться коректно для даної локалізації";

    private SelenideElement contRec = $(By.xpath("//header/div[1]//div[3]/a[2]"));
    private String strContRec = "Tекст 'Контакти для відновлення' не відображаэться коректно для даної локалізації";

    private SelenideElement magSec = $(By.xpath("//header/div[1]//div[3]/a[3]"));
    private String strMagSec = "Tекст 'Журнал безпеки' не відображаэться коректно для даної локалізації";

    private SelenideElement privData = $(By.xpath("//header/div[1]//div[3]/a[4]"));
    private String strPrivData = "Tекст 'Особисті дані' не відображаэться коректно для даної локалізації";

    private SelenideElement passCh = $(By.xpath("//header/div[1]//div[3]/a[5]"));
    private String strPassCh = "Tекст 'Зміна пароля' не відображаэться коректно для даної локалізації";

    private SelenideElement deleteAc = $(By.xpath("//header/div[1]//div[3]/a[6]"));
    private String strDeleteAc = "Tекст 'Видалення аккаунту' не відображаэться коректно для даної локалізації";

    //============================================================================================
    @Test //Перевірка для Української локалізації
    public void TestVerifiedTextUA() throws InterruptedException {

        turnToUA();

        open("http://mail.betadev.ukr.net/desktop");

        $(By.cssSelector(".login-button__menu-icon")).click();

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals("Швидкі клавіші", speedKey.getText(), strSpeedKey);
        softAssertion.assertEquals("Допомога", hellper.getText(), strHellper);
        softAssertion.assertEquals("Конфіденційність", privat.getText(), strPrivat);
        softAssertion.assertEquals("Вихід", exitBut.getText(), strExitBut);

        softAssertion.assertEquals("Загальні налаштування", allSet.getText(), strAllSet);
        softAssertion.assertEquals("Обліковий запис", account.getText(), strAccount);
        softAssertion.assertEquals("Автовідповідач", answering.getText(), strAnswering);
        softAssertion.assertEquals("Інтерфейс", interF.getText(), strInterF);
        softAssertion.assertEquals("Фільтри", filters.getText(), strFilters);
        softAssertion.assertEquals("Імпорт пошти", impor.getText(), strImport);
        softAssertion.assertEquals("Додаткові адреси", address.getText(), strAddress);
        softAssertion.assertEquals("Поштові програми", mailProg.getText(), strMailProg);
        softAssertion.assertEquals("Пересилання листів", forward.getText(), strForward);

        softAssertion.assertEquals("Налаштування безпекиОгляд", setSec.getText(), strSetSec);
        softAssertion.assertEquals("Огляд", review.getText(), strReview);
        softAssertion.assertEquals("Відкриті сесії", openSession.getText(), strOpenSession);
        softAssertion.assertEquals("Контакти для відновлення", contRec.getText(), strContRec);
        softAssertion.assertEquals("Журнал безпеки", magSec.getText(), strMagSec);
        softAssertion.assertEquals("Особисті дані", privData.getText(), strPrivData);
        softAssertion.assertEquals("Зміна пароля", passCh.getText(), strPassCh);
        softAssertion.assertEquals("Видалення аккаунту", deleteAc.getText(), strDeleteAc);

        softAssertion.assertAll();

    }

    @Test //Перевірка для Російської локалізації
    public void TestVerifiedTextRU() throws InterruptedException {

        turnToRU();

        open("http://mail.betadev.ukr.net/desktop");

        $(By.cssSelector(".login-button__menu-icon")).click();

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals("Быстрые клавиши", speedKey.getText(), strSpeedKey);
        softAssertion.assertEquals("Помощь", hellper.getText(), strHellper);
        softAssertion.assertEquals("Конфиденциальность", privat.getText(), strPrivat);
        softAssertion.assertEquals("Выход", exitBut.getText(), strExitBut);

        softAssertion.assertEquals("Общие настройки", allSet.getText(), strAllSet);
        softAssertion.assertEquals("Учетная запись", account.getText(), strAccount);
        softAssertion.assertEquals("Автоответчик", answering.getText(), strAnswering);
        softAssertion.assertEquals("Интерфейс", interF.getText(), strInterF);
        softAssertion.assertEquals("Фильтры", filters.getText(), strFilters);
        softAssertion.assertEquals("Импорт почты", impor.getText(), strImport);
        softAssertion.assertEquals("Дополнительные адреса", address.getText(), strAddress);
        softAssertion.assertEquals("Почтовые программы", mailProg.getText(), strMailProg);
        softAssertion.assertEquals("Пересылка писем", forward.getText(), strForward);

        softAssertion.assertEquals("Настройки безопасностиОбзор", setSec.getText(), strSetSec);
        softAssertion.assertEquals("Обзор", review.getText(), strReview);
        softAssertion.assertEquals("Открытые сессии", openSession.getText(), strOpenSession);
        softAssertion.assertEquals("Контакты для восстановления", contRec.getText(), strContRec);
        softAssertion.assertEquals("Журнал безопасности", magSec.getText(), strMagSec);
        softAssertion.assertEquals("Личные данные", privData.getText(), strPrivData);
        softAssertion.assertEquals("Смена пароля", passCh.getText(), strPassCh);
        softAssertion.assertEquals("Удаление аккаунта", deleteAc.getText(), strDeleteAc);

        softAssertion.assertAll();

        turnToUA();
    }

    @Test //Перевірка для Англійської локалізації
    public void TestVerifiedTextEN(){
        turnToEN();

        open("http://mail.betadev.ukr.net/desktop");

        $(By.cssSelector(".login-button__menu-icon")).click();

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals("Hot keys", speedKey.getText(), strSpeedKey);
        softAssertion.assertEquals("Help", hellper.getText(), strHellper);
        softAssertion.assertEquals("Privacy", privat.getText(), strPrivat);
        softAssertion.assertEquals("Sign out", exitBut.getText(), strExitBut);

        softAssertion.assertEquals("General Settings", allSet.getText(), strAllSet);
        softAssertion.assertEquals("My Account", account.getText(), strAccount);
        softAssertion.assertEquals("Automated Responder", answering.getText(), strAnswering);
        softAssertion.assertEquals("Interface", interF.getText(), strInterF);
        softAssertion.assertEquals("Filters", filters.getText(), strFilters);
        softAssertion.assertEquals("Mail Import", impor.getText(), strImport);
        softAssertion.assertEquals("My Other E-mail Addresses", address.getText(), strAddress);
        softAssertion.assertEquals("POP/IMAP Access", mailProg.getText(), strMailProg);
        softAssertion.assertEquals("Forwarding", forward.getText(), strForward);

        softAssertion.assertEquals("Security SettingsOverview", setSec.getText(), strSetSec);
        softAssertion.assertEquals("Overview", review.getText(), strReview);
        softAssertion.assertEquals("Open Sessions", openSession.getText(), strOpenSession);
        softAssertion.assertEquals("Recovery Contacts", contRec.getText(), strContRec);
        softAssertion.assertEquals("Security Log", magSec.getText(), strMagSec);
        softAssertion.assertEquals("Personal Info", privData.getText(), strPrivData);
        softAssertion.assertEquals("Password Change", passCh.getText(), strPassCh);
        softAssertion.assertEquals("Account Deletion", deleteAc.getText(), strDeleteAc);

        softAssertion.assertAll();

        turnToUA();
    }
}
