package tests;

import org.junit.jupiter.api.Test;
import tests.testdata.TestBase;
//import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.testdata.TestData.*;

public class TextBoxTests extends TestBase {

  @Test
    void successfulFillFormTest(){ //полностью заполненная форма
      open("/text-box.html");
      $("[id=userName]").setValue(userName + " " + userLastName);
      $("[id=userEmail]").setValue(userEmail);
      $("[id=currentAddress]").setValue(currentAddress);
      $("[id=permanentAddress]").setValue(permanentAddress);
      $("[id=submit]").click();
      //проверка результата заполнения
      $("[id=output] [id=name]").shouldHave(text(userName));
      $("[id=output] [id=email]").shouldHave(text(userEmail));
      $("[id=output] [id=currentAddress]").shouldHave(text(currentAddress));
      $("[id=output] [id=permanentAddress]").shouldHave(text(permanentAddress));
   }

  @Test
  void successfulEmptyFormTest(){    //проверка пустой формы
    open("/text-box.html");
    $("[id=submit]").click();
    //проверка результата заполнения
    $("[id=output] [id=name]").shouldHave(text("Name:"));
    $("[id=output] [id=email]").shouldHave(text("Email:"));
    $("[id=output] [id=currentAddress]").shouldHave(text("Current Address :"));
    $("[id=output] [id=permanentAddress]").shouldHave(text("Permananet Address :"));
  }
  @Test
  void successfulNameFormTest(){    //проверка формы с 1 атрибутом
    open("/text-box.html");
    $("[id=userName]").setValue(userName);
    $("[id=submit]").click();
    //проверка результата заполнения
    $("[id=output] [id=name]").shouldHave(text(userName));
    $("[id=output] [id=email]").shouldHave(text("Email:"));
    $("[id=output] [id=currentAddress]").shouldHave(text("Current Address :"));
    $("[id=output] [id=permanentAddress]").shouldHave(text("Permananet Address :"));
  }
  @Test
  void verifyEmailValidationTest() { //проверка на валидацию @почта.домен в поле Email
    open("/text-box.html");
    $("[id=userEmail]").setValue(invalidUserEmail);
    $("[id=submit]").click();
    //проверка результата заполнения
    String validationMessage = executeJavaScript("return arguments[0].validationMessage;", $("[id=userEmail]"));
    assertEquals(
            "Адрес электронной почты должен содержать символ \"@\". В адресе \"anna\" отсутствует символ \"@\".",
            validationMessage
    );
  }
}

