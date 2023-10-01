package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    private SelenideElement fullNameInput = $("#userName"),
                            emailInput = $("#userEmail"),
                            currentAddressInput = $("#currentAddress"),
                            permanentAddressInput = $("#permanentAddress"),
                            submitButton = $("#submit"),
                            resultBlock = $("#output");


    public TextBoxPage openPage(){
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setFullName(String fullName){
        fullNameInput.setValue(fullName);
        return this;
    }

    public TextBoxPage setEmail(String email){
        emailInput.setValue(email);
        return this;
    }

    public TextBoxPage setCurrentAddress(String currentAddress){
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public TextBoxPage setPermanentAddress(String permanentAddress){
        permanentAddressInput.setValue(permanentAddress);
        return this;
    }

    public TextBoxPage submitForm(){
        submitButton.click();
        return this;
    }

    public TextBoxPage verifyData(String value){
        resultBlock.shouldHave(text(value));
        return this;
    }
}


