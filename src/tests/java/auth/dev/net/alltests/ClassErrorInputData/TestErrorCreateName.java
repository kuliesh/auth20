package auth.dev.net.alltests.ClassErrorInputData;

import auth.dev.net.alltests.BaseClassesForTests.BaseTestsChrome;
import auth.dev.net.helpers.ApachePOIreadHelper;
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

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

public class TestErrorCreateName extends BaseTestsChrome {
    final static Logger logger = Logger.getLogger(TestErrorCreateName.class);

    //Активація дата провайдера
    @DataProvider
    public Object[][] InputErrorName (Method method) {

        ApachePOIreadHelper excelReader = new ApachePOIreadHelper();
        File file = new File("D:/AutomationTest/auth20/src/tests/java/auth/dev/net/data_files/test_incorrectly_name_acc.xlsx");
        excelReader.setExcelFile(String.valueOf(file), "Ukr");
        List rowsNo = excelReader.getRowContains(method.getName(), 0);
        return excelReader.getTableArray(rowsNo);
    }

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page of registration");
        open("http://accounts.betadev.ukr.net/login"); //відкриваємо сторінку входу до поштової скриньки
        $(By.linkText("Створити скриньку")).click(); //переходимо на сторінку реєстрації поштової скриньки
        Thread.sleep(2000);
        refresh();
    }

    @Test(dataProvider = "InputErrorName")
    public void incorNamAcc(ArrayList data) throws InterruptedException {

        String testName = String.valueOf(data.get(0));
        String inputName = String.valueOf(data.get(1));
        String displayedError = String.valueOf(data.get(2));
        String infoTest = String.valueOf(data.get(3));

        logger.info("testName = " + testName);
        logger.info("inputName = " + inputName);
        logger.info("displayedError = " + displayedError);
        logger.info("infoTest = " + infoTest);

        SoftAssert softAssertion = new SoftAssert();

        $(By.cssSelector("#id-login")).sendKeys(""+inputName+"");
        $(By.cssSelector("#id-email")).click();

        softAssertion.assertEquals(""+displayedError+"", $(By.xpath("//form/section[1]/div/p")).getText(), "Перевірка '"+displayedError+"' для '"+infoTest+"' не пройшло для системи з Української локалізації");
        refresh();

        softAssertion.assertAll();
    }

}
