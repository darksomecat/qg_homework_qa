package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TextBoxTests extends TestBase {

    @Test
    @DisplayName("полностью заполненная форма")

    void successfulFillFormTest() {

        textBoxPage
                .openPage()
                .typeUserName(testData.fullName)
                .typeUserEmail(testData.userEmail)
                .typeCurrentAddress(testData.currentAddress)
                .typePermanentAddress(testData.permanentAddress)

                .submitForm()
                .checkField("name", testData.fullName)
                .checkField("email", testData.userEmail)
                .checkField("currentAddress", testData.currentAddress)
                .checkField("permanentAddress", testData.permanentAddress);

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
                .typeUserName(testData.fullName)
                .submitForm()
                .checkField("name", testData.fullName);

    }

    @Test
    @DisplayName("проверка на валидацию @почта.домен в поле Email")

    void verifyEmailValidationTest() {

        textBoxPage
                .openPage()
                .typeUserEmail(testData.invalidUserEmail)
                .submitForm()
                .checkValidationMessage(testData.invalidUserEmail);

    }

}

