package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.CSVUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;


import java.util.List;

public class LoginTest {

    private WebDriver driver;

    private LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage();
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        List<String[]> records = CSVUtil.readCSV("src/main/resources/data_users.csv");
        Object[][] data = new Object[records.size()][2];
        for (int i = 0; i < records.size(); i++) {
            data[i][0] = records.get(i)[0]; // username
            data[i][1] = records.get(i)[1]; // password
        }
        return data;
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        loginPage.login(username, password);
        // Check if login was successful
        try {
            WebElement productsTitle = driver.findElement(By.className("title"));
            Assert.assertTrue(productsTitle.isDisplayed(), "Login successful");
        } catch (Exception e) {
            WebElement errorMessage = driver.findElement(By.cssSelector("[data-test='error']"));
            Assert.assertTrue(errorMessage.isDisplayed(), "Login failed");
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


