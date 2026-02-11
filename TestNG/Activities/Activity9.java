import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Alert;

import org.testng.Reporter;
import org.testng.Assert;

public class Activity9 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/alerts");
    }

    @BeforeMethod
    public void resetFocus() {
        // Switch back to the main page before each test
        driver.switchTo().defaultContent();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @Test
    public void simpleAlertTestCase() {
        driver.findElement(By.id("simple")).click();
        Alert simpleAlert = driver.switchTo().alert();

        String alertText = simpleAlert.getText();
        Reporter.log("Simple Alert