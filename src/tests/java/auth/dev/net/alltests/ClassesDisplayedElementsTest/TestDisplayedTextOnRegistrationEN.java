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

public class TestDisplayedTextOnRegistrationEN extends BaseTestsChrome {

    final static Logger logger = Logger.getLogger(TestDisplayedTextOnRegistrationEN.class);

    private String section = "//section[3]/section[2]/div/";

    //Активація дата провайдера
    @DataProvider
    public Object[][] TextENForRegistration (Method method){

        ApachePOIreadHelper excelReader = new ApachePOIreadHelper();
        File file = new File("D:/AutomationTest/auth20/src/tests/java/auth/dev/net/data_files/text_registration_page_data.xlsx");
        excelReader.setExcelFile(String.valueOf(file), "textUA");
        List rowsNo = excelReader.getRowContains(method.getName(), 0 );
        return excelReader.getTableArray(rowsNo);
    }

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page of registration");
        open("http://accounts-new.dev.ukr.net/login"); //відкриваємо сторінку входу до поштової скриньки
        $(By.linkText("Створити скриньку")).click(); //переходимо на сторінку реєстрації поштової скриньки
        Thread.sleep(2000);
        refresh();

        logger.info("Переключаємося на англійську локалізацію");
        $(new Selectors.ByText("English")).click();
    }

    @Test(dataProvider = "TextENForRegistration")
    public void textEn(ArrayList data) {
        String local= String.valueOf(data.get(0));
        String textReg = String.valueOf(data.get(1));
        String elementReg = String.valueOf(data.get(2));

        logger.info("local = " + local);
        logger.info("textReg = " + textReg);
        logger.info("elementReg = " + elementReg);

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals(""+textReg+"", $(By.xpath(""+elementReg+"")).getText(), "Строка '"+textReg+"' не відображається для Англійської локалізації");

        softAssertion.assertAll();
    }

    @Test
    public void textEnNO(){

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertFalse($(By.xpath("//input[id='id-first-name'][@placeholder='First name']")).isDisplayed(), "Плехолдер 'First name' не відображається"); //переробити даний запит
        softAssertion.assertTrue($(By.xpath("//section[1]/div/div[2]/input[@placeholder='Last name']")).isDisplayed(), "Плехолдер 'Last name' не відображається");
        softAssertion.assertTrue($(By.xpath(""+section+"div[1]/input[@placeholder='Day']")).isDisplayed(), "Плехолдер 'Day' не відображається");
        softAssertion.assertEquals("Month", $(By.xpath(""+section+"section/div/span")).getText(),"Напис 'Month' не відображається");
        softAssertion.assertTrue($(By.xpath(""+section+"div[2]/input[@placeholder='Year']")).isDisplayed(), "Плехолдер 'Year' не відображається");
        softAssertion.assertEquals("A message with an activation code will be sent to the phone provided here" , $(By.xpath("//section[7]/button/span[1]")).getText(), "Строка 'A message with an activation code will be sent to the phone provided here' невідображаэться");

        softAssertion.assertAll();
    }
}
