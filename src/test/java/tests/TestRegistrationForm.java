package tests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static tests.testdata.TableRegistrationForm.*;
import static tests.testdata.TestData.*;

public class TestRegistrationForm extends TestBase {
    @Test
    @DisplayName("Заполнение полной формы")
    void registrationFormTest() {
        registrationPage.openPage()
                .tittleAndSubtittlePageRegistrationForm(practiceFormTittle, registrationTittle)
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
                .tittleTableSubmittingForm(titleTableForm)
                .checkResultTable(STUDENT_NAME, userName + " " + userLastName)
                .checkResultTable(STUDENT_EMAIL, userEmail)
                .checkResultTable(GENDER, gender)
                .checkResultTable(MOBILE, userNumber)
                .checkResultTable(DATE_OF_BIRTH, birthDay + " " + birthMonth + " " + birthYear)
                .checkResultTable(SUBJECTS, subjectsInput)
                .checkResultTable(HOBBIES, hobbies)
                .checkResultTable(PICTURE, fileName)
                .checkResultTable(ADDRESS, currentAddress)
                .checkResultTable(STATE_AND_CITY, state + " " + city)
                .closeModalButton();
    }

    @Test
    @DisplayName("Заполнение обязательных полей")
    void requiredAttrTest() {
        registrationPage.openPage()
                .tittleAndSubtittlePageRegistrationForm(practiceFormTittle, registrationTittle)
                .typeFirstName(userName)
                .typeLastName(userLastName)
                .setGender(gender)
                .typeUserNumberInput(userNumber)
                .submitButton()
                .tittleTableSubmittingForm(titleTableForm)
                .checkResultTable(STUDENT_NAME, userName + " " + userLastName)
                .checkResultTable(STUDENT_EMAIL, "-")
                .checkResultTable(GENDER, gender)
                .checkResultTable(MOBILE, userNumber)
                .checkResultTable(DATE_OF_BIRTH, "-")
                .checkResultTable(SUBJECTS, "-")
                .checkResultTable(HOBBIES, "-")
                .checkResultTable(PICTURE, "-")
                .checkResultTable(ADDRESS, "-")
                .checkResultTable(STATE_AND_CITY, "-")
                .closeModalButton();
    }

    @Test
    @DisplayName("Проверка по нажатию на кнопку в пустой форме")
    void verifyEmptyFormValidationTest() {
        registrationPage.openPage()
                .tittleAndSubtittlePageRegistrationForm(practiceFormTittle, registrationTittle)
                .submitButton()
                .errorMassage(formErrorText);

    }
    @Test
    @DisplayName("Проверка на 9 символов в номере")

    void verifyNumberValidationTest() {
        registrationPage.openPage()
                .tittleAndSubtittlePageRegistrationForm(practiceFormTittle, registrationTittle)
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
                .tittleAndSubtittlePageRegistrationForm(practiceFormTittle, registrationTittle)
                .typeFirstName(userName)
                .setGender(gender)
                .typeUserNumberInput(userNumber)
                .submitButton()
                .errorMassage(formErrorText);
    }

    @Test
    @DisplayName("Проверка на заполнение только фамилии")

    void verifyastNameValidationTest() { //проверка на заполнение только фамилии
        registrationPage.openPage()
                .tittleAndSubtittlePageRegistrationForm(practiceFormTittle, registrationTittle)
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
                .tittleAndSubtittlePageRegistrationForm(practiceFormTittle, registrationTittle)
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
                .tittleAndSubtittlePageRegistrationForm(practiceFormTittle, registrationTittle)
                .typeFirstName(userName + specChars)
                .typeLastName(userLastName + specChars)
                .setGender(gender)
                .typeUserNumberInput(userNumber)
                .submitButton()
                .tittleTableSubmittingForm(titleTableForm)
                .checkResultTable(STUDENT_NAME, userName + specChars + " " + userLastName + specChars)
                .checkResultTable(STUDENT_EMAIL, "-")
                .checkResultTable(GENDER, gender)
                .checkResultTable(MOBILE, userNumber)
                .checkResultTable(DATE_OF_BIRTH, "-")
                .checkResultTable(SUBJECTS, "-")
                .checkResultTable(HOBBIES, "-")
                .checkResultTable(PICTURE, "-")
                .checkResultTable(ADDRESS, "-")
                .checkResultTable(STATE_AND_CITY, "-")
                .closeModalButton();
    }

}