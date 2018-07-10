package auth.dev.net.alltests.ClassesDisplayedElementsTest;

import auth.dev.net.alltests.BaseClassesForTests.BaseTestsChrome;
import auth.dev.net.helpers.ApachePOIreadHelper;
import com.codeborne.selenide.Selectors;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class TestDisplayedTextOnRegistrationRU extends BaseTestsChrome {

    final static Logger logger = Logger.getLogger(TestDisplayedTextOnRegistrationRU.class);

    private String section = "//section[3]/section[2]/div/";

    //Активація дата провайдера
    @DataProvider
    public Object[][] TextRUForRegistration (Method method){

        ApachePOIreadHelper excelReader = new ApachePOIreadHelper();
        File file = new File("D:/AutomationTest/auth20/src/tests/java/auth/dev/net/data_files/text_registration_page_data.xlsx");
        excelReader.setExcelFile(String.valueOf(file), "textRU");
        List rowsNo = excelReader.getRowContains(method.getName(), 0 );
        return excelReader.getTableArray(rowsNo);
    }

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page of registration");
        open("http://accounts.betadev.ukr.net/login"); //відкриваємо сторінку входу до поштової скриньки
        $(By.linkText("Створити скриньку")).click(); //переходимо на сторінку реєстрації поштової скриньки
        Thread.sleep(2000);
        refresh();

        logger.info("Переключаємося на російську локалізацію");
        $(new Selectors.ByText("Русский")).click();
    }

    @Test(dataProvider = "TextRUForRegistration")
    public void textRu(ArrayList data) {

        String local= String.valueOf(data.get(0));
        String textReg = String.valueOf(data.get(1));
        String elementReg = String.valueOf(data.get(2));

        logger.info("local = " + local);
        logger.info("textReg = " + textReg);
        logger.info("elementReg = " + elementReg);

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals(""+textReg+"", $(By.xpath(""+elementReg+"")).getText(), "Строка '"+textReg+"' не відображається для Російської локалізації");

        softAssertion.assertAll();

    }

    @Test
    public void textRuNO(){

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertFalse($(By.xpath("//input[id='id-first-name'][@placeholder='Имя']")).isDisplayed(), "Плехолдер 'Имя' не відображається"); //переробити даний запит
        softAssertion.assertTrue($(By.xpath("//section[1]/div/div[2]/input[@placeholder='Фамилия']")).isDisplayed(), "Плехолдер 'Фамилия' не відображається");
        softAssertion.assertTrue($(By.xpath(""+section+"div[1]/input[@placeholder='число']")).isDisplayed(), "Плехолдер 'число' не відображається");
        softAssertion.assertEquals("месяц", $(By.xpath(""+section+"section/div/span")).getText(),"Напис 'месяц' не відображається");
        softAssertion.assertTrue($(By.xpath(""+section+"div[2]/input[@placeholder='год']")).isDisplayed(), "Плехолдер 'год' не відображається");
        softAssertion.assertEquals("На указанный мобильный телефон будет отправлено сообщение с кодом активации" , $(By.xpath("//section[7]/button/span[1]")).getText(), "Строка 'На указанный мобильный телефон будет отправлено сообщение с кодом активации' невыдображаэться");

        softAssertion.assertAll();
    }
}
