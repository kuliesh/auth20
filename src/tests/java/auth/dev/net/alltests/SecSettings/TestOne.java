package auth.dev.net.alltests.SecSettings;

import auth.dev.net.alltests.BaseClassesForTests.BaseTestsChrome;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

public class TestOne extends BaseTestsChrome {
        Logger logger=Logger.getLogger(TestOne.class);

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Login to account");
        open("https://mail.ukr.net/desktop/login"); //відкриваємо сторінку входу до поштової скриньки
        $(By.cssSelector("#id-1")).sendKeys("s.kuliesh");
        $(By.cssSelector("#id-2")).sendKeys(",fhvfktq!!2018CC");
        $(By.cssSelector(".form__submit")).click();
        //$(new Selectors.ByText("Увійти")).click();
        Thread.sleep(2000);
        refresh();
    }

    public void isRunFrame(){
        By iframePassCh = By.cssSelector(".security__iframe");
        switchTo().frame($(iframePassCh));
    }

    public void isStopFrame(){
        switchTo().defaultContent();
    }

    @Test //Перевірка для Української локалізації
    public void TestVerifiedTextUA(){
        open("https://mail.ukr.net/desktop#security/changePassword");
        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals("Пароль – це унікальний ключ від вашої поштової скриньки. Тому ми радимо дотримуватися ", $(By.xpath("/main/section[3]/a/p/text()[1]")).getText(), "Текст є");
        softAssertion.assertEquals("рекомендацій зі створення", $(By.xpath("html/body/main/section[3]/a/p/div/strong/text()")).getText(), "Текст є");
        softAssertion.assertEquals(" безпечного пароля і час від часу змінювати його заради вашої безпеки.", $(By.xpath("/main/section[3]/a/p/text()[2]")).getText(), "Текст є");

        isStopFrame();
    }
}
