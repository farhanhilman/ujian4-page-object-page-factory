package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //WebElement

    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement txtError;

    @FindBy(xpath = "//div[@class='login_logo']")
    private WebElement attrLoginLogo;

    public void setUsername(String username){
        this.username.sendKeys(username);
    }

    public void setPassword(String password){
        this.password.sendKeys(password);
    }

    public void login(String username, String password){
        setUsername(username);
        setPassword(password);
        loginButton.click();
    }

    //Assertion
    public String getTxtError(){
        return  txtError.getText();
    }

    public String getAttributeLoginLogo() {
        return attrLoginLogo.getAttribute("class");
    }
}
