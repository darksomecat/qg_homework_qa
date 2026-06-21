package tests;

import org.junit.jupiter.api.Test;
import tests.examples.TestBase;
//import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase {

  @Test
    void successfullFillFormTest(){
      open("/text-box.html");
      $("[id=userName]").setValue("Anna Ukolova");
      $("[id=userEmail]").setValue("anna@mailzz.ru");
      $("[id=currentAddress]").setValue("ул.Пушкина");
      $("[id=permanentAddress]").setValue("ул.Колотушкина");
      $("[id=submit]").click();

      $("[id=output] [id=name]").shouldHave(text("Anna Ukolova"));
      $("[id=output] [id=email]").shouldHave(text("anna@mailzz.ru"));
      $("[id=output] [id=currentAddress]").shouldHave(text("ул.Пушкина"));
      $("[id=output] [id=permanentAddress]").shouldHave(text("ул.Колотушкина"));
   }
}
