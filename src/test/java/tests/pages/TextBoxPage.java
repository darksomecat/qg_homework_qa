package tests.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextBoxPage {
    private final SelenideElement userNameInput = $("#userName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement outputResults = $("#output");
    private final SelenideElement userCurrentAddress = $("#currentAddress");
    private final SelenideElement userPermanentAddress = $("#permanentAddress");


    public TextBoxPage openPage(){
        open("/text-box");

        return this;
    }

    public TextBoxPage typeUserName(String value) {
        userNameInput. setValue(value);

        return this;
    }

    public TextBoxPage typeCurrentAddress(String value) {
        userCurrentAddress. setValue(value);

        return this;
    }
    public TextBoxPage typePermanentAddress(String value) {
        userPermanentAddress. setValue(value);

        return this;
    }

    public TextBoxPage typeUserEmail(String value) {
        userEmailInput. setValue(value);

        return this;
    }

    public TextBoxPage submitForm() {
        submitButton.click();

        return this;
    }
    public TextBoxPage checkField(String key, String value) {
        outputResults.$(byId(key)).shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkValidationMessage(String value) {
        String validationMessage = executeJavaScript("return arguments[0].validationMessage;", $("[id=userEmail]"));
        assertEquals(
                "Адрес электронной почты должен содержать символ \"@\". В адресе \""+value+"\" отсутствует символ \"@\".",
                validationMessage
        );

        return this;
    }

}
