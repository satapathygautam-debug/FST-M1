import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Create FirefoxDriver instance
        driver = new FirefoxDriver();
        // Open the login form page
        driver.get("https://training-support.net/webelements/login-form");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser after tests
        driver.close();
    }

    @Test
    @Parameters({ "username", "password" })
    public void loginTest(String username, String password) {
        // Locate elements
        WebElement userField = driver.findElement(By.id("username"));
        WebElement passField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        // Perform actions
        userField.sendKeys(username);
        passField.sendKeys(password);
        loginButton.click();
    }
}
