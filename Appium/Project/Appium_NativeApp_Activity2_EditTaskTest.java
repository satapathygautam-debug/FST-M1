package com.appium.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

/**
 * Activity 2: Edit a task to add a deadline
 */
public class NativeApp_Activity2_EditTaskTest extends BaseTest {
    
    private static final String APP_PACKAGE = "com.google.android.apps.tasks";
    private static final String APP_ACTIVITY = ".ui.TaskListsActivity";
    
    @BeforeMethod
    @Override
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(PLATFORM_NAME);
        options.setDeviceName(DEVICE_NAME);
        options.setAutomationName(AUTOMATION_NAME);
        options.setAppPackage(APP_PACKAGE);
        options.setAppActivity(APP_ACTIVITY);
        
        driver = new io.appium.java_client.android.AndroidDriver(new URL(APPIUM_SERVER_URL), options);
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }
    
    @Test(priority = 2, description = "Activity 2: Edit task to add deadline")
    public void testEditTaskAddDeadline() {
        System.out.println("=== Starting Activity 2: Edit Task Test ===");
        
        // Wait for app to load
        waitFor(2);
        
        // Find the first task in the list
        WebElement firstTask = driver.findElement(AppiumBy.xpath(
            "(//android.widget.TextView[contains(@resource-id, 'task_name')])[1]"
        ));
        
        // Long press on the first task to edit
        performLongPress(firstTask);
        
        waitFor(1);
        
        // Click on "Edit" option from context menu or directly open edit screen
        try {
            WebElement editOption = driver.findElement(AppiumBy.xpath(
                "//android.widget.TextView[@text='Edit']"
            ));
            editOption.click();
        } catch (Exception e) {
            // If no context menu, task might open directly in edit mode
            System.out.println("Task opened in edit mode");
        }
        
        waitFor(1);
        
        // Set deadline - Click on date/deadline field
        try {
            WebElement deadlineField = driver.findElement(AppiumBy.id("add_task_due_date"));
            deadlineField.click();
            
            waitFor(1);
            
            // Set deadline to next Saturday
            // This will depend on the date picker UI
            setNextSaturday();
            
            // Click OK on date picker
            WebElement okButton = driver.findElement(AppiumBy.id("button1")); // Standard Android OK button
            okButton.click();
            
            waitFor(1);
            
        } catch (Exception e) {
            System.out.println("Error setting deadline: " + e.getMessage());
        }
        
        // Save the edited task
        WebElement saveButton = driver.findElement(AppiumBy.id("add_task_done"));
        saveButton.click();
        
        waitFor(2);
        
        // Assertion: Verify deadline is set
        // Find the first task again and check for deadline indicator
        WebElement updatedTask = driver.findElement(AppiumBy.xpath(
            "(//android.widget.TextView[contains(@resource-id, 'task_name')])[1]"
        ));
        
        // Check if deadline/due date is visible
        boolean deadlineSet = driver.findElements(AppiumBy.id("task_due_date")).size() > 0;
        Assert.assertTrue(deadlineSet, "Deadline was not set for the task!");
        
        System.out.println("✓ Activity 2 Passed: Deadline set successfully for the task");
    }
    
    /**
     * Helper method to perform long press on an element
     */
    private void performLongPress(WebElement element) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence longPress = new Sequence(finger, 1);
        
        longPress.addAction(finger.createPointerMove(Duration.ZERO, 
            PointerInput.Origin.viewport(), 
            element.getLocation().getX() + 10, 
            element.getLocation().getY() + 10));
        longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        longPress.addAction(new org.openqa.selenium.interactions.Pause(finger, Duration.ofSeconds(2)));
        longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        
        driver.perform(Arrays.asList(longPress));
    }
    
    /**
     * Helper method to select next Saturday in date picker
     */
    private void setNextSaturday() {
        try {
            // This is a simplified version - actual implementation will depend on date picker UI
            // You might need to navigate through calendar to find next Saturday
            
            // Example: Click on a specific date
            // Update based on actual date picker structure
            WebElement saturdayDate = driver.findElement(AppiumBy.xpath(
                "//android.view.View[@content-desc[contains(., 'Saturday')]]"
            ));
            saturdayDate.click();
            
        } catch (Exception e) {
            System.out.println("Using alternative method to set date");
            // Alternative: Use accessibility labels or different locators
        }
    }
}
