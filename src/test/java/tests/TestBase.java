package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import tests.helpers.Attach;
import tests.pages.RegistrationPage;
import tests.pages.TextBoxPage;
import tests.testdata.TestData;

import java.util.Map;

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
        Configuration.browserSize="1080x1300";
        Configuration.baseUrl = "https://qa-guru.github.io/one-page-form";
        //Configuration.holdBrowserOpen = true;
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-dev-shm-usage", "--no-sandbox", "--start-maximized");
        chromeOptions.setCapability("se:cdpEnabled", false);
        chromeOptions.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true,
                "screenResolution", "1080x1500"
        ));
        Configuration.browserCapabilities = chromeOptions;
        Configuration.remote = "https://user1:1234@selenoid.qa.guru/wd/hub";
    }
    @AfterEach
    void addAtachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.attachAsText("Some file", "Some Content");
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
