package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTests extends TestBase {
    private String firstName = "Angelina";
    private String lastName = "Jolie";
    private String userEmail = "AngelinaJolie@test.com";
    private String sex = "Female";
    private String userNumber = "9991110000";
    private String day = "04";
    private String month = "June";
    private String year = "1975";
    private String subject = "Maths";
    private String hobby = "Reading";
    private String filePath = "src/test/resources/tiger.jpg";
    private String fileName = "tiger.jpg";
    private String currentAddress = "USA";
    private String state = "Haryana";
    private String city = "Panipat";
    private String resultTableTitle = "Thanks for submitting the form";
    private RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeFooterAndBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(sex)
                .setNumber(userNumber)
                .setDate(day, month, year)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadFle(filePath)
                .setAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submitForm();

        registrationPage.verifyResult(firstName + " " + lastName)
                        .verifyResult(userEmail)
                        .verifyResult(sex)
                        .verifyResult(userNumber)
                        .verifyResult(day + " " + month + "," + year)
                        .verifyResult(subject)
                        .verifyResult(hobby)
                        .verifyResult(fileName)
                        .verifyResult(currentAddress)
                        .verifyResult(state + " " + city);
    }

    @Test
    void modalIsClosedTest(){
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(sex)
                .setNumber(userNumber)
                .submitForm();

        registrationPage.modalIsDisplayed()
                        .verifyModalTitle(resultTableTitle)
                        .closeModal()
                        .modalIsNotDisplayed();
    }
}
