package tests;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static tests.testdata.TittleAndSubtittleForms.*;

public class  TestRegistrationForm extends TestBase {

    @Feature("Форма анкеты регистрации студентов")
    @Test
    @DisplayName("Заполнение всех полей на форме")

    void registrationFormTest() {
        step("Открыть главную страницу", () ->
            registrationPage.openPage());
        step("Ввести данные в форму " + practiceFormTittle, () -> {
            registrationPage
                .tittleAndSubtitlePageRegistrationForm(practiceFormTittle, registrationTittle)
                .typeFirstName(testData.userName)
                .typeLastName(testData.userLastName)
                .typeEmailInput(testData.userEmail)
                .setGender(testData.gender)
                .typeUserNumberInput(testData.userNumber)
                .setDateOfBirth(testData.birthDay, testData.birthMonth, testData.birthYear)
                .typeSubjectsInput(testData.subjectsInput)
                .typeGetHobbiesWrapper(testData.hobbies)
                .fileUploader(testData.fileName)
                .typeUserCurrentAddress(testData.currentAddress)
                .setStateAndCity(testData.state, testData.city);
        });
        step("Нажать кнопку submit", () ->
            registrationPage.submitButton());
        step("Проверить результаты заполнения данных", () -> {
            step("Проверить заголовки", () -> {
            registrationPage
                .checkTittleTableSubmittingForm(titleTableForm);});
            registrationPage
                .checkResult("Student Name", testData.userName + " " + testData.userLastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth",
                        testData.birthDay + " " + testData.birthMonth + " " + testData.birthYear)
                .checkResult("Subjects", testData.subjectsInput)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.fileName)
                .checkResult("Address", testData.currentAddress)
                .checkResult("State and City", testData.state + " " + testData.city);});
        step("Закрыть таблицу " + titleTableForm, () ->
            registrationPage.closeModalButton());
    }

