package com.appium.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * Chrome Activity 2: Testing Login Form with correct and incorrect credentials
 */
public class ChromeApp_Activity2_LoginFormTest extends BaseTest {
    
    private static final String CHROME_PACKAGE = "com.android.chrome";
    private static final String CHROME_ACTIVITY = "com.google.android.apps.chrome.Main";
    private static final String TEST_URL = "https://training-support.net/webelements";
    
    private WebDriverWait wait;
    
    @BeforeMethod
    @Override
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(PLATFORM_NAME);
        options.setDeviceName(DEVICE_NAME);
        options.setAutomationName(AUTOMATION_NAME);
        options.setAppPackage(CHROME_PACKAGE);
        options.setAppActivity(CHROME_ACTIVITY);
        options.setCapability("browserName", "Chrome");
        
        driver = new io.appium.java_client.android.AndroidDriver(new URL(APPIUM_SERVER_URL), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    
    @Test(priority = 5, description = "Chrome Activity 2: Test login with CORRECT credentials")
    public void testLoginWithCorrectCredentials() {
        System.out.println("=== Starting Chrome Activity 2A: Login with Correct Credentials ===");
        
        // Navigate to the URL
        driver.get(TEST_URL);
        waitFor(3);
        
        // Scroll to find the Login Form card
        scrollToElement("Login Form");
        waitFor(1);
        
        // Click on Login Form card
        WebElement loginCard = wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.xpath("//h4[contains(text(), 'Login Form')]/ancestor::div[contains(@class, 'card')]")
        ));
        loginCard.click();
        waitFor(2);
        
        // Perform login with correct credentials
        performLogin("admin", "password");
        
        // Assertion: Verify success message
        WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
            AppiumBy.xpath("//*[contains(text(), 'Login Success') or contains(text(), 'Welcome Back')]")
        ));
        
        String messageText = successMessage.getText();
        Assert.assertTrue(messageText.contains("Success") || messageText.contains("Welcome"), 
            "Login success message not found! Got: " + messageText);
        
        System.out.println("✓ Chrome Activity 2A Passed: Login with correct credentials successful");
        System.out.println("Success message: " + messageText);
    }
    
    @Test(priority = 6, description = "Chrome Activity 2: Test login with INCORRECT credentials")
    public void testLoginWithIncorrectCredentials() {
        System.out.println("=== Starting Chrome Activity 2B: Login with Incorrect Credentials ===");
        
        // Navigate to the URL
        driver.get(TEST_URL);
        waitFor(3);
        
        // Scroll to find the Login Form card
        scrollToElement("Login Form");
        waitFor(1);
        
        // Click on Login Form card
        WebElement loginCard = wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.xpath("//h4[contains(text(), 'Login Form')]/ancestor::div[contains(@class, 'card')]")
        ));
        loginCard.click();
        waitFor(2);
        
        // Perform login with incorrect credentials
        performLogin("wronguser", "wrongpass");
        
        // Assertion: Verify error message
        WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
            AppiumBy.xpath("//*[contains(text(), 'Invalid credentials') or contains(text(), 'Invalid')]")
        ));
        
        String messageText = errorMessage.getText();
        Assert.assertTrue(messageText.contains("Invalid"), 
            "Invalid credentials message not found! Got: " + messageText);
        
        System.out.println("✓ Chrome Activity 2B Passed: Incorrect credentials properly rejected");
        System.out.println("Error message: " + messageText);
    }
    
    /**
     * Helper method to perform login
     */
    private void performLogin(String username, String password) {
        // Find username field
        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(
            AppiumBy.xpath("//input[@id='username' or @name='username' or @placeholder='Username']")
        ));
        usernameField.clear();
        usernameField.sendKeys(username);
        
        waitFor(1);
        
        // Find password field
        WebElement passwordField = driver.findElement(
            AppiumBy.xpath("//input[@id='password' or @name='password' or @type='password']")
        );
        passwordField.clear();
        passwordField.sendKeys(password);
        
        waitFor(1);
        
        // Click submit button
        WebElement submitButton = driver.findElement(
            AppiumBy.xpath("//button[@type='submit' or contains(text(), 'Submit') or contains(text(), 'Login')]")
        );
        submitButton.click();
        
        waitFor(2);
        
        System.out.println("Attempted login with username: " + username);
    }
    
    /**
     * Helper method to scroll to an element by text
     */
    private void scrollToElement(String text) {
        driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().textContains(\"" + text + "\"))"
        ));
    }
}
