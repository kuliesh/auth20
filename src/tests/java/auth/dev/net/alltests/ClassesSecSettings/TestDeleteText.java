package auth.dev.net.alltests.ClassesSecSettings;

import auth.dev.net.alltests.BaseClassesForTests.BaseTestsChrome;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.*;

public class TestDeleteText extends BaseTestsChrome {
    final static  Logger logger = Logger.getLogger(TestDeleteText.class);

    private SelenideElement titleDelete = $(By.xpath("//main/section[6]/a/h1"));
    private String strTitleDelete = "Строка 'Видалення акаунта' не відображається в блоці зміни пароля";

    private SelenideElement deleteBd = $(By.xpath("//main/section[6]/a/div[3]"));
    private String strDeleteBd = "Строка 'Якщо ви вважаєте, що ця поштова скринька вам більше не знадобиться, ви можете її видалити.";

    private SelenideElement deleteIco = $(By.cssSelector(".app-tab__icon.app-tab__icon_delete-account"));
    private String strDeleteIco = "Іконка 'app-tab__icon_delete-account' невідображається";

    private String strDeleteBdTextUA = "Якщо ви вважаєте, що ця поштова скринька вам більше не знадобиться, ви можете її видалити.";
    private String strDeleteBdTextRU = "Если вы полагаете, что этот почтовый ящик вам больше не понадобится, вы можете его удалить.";
    private String strDeleteBdTextEN = "If you consider that you don’t need your mailbox anymore, you can delete your account.";

    private String strDeleteText1 = "Текст 'Видалення призведе до втрати доступу до всього вмісту скриньки, а вхідні листи будуть відхилятися. Тому, будь ласка, згадайте, чи не пов'язана ця скринька з важливими для вас інтернет-сервісами і платіжними системами.' невідображається";
    private String strDeleteText2 = "Текст 'Нам шкода, що ви вирішили видалити свою поштову скриньку @UKR.NET.\n" +
            "Ми розуміємо, що на це є причини, і будемо вдячні, якщо ви поділитеся ними.' невідображається";
    private String strDeleteText3 = "Текст 'Я створював(ла) цю скриньку для реєстрації на інших сайтах і не планую використовувати її у майбутньому.' невідображається";
    private String strDeleteText4 = "Текст 'Я створював(ла) цю скриньку для отримання розсилок, і вони мені більше не потрібні.' невідображається";
    private String strDeleteText5 = "Текст 'Я створював(ла) цю скриньку для робочого і(чи) особистого листування, але вона мені більше не потрібна.' невідображається";
    private String strDeleteText6 = "Текст 'Я створив(ла) іншу поштову скриньку.' невідображається";
    private String strDeleteText7 = "Текст 'Я почав(ла) отримувати забагато спаму в цю скриньку.' невідображається";
    private String strDeleteText8 = "Текст 'Я хочу видалити цю скриньку з міркувань безпеки.' невідображається";
    private String strDeleteText9 = "Текст 'Інше' невідображається";
    private String strDeleteText10 = "Текст в полі 'Введіть пароль для підтвердження видалення' невідображається";
    private String strDeleteText11 = "Текст на кнопці 'Видалити акаунт' невідображається";

    private SelenideElement deleteText1 = $(By.xpath("//main/section[6]/form/p"));
    private SelenideElement deleteText2 = $(By.xpath("//main/section[6]/form/b"));
    private SelenideElement deleteText3 = $(By.xpath("//main/section[6]/form/div[1]/label[2]/p"));
    private SelenideElement deleteText4 = $(By.xpath("//main/section[6]/form/div[2]/label[2]/p"));
    private SelenideElement deleteText5 = $(By.xpath("//main/section[6]/form/div[3]/label[2]/p"));
    private SelenideElement deleteText6 = $(By.xpath("//main/section[6]/form/div[4]/label[2]/p"));
    private SelenideElement deleteText7 = $(By.xpath("//main/section[6]/form/div[5]/label[2]/p"));
    private SelenideElement deleteText8 = $(By.xpath("//main/section[6]/form/div[6]/label[2]/p"));
    private SelenideElement deleteText9 = $(By.xpath("//main/section[6]/form/div[7]/label[2]/p"));
    private SelenideElement deleteText10 = $(By.xpath("//main/section[6]/form/div[9]/label"));
    private SelenideElement deleteText11 = $(By.cssSelector(".button__content"));