//    @Test
//    @DisplayName("Заполнить только обязательные поля")
//
//    void requiredAttrTest() {
//        step("Открыть главную страницу", () ->
//            registrationPage.openPage());
//        step("Ввести данные в форму " + practiceFormTittle, () -> {
//            step("Проверить заголовки", () -> {
//            registrationPage
//                .tittleAndSubtitlePageRegistrationForm(practiceFormTittle, registrationTittle);});
//            registrationPage
//                .typeFirstName(testData.userName)
//                .typeLastName(testData.userLastName)
//                .setGender(testData.gender)
//                .typeUserNumberInput(testData.userNumber);
//        });
//        step("Нажать кнопку submit", () ->
//            registrationPage.submitButton());
//        step("Проверить результаты заполнения данных", () -> {
//             step("Проверить заголовки", () -> {
//             registrationPage
//                .checkTittleTableSubmittingForm(titleTableForm);});
//             registrationPage
//                .checkResult("Student Name", testData.userName + " " + testData.userLastName)
//                .checkResult("Student Email", "-")
//                .checkResult("Gender", testData.gender)
//                .checkResult("Mobile", testData.userNumber)
//                .checkResult("Date of Birth", "-")
//                .checkResult("Subjects", "-")
//                .checkResult("Hobbies", "-")
//                .checkResult("Picture", "-")
//                .checkResult("Address", "-")
//                .checkResult("State and City", "-");
//        });
//        step("Закрыть таблицу " + titleTableForm, () ->
//             registrationPage.closeModalButton());
//        }
//
//    @Test
//    @DisplayName("Валидация незаполненных полей")
//
//    void verifyEmptyFormValidationTest() {
//        step("Открыть главную страницу", () ->
//            registrationPage.openPage());
//        step("Не заполнять поля формы " + practiceFormTittle, () -> {
//            step("Проверить заголовки", () ->
//            registrationPage
//               .tittleAndSubtitlePageRegistrationForm(practiceFormTittle, registrationTittle));
//        });
//        step("Нажать кнопку submit", () ->
//            registrationPage.submitButton());
//        step("Проверить текст ошибки", () ->
//            registrationPage.errorMassage(formErrorText));
//
//    }
//
//    @Test
//    @DisplayName("Ввести 9 символов в номер телефона")
//
//    void verifyNumberValidationTest() {
//        step("Открыть главную страницу", () ->
//            registrationPage.openPage());
//        step("Ввести данные в форму " + practiceFormTittle, () -> {
//            step("Проверить заголовки", () -> {
//            registrationPage
//                .tittleAndSubtitlePageRegistrationForm(practiceFormTittle, registrationTittle);});
//            registrationPage
//                .typeFirstName(testData.userName)
//                .typeLastName(testData.userLastName)
//                .setGender(testData.gender)
//                .typeUserNumberInput(testData.invalidShortUserNumber);
//        });
//        step("Нажать кнопку submit", () ->
//            registrationPage.submitButton());
//        step("Проверить текст ошибки", () ->
//            registrationPage.errorMassage(formErrorText));
//
//    }
//
//    @Test
//    @DisplayName("Валидация на заполнение без фамилии")
//
//    void verifyFirstNameValidationTest() {
//        step("Открыть главную страницу", () ->
//            registrationPage.openPage());
//        step("Ввести данные в форму " + practiceFormTittle, () -> {
//            step("Проверить заголовки", () -> {
//            registrationPage
//                .tittleAndSubtitlePageRegistrationForm(practiceFormTittle, registrationTittle);});
//            registrationPage
//                .typeFirstName(testData.userName)
//                .setGender(testData.gender)
//                .typeUserNumberInput(testData.userNumber);
//        });
//        step("Нажать кнопку submit", () ->
//            registrationPage.submitButton());
//        step("Проверить текст ошибки", () ->
//            registrationPage.errorMassage(formErrorText));
//    }
//
//    @Test
//    @DisplayName("Валидация на заполнение без имени")
//
//    void verifyastNameValidationTest() {
//        step("Открыть главную страницу", () ->
//            registrationPage.openPage());
//        step("Ввести данные в форму " + practiceFormTittle, () -> {
//            step("Проверить заголовки", () -> {
//            registrationPage
//                .tittleAndSubtitlePageRegistrationForm(practiceFormTittle, registrationTittle);});
//            registrationPage
//                .typeLastName(testData.userLastName)
//                .setGender(testData.gender)
//                .typeUserNumberInput(testData.userNumber);
//        });
//        step("Нажать кнопку submit", () ->
//             registrationPage.submitButton());
//        step("Проверить текст ошибки", () ->
//             registrationPage.errorMassage(formErrorText));
//    }
//
//    @Test
//    @DisplayName("Валидация на ввод только цифр в поле Mobile")
//
//    void verifyMolileNumberValidationTest() {
//        step("Открыть главную страницу", () ->
//            registrationPage.openPage());
//        step("Ввести данные в форму " + practiceFormTittle, () -> {
//            step("Проверить заголовки", () -> {
//            registrationPage
//                .tittleAndSubtitlePageRegistrationForm(practiceFormTittle, registrationTittle);});
//            registrationPage
//                .typeFirstName(testData.userName)
//                .typeLastName(testData.userLastName)
//                .setGender(testData.gender)
//                .typeUserNumberInput(testData.phoneInputWithLetters);
//        });
//        step("Нажать кнопку submit", () ->
//            registrationPage.submitButton());
//        step("Проверить текст ошибки", () ->
//            registrationPage.errorMassage(formErrorText));
//    }
//
//    @Test
//    @DisplayName("Ввести спецсимволы в имя")
//
//    void verifyNameSpecialCharactersTest() {
//        step("Открыть главную страницу", () ->
//            registrationPage.openPage());
//        step("Ввести данные в форму " + practiceFormTittle, () -> {
//            step("Проверить заголовки", () -> {
//            registrationPage
//                .tittleAndSubtitlePageRegistrationForm(practiceFormTittle, registrationTittle);});
//            registrationPage
//                .typeFirstName(testData.userName + testData.specChars)
//                .typeLastName(testData.userLastName + testData.specChars)
//                .setGender(testData.gender)
//                .typeUserNumberInput(testData.userNumber);
//        });
//        step("Нажать кнопку submit", () ->
//            registrationPage.submitButton());
//        step("Проверить результаты заполнения данных", () -> {
//            step("Проверить заголовки", () -> {
//            registrationPage
//                .checkTittleTableSubmittingForm(titleTableForm);});
//            registrationPage
//                .checkTittleTableSubmittingForm(titleTableForm)
//                .checkResult("Student Name", testData.userName + testData.specChars + " " + testData.userLastName + testData.specChars)
//                .checkResult("Student Email", "-")
//                .checkResult("Gender", testData.gender)
//                .checkResult("Mobile", testData.userNumber)
//                .checkResult("Date of Birth", "-")
//                .checkResult("Subjects", "-")
//                .checkResult("Hobbies", "-")
//                .checkResult("Picture", "-")
//                .checkResult("Address", "-")
//                .checkResult("State and City", "-");
//        });
//            step("Закрыть таблицу " + titleTableForm, () ->
//            registrationPage.closeModalButton());
//    }

}