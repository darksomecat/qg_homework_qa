package tests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static tests.testdata.TestData.*;

public class  TestRegistrationForm extends TestBase {
    @Test
    @DisplayName("Заполнение полной формы")
    void registrationFormTest() {
        registrationPage.openPage()
                .tittleAndSubtitlePageRegistrationForm(practiceFormTittle, registrationTittle)
                .typeFirstName(userName)
                .typeLastName(userLastName)
                .typeEmailInput(userEmail)
                .setGender(gender)
                .typeUserNumberInput(userNumber)
                .setDateOfBirth(birthDay, birthMonthIndex, birthYear)
                .typeSubjectsInput(subjectsInput)
                .typeGetHobbiesWrapper(hobbies)
                .fileUploader(fileName)
                .typeUserCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .submitButton()
                .checkTittleTableSubmittingForm(titleTableForm)
                .checkResult("Student Name", userName + " " + userLastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth",
                        birthDay + " " + birthMonth + " " + birthYear)
                .checkResult("Subjects", subjectsInput)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", fileName)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city)
                .closeModalButton();
    }

    @Test
    @DisplayName("Заполнение обязательных полей")
    void requiredAttrTest() {
        registrationPage.openPage()
                .tittleAndSubtitlePageRegistrationForm(practiceFormTittle, registrationTittle)
                .typeFirstName(userName)
                .typeLastName(userLastName)
                .setGender(gender)
                .typeUserNumberInput(userNumber)
                .submitButton()
                .checkTittleTableSubmittingForm(titleTableForm)
                .checkResult("Student Name", userName + " " + userLastName)
                .checkResult("Student Email", "-")
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", "-")
                .checkResult("Subjects", "-")
                .checkResult("Hobbies", "-")
                .checkResult("Picture", "-")
                .checkResult("Address", "-")
                .checkResult("State and City", "-")
                .closeModalButton();
    }

    @Test
    @DisplayName("Проверка по нажатию на кнопку в пустой форме")
    void verifyEmptyFormValidationTest() {
        registrationPage.openPage()
                .tittleAndSubtitlePageRegistrationForm(practiceFormTittle, registrationTittle)
                .submitButton()
                .errorMassage(formErrorText);

    }
    @Test
    @DisplayName("Проверка на 9 символов в номере")

    void verifyNumberValidationTest() {
        registrationPage.openPage()
                .tittleAndSubtitlePageRegistrationForm(practiceFormTittle, registrationTittle)
                .typeFirstName(userName)
                .typeLastName(userLastName)
                .setGender(gender)
                .typeUserNumberInput(invalidShortUserNumber)
                .submitButton()
                .errorMassage(formErrorText);
    }
    @Test
    @DisplayName("Проверка на заполнение только имени")

    void verifyFirstNameValidationTest() {
        registrationPage.openPage()
                .tittleAndSubtitlePageRegistrationForm(practiceFormTittle, registrationTittle)
                .typeFirstName(userName)
                .setGender(gender)
                .typeUserNumberInput(userNumber)
                .submitButton()
                .errorMassage(formErrorText);
    }

    @Test
    @DisplayName("Проверка на заполнение только фамилии")

    void verifyastNameValidationTest() {
        registrationPage.openPage()
                .tittleAndSubtitlePageRegistrationForm(practiceFormTittle, registrationTittle)
                .typeLastName(userLastName)
                .setGender(gender)
                .typeUserNumberInput(invalidShortUserNumber)
                .submitButton()
                .errorMassage(formErrorText);
    }

    @Test
    @DisplayName("Проверка на валидацию только цифр в поле Mobile")

    void verifyMolileNumberValidationTest() {
        registrationPage.openPage()
                .tittleAndSubtitlePageRegistrationForm(practiceFormTittle, registrationTittle)
                .typeFirstName(userName)
                .typeLastName(userLastName)
                .setGender(gender)
                .typeUserNumberInput(phoneInputWithLetters)
                .submitButton()
                .errorMassage(formErrorText);
    }


    @Test
    @DisplayName("Проверка на добавление спецсимволов в имя")

    void verifyNameSpecialCharactersTest() {
        registrationPage.openPage()
                .tittleAndSubtitlePageRegistrationForm(practiceFormTittle, registrationTittle)
                .typeFirstName(userName + specChars)
                .typeLastName(userLastName + specChars)
                .setGender(gender)
                .typeUserNumberInput(userNumber)
                .submitButton()
                .checkTittleTableSubmittingForm(titleTableForm)
                .checkResult("Student Name", userName + specChars + " " + userLastName + specChars)
                .checkResult("Student Email", "-")
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", "-")
                .checkResult("Subjects", "-")
                .checkResult("Hobbies", "-")
                .checkResult("Picture", "-")
                .checkResult("Address", "-")
                .checkResult("State and City", "-")
                .closeModalButton();
    }

}