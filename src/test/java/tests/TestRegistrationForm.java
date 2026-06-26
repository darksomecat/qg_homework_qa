package tests;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestRegistrationForm extends TestBase {
    @Test
    void registrationFormTest() { //заполнение полной формы
        open("/automation-practice-form.html");
        $("[aria-label=Close]").click(); //закрытие всплывающего окна
        $(".card").shouldHave(text("Practice Form"));
        $(".practice-form-wrapper .subtitle").shouldHave(text("Student Registration Form"));
        $(byId("firstName")).setValue("Anna");
        $(byId("lastName")).setValue("Ukolova");
        $(byId("userEmail")).setValue("darksomecat@gmails.com");
        $("[id=genterWrapper]").$(byText("Other")).click();
        $(byId("userNumber")).setValue("8123456789");
        $(byId("dateOfBirthInput")).click();
        $(byClassName("react-datepicker__month-select")).selectOption(11);
        $(byClassName("react-datepicker__year-select")).selectOption("1997");
        $(".react-datepicker__day.react-datepicker__day--002").click();
        $(byId("subjectsInput")).setValue("Science");
        $(byId("subjectsDropdown")).click();
        $("[id=hobbiesWrapper]").$(byText("Music")).click();
        $("[id=uploadPicture]").uploadFromClasspath("images.jpeg");
        $(byId("currentAddress")).setValue("My address");
        $(byId("state")).click();
        $("[id=stateCity-wrapper]").$(byText("NCR")).click();
        $(byId("city")).click();
        $("[id=stateCity-wrapper]").$(byText("Delhi")).click();
        $(byId("submit")).click();
        //проверка результата заполнения формы
        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        $("[id=resultBody]").shouldHave(text("Student Name")).shouldHave(text("Anna Ukolova"));
        $("[id=resultBody]").shouldHave(text("Student Email")).shouldHave(text("darksomecat@gmails.com"));
        $("[id=resultBody]").shouldHave(text("Gender")).shouldHave(text("Other"));
        $("[id=resultBody]").shouldHave(text("Mobile")).shouldHave(text("8123456789"));
        $("[id=resultBody]").shouldHave(text("Date of Birth")).shouldHave(text("02 Dec 1997"));
        $("[id=resultBody]").shouldHave(text("Subjects")).shouldHave(text("Computer Science"));
        $("[id=resultBody]").shouldHave(text("Hobbies")).shouldHave(text("Music"));
        $("[id=resultBody]").shouldHave(text("Picture")).shouldHave(text("images.jpeg"));
        $("[id=resultBody]").shouldHave(text("Address")).shouldHave(text("My address"));
        $("[id=resultBody]").shouldHave(text("State and City")).shouldHave(text("NCR Delhi"));
        $(byId("closeModal")).click();
    }

    @Test
    void requiredAttrTest() { //заполнение обязательных полей
        open("/automation-practice-form.html");
        $("[aria-label=Close]").click(); //закрытие всплывающего окна
        $(byId("firstName")).setValue("Anna");
        $(byId("lastName")).setValue("Ukolova");
        $("[id=genterWrapper]").$(byText("Other")).click();
        $(byId("userNumber")).setValue("8123456789");
        $(byId("submit")).click();
        //проверка результата заполнения формы
        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        $("[id=resultBody]").shouldHave(text("Student Name")).shouldHave(text("Anna Ukolova"));
        $("[id=resultBody]").shouldHave(text("Student Email")).shouldHave(text("-"));
        $("[id=resultBody]").shouldHave(text("Gender")).shouldHave(text("Female"));
        $("[id=resultBody]").shouldHave(text("Mobile")).shouldHave(text("8123456789"));
        $("[id=resultBody]").shouldHave(text("Date of Birth")).shouldHave(text("-"));
        $("[id=resultBody]").shouldHave(text("Subjects")).shouldHave(text("-"));
        $("[id=resultBody]").shouldHave(text("Hobbies")).shouldHave(text("-"));
        $("[id=resultBody]").shouldHave(text("Picture")).shouldHave(text("-"));
        $("[id=resultBody]").shouldHave(text("Address")).shouldHave(text("-"));
        $("[id=resultBody]").shouldHave(text("State and City")).shouldHave(text("-"));
        $(byId("closeModal")).click();
    }

    @Test
    void verifyEmptyFormValidationTest() { //проверка по нажатию на кнопку в пустой форме
         open("/automation-practice-form.html");
         $("[aria-label=Close]").click(); //закрытие всплывающего окна
         $(byId("submit")).click();
         //проверка результата валидации
         $("[id=formError]").shouldHave(text("Please fill required fields and enter a valid 10-digit mobile number."));
}
    @Test
    void verifyNumberValidationTest() { //проверка на 9 символов в номере
        open("/automation-practice-form.html");
        $("[aria-label=Close]").click(); //закрытие всплывающего окна
        $(byId("firstName")).setValue("Anna");
        $(byId("lastName")).setValue("Ukolova");
        $("[id=genterWrapper]").$(byText("Other")).click();
        $(byId("userNumber")).setValue("123456789");
        $(byId("submit")).click();
        //проверка результата валидации
        $("[id=formError]").shouldHave(text("Please fill required fields and enter a valid 10-digit mobile number."));
    }
    @Test
    void verifyFirstNameValidationTest() { //проверка на заполнение только имени
        open("/automation-practice-form.html");
        $("[aria-label=Close]").click(); //закрытие всплывающего окна
        $(byId("firstName")).setValue("Anna");
        $("[id=genterWrapper]").$(byText("Other")).click();
        $(byId("userNumber")).setValue("8123456789");
        $(byId("submit")).click();
        //проверка результата валидации
        $("[id=formError]").shouldHave(text("Please fill required fields and enter a valid 10-digit mobile number."));
    }
    @Test
    void verifyastNameValidationTest() { //проверка на заполнение только фамилии
        open("/automation-practice-form.html");
        $("[aria-label=Close]").click(); //закрытие всплывающего окна
        $(byId("lastName")).setValue("Ukolova");
        $("[id=genterWrapper]").$(byText("Other")).click();
        $(byId("userNumber")).setValue("8123456789");
        $(byId("submit")).click();
        //проверка результата валидации
        $("[id=formError]").shouldHave(text("Please fill required fields and enter a valid 10-digit mobile number."));
    }

    @Test
    void verifyEmailValidationTest() { //проверка на валидацию @почта.домен в поле Email
        open("/automation-practice-form.html");
        $("[aria-label=Close]").click(); //закрытие всплывающего окна
        $(byId("firstName")).setValue("Anna");
        $(byId("lastName")).setValue("Ukolova");
        $("[id=genterWrapper]").$(byText("Other")).click();
        $(byId("userNumber")).setValue("8123456789");
        $(byId("userEmail")).setValue("darksomecat");
        $(byId("submit")).click();
        //проверка результата валидации
        $("[id=formError]").shouldHave(text("Please fill required fields and enter a valid 10-digit mobile number."));
    }
    @Test
    void verifyNameSpecialCharactersTest() { //проверка на добавление спецсимволов в имя
        open("/automation-practice-form.html");
        $("[aria-label=Close]").click(); //закрытие всплывающего окна
        $(byId("firstName")).setValue("AnnaАнна!№;:?*()_{}{");
        $(byId("lastName")).setValue("UkolovaУколова!@#$%^&*()_");
        $("[id=genterWrapper]").$(byText("Other")).click();
        $(byId("userNumber")).setValue("8123456789");
        $(byId("submit")).click();
        //проверка результата заполнения формы
        $("[id=resultBody]").shouldHave(text("Student Name")).shouldHave(text("AnnaАнна!№;:?*()_{}{ UkolovaУколова!@#$%^&*()_"));
        $(byId("closeModal")).click();
    }

}