package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {
    private String fullName = "Angelina Jolie";
    private String email = "angelina.jolie@mail.com";
    private String currentAddress = "USA, some city";
    private String permanentAddress = "USA, another city";
    private TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successfulRegistrationTest(){
        textBoxPage.openPage()
                .setFullName(fullName)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submitForm();

        textBoxPage.verifyData(fullName)
                .verifyData(email)
                .verifyData(currentAddress)
                .verifyData(permanentAddress);
    }
}
