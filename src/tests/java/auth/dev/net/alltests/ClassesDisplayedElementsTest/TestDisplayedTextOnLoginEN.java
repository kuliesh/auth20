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

public class TestDisplayedTextOnLoginEN extends BaseTestsChrome {

    final static Logger logger = Logger.getLogger(TestDisplayedTextOnLoginEN.class);

    //Активація дата провайдера
    @DataProvider
    public Object[][] TextENForRegistration (Method method){

        ApachePOIreadHelper excelReader = new ApachePOIreadHelper();
        File file = new File("D:/AutomationTest/auth20/src/tests/java/auth/dev/net/data_files/text_login_page_data.xlsx");
        excelReader.setExcelFile(String.valueOf(file), "textEN");
        List rowsNo = excelReader.getRowContains(method.getName(), 0 );
        return excelReader.getTableArray(rowsNo);
    }

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page of registration");
        open("http://accounts-new.dev.ukr.net/login"); //відкриваємо сторінку входу до поштової скриньки
        Thread.sleep(2000);
        refresh();

        logger.info("Переключаємося на англійську локалізацію");
        $(new Selectors.ByText("English")).click();
    }

    @Test(dataProvider = "TextENForRegistration")
    public void textEn(ArrayList data) {

        String local= String.valueOf(data.get(0));
        String textLogin = String.valueOf(data.get(1));
        String elementLogin = String.valueOf(data.get(2));

        logger.info("local = " + local);
        logger.info("textLogin = " + textLogin);
        logger.info("elementLogin = " + elementLogin);

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals(""+textLogin+"", $(By.xpath(""+elementLogin+"")).getText(), "Строка '"+textLogin+"' не відображається для Англійської локалізації на сторінці логіну до поштового акаунту");

        softAssertion.assertAll();
    }
}
