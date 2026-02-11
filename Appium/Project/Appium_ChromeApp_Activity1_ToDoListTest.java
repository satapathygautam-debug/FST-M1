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
import java.util.List;

/**
 * Chrome Activity 1: Testing To-Do List web page
 */
public class ChromeApp_Activity1_ToDoListTest extends BaseTest {
    
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
        
        // Set Chrome browser
        options.setAppPackage(CHROME_PACKAGE);
        options.setAppActivity(CHROME_ACTIVITY);
        options.setCapability("browserName", "Chrome");
        
        driver = new io.appium.java_client.android.AndroidDriver(new URL(APPIUM_SERVER_URL), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    
    @Test(priority = 4, description = "Chrome Activity 1: Test To-Do List web page")
    public void testToDoListWebPage() {
        System.out.println("=== Starting Chrome Activity 1: To-Do List Web Test ===");
        
        // Navigate to the URL
        driver.get(TEST_URL);
        waitFor(3);
        
        // Scroll to find the To-Do List card
        scrollToElement("To-Do List");
        waitFor(1);
        
        // Click on To-Do List card
        WebElement toDoCard = wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.xpath("//h4[contains(text(), 'To-Do List')]/ancestor::div[contains(@class, 'card')]")
        ));
        toDoCard.click();
        waitFor(2);
        
        // Find the input field and add tasks
        WebElement inputField = wait.until(ExpectedConditions.presenceOfElementLocated(
            AppiumBy.xpath("//input[@type='text' or @placeholder='Add a task']")
        ));
        
        // Add Task 1: Add tasks to list
        addTaskToList(inputField, "Add tasks to list");
        waitFor(1);
        
        // Add Task 2: Get number of tasks
        addTaskToList(inputField, "Get number of tasks");
        waitFor(1);
        
        // Add Task 3: Clear the list
        addTaskToList(inputField, "Clear the list");
        waitFor(1);
        
        // Click on each task to strike them out
        strikeOutAllTasks();
        waitFor(1);
        
        // Assertion: Verify the count of tasks
        // Note: 2 tasks already present + 3 added = 5 total
        List<WebElement> allTasks = driver.findElements(
            AppiumBy.xpath("//ul[@id='tasksList' or contains(@class, 'task-list')]//li")
        );
        
        int expectedTaskCount = 5; // 2 pre-existing + 3 newly added
        Assert.assertEquals(allTasks.size(), expectedTaskCount, 
            "Expected " + expectedTaskCount + " tasks but found: " + allTasks.size());
        
        System.out.println("✓ Chrome Activity 1 Passed: To-Do list test completed");
        System.out.println("Total tasks in list: " + allTasks.size());
    }
    
    /**
     * Helper method to add a task to the list
     */
    private void addTaskToList(WebElement inputField, String taskName) {
        inputField.clear();
        inputField.sendKeys(taskName);
        
        // Find and click add button
        WebElement addButton = driver.findElement(
            AppiumBy.xpath("//button[contains(text(), 'Add') or @type='submit']")
        );
        addButton.click();
        
        System.out.println("Added task: " + taskName);
    }
    
    /**
     * Helper method to strike out all tasks
     */
    private void strikeOutAllTasks() {
        List<WebElement> tasks = driver.findElements(
            AppiumBy.xpath("//ul[@id='tasksList' or contains(@class, 'task-list')]//li")
        );
        
        System.out.println("Striking out " + tasks.size() + " tasks");
        
        for (WebElement task : tasks) {
            try {
                task.click();
                waitFor(1);
            } catch (Exception e) {
                System.out.println("Error clicking task: " + e.getMessage());
            }
        }
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
