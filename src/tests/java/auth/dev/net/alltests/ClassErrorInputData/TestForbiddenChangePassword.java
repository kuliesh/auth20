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

public class TestForbiddenChangePassword extends BaseTestsChrome {
    final static Logger logger = Logger.getLogger(TestForbiddenChangePassword.class);

    //Активація дата провайдера
    @DataProvider
    public Object[][] ForbiddenPassword (Method method) {

        ApachePOIreadHelper excelReader = new ApachePOIreadHelper();
        File file = new File("D:/AutomationTest/auth20/src/tests/java/auth/dev/net/data_files/test_forbidden_password_reset.xlsx");
        excelReader.setExcelFile(String.valueOf(file), "ForbiddenTest");
        List rowsNo = excelReader.getRowContains(method.getName(), 0);
        return excelReader.getTableArray(rowsNo);
    }

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page of login");
        open("http://accounts.dev.ukr.net/login");
        //open("http://accounts.betadev.ukr.net/login"); //відкриваємо сторінку входу до поштової скриньки
        $(By.cssSelector("#id-l")).sendKeys("reset_003");
        $(By.cssSelector("#id-p")).sendKeys(",fhvfktq!");
        //$(By.cssSelector("#id-p")).sendKeys(",fhvfktq");
        $(By.cssSelector(".form__submit")).click();
        Thread.sleep(2000);
        refresh();
    }

    @Test(dataProvider = "ForbiddenPassword")
    public void forbiddenPassword(ArrayList data) {

        open("http://prod.dev.ukr.net/desktop#security/changePassword");
        //open("https://mail.betadev.ukr.net/desktop#security/changePassword"); //відкриваємо сторінку зміни пароля в налаштуваннях

        isRunFrame();

        String testName = String.valueOf(data.get(0));
        String inputPassword = String.valueOf(data.get(1));
        String displayedError = String.valueOf(data.get(2));

        logger.info("testName = " + testName);
        logger.info("inputPassword = " + inputPassword);
        logger.info("displayedError = " + displayedError);

        SoftAssert softAssertion = new SoftAssert();

        $(By.cssSelector("#change-password-new-input")).sendKeys(""+inputPassword+"");
        $(By.cssSelector(".button.button_type-submit.button_size-normal.change-password__submit")).click();

        softAssertion.assertEquals(""+displayedError+"", $(By.cssSelector(".input-text__error")).getText(), "Пароль '"+inputPassword+"' сприймається системою");

        $(By.cssSelector("#change-password-new-input")).clear();
        softAssertion.assertAll();

        isStopFrame();
    }
}
