package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import tests.pages.RegistrationPage;
import tests.pages.TextBoxPage;
import tests.testdata.TestData;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    TestData testData = new TestData();
    RegistrationPage registrationPage = new RegistrationPage();
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeAll
       static void beforeAll(){
        Configuration.browser = "Chrome";
        Configuration.baseUrl = "https://qa-guru.github.io/one-page-form";
        //Configuration.holdBrowserOpen = true;
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browserVersion = System.getProperty("browserVersion", "148.0");
        Configuration.remote = "https://user1:1234@selenoid.qa.guru/wd/hub";
        closeWebDriver();
    }
    @AfterEach
    void addAtachments() {
        closeWebDriver();

    }
}
