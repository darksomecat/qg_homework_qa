package tests.pages;

import com.codeborne.selenide.SelenideElement;
import tests.testdata.TableTextBoxPage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextBoxPage {
    private SelenideElement userNameInput = $("#userName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement outputResults = $("#output");
    private SelenideElement userCurrentAddress = $("#currentAddress");
    private SelenideElement userPermanentAddress = $("#permanentAddress");


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
    public TextBoxPage checkField(TableTextBoxPage field, String value) {
        if (value == null || value.isEmpty())
        {
            outputResults.$(byId(field.getId())).shouldHave(exactText(field.getEmptyText()));
        }
        else
        {
            outputResults.$(byId(field.getId())).shouldHave(text(value));
        }

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
