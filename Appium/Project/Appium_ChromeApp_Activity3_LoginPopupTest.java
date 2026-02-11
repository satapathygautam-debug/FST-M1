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
import java.util.Set;

/**
 * Chrome Activity 3: Testing Login in Popup
 */
public class ChromeApp_Activity3_LoginPopupTest extends BaseTest {
    
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
    
    @Test(priority = 7, description = "Chrome Activity 3: Test login in popup")
    public void testLoginInPopup() {
        System.out.println("=== Starting Chrome Activity 3: Login in Popup Test ===");
        
        // Navigate to the URL
        driver.get(TEST_URL);
        waitFor(3);
        
        // Scroll to find the Popups card
        scrollToElement("Popups");
        waitFor(1);
        
        // Click on Popups card
        WebElement popupsCard = wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.xpath("//h4[contains(text(), 'Popups') or contains(text(), 'Popup')]/ancestor::div[contains(@class, 'card')]")
        ));
        popupsCard.click();
        waitFor(2);
        
        // Find and click the button to open popup with login form
        WebElement openPopupButton = wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.xpath("//button[contains(text(), 'Sign In') or contains(text(), 'Login') or contains(text(), 'Open')]")
        ));
        openPopupButton.click();
        waitFor(2);
        
        // Switch to popup/modal if it's a different context
        // For web modals, we might not need to switch windows
        // But check if there are multiple contexts
        try {
            Set<String> contextHandles = driver.getContextHandles();
            if (contextHandles.size() > 1) {
                String webContext = contextHandles.stream()
                    .filter(context -> context.contains("WEBVIEW"))
                    .findFirst()
                    .orElse(null);
                if (webContext != null) {
                    driver.context(webContext);
                }
            }
        } catch (Exception e) {
            System.out.println("No context switch needed");
        }
        
        // Find username field in the popup
        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(
            AppiumBy.xpath("//input[@id='username' or @name='username' or @placeholder='Username']")
        ));
        usernameField.clear();
        usernameField.sendKeys("admin");
        
        waitFor(1);
        
        // Find password field in the popup
        WebElement passwordField = driver.findElement(
            AppiumBy.xpath("//input[@id='password' or @name='password' or @type='password']")
        );
        passwordField.clear();
        passwordField.sendKeys("password");
        
        waitFor(1);
        
        // Click submit button in the popup
        WebElement submitButton = driver.findElement(
            AppiumBy.xpath("//button[@type='submit' or contains(text(), 'Submit') or contains(text(), 'Login')]")
        );
        submitButton.click();
        
        waitFor(3);
        
        // Assertion: Verify success message appears
        WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
            AppiumBy.xpath("//*[contains(text(), 'Login Success') or contains(text(), 'Welcome Back')]")
        ));
        
        String messageText = successMessage.getText();
        Assert.assertTrue(messageText.contains("Success") || messageText.contains("Welcome"), 
            "Login success message not found in popup! Got: " + messageText);
        
        System.out.println("✓ Chrome Activity 3 Passed: Login in popup successful");
        System.out.println("Success message: " + messageText);
    }
    
    /**
     * Helper method to scroll to an element by text
     */
    private void scrollToElement(String text) {
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().textContains(\"" + text + "\"))"
            ));
        } catch (Exception e) {
            System.out.println("Scroll not needed or element already visible");
        }
    }
}
