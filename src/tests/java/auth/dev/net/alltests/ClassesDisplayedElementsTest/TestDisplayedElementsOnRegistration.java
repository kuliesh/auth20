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

public class TestDisplayedElementsOnRegistration extends BaseTestsChrome {

    final static Logger logger = Logger.getLogger(TestDisplayedElementsOnRegistration.class);

    private SelenideElement loginInput = $("#id-login");
    private String strLoginInput = "Поле для вводу 'Придумайте ім'я поштової скриньки' не відображається";

    private SelenideElement passwordInput = $("#id-password");
    private String strPasswordInput = "Поле для вводу 'Придумайте пароль' не відображається";

    private SelenideElement passwordRepeat = $("#id-password-repeat");
    private String strPasswordRepeat = "Поле для вводу 'Введіть пароль повторно' не відображається";

    private SelenideElement nameInput = $("#id-first-name");
    private String strNameInput = "Поле для вводу 'Ім'я' не відображається";

    private SelenideElement surnameInput =$(By.xpath("//section[1]/div/div[2]/input"));
    private String strSurnameInput = "Поле для вводу 'Прізвище' не відображається";

    private SelenideElement dayInput = $("#id-birth-day");
    private String strDayInput = "Поле для вводу 'Числа' не відображається";

    private SelenideElement monthInput= $(".input-select__target");
    private String strMonthInput = "Поле для вводу 'місяць' не відображається";

    private SelenideElement yearInput = $(By.xpath("//section[2]/div/div[2]/input"));
    private String strYearInput = "Поле для вводу 'рік' не відображається";

    private SelenideElement senderInput = $("#id-sender-name");
    private String strSenderInput = "Поле для вводу 'Ім'я відправника' не відображається";

    private SelenideElement reserveMailInput = $("#id-email");
    private String strReserveMailInput = "Поле для вводу 'Резервний e-mail' не відображається";

    private SelenideElement mobileInput = $("#id-mobile");
    private String strMobileInput = "Поле для вводу 'Мобільний телефон' не відображається";

    private SelenideElement codeFild = $(".verifier__send.is-disabled");
    private String strCodeFild = "Поле для вводу 'Отримати код' не відображається";

    private SelenideElement chImport = $(By.xpath("//section[8]/div/label[1]"));
    private String strChImport = "Чекбокс для імпорту не відображається";

    private SelenideElement chAcceptImport = $(By.xpath("//section[8]/div/label[2]"));
    private String strChAcceptImport = "Чекбокс для імпорту для погодження не відображається";

    private SelenideElement submitButton = $(".submit");
    private String strSubmitButton = "Кнопка 'Зареєструвати скриньку' не відображається";

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page of registration");
        open("http://accounts.betadev.ukr.net/login");
        open("http://accounts.dev.ukr.net/login"); //відкриваємо сторінку входу до поштової скриньки
        $(By.linkText("Створити скриньку")).click(); //переходимо на сторінку реєстрації поштової скриньки
        Thread.sleep(2000);
    }

    public void isDispayedElementsReg(){

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertTrue(loginInput.isDisplayed(), strLoginInput);
        softAssertion.assertTrue(passwordInput.isDisplayed(), strPasswordInput);
        softAssertion.assertTrue(passwordRepeat.isDisplayed(), strPasswordRepeat);
        softAssertion.assertTrue(nameInput.isDisplayed(), strNameInput);
        softAssertion.assertTrue(surnameInput.isDisplayed(), strSurnameInput);
        softAssertion.assertTrue(dayInput.isDisplayed(), strDayInput);
        softAssertion.assertTrue(monthInput.isDisplayed(), strMonthInput);
        softAssertion.assertTrue(yearInput.isDisplayed(), strYearInput);
        softAssertion.assertTrue(senderInput.isDisplayed(), strSenderInput);
        softAssertion.assertTrue(reserveMailInput.isDisplayed(), strReserveMailInput);
        softAssertion.assertTrue(mobileInput.isDisplayed(), strMobileInput);
        softAssertion.assertTrue(codeFild.isDisplayed(), strCodeFild);
        softAssertion.assertTrue(chImport.isDisplayed(), strChImport);
        softAssertion.assertTrue(chAcceptImport.isDisplayed(), strChAcceptImport);
        softAssertion.assertTrue(submitButton.isDisplayed(), strSubmitButton);

        softAssertion.assertAll();
    }

    @Test
    public void test001_VerifyElementsWithUkr(){
        refresh();

        logger.info("Відображення елементів на сторінці реєстрації при виборі української локалізації");

        isDispayedElementsReg();
    }

    @Test
    public void test002_VerifyElementsWithRu(){
        refresh();

        logger.info("Відображення елементів на сторінці реєстрації при виборі російської локалізації");
        logger.info("Переключаємося на російську локалізацію");
        $(new Selectors.ByText("Русский")).click();

        isDispayedElementsReg();

        refresh();
    }

    @Test
    public void test003_VerifyElementsWithEng(){
        refresh();

        logger.info("Відображення елементів на сторінці реєстрації при виборі російської локалізації");

        logger.info("Переключаємося на англійську локалізацію");
        $(new Selectors.ByText("English")).click();

        isDispayedElementsReg();

        refresh();
    }

    @Test
    public void test004_VerifiedElementsSex(){
        refresh();
        logger.info("Відображення елементів 'стать' при реєстрації при виборі різних локалізацій");

        SoftAssert softAssertion = new SoftAssert();

        logger.info("Переключаємося на українську локалізацію");
        softAssertion.assertTrue($(By.xpath("//label[text()='Чоловік']")).isDisplayed(), "Радіобатон 'Чоловік' не відображається");
        softAssertion.assertTrue($(By.xpath("//label[text()='Жінка']")).isDisplayed(), "Радіобатон 'Жінка' не відображається");

        logger.info("Переключаємося на роійську локалізацію");
        $(new Selectors.ByText("Русский")).click();
        softAssertion.assertTrue($(By.xpath("//label[text()='Мужчина']")).isDisplayed(), "Радіобатон 'Мужчина' не відображається");
        softAssertion.assertTrue($(By.xpath("//label[text()='Женщина']")).isDisplayed(), "Радіобатон 'Женщина' не відображається");

        logger.info("Переключаємося на англійську локалізацію");
        $(new Selectors.ByText("English")).click();
        softAssertion.assertTrue($(By.xpath("//label[text()='Male']")).isDisplayed(), "Радіобатон 'Male' не відображається");
        softAssertion.assertTrue($(By.xpath("//label[text()='Female']")).isDisplayed(), "Радіобатон 'Female' не відображається");

        softAssertion.assertAll();

        refresh();
    }
}
