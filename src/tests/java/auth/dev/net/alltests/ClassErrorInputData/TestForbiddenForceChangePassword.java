//доробити тест з урахування другої сторінки у файлі
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

import static com.codeborne.selenide.Selenide.*;

public class TestForbiddenForceChangePassword extends BaseTestsChrome {
    final static Logger logger = Logger.getLogger(TestForbiddenForceChangePassword.class);

    //Активація дата провайдера
    @DataProvider
    public Object[][] ForbiddenPassword (Method method) {

        ApachePOIreadHelper excelReader = new ApachePOIreadHelper();
        File file = new File("D:/AutomationTest/auth20/src/tests/java/auth/dev/net/data_files/test_forbidden_password_reset_UKR.xlsx");
        excelReader.setExcelFile(String.valueOf(file), "ForbiddenTest");
        List rowsNo = excelReader.getRowContains(method.getName(), 0);
        return excelReader.getTableArray(rowsNo);
    }

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page of force change password activation page");

        open("http://accounts-new.dev.ukr.net/debug/force_pwd_change/reset_014@dev.ukr.net");
        open("https://accounts-new.dev.ukr.net/login"); //відкриваємо сторінку входу до поштової скриньки
        $(By.cssSelector("#id-l")).sendKeys("reset_014");
        $(By.cssSelector("#id-p")).sendKeys(",fhvfktq");
        $(By.cssSelector(".form__submit")).click();
        Thread.sleep(2000);
        refresh();
    }

    @Test(dataProvider = "ForbiddenPassword")
    public void forbiddenPassword(ArrayList data) {

        //isRunFrame();

        String testName = String.valueOf(data.get(0));
        String inputPassword = String.valueOf(data.get(1));
        String displayedError = String.valueOf(data.get(2));

        logger.info("testName = " + testName);
        logger.info("inputPassword = " + inputPassword);
        logger.info("displayedError = " + displayedError);

        SoftAssert softAssertion = new SoftAssert();

        $(By.cssSelector("#id-new-input")).sendKeys(""+inputPassword+"");
        $(By.cssSelector(".button.button_type-submit.button_size-large.form__submit")).click();

        softAssertion.assertEquals(""+displayedError+"", $(By.cssSelector(".input-text__error")).getText(), "Пароль '"+inputPassword+"' сприймається системою");

        $(By.cssSelector("#id-new-input")).clear();
        softAssertion.assertAll();

       // isStopFrame();
    }
}
