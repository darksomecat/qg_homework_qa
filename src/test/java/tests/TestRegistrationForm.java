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
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Anna Ukolova"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("darksomecat@gmails.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Other"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8123456789"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("02 Dec 1997"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Computer Science"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("images.jpeg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("My address"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
        $(byId("closeModal")).click();
    }

    @Test
    void requiredAttrTest() { //заполнение обязательных полей
        open("/automation-practice-form.html");
        $("[aria-label=Close]").click(); //закрытие всплывающего окна
        $(byId("firstName")).setValue("Anna");
        $(byId("lastName")).setValue("Ukolova");
        $("[id=genterWrapper]").$(byText("Female")).click();
        $(byId("userNumber")).setValue("8123456789");
        $(byId("submit")).click();
        //проверка результата заполнения формы
        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Anna Ukolova"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("-"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8123456789"));
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
    void verifyMolileNumberValidationTest() { //проверка на валидацию только цифр в поле Mobile
        open("/automation-practice-form.html");
        $("[aria-label=Close]").click(); //закрытие всплывающего окна
        $(byId("firstName")).setValue("Anna");
        $(byId("lastName")).setValue("Ukolova");
        $("[id=genterWrapper]").$(byText("Other")).click();
        $(byId("userNumber")).setValue("qweasdzxcv");
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
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("AnnaАнна!№;:?*()_{}{ UkolovaУколова!@#$%^&*()_"));
        $(byId("closeModal")).click();
    }

}