package tests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static tests.testdata.TittleAndSubtittleForms.*;

public class  TestRegistrationForm extends TestBase {

    @Test
    @DisplayName("Заполнение полной формы")
    void registrationFormTest() {
        registrationPage.openPage()
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
                .setStateAndCity(testData.state, testData.city)
                .submitButton()
                .checkTittleTableSubmittingForm(titleTableForm)
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
                .checkResult("State and City", testData.state + " " + testData.city)
                .closeModalButton();
    }

    @Test
    @DisplayName("Заполнение обязательных полей")
    void requiredAttrTest() {
        registrationPage.openPage()
                .tittleAndSubtitlePageRegistrationForm(practiceFormTittle, registrationTittle)
                .typeFirstName(testData.userName)
                .typeLastName(testData.userLastName)
                .setGender(testData.gender)
                .typeUserNumberInput(testData.userNumber)
                .submitButton()
                .checkTittleTableSubmittingForm(titleTableForm)
                .checkResult("Student Name", testData.userName + " " + testData.userLastName)
                .checkResult("Student Email", "-")
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
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
                .typeFirstName(testData.userName)
                .typeLastName(testData.userLastName)
                .setGender(testData.gender)
                .typeUserNumberInput(testData.invalidShortUserNumber)
                .submitButton()
                .errorMassage(formErrorText);
    }

    @Test
    @DisplayName("Проверка на заполнение только имени")

    void verifyFirstNameValidationTest() {
        registrationPage.openPage()
                .tittleAndSubtitlePageRegistrationForm(practiceFormTittle, registrationTittle)
                .typeFirstName(testData.userName)
                .setGender(testData.gender)
                .typeUserNumberInput(testData.userNumber)
                .submitButton()
                .errorMassage(formErrorText);
    }

    @Test
    @DisplayName("Проверка на заполнение только фамилии")

    void verifyastNameValidationTest() {
        registrationPage.openPage()
                .tittleAndSubtitlePageRegistrationForm(practiceFormTittle, registrationTittle)
                .typeLastName(testData.userLastName)
                .setGender(testData.gender)
                .typeUserNumberInput(testData.userNumber)
                .submitButton()
                .errorMassage(formErrorText);
    }

    @Test
    @DisplayName("Проверка на валидацию только цифр в поле Mobile")

    void verifyMolileNumberValidationTest() {
        registrationPage.openPage()
                .tittleAndSubtitlePageRegistrationForm(practiceFormTittle, registrationTittle)
                .typeFirstName(testData.userName)
                .typeLastName(testData.userLastName)
                .setGender(testData.gender)
                .typeUserNumberInput(testData.phoneInputWithLetters)
                .submitButton()
                .errorMassage(formErrorText);
    }

    @Test
    @DisplayName("Проверка на добавление спецсимволов в имя")

    void verifyNameSpecialCharactersTest() {
        registrationPage.openPage()
                .tittleAndSubtitlePageRegistrationForm(practiceFormTittle, registrationTittle)
                .typeFirstName(testData.userName + testData.specChars)
                .typeLastName(testData.userLastName + testData.specChars)
                .setGender(testData.gender)
                .typeUserNumberInput(testData.userNumber)
                .submitButton()
                .checkTittleTableSubmittingForm(titleTableForm)
                .checkResult("Student Name", testData.userName + testData.specChars + " " + testData.userLastName + testData.specChars)
                .checkResult("Student Email", "-")
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", "-")
                .checkResult("Subjects", "-")
                .checkResult("Hobbies", "-")
                .checkResult("Picture", "-")
                .checkResult("Address", "-")
                .checkResult("State and City", "-")
                .closeModalButton();
    }

}