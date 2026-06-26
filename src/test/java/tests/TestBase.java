package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
       static void beforeAll(){
        Configuration.browser = "Chrome";
        Configuration.baseUrl = "https://qa-guru.github.io/one-page-form";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize="1428x1158";

    }
}
