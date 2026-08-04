package tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.testdata.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.testdata.TestData.*;

public class TestRegistrationForm extends TestBase {
    @BeforeEach
    void openRegistrationForm() {
        open("/automation-practice-form.html");
    }
    @Test
    void registrationFormTest() { //заполнение полной формы
        $("[aria-label=Close]").click(); //закрытие всплывающего окна
        $(".card").shouldHave(text("Practice Form"));
        $(".practice-form-wrapper .subtitle").shouldHave(text("Student Registration Form"));
        $(byId("firstName")).setValue(userName);
        $(byId("lastName")).setValue(userLastName);
        $(byId("userEmail")).setValue(userEmail);
        $("[id=genterWrapper]").$(byText(gender)).click();
        $(byId("userNumber")).setValue(userNumber);
        $(byId("dateOfBirthInput")).click();
        $(byClassName("react-datepicker__month-select")).selectOption(11);
        $(byClassName("react-datepicker__year-select")).selectOption("1997");
        $(".react-datepicker__day.react-datepicker__day--002").click();
        $(byId("subjectsInput")).setValue(subjectsInput);
        $(byId("subjectsDropdown")).click();
        $("[id=hobbiesWrapper]").$(byText(Hobbies)).click();
        $("[id=uploadPicture]").uploadFromClasspath("images.jpeg");
        $(byId("currentAddress")).setValue(currentAddress);
        $(byId("state")).click();
        $("[id=stateCity-wrapper]").$(byText(state)).click();
        $(byId("city")).click();
        $("[id=stateCity-wrapper]").$(byText(city)).click();
        $(byId("submit")).click();
        //проверка результата заполнения формы
        $("[id=example-modal-sizes-title-lg]").shouldHave(text(titleTableForm));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(userName +" " + userLastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(userEmail));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(dateOfBirth));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subjectsInput));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(Hobbies));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("images.jpeg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(state + " " + city));
        $(byId("closeModal")).click();
    }

    @Test
    void requiredAttrTest() { //заполнение обязательных полей
        $("[aria-label=Close]").click(); //закрытие всплывающего окна
        $(byId("firstName")).setValue(userName);
        $(byId("lastName")).setValue(userLastName);
        $("[id=genterWrapper]").$(byText(gender)).click();
        $(byId("userNumber")).setValue(userNumber);
        $(byId("submit")).click();
        //проверка результата заполнения формы
        $("[id=example-modal-sizes-title-lg]").shouldHave(text(titleTableForm));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(userName + " " + userLastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("-"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("-"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("-"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("-"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("-"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("-"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("-"));
        $(byId("closeModal")).click();
    }

    @Test
    void verifyEmptyFormValidationTest() { //проверка по нажатию на кнопку в пустой форме
         $("[aria-label=Close]").click(); //закрытие всплывающего окна
         $(byId("submit")).click();
         //проверка результата валидации
         $("[id=formError]").shouldHave(text(formErrorText));
}
    @Test
    void verifyNumberValidationTest() { //проверка на 9 символов в номере
        $("[aria-label=Close]").click(); //закрытие всплывающего окна
        $(byId("firstName")).setValue(userName);
        $(byId("lastName")).setValue(userLastName);
        $("[id=genterWrapper]").$(byText(gender)).click();
        $(byId("userNumber")).setValue(invalidShortUserNumber);
        $(byId("submit")).click();
        //проверка результата валидации
        $("[id=formError]").shouldHave(text(formErrorText));
    }
    @Test
    void verifyFirstNameValidationTest() { //проверка на заполнение только имени
        $("[aria-label=Close]").click(); //закрытие всплывающего окна
        $(byId("firstName")).setValue(userName);
        $("[id=genterWrapper]").$(byText(gender)).click();
        $(byId("userNumber")).setValue(userNumber);
        $(byId("submit")).click();
        //проверка результата валидации
        $("[id=formError]").shouldHave(text(formErrorText));
    }
    @Test
    void verifyastNameValidationTest() { //проверка на заполнение только фамилии
        $("[aria-label=Close]").click(); //закрытие всплывающего окна
        $(byId("lastName")).setValue(userLastName);
        $("[id=genterWrapper]").$(byText(gender)).click();
        $(byId("userNumber")).setValue(userNumber);
        $(byId("submit")).click();
        //проверка результата валидации
        $("[id=formError]").shouldHave(text(formErrorText));
    }

    @Test
    void verifyMolileNumberValidationTest() { //проверка на валидацию только цифр в поле Mobile
        $("[aria-label=Close]").click(); //закрытие всплывающего окна
        $(byId("firstName")).setValue(userName);
        $(byId("lastName")).setValue(userEmail);
        $("[id=genterWrapper]").$(byText(gender)).click();
        $(byId("userNumber")).setValue(phoneInputWithLetters);
        $(byId("submit")).click();
        //проверка результата валидации
        $("[id=formError]").shouldHave(text(formErrorText));
    }
    @Test
    void verifyNameSpecialCharactersTest() { //проверка на добавление спецсимволов в имя
        $("[aria-label=Close]").click(); //закрытие всплывающего окна
        $(byId("firstName")).setValue(userName + specChars);
        $(byId("lastName")).setValue(userLastName + specChars);
        $("[id=genterWrapper]").$(byText(gender)).click();
        $(byId("userNumber")).setValue(userNumber);
        $(byId("submit")).click();
        //проверка результата заполнения формы
        $("[id=example-modal-sizes-title-lg]").shouldHave(text(titleTableForm));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(userName + specChars + " " + userLastName + specChars));
        $(byId("closeModal")).click();
    }

}