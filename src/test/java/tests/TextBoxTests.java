package tests;

import org.junit.jupiter.api.Test;
//import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase {

  @Test
    void successfulFillFormTest(){ //полностью заполненная форма
      open("/text-box.html");
      $("[id=userName]").setValue("Anna Ukolova");
      $("[id=userEmail]").setValue("anna@mailzz.ru");
      $("[id=currentAddress]").setValue("ул.Пушкина д2");
      $("[id=permanentAddress]").setValue("ул.Колотушкина");
      $("[id=submit]").click();
      //проверка результата заполнения
      $("[id=output] [id=name]").shouldHave(text("Anna Ukolova"));
      $("[id=output] [id=email]").shouldHave(text("anna@mailzz.ru"));
      $("[id=output] [id=currentAddress]").shouldHave(text("ул.Пушкина д2"));
      $("[id=output] [id=permanentAddress]").shouldHave(text("ул.Колотушкина"));
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
  void successfulNameFormTest(){    //проверка пустой формы
    open("/text-box.html");
    $("[id=userName]").setValue("Anna");
    $("[id=submit]").click();
    //проверка результата заполнения
    $("[id=output] [id=name]").shouldHave(text("Name:Anna"));
    $("[id=output] [id=email]").shouldHave(text("Email:"));
    $("[id=output] [id=currentAddress]").shouldHave(text("Current Address :"));
    $("[id=output] [id=permanentAddress]").shouldHave(text("Permananet Address :"));
  }
  @Test
  void verifyEmailValidationTest() { //проверка на валидацию @почта.домен в поле Email
    open("/text-box.html");
    $("[id=userEmail]").setValue("anna");
    $("[id=submit]").click();
    //проверка результата заполнения
    $("[id=output] [id=email]").shouldHave(text("Адрес электронной почты должен содержать символ \\\"@\\\". В адресе \\\"sd\\\" отсутствует символ \"@\\\""));

  }
}

