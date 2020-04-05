package com.weborders.pages;

import com.weborders.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractBasePage {

    @FindBy(id="ctl00_MainContent_username")
    private WebElement username;

    @FindBy(id="ctl00_MainContent_password")
    private WebElement password;

    //same action but different parameter list
    //log in with credentials or not

    public void login(){
        String usernameValue = ConfigurationReader.getProperty("userName");
        String passwordValue = ConfigurationReader.getProperty("password");
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    public void login(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

}
