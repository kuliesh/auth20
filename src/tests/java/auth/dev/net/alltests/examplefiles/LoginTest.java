package auth.dev.net.alltests.examplefiles;

import auth.dev.net.alltests.BaseClassesForTests.BaseTestsChrome;
import auth.dev.net.helpers.ApachePOIreadHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertFalse;

@Test
public class LoginTest extends BaseTestsChrome {
    final static Logger logger = Logger.getLogger(LoginTest.class);

    //Активація дата провайдера
    @DataProvider
    public Object[][] rightDataForLogin (Method method){

        ApachePOIreadHelper excelReader = new ApachePOIreadHelper();
        File file = new File("D:/AutomationTest/authtest/data_file/login_data.xlsx");
        excelReader.setExcelFile(String.valueOf(file), "LoginTest");
        List rowsNo = excelReader.getRowContains(method.getName(), 0 );
        return excelReader.getTableArray(rowsNo);
    }

    @Test(dataProvider = "rightDataForLogin")
    //формування масиву даних з файла, що був оброблений дата провайдером
    public void loginPasswordData(ArrayList data) throws InterruptedException {
        String login = String.valueOf(data.get(0));
        String userName = String.valueOf(data.get(1));
        String password = String.valueOf(data.get(2));
        logger.info("password = " + password);
        logger.info("userName = " + userName);
        logger.info("login = " + login);

        open("http://newfront.dev.ukr.net/desktop/login");
        Thread.sleep(2000);

        //Вже сам тест
        $(By.cssSelector("#id-1")).sendKeys(userName);
        $(By.cssSelector("#id-2")).sendKeys(password);
        $(By.cssSelector(".button.is-type-submit.is-size-large.form__submit")).click();
        $(By.xpath("html/body/div[1]/div[2]/header/div[1]/div[2]/a/p")).shouldHave(text(userName));
        assertFalse("No user found.",$(By.xpath("html/body/div[1]/div[2]/header/div[1]/div[2]/a/p")).getText().equals(userName));
        $(By.cssSelector(".login-button__menu-icon")).click();
        $(By.cssSelector("#login__logout>b")).click();
        Thread.sleep(2000);
    }
}