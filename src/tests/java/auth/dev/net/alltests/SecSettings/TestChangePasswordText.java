package auth.dev.net.alltests.SecSettings;

import auth.dev.net.alltests.BaseClassesForTests.BaseTestsChrome;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.*;


public class TestChangePasswordText extends BaseTestsChrome {
    final static Logger logger=Logger.getLogger(TestChangePasswordText.class);

    private SelenideElement titlePassCh = $(By.xpath("//main/section[3]/a/h1"));
    private String strTitlePassCh= "Строка 'Зміна пароля' не відображається в блоці зміни пароля";

    private SelenideElement passNow = $(By.xpath("//main/section[3]/div/form/div[2]/label"));
    private String strPassNow = "Строка 'Введіть поточний пароль' не відображається в блоці зміни пароля";

    private SelenideElement passNew = $(By.xpath("//main/section[3]/div/form/div[3]/label"));
    private String strPassNew = "Строка 'Придумайте новий пароль' не відображається в блоці зміни пароля";

    private SelenideElement passNew2 = $(By.xpath("//main/section[3]/div/form/div[4]/label"));
    private String strPassNew2 = "Строка 'Введіть новий пароль повторно' не відображається в блоці зміни пароля";

    private SelenideElement passButt = $(By.cssSelector(".button__content"));
    private String strPassButt = "Строка 'Змінити пароль' на кнопці не відображається в блоці зміни пароля";

    private SelenideElement passIco = $(By.cssSelector(".app-tab__icon.app-tab__icon_change-password"));
    private String strPassIco = "Іконка 'app-tab__icon_change-password' невідображається";

    private SelenideElement passTextHeader = $(By.cssSelector(".app-tab.app-tab_active  div.app-tab__desc"));
    private String strPassTextHeader = "Пароль – це унікальний ключ від вашої поштової скриньки. Тому ми радимо дотримуватися рекомендацій зі створення безпечного пароля і час від часу змінювати його заради вашої безпеки.";

    private String strPassTextUA = "Пароль – це унікальний ключ від вашої поштової скриньки. Тому ми радимо дотримуватися\n" +
            "рекомендацій зі створення\n" +
            "безпечного пароля і час від часу змінювати його заради вашої безпеки.";

    private String strPassTextRU = "Пароль – это уникальный ключ от вашего почтового ящика. Поэтому мы советуем придерживаться\n" +
            "рекомендаций по созданию\n" +
            "безопасного пароля и время от времени менять его ради вашей безопасности.";

    private String strPassTextEN = "Password is a unique token to your mailbox. Therefore, we highly recommend to adhere to the\n" +
            "tips\n" +
            "on how to create a strong password and reset it from time to time to keep your account safe.";

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
        open("http://mail.betadev.ukr.net/desktop#settings/interface");
        $(By.xpath("//table/tbody/tr[2]/td[2]/label/span")).click();
        $(By.xpath("//table/tbody/tr[2]/td[2]/div/div/a[text()='English']")).click();
        $(By.cssSelector(".accept")).click();
        refresh();
    }

    @Test //Перевірка для Української локалізації
    public void TestVerifiedTextUA(){
        open("http://mail.betadev.ukr.net/desktop#security/changePassword");
        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals("Зміна пароля", titlePassCh.getText(), strTitlePassCh);
        softAssertion.assertEquals(strPassTextUA, passTextHeader.getText(), strPassTextHeader);
        softAssertion.assertEquals("Введіть поточний пароль", passNow.getText(), strPassNow);
        softAssertion.assertEquals("Придумайте новий пароль", passNew.getText(), strPassNew);
        softAssertion.assertEquals("Введіть новий пароль повторно", passNew2.getText(), strPassNew2);
        softAssertion.assertEquals("Змінити пароль", passButt.getText(), strPassButt);
        softAssertion.assertTrue(passIco.isDisplayed(), strPassIco);

        softAssertion.assertAll();
        isStopFrame();
    }

    @Test //Перевірка для Російської локалізації
    public void TestVerifiedTextRU() throws InterruptedException {
        turnToRU();

        open("http://mail.betadev.ukr.net/desktop#security/changePassword");
        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals("Смена пароля", titlePassCh.getText(), strTitlePassCh);
        softAssertion.assertEquals(strPassTextRU, passTextHeader.getText(), strPassTextHeader);
        softAssertion.assertEquals("Введите текущий пароль", passNow.getText(), strPassNow);
        softAssertion.assertEquals("Придумайте новый пароль", passNew.getText(), strPassNew);
        softAssertion.assertEquals("Введите новый пароль повторно", passNew2.getText(), strPassNew2);
        softAssertion.assertEquals("Сменить пароль", passButt.getText(), strPassButt);
        softAssertion.assertTrue(passIco.isDisplayed(), strPassIco);

        softAssertion.assertAll();
        isStopFrame();

        turnToUA();
    }

    @Test //Перевірка для Англійської локалізації
    public void TestVerifiedTextEN(){
        turnToEN();

        open("http://mail.betadev.ukr.net/desktop#security/changePassword");
        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals("Password Change", titlePassCh.getText(), strTitlePassCh);
        softAssertion.assertEquals(strPassTextEN, passTextHeader.getText(), strPassTextHeader);
        softAssertion.assertEquals("Re-enter your current password", passNow.getText(), strPassNow);
        softAssertion.assertEquals("Create a new password", passNew.getText(), strPassNew);
        softAssertion.assertEquals("Confirm your new password", passNew2.getText(), strPassNew2);
        softAssertion.assertEquals("Change password", passButt.getText(), strPassButt);
        softAssertion.assertTrue(passIco.isDisplayed(), strPassIco);

        softAssertion.assertAll();
        isStopFrame();

        turnToUA();
    }
}
