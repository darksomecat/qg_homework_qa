package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static tests.testdata.TestData.*;
import static tests.testdata.TableTextBoxPage.*;

public class TextBoxTests extends TestBase {

    @Test
    @DisplayName("полностью заполненная форма")

    void successfulFillFormTest_chaining() {

        textBoxPage
                .openPage()
                .typeUserName(fullName)
                .typeUserEmail(userEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)

                .submitForm()
                .checkField(NAME, fullName)
                .checkField(EMAIL, userEmail)
                .checkField(CURRENT_ADDRESS, currentAddress)
                .checkField(PERMANENT_ADDRESS, permanentAddress);

    }

    @Test
    @DisplayName("проверка пустой формы")

    void successfulEmptyFormTest(){

            textBoxPage
                    .openPage()
                    .submitForm()
                    .checkField(NAME, "")
                    .checkField(EMAIL, "")
                    .checkField(CURRENT_ADDRESS, "")
                    .checkField(PERMANENT_ADDRESS, "");

    }

    @Test
    @DisplayName("проверка формы с 1 атрибутом")

    void successfulNameFormTest(){

        textBoxPage
                .openPage()
                .typeUserName(fullName)
                .submitForm()
                .checkField(NAME, fullName)
                .checkField(EMAIL, "")
                .checkField(CURRENT_ADDRESS, "")
                .checkField(PERMANENT_ADDRESS, "");

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