    private String strDeleteElText1 = "Елемент - перший чекбокс - невідображається";
    private String strDeleteElText2 = "Елемент - другий чекбокс - невідображається";
    private String strDeleteElText3 = "Елемент - третій чекбокс - невідображається";
    private String strDeleteElText4 = "Елемент - четвертий чекбокс - невідображається";
    private String strDeleteElText5 = "Елемент - п'ятий чекбокс - невідображається";
    private String strDeleteElText6 = "Елемент - шостий чекбокс - невідображається";
    private String strDeleteElText7 = "Елемент - сьомий чекбокс - невідображається";
    //private String strDeleteElText8 = "Елемент - око - невідображається";
    private String strDeleteElText9 = "Елемент -  поля вводу - невідображається";
    private String strDeleteElText10 = "Елемент - кнопка видалення - невідображається";

    private SelenideElement deleteElText1 = $(By.xpath("//main/section[6]/form/div[1]/label[1]"));
    private SelenideElement deleteElText2 = $(By.xpath("//main/section[6]/form/div[2]/label[1]"));
    private SelenideElement deleteElText3 = $(By.xpath("//main/section[6]/form/div[3]/label[1]"));
    private SelenideElement deleteElText4 = $(By.xpath("//main/section[6]/form/div[4]/label[1]"));
    private SelenideElement deleteElText5 = $(By.xpath("//main/section[6]/form/div[5]/label[1]"));
    private SelenideElement deleteElText6 = $(By.xpath("//main/section[6]/form/div[6]/label[1]"));
    private SelenideElement deleteElText7 = $(By.xpath("//main/section[6]/form/div[7]/label[1]"));
    //private SelenideElement deleteElText8 = $(By.xpath("//main/section[6]/form/div[9]/div/label/button"));
    private SelenideElement deleteElText9 = $(By.xpath("//main/section[6]/form/div[9]/div/input"));
    private SelenideElement deleteElText10 = $(By.cssSelector(".button__content"));

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

        open("http://alpha.dev.ukr.net/desktop#security/deleteAccount");

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals("Видалення акаунта", titleDelete.getText(), strTitleDelete);
        softAssertion.assertEquals(strDeleteBdTextUA, deleteBd.getText(), strDeleteBd);
        softAssertion.assertTrue(deleteIco.isDisplayed(), strDeleteIco);

        softAssertion.assertEquals("Видалення призведе до втрати доступу до всього вмісту скриньки, а вхідні листи будуть відхилятися. Тому, будь ласка, згадайте, чи не пов'язана ця скринька з важливими для вас інтернет-сервісами і платіжними системами.", deleteText1.getText(), strDeleteText1);
        softAssertion.assertEquals("Нам шкода, що ви вирішили видалити свою поштову скриньку @UKR.NET.\n" +
                "Ми розуміємо, що на це є причини, і будемо вдячні, якщо ви поділитеся ними.", deleteText2.getText(), strDeleteText2);
        softAssertion.assertEquals("Я створював(ла) цю скриньку для реєстрації на інших сайтах і не планую використовувати її у майбутньому.", deleteText3.getText(), strDeleteText3);
        softAssertion.assertEquals("Я створював(ла) цю скриньку для отримання розсилок, і вони мені більше не потрібні.", deleteText4.getText(), strDeleteText4);
        softAssertion.assertEquals("Я створював(ла) цю скриньку для робочого і(чи) особистого листування, але вона мені більше не потрібна.", deleteText5.getText(), strDeleteText5);
        softAssertion.assertEquals("Я створив(ла) іншу поштову скриньку.", deleteText6.getText(), strDeleteText6);
        softAssertion.assertEquals("Я почав(ла) отримувати забагато спаму в цю скриньку.", deleteText7.getText(), strDeleteText7);
        softAssertion.assertEquals("Я хочу видалити цю скриньку з міркувань безпеки.", deleteText8.getText(), strDeleteText8);
        softAssertion.assertEquals("Інше:", deleteText9.getText(), strDeleteText9);
        softAssertion.assertEquals("Введіть пароль для підтвердження видалення", deleteText10.getText(), strDeleteText10);
        softAssertion.assertEquals("Видалити акаунт", deleteText11.getText(), strDeleteText11);

