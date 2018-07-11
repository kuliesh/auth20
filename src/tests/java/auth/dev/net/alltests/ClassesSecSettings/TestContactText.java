package auth.dev.net.alltests.ClassesSecSettings;

import auth.dev.net.alltests.BaseClassesForTests.BaseTestsChrome;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.*;

public class TestContactText extends BaseTestsChrome {
    final static  Logger logger = Logger.getLogger(TestContactText.class);

    private SelenideElement titleContact = $(By.xpath("//main/section[4]/a/h1"));
    private String strTitleContact = "Строка 'Контакти для відновлення' не відображається в блоці зміни пароля";

    private SelenideElement contactBd = $(By.xpath("//main/section[4]/a/div[3]"));
    private String strContactBd = "Строка 'У випадку якщо ви забудете пароль, ми допоможемо відновити доступ до вашої пошти протягом кількох хвилин: на вказані тут мобільний телефон або резервний e-mail буде відправлено код для зміни пароля. Тому, будь ласка, додайте свої актуальні контактні дані – номер мобільного телефону і резервний e-mail. На ці ж контакти ви зможете отримувати сповіщення безпеки.' не відображається в блоці зміни пароля";

    private SelenideElement contactIco = $(By.cssSelector(".app-tab__icon.app-tab__icon_contacts"));
    private String strContactIco = "Іконка 'app-tab__icon_contacts' невідображається";

    private SelenideElement contactNumTitle = $(By.xpath("//main/section[4]/div/article[1]/h4"));
    private String strContactNumTitle = "Текст 'Мобільний телефон' невідображається";
    private SelenideElement contactNumBut = $(By.xpath("//main/section[4]/div/article[1]/button/div"));
    private String strContactNumBut = "Текст 'додати мобільний телефон' невідображається";
    private SelenideElement contactEmailTit = $(By.xpath("//main/section[4]/div/article[2]/h4"));
    private String strContactEmailTit = "Текст 'Резервний e-mail' невідображається";
    private SelenideElement contactEmailBut = $(By.xpath("//main/section[4]/div/article[2]/button/div"));
    private String strContactBut = "Текст 'додати резервний e-mail' невідображається";

    private String strContactBdTextUA = "У випадку якщо ви забудете пароль, ми допоможемо відновити доступ до вашої пошти протягом кількох хвилин: на вказані тут мобільний телефон або резервний e-mail буде відправлено код для зміни пароля. Тому, будь ласка, додайте свої актуальні контактні дані – номер мобільного телефону і резервний e-mail. На ці ж контакти ви зможете отримувати сповіщення безпеки.";
    private String strContactBdTextRU = "В случае если вы забудете пароль, мы поможем восстановить доступ к вашей почте в течение нескольких минут: на указанные здесь мобильный телефон или резервный e-mail будет отправлен код для смены пароля. Поэтому, пожалуйста, добавьте свои актуальные контактные данные – номер мобильного телефона и резервный e-mail. На эти же контакты вы сможете получать уведомления безопасности.";
    private String strContactBdTextEN = "If you ever forget your password, we will help you regain access to your mailbox within several minutes: a message or a letter with a password reset code will be sent to the mobile phone or optional e-mail provided here. Therefore, please provide your actual contact information: mobile phone and optional e-mail. These contacts will be also used to alert you to your account security events.";

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
        By iframeContact = By.cssSelector(".security__iframe");
        switchTo().frame($(iframeContact));
    }

    public void isStopFrame(){
        switchTo().defaultContent();
    }

    public void turnToUA(){
        open("https://mail.betadev.ukr.net/desktop#settings/interface");
        $(By.xpath("//table/tbody/tr[2]/td[2]/label/span")).click();
        $(By.xpath("//table/tbody/tr[2]/td[2]/div/div/a[text()='Українська']")).click();
        $(By.cssSelector(".accept")).click();
        refresh();
    }

    public void turnToRU(){
        open("https://mail.betadev.ukr.net/desktop#settings/interface");
        $(By.xpath("//table/tbody/tr[2]/td[2]/label/span")).click();
        $(By.xpath("//table/tbody/tr[2]/td[2]/div/div/a[text()='Русский']")).click();
        $(By.cssSelector(".accept")).click();
        refresh();
    }

    public void turnToEN(){
        open("https://mail.betadev.ukr.net/desktop#settings/interface");
        $(By.xpath("//table/tbody/tr[2]/td[2]/label/span")).click();
        $(By.xpath("//table/tbody/tr[2]/td[2]/div/div/a[text()='English']")).click();
        $(By.cssSelector(".accept")).click();
        refresh();
    }

    @Test //Перевірка для Української локалізації
    public void TestVerifiedTextUA(){

        turnToUA();

        open("http://mail.betadev.ukr.net/desktop#security/contacts");
        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals("Контакти для відновлення", titleContact.getText(), strTitleContact);
        softAssertion.assertEquals(strContactBdTextUA, contactBd.getText(), strContactBd);
        softAssertion.assertTrue(contactIco.isDisplayed(), strContactIco);
        softAssertion.assertEquals("Мобільний телефон", contactNumTitle.getText(),strContactNumTitle);
        softAssertion.assertEquals("додати мобільний телефон", contactNumBut.getText(), strContactNumBut);
        softAssertion.assertEquals("Резервний e-mail", contactEmailTit.getText(), strContactEmailTit);
        softAssertion.assertEquals("додати резервний e-mail", contactEmailBut.getText(), strContactBut);

        softAssertion.assertAll();
        isStopFrame();
    }

    @Test //Перевірка для Російської локалізації
    public void TestVerifiedTextRU(){

        turnToRU();

        open("http://mail.betadev.ukr.net/desktop#security/contacts");
        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals("Контакты для восстановления", titleContact.getText(), strTitleContact);
        softAssertion.assertEquals(strContactBdTextRU, contactBd.getText(), strContactBd);
        softAssertion.assertTrue(contactIco.isDisplayed(), strContactIco);
        softAssertion.assertEquals("Мобильный телефон", contactNumTitle.getText(),strContactNumTitle);
        softAssertion.assertEquals("добавить мобильный телефон", contactNumBut.getText(), strContactNumBut);
        softAssertion.assertEquals("Резервный e-mail", contactEmailTit.getText(), strContactEmailTit);
        softAssertion.assertEquals("добавить резервный e-mail", contactEmailBut.getText(), strContactBut);
        softAssertion.assertAll();
        isStopFrame();

        turnToUA();
    }

    @Test //Перевірка для Англійської локалізації
    public void TestVerifiedTextEN(){

        turnToEN();

        open("http://mail.betadev.ukr.net/desktop#security/contacts");
        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals("Recovery Contacts", titleContact.getText(), strTitleContact);
        softAssertion.assertEquals(strContactBdTextEN, contactBd.getText(), strContactBd);
        softAssertion.assertTrue(contactIco.isDisplayed(), strContactIco);
        softAssertion.assertEquals("Mobile phone number", contactNumTitle.getText(),strContactNumTitle);
        softAssertion.assertEquals("add mobile phone number", contactNumBut.getText(), strContactNumBut);
        softAssertion.assertEquals("Optional recovery e-mail address", contactEmailTit.getText(), strContactEmailTit);
        softAssertion.assertEquals("add optional recovery e-mail address", contactEmailBut.getText(), strContactBut);
        softAssertion.assertAll();
        isStopFrame();

        turnToUA();
    }
}
