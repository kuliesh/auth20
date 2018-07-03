package auth.dev.net.alltests.ClassesDisplayedElementsTest;

import auth.dev.net.alltests.BaseClassesForTests.BaseTestsChrome;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

public class TestDisplayedElementsOnLogin extends BaseTestsChrome {

    final static Logger logger = Logger.getLogger(TestDisplayedElementsOnLogin.class);

    private SelenideElement logo = $(".header__logo");
    private String strLogo = "Лого на сторінці логіну не відображається";

    private SelenideElement lang = $(".header__lang-item");
    private String strLang = "Вибір мови на сторінці логіну не відображається";

    private SelenideElement login = $(By.xpath("//form/div[1]/div/input"));
    private String strLogin = "Поле вводу імені акаунту на сторінці логіну не відображається";

    private SelenideElement password = $(By.xpath("//form/div[2]/div/input"));
    private String strPassword = "Поле вводу пароля акаунту на сторінці логіну не відображається";

    private SelenideElement yey = $(By.xpath("//label/button[@class='input-password__eye']"));
    private String strYey = "Око відкриття пароля акаунту на сторінці логіну не відображається";

    private SelenideElement checkbox = $(".checkbox__imitator");
    private String strCheckbox = "Чекбокс на сторінці логіну не відображається";

    private SelenideElement button = $(".button");
    private String strButton = "Кнопка входу на сторінці логіну не відображається";

    private SelenideElement promo = $(".promo");
    private String strPromo = "Блок Promo на сторінці логіну не відображається";

    private SelenideElement footerSupport = $(".footer__support");
    private String strFooterSupport = "Блок Support на сторінці логіну не відображається";

    private SelenideElement footerTerms = $(".footer__terms");
    private String strFooterTerms = "Блок Terms на сторінці логіну не відображається";

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page of login");
        open("http://accounts-new.dev.ukr.net/login"); //відкриваємо сторінку входу до поштової скриньки
        Thread.sleep(2000);
    }

    public void isDispayedElementsLog(){

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertTrue(logo.isDisplayed(), strLogo);
        softAssertion.assertTrue(lang.isDisplayed(), strLang);
        softAssertion.assertTrue(login.isDisplayed(), strLogin);
        softAssertion.assertTrue(password.isDisplayed(), strPassword);
        softAssertion.assertTrue(yey.isDisplayed(), strYey);
        softAssertion.assertTrue(checkbox.isDisplayed(), strCheckbox);
        softAssertion.assertTrue(button.isDisplayed(), strButton);
        softAssertion.assertTrue(promo.isDisplayed(), strPromo);
        softAssertion.assertTrue(footerTerms.isDisplayed(), strFooterSupport);
        softAssertion.assertTrue(footerSupport.isDisplayed(), strFooterTerms);

        softAssertion.assertAll();
    }

    @Test
    public void test001_VerifyElementsWithUkr(){
        refresh();

        logger.info("Відображення елементів на сторінці реєстрації при виборі української локалізації");

        isDispayedElementsLog();
    }

    @Test
    public void test002_VerifyElementsWithRu(){
        refresh();

        logger.info("Відображення елементів на сторінці логіну при виборі російської локалізації");
        logger.info("Переключаємося на російську локалізацію");
        $(new Selectors.ByText("Русский")).click();

        isDispayedElementsLog();
    }

    @Test
    public void test003_VerifyElementsWithEng(){
        refresh();

        logger.info("Відображення елементів на сторінці логіну при виборі російської локалізації");

        logger.info("Переключаємося на англійську локалізацію");
        $(new Selectors.ByText("English")).click();
//
        isDispayedElementsLog();
    }
}
