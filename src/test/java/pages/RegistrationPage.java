package pages;
import pages.components.CalendarComponent;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;


public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            genderWrapper   = $("#genterWrapper"),
            inputEmail =  $("#userEmail"),
            inputUserNumber = $("#userNumber"),
            inputAddress = $("#currentAddress"),
            subjectInput = $("#subjectsInput"),
            chooseHobbies = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            chooseCountry = $("#react-select-3-input"),
            chooseCity =  $("#react-select-4-input"),
            calendarInput = $(".react-datepicker-wrapper"),
            buttonSubmit = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }
    public RegistrationPage removeBanner() {

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }



    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        inputEmail.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        inputUserNumber.setValue(value);

        return this;
    }
    public RegistrationPage setAddress(String value) {
        inputAddress.setValue(value);

        return this;
    }
    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage setHobbies(String value) {
        chooseHobbies.$(byText(value)).click();
        return this;
    }
    public RegistrationPage uploadFile(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }
    public RegistrationPage chooseCountry(String value) {
        chooseCountry.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage chooseCity(String value) {
        chooseCity.setValue(value).pressEnter();

        return this;
    }

    public void closeForm() {
        buttonSubmit.click();

    }
    public void checkUnsuccessPageWithTable() {
        buttonSubmit.isEnabled();
    }


}
