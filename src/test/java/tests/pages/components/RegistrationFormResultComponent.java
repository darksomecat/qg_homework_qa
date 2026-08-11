package tests.pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class RegistrationFormResultComponent {
    private final SelenideElement tittleTable = $("#example-modal-sizes-title-lg");
    private final SelenideElement table = $(".table-responsive");

    public RegistrationFormResultComponent checkTittleTableSubmittingForm (String value) {
            tittleTable.shouldHave(text(value));
            return this;
        }

    public RegistrationFormResultComponent checkResult(String key, String value) {
        table.$(byText(key))
                .parent()
                .shouldHave(text(value));

        return this;
    }
}