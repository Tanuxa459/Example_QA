package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.TableOfDataPage;
import pages.RegistrationPage;
import utils.RandomGenerate;




public class PracticeFormWithPageObjectTest extends TestBase{

    private String
            firstName,
            lastName,
            email,
            gender,
            phone,
            yearBirth,
            monthBirth,
            dayBirth,
            subject,
            hobby,
            picture,
            address,
            state,
            city;


    private  String
            fullNameTable = "Student Name",
            emailTable = "Student Email",
            genderTable = "Gender",
            phoneTable = "Mobile",
            birthdayTable = "Date of Birth",
            subjectTable = "Subjects",
            hobbyTable = "Hobbies",
            pictureTable = "Picture",
            addressTable = "Address",
            stateTable = "State and City";


    RegistrationPage registrationPage = new RegistrationPage();
    TableOfDataPage tableOfDataPage = new TableOfDataPage();
    RandomGenerate randomGenerate = new RandomGenerate();


    @BeforeEach
    public void  setValue () {

        firstName = randomGenerate.getFirstName();
        lastName = randomGenerate.getLastName();
        email = randomGenerate.getUserEmail();
        gender = randomGenerate.getRandomGender();
        phone = randomGenerate.getUserPhone();
        dayBirth = randomGenerate.getRandomDay();
        monthBirth = randomGenerate.getRandomMonth();
        yearBirth = randomGenerate.getRandomYear();
        subject = randomGenerate.getRandomSubject();
        hobby = randomGenerate.getRandomHobbies();
        picture = randomGenerate.getRandomPicture();
        address = randomGenerate.getStreetAddress();
        state = randomGenerate.getRandomState();
        city = randomGenerate.getRandomCity(state);
}


    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phone)
                .setDateOfBirth(dayBirth,monthBirth,yearBirth)
                .setSubject(subject)
                .uploadFile(picture)
                .setAddress(address)
                .chooseCountry(state)
                .chooseCity(city)
                .setHobbies(hobby)
                .closeForm();

        tableOfDataPage.checkSuccessPageWithTable();
        tableOfDataPage.checkDataTable(fullNameTable,firstName + " " + lastName);
        tableOfDataPage.checkDataTable(emailTable,email);
        tableOfDataPage.checkDataTable(genderTable,gender);
        tableOfDataPage.checkDataTable(phoneTable,phone);
        tableOfDataPage.checkDataTable(birthdayTable,dayBirth+ " " + monthBirth+","+yearBirth);
        tableOfDataPage.checkDataTable(subjectTable,subject);
        tableOfDataPage.checkDataTable(hobbyTable,hobby);
        tableOfDataPage.checkDataTable(pictureTable,picture);
        tableOfDataPage.checkDataTable(addressTable,address);
        tableOfDataPage.checkDataTable(stateTable,state + " " + city);

    }
    @Test
    void negativeEmailTest() {
        registrationPage.openPage()
                .removeBanner()
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phone)
                .setSubject(subject)
                .uploadFile(picture)
                .chooseCountry(state)
                .chooseCity(city)
                .setHobbies(hobby)
                .closeForm();

        registrationPage.checkUnsuccessPageWithTable();

    }
    @Test
    void minDataTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setEmail(email)
                .setUserNumber(phone)
                .closeForm();

        tableOfDataPage.checkSuccessPageWithTable();
        tableOfDataPage.checkDataTable(fullNameTable,firstName + " " + lastName);
        tableOfDataPage.checkDataTable(emailTable,email);
        tableOfDataPage.checkDataTable(genderTable,gender);
        tableOfDataPage.checkDataTable(phoneTable,phone);

    }

}
