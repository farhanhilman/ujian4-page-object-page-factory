package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;

    public CartPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //WebElement
    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement itemName;

    @FindBy(xpath = "//button[@id='continue-shopping']")
    private WebElement backButton;

    //Assertion
    public String getItemName(){
        return itemName.getText();
    }

    public void clickBackButton(){
        backButton.click();
    }



}
