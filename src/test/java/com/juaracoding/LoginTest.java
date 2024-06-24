package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.HomePage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.CSVUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;

    LoginPage loginPage;

    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage();
        homePage = new HomePage();
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
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

}