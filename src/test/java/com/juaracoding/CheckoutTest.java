package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.HomePage;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutTest {

    private WebDriver driver;

    private LoginPage loginPage;

    private HomePage homePage;

    private CartPage cartPage;

    private CheckoutPage checkoutPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage();
        homePage = new HomePage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }


    @Test
    public void testCheckout(){
        loginPage.login("standard_user", "secret_sauce");
        homePage.clickAddButton();
        homePage.clickCartButton();
        cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.getTxtCheckout().contains("Checkout"));
        checkoutPage.isiDataCheckout("farhan", "hilman", "30163");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300)");
        checkoutPage.clickContinueButton();
        DriverSingleton.delay(3);
        Assert.assertEquals(checkoutPage.getTxtPaymentInformation(), "Payment Information:");
        Assert.assertEquals(checkoutPage.getTxtShipingInformation(), "Shipping Information:");
        Assert.assertEquals(checkoutPage.getTotalPrice(), "Price Total");
        checkoutPage.clickFinishButton();
        checkoutPage.clickBackHomeButton();
        homePage.logout();
    }


}
