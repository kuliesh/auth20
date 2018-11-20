package auth.dev.net.alltests.ClassesSecSettings;

import auth.dev.net.alltests.BaseClassesForTests.BaseTestsChrome;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.*;

public class TestPersonalText extends BaseTestsChrome {
    final static  Logger logger = Logger.getLogger(TestPersonalText.class);

    private SelenideElement titlePersonal = $(By.xpath("//main/section[5]/a/h1"));
    private String strTitlePersonal = "Строка 'Особисті дані' не відображається в блоці зміни пароля";

    private SelenideElement personalBd = $(By.xpath("//main/section[5]/a/div[3]"));
    private String strPersonalBd = "Строка 'Ваші особисті дані знадобляться для відновлення доступу до пошти за допомогою паспорта, якщо інші способи виявляться неможливими. Тому ім'я, прізвище і дата народження, вказані тут, повинні збігатися з вашими паспортними даними. Інакше ніхто, навіть ми, не зможе допомогти вам – доступ до пошти буде втрачено назавжди.";

    private SelenideElement personalIco = $(By.cssSelector(".app-tab__icon.app-tab__icon_personal-data"));
    private String strPersonalIco = "Іконка 'app-tab__icon_personal-data' невідображається";

    private SelenideElement personalName = $(By.xpath("//main/section[5]/div/div/article[1]/label"));
    private String strPersonalName = "Текст 'Ім'я' невідображається";
    private SelenideElement personalSecName = $(By.xpath("//main/section[5]/div/div/article[2]/label"));
    private String strPersonalSecName = "Текст 'Прізвище' невідображається";
    private SelenideElement personalDay = $(By.xpath("//main/section[5]/div/div/article[3]/label"));
    private String strPersonalDay= "Текст 'Дата народження' невідображається";
    private SelenideElement personalSex = $(By.xpath("//main/section[5]/div/div/article[4]/label"));
    private String strPersonalSex = "Текст 'Стать' невідображається";
    private SelenideElement personalTextBut = $(By.cssSelector(".button__content"));
    private String strPersonalTextBut = "Текст 'Редагувати' невідображається";
    private SelenideElement personalBut = $(By.cssSelector(".button__content"));
    private String strPersonalBut = "Кнопка 'Редагувати' невідображається";

    private String strPersonalBdTextUA = "Ваші особисті дані знадобляться для відновлення доступу до пошти за допомогою паспорта, якщо інші способи виявляться неможливими. Тому ім'я, прізвище і дата народження, вказані тут, повинні збігатися з вашими паспортними даними. Інакше ніхто, навіть ми, не зможе допомогти вам – доступ до пошти буде втрачено назавжди.";
    private String strPersonalBdTextRU = "Ваши личные данные понадобятся для восстановления доступа к почте с помощью паспорта, если другие способы окажутся невозможными. Поэтому имя, фамилия и дата рождения, указываемые здесь, должны совпадать с вашими паспортными данными. В противном случае никто, даже мы, не сможет помочь вам – доступ к ящику будет утерян навсегда.";
    private String strPersonalBdTextEN = "Your personal info will be used to help you regain access to your mailbox with your ID, if any other recovery options are not available. Thus, first name, last name and birthdate, specified here, should match those in your ID. Otherwise, this option will also become unavailable, and nobody, not even us, would be capable of recovering access to your account - your mailbox will be permanently unavailable.";

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

        open("http://alpha.dev.ukr.net/desktop#security/personalData");

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals("Особисті дані", titlePersonal.getText(), strTitlePersonal);
        softAssertion.assertEquals(strPersonalBdTextUA, personalBd.getText(), strPersonalBd);
        softAssertion.assertTrue(personalIco.isDisplayed(), strPersonalIco);

        softAssertion.assertEquals("Ім'я", personalName.getText(), strPersonalName);
        softAssertion.assertEquals("Прізвище", personalSecName.getText(), strPersonalSecName);
        softAssertion.assertEquals("Дата народження", personalDay.getText(), strPersonalDay);
        softAssertion.assertEquals("Стать", personalSex.getText(), strPersonalSex);
        softAssertion.assertEquals("Редагувати", personalTextBut.getText(), strPersonalTextBut);
        softAssertion.assertTrue(personalBut.isDisplayed(), strPersonalBut);

        softAssertion.assertAll();

        isStopFrame();
    }

    @Test //Перевірка для Російської локалізації
    public void TestVerifiedTextRU(){

        turnToRU();

        open("http://alpha.dev.ukr.net/desktop#security/personalData");

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals("Личные данные", titlePersonal.getText(), strTitlePersonal);
        softAssertion.assertEquals(strPersonalBdTextRU, personalBd.getText(), strPersonalBd);
        softAssertion.assertTrue(personalIco.isDisplayed(), strPersonalIco);

        softAssertion.assertEquals("Имя", personalName.getText(), strPersonalName);
        softAssertion.assertEquals("Фамилия", personalSecName.getText(), strPersonalSecName);
        softAssertion.assertEquals("Дата рождения", personalDay.getText(), strPersonalDay);
        softAssertion.assertEquals("Пол", personalSex.getText(), strPersonalSex);
        softAssertion.assertEquals("Редактировать", personalTextBut.getText(), strPersonalTextBut);
        softAssertion.assertTrue(personalBut.isDisplayed(), strPersonalBut);

        softAssertion.assertAll();

        isStopFrame();

        turnToUA();
    }

    @Test //Перевірка для Англійської локалізації
    public void TestVerifiedTextEN(){

        turnToEN();

        open("http://alpha.dev.ukr.net/desktop#security/personalData");

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals("Personal Info", titlePersonal.getText(), strTitlePersonal);
        softAssertion.assertEquals(strPersonalBdTextEN, personalBd.getText(), strPersonalBd);
        softAssertion.assertTrue(personalIco.isDisplayed(), strPersonalIco);

        softAssertion.assertEquals("First name", personalName.getText(), strPersonalName);
        softAssertion.assertEquals("Last name", personalSecName.getText(), strPersonalSecName);
        softAssertion.assertEquals("Birthdate", personalDay.getText(), strPersonalDay);
        softAssertion.assertEquals("Gender", personalSex.getText(), strPersonalSex);
        softAssertion.assertEquals("Edit", personalTextBut.getText(), strPersonalTextBut);
        softAssertion.assertTrue(personalBut.isDisplayed(), strPersonalBut);

        softAssertion.assertAll();

        isStopFrame();

        turnToUA();
    }
}
