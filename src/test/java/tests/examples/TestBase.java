package tests.examples;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    static void beforeAll(){
        Configuration.browser = "Chrome";
        //hromeOptions options = new ChromeOptions();
        //options.setBinary("C:\\Program Files\\Yandex\\YandexBrowser\\Application\\browser.exe");
        //Configuration.browserCapabilities = options;
        Configuration.baseUrl = "https://qa-guru.github.io/one-page-form";
    }

    @AfterEach
    void afterEach(){closeWebDriver();
    }
}
