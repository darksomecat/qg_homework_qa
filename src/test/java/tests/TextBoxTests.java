package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
  @Test

    void successfullFillFormTest(){
      open("https://qa-guru.github.io/one-page-form/text-box.html");
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