        softAssertion.assertTrue(deleteElText1.isDisplayed(), strDeleteElText1);
        softAssertion.assertTrue(deleteElText2.isDisplayed(), strDeleteElText2);
        softAssertion.assertTrue(deleteElText3.isDisplayed(), strDeleteElText3);
        softAssertion.assertTrue(deleteElText4.isDisplayed(), strDeleteElText4);
        softAssertion.assertTrue(deleteElText5.isDisplayed(), strDeleteElText5);
        softAssertion.assertTrue(deleteElText6.isDisplayed(), strDeleteElText6);
        softAssertion.assertTrue(deleteElText7.isDisplayed(), strDeleteElText7);
        //softAssertion.assertTrue(deleteElText8.isDisplayed(), strDeleteElText8);
        softAssertion.assertTrue(deleteElText9.isDisplayed(), strDeleteElText9);
        softAssertion.assertTrue(deleteElText10.isDisplayed(), strDeleteElText10);

        softAssertion.assertAll();

        isStopFrame();
    }

    @Test //Перевірка для Російської локалізації
    public void TestVerifiedTextRU(){

        turnToRU();

        open("http://alpha.dev.ukr.net/desktop#security/deleteAccount");

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals("Удаление аккаунта", titleDelete.getText(), strTitleDelete);
        softAssertion.assertEquals(strDeleteBdTextRU, deleteBd.getText(), strDeleteBd);
        softAssertion.assertTrue(deleteIco.isDisplayed(), strDeleteIco);


        softAssertion.assertEquals("Удаление приведет к потере доступа ко всему содержимому ящика, а входящие письма будут отклоняться. Поэтому, пожалуйста, вспомните, не связан ли данный почтовый ящик с важными для вас интернет-сервисами и платежными системами.", deleteText1.getText(), strDeleteText1);
        softAssertion.assertEquals("Нам жаль, что вы решили удалить свой почтовый ящик @UKR.NET.\n" +
                "Мы понимаем, что на это есть причины и будем признательны, если вы ими поделитесь.", deleteText2.getText(), strDeleteText2);
        softAssertion.assertEquals("Я создавал(а) этот ящик для регистрации на других сайтах и не планирую использовать его в будущем.", deleteText3.getText(), strDeleteText3);
        softAssertion.assertEquals("Я создавал(а) этот ящик для получения рассылок, и они мне больше не нужны.", deleteText4.getText(), strDeleteText4);
        softAssertion.assertEquals("Я создавал(а) этот ящик для рабочей и(или) личной переписки, но он мне больше не нужен.", deleteText5.getText(), strDeleteText5);
        softAssertion.assertEquals("Я создал(а) другой почтовый ящик.", deleteText6.getText(), strDeleteText6);
        softAssertion.assertEquals("Я стал(а) получать слишком много спама в этот ящик.", deleteText7.getText(), strDeleteText7);
        softAssertion.assertEquals("Я хочу удалить этот ящик из соображений безопасности.", deleteText8.getText(), strDeleteText8);
        softAssertion.assertEquals("Другое:", deleteText9.getText(), strDeleteText9);
        softAssertion.assertEquals("Введите пароль для подтверждения удаления", deleteText10.getText(), strDeleteText10);
        softAssertion.assertEquals("Удалить аккаунт", deleteText11.getText(), strDeleteText11);

        softAssertion.assertTrue(deleteElText1.isDisplayed(), strDeleteElText1);
        softAssertion.assertTrue(deleteElText2.isDisplayed(), strDeleteElText2);
        softAssertion.assertTrue(deleteElText3.isDisplayed(), strDeleteElText3);
        softAssertion.assertTrue(deleteElText4.isDisplayed(), strDeleteElText4);
        softAssertion.assertTrue(deleteElText5.isDisplayed(), strDeleteElText5);
        softAssertion.assertTrue(deleteElText6.isDisplayed(), strDeleteElText6);
        softAssertion.assertTrue(deleteElText7.isDisplayed(), strDeleteElText7);
        //softAssertion.assertTrue(deleteElText8.isDisplayed(), strDeleteElText8);
        softAssertion.assertTrue(deleteElText9.isDisplayed(), strDeleteElText9);
        softAssertion.assertTrue(deleteElText10.isDisplayed(), strDeleteElText10);

        softAssertion.assertAll();

        isStopFrame();

        turnToUA();
    }

    @Test //Перевірка для Англійської локалізації
    public void TestVerifiedTextEN(){

        turnToEN();

        open("http://alpha.dev.ukr.net/desktop#security/deleteAccount");

        isRunFrame();

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertEquals("Account Deletion", titleDelete.getText(), strTitleDelete);
        softAssertion.assertEquals(strDeleteBdTextEN, deleteBd.getText(), strDeleteBd);
        softAssertion.assertTrue(deleteIco.isDisplayed(), strDeleteIco);

        softAssertion.assertEquals("Once you delete your account, you will lose access to your data, and incoming messages will be declined. Therefore, please make sure that mailbox is not associated with other internet services and payment systems that are important to you.", deleteText1.getText(), strDeleteText1);
        softAssertion.assertEquals("We regret that you decided to delete your @UKR.NET mailbox.\n" +
                "We recognize that you have the reasons for it, and appreciate, if you could share them with us.", deleteText2.getText(), strDeleteText2);
        softAssertion.assertEquals("I created that mailbox for signing into other services and I do not intend to use it in the future.", deleteText3.getText(), strDeleteText3);
        softAssertion.assertEquals("I created that mailbox for receiving subscription e-mails, and it is no longer needed.", deleteText4.getText(), strDeleteText4);
        softAssertion.assertEquals("I created that mailbox for business and(or) private messaging, and there is no need in it anymore.", deleteText5.getText(), strDeleteText5);
        softAssertion.assertEquals("I created another mailbox.", deleteText6.getText(), strDeleteText6);
        softAssertion.assertEquals("That mailbox is overwhelmed with spam.", deleteText7.getText(), strDeleteText7);
        softAssertion.assertEquals("I would like to delete that mailbox for security reasons.", deleteText8.getText(), strDeleteText8);
        softAssertion.assertEquals("Other:", deleteText9.getText(), strDeleteText9);
        softAssertion.assertEquals("To confirm deletion, please re-enter your password", deleteText10.getText(), strDeleteText10);
        softAssertion.assertEquals("Delete account", deleteText11.getText(), strDeleteText11);

        softAssertion.assertTrue(deleteElText1.isDisplayed(), strDeleteElText1);
        softAssertion.assertTrue(deleteElText2.isDisplayed(), strDeleteElText2);
        softAssertion.assertTrue(deleteElText3.isDisplayed(), strDeleteElText3);
        softAssertion.assertTrue(deleteElText4.isDisplayed(), strDeleteElText4);
        softAssertion.assertTrue(deleteElText5.isDisplayed(), strDeleteElText5);
        softAssertion.assertTrue(deleteElText6.isDisplayed(), strDeleteElText6);
        softAssertion.assertTrue(deleteElText7.isDisplayed(), strDeleteElText7);
        //softAssertion.assertTrue(deleteElText8.isDisplayed(), strDeleteElText8);
        softAssertion.assertTrue(deleteElText9.isDisplayed(), strDeleteElText9);
        softAssertion.assertTrue(deleteElText10.isDisplayed(), strDeleteElText10);

        softAssertion.assertAll();

        isStopFrame();

        turnToUA();
    }
}
