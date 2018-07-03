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

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

public class TestForbiddenPassword extends BaseTestsChrome {
    final static Logger logger = Logger.getLogger(TestForbiddenPassword.class);

    //Активація дата провайдера
    @DataProvider
    public Object[][] ForbiddenPasswordUkr (Method method) {

        ApachePOIreadHelper excelReader = new ApachePOIreadHelper();
        File file = new File("//auth20/src/tests/java/auth/dev/net/data_files/test_forbidden_password.xlsx");
        excelReader.setExcelFile(String.valueOf(file), "ForbiddenTest");
        List rowsNo = excelReader.getRowContains(method.getName(), 0);
        return excelReader.getTableArray(rowsNo);
    }

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page of registration");
        open("http://accounts.ukr.net/login"); //відкриваємо сторінку входу до поштової скриньки
        $(By.linkText("Створити скриньку")).click(); //переходимо на сторінку реєстрації поштової скриньки
        Thread.sleep(2000);
        refresh();
    }

    @Test(dataProvider = "ForbiddenPasswordUkr")
    public void forbiddenPassword(ArrayList data) {

        String testName = String.valueOf(data.get(0));
        String inputPassword = String.valueOf(data.get(1));
        String displayedError = String.valueOf(data.get(2));

        logger.info("testName = " + testName);
        logger.info("inputPassword = " + inputPassword);
        logger.info("displayedError = " + displayedError);

        SoftAssert softAssertion = new SoftAssert();

        $(By.cssSelector("#id-password")).sendKeys(inputPassword);
        $(By.cssSelector("#id-password-repeat")).click();
        $(By.cssSelector(".input-default__error.is-size-normal")).shouldHave(text(displayedError));

        softAssertion.assertEquals(""+displayedError+"", $(By.cssSelector(".input-default__error.is-size-normal")).getText(), "Пароль '"+inputPassword+"' сприймається системою для Української локалізації");

        refresh();
        softAssertion.assertAll();

    }
}
