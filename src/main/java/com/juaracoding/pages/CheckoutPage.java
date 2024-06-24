package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    private WebDriver driver;

    public CheckoutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='title']")
    private WebElement txtCheckout;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement posCode;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[normalize-space()='Payment Information:']")
    private WebElement txtPayementInformation;

    @FindBy(xpath = "//div[normalize-space()='Shipping Information:']")
    private WebElement txtShipingInformation;

    @FindBy(xpath = "//div[normalize-space()='Price Total']")
    private WebElement txtPriceTotal;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishButton;

    @FindBy(xpath = "//button[@id='cancel']")
    private WebElement cancelButton;

    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement backHomeButton;

    public String getTxtCheckout(){
        return txtCheckout.getText();
    }

    public String getTxtPaymentInformation(){
        return txtPayementInformation.getText();
    }

    public String getTxtShipingInformation(){
        return txtShipingInformation.getText();
    }

    public String getTotalPrice(){
        return txtPriceTotal.getText();
    }

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void setPosCode(String posCode) {
        this.posCode.sendKeys(posCode);
    }

    public void isiDataCheckout(String firtsName, String lastName, String posCode){
        setFirstName(firtsName);
        setLastName(lastName);
        setPosCode(posCode);
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public void clickFinishButton(){
        finishButton.click();
    }

    public void clickCancelButton(){
        cancelButton.click();
    }

    public void clickBackHomeButton(){
        backHomeButton.click();
    }

}
