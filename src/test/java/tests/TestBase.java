package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import tests.pages.RegistrationPage;
import tests.pages.TextBoxPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    RegistrationPage registrationPage = new RegistrationPage();
    @BeforeAll
       static void beforeAll(){
        Configuration.browser = "Chrome";
        //Configuration.baseUrl = "https://qa-guru.github.io/one-page-form";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize="1428x1158";
        closeWebDriver();
    }
}
