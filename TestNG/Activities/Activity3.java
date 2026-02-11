package testngActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Create driver instance for Firefox
        driver = new FirefoxDriver();

        // Open the login form page
        driver.get("https://training-support.net/webelements/login-form/");
    }

    @Test
    public void testLoginForm() {
        // Find the username and password fields
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");

        // Click the login button
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        // Read the confirmation message
        String confirmationMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Confirmation message: " + confirmationMessage);

        // Assert the confirmation message
        Assert.assertEquals(confirmationMessage, "Welcome Back, admin");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.close();
    }
}
