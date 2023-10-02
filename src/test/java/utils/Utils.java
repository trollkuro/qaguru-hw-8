package utils;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class Utils {

    public void removeFooterAndBanner(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
}
