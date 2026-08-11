package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static tests.testdata.TestData.*;

public class TextBoxTests extends TestBase {

    @Test
    @DisplayName("полностью заполненная форма")

    void successfulFillFormTest() {

        textBoxPage
                .openPage()
                .typeUserName(fullName)
                .typeUserEmail(userEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)

                .submitForm()
                .checkField("name", fullName)
                .checkField("email", userEmail)
                .checkField("currentAddress", currentAddress)
                .checkField("permanentAddress", permanentAddress);

    }

    @Test
    @DisplayName("проверка приема пустой формы")

    void successfulEmptyFormTest(){

            textBoxPage
                    .openPage()
                    .submitForm();

    }

    @Test
    @DisplayName("проверка формы с 1 атрибутом")

    void successfulNameFormTest(){

        textBoxPage
                .openPage()
                .typeUserName(fullName)
                .submitForm()
                .checkField("name", fullName);

    }

    @Test
    @DisplayName("проверка на валидацию @почта.домен в поле Email")

    void verifyEmailValidationTest() {

        textBoxPage
                .openPage()
                .typeUserEmail(invalidUserEmail)
                .submitForm()
                .checkValidationMessage(invalidUserEmail);

    }

}

