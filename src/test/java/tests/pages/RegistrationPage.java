package tests.pages;

import com.codeborne.selenide.SelenideElement;
import tests.pages.components.CalendarComponent;
import tests.pages.components.RegistrationFormResultComponent;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    CalendarComponent calender = new CalendarComponent();
    RegistrationFormResultComponent registrationFormResult = new RegistrationFormResultComponent();

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $("[aria-label=Close]").click(); //закрытие всплывающего окна
        $(".card").shouldHave(text("Practice Form"));
        $(".practice-form-wrapper .subtitle").shouldHave(text("Student Registration Form"));
        return this;
    }

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderConteiner = $("#genterWrapper");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesContainer = $("#hobbiesWrapper");
    private final SelenideElement pictureUpload = $("#uploadPicture");
    private final SelenideElement userCurrentAddress = $("#currentAddress");
    private final SelenideElement stateSelect = $("#state");
    private final SelenideElement citySelect = $("#city");
    private final SelenideElement titleMainPageRegistrationForm = $(".card");
    private final SelenideElement subtitleMainPageRegistrationForm = $(".subtitle");
    private final SelenideElement submitForm = $("#submit");
    private final SelenideElement closeModal = $("#closeModal");
    private final SelenideElement validMassage = $("#formError");


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

    public RegistrationPage tittleAndSubtitlePageRegistrationForm(String tittleForm, String subtittleForm) {
        tittleFormPage(tittleForm);
        subtittleFormage(subtittleForm);

        return this;
    }

    public RegistrationPage errorMassage (String value) {
        validMassage.shouldHave(text(value));

        return this;
    }

    public RegistrationPage setDateOfBirth(int day, String month, int year) {
        $("#dateOfBirthInput").click();
        calender.setDate(day, month, year);

        return this;
    }

    public RegistrationPage checkTittleTableSubmittingForm(String value) {
        registrationFormResult.checkTittleTableSubmittingForm(value);
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        registrationFormResult.checkResult(key, value);
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
