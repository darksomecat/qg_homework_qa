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

        String remote = System.getProperty("remote");
        String browser = System.getProperty("browser");
        String browserSize = System.getProperty("browserSize");
        String baseUrl = System.getProperty("baseUrl");
        String browserVersion = System.getProperty("browserVersion");
        String headless = System.getProperty("headless");

        if (remote != null) Configuration.remote = remote;
        if (browser != null) Configuration.browser = browser; // Защита от "Chrome" с большой буквы
        if (browserSize != null) Configuration.browserSize = browserSize;
        if (baseUrl != null) Configuration.baseUrl = baseUrl;
        if (browserVersion != null) Configuration.browserVersion = browserVersion;
        if (headless != null) {
            Configuration.headless = Boolean.parseBoolean(headless);
        }

        System.out.println("remote: " + remote);
        System.out.println("browser: " + Configuration.browser);
        System.out.println("browserSize: " + Configuration.browserSize);
        System.out.println("baseUrl: " + Configuration.baseUrl);
        System.out.println("browserVersion: " + Configuration.browserVersion);
        System.out.println("headless: " + Configuration.headless);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-dev-shm-usage", "--no-sandbox", "--start-maximized");
        chromeOptions.setCapability("se:cdpEnabled", false);
        chromeOptions.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true,
                "screenResolution", "1080x1300"
        ));

        Configuration.browserCapabilities = chromeOptions;

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
