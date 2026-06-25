package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import java.io.File;

public class TestBase {
   public static File picture = new File("src/test/java/tests/resources/images.jpeg");
    @BeforeAll
       static void beforeAll(){
        Configuration.browser = "Chrome";
        Configuration.baseUrl = "https://qa-guru.github.io/one-page-form";
       // Configuration.holdBrowserOpen = true;
        Configuration.browserSize="1428x1158";

    }
}
