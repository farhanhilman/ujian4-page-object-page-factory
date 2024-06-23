package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    public HomePage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "title")
    private WebElement productTitle;

    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement txtLogo;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement menuButton;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement logoutButton;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addButton;

    @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
    private WebElement txtRemove;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement txtCart;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartButton;

    //Assertion
    public String getTxtLogo(){
        return txtLogo.getText();
    }

    public String getTxtRemove(){
        return txtRemove.getText();
    }

    public String getTxtCart(){
        return txtCart.getText();
    }

    public String getProductTitle(){
        return productTitle.getText();
    }

    public void logout(){
        menuButton.click();
        DriverSingleton.delay(3);
        logoutButton.click();
    }

    public void clickAddButton(){
        addButton.click();
    }


    public void clickCartButton(){
        cartButton.click();
    }




}
