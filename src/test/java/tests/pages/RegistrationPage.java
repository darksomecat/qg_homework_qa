package tests.pages;

import com.codeborne.selenide.SelenideElement;
import tests.pages.components.CalendarComponent;
import tests.testdata.TableRegistrationForm;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calender = new CalendarComponent();

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $("[aria-label=Close]").click(); //закрытие всплывающего окна
        $(".card").shouldHave(text("Practice Form"));
        $(".practice-form-wrapper .subtitle").shouldHave(text("Student Registration Form"));
        return this;
    }

    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement emailInput = $("#userEmail");
    private SelenideElement genderConteiner = $("#genterWrapper");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbiesContainer = $("#hobbiesWrapper");
    private SelenideElement pictureUpload = $("#uploadPicture");
    private SelenideElement userCurrentAddress = $("#currentAddress");
    private SelenideElement stateSelect = $("#state");
    private SelenideElement citySelect = $("#city");
    private SelenideElement resultsRegistration = $(".table-responsive");
    private SelenideElement tittleTable = $("#example-modal-sizes-title-lg");
    private SelenideElement titleMainPageRegistrationForm = $(".card");
    private SelenideElement subtitleMainPageRegistrationForm = $(".subtitle");
    private SelenideElement submitForm = $("#submit");
    private SelenideElement closeModal = $("#closeModal");
    private SelenideElement validMassage = $("#formError");


    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;

    }

    public RegistrationPage typeEmailInput(String value) {
        emailInput.setValue(value);

        return this;
    }

      public RegistrationPage typeUserNumberInput(String value) {
          userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage typeSubjectsInput(String value) {
        subjectsInput.setValue(value);
        $(byId("subjectsDropdown")).click();

        return this;
    }

    public RegistrationPage typeGetHobbiesWrapper(String value) {
        hobbiesContainer.$(byText(value)).click();

        return this;
    }

    public RegistrationPage fileUploader (String value) {
        pictureUpload.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage typeUserCurrentAddress (String value) {
        userCurrentAddress.setValue(value);

        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderConteiner.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setState (String value) {
        stateSelect.click();
        $("[id=stateCity-wrapper]").$(byText(value)).click();
        return this;
    }
    public RegistrationPage setCity (String value) {
        citySelect.click();
        $("[id=stateCity-wrapper]").$(byText(value)).click();

        return this;
    }

    public RegistrationPage setStateAndCity (String state, String city) {
        setState(state);
        setCity(city);

        return this;
    }

    public RegistrationPage tittleFormPage (String value) {
        titleMainPageRegistrationForm.shouldHave(text(value));
        return this;
    }


    public RegistrationPage subtittleFormage (String value) {
        subtitleMainPageRegistrationForm.shouldHave(text(value));

        return this;
    }
    public RegistrationPage tittleAndSubtittlePageRegistrationForm (String tittleForm, String subtittleForm) {
        tittleFormPage(tittleForm);
        subtittleFormage(subtittleForm);

        return this;
    }

    public RegistrationPage tittleTableSubmittingForm (String value) {
        tittleTable.shouldHave(text(value));
        return this;
    }

    public RegistrationPage errorMassage (String value) {
        validMassage.shouldHave(text(value));

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, int month, String year) {
        $("#dateOfBirthInput").click();
        calender.setDate(day, month, year);

        return this;
    }
    public RegistrationPage checkResultTable(TableRegistrationForm field, String value) {

        if (value == null || value.isEmpty()) {
            resultsRegistration.shouldHave(exactText(field.getEmptyText()));
        } else {
            resultsRegistration.$(byText(field.getRow())).parent().shouldHave(text(value));
        }

        return this;
    }

        public RegistrationPage submitButton() {
            submitForm.click();

        return this;
    }
        public RegistrationPage closeModalButton() {
            closeModal.click();

        return this;
    }
}
