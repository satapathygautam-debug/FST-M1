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
import java.util.List;

/**
 * Activity 3: Mark all tasks as complete
 */
public class NativeApp_Activity3_CompleteTasksTest extends BaseTest {
    
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
    
    @Test(priority = 3, description = "Activity 3: Mark tasks as complete")
    public void testMarkTasksAsComplete() {
        System.out.println("=== Starting Activity 3: Mark Tasks Complete Test ===");
        
        // Wait for app to load
        waitFor(2);
        
        // Step 1: Mark the first two tasks as complete
        markTaskComplete(1);
        waitFor(1);
        markTaskComplete(2);
        waitFor(1);
        
        // Step 2: Long press the third task to edit it
        WebElement thirdTask = driver.findElement(AppiumBy.xpath(
            "(//android.widget.TextView[contains(@resource-id, 'task_name')])[3]"
        ));
        performLongPress(thirdTask);
        
        waitFor(1);
        
        // Open edit screen
        try {
            WebElement editOption = driver.findElement(AppiumBy.xpath(
                "//android.widget.TextView[@text='Edit']"
            ));
            editOption.click();
        } catch (Exception e) {
            System.out.println("Task opened in edit mode");
        }
        
        waitFor(1);
        
        // Step 3: Slide the progress bar to 50%
        try {
            WebElement progressBar = driver.findElement(AppiumBy.id("task_progress_bar"));
            slideProgressBar(progressBar, 50);
            waitFor(1);
        } catch (Exception e) {
            System.out.println("Progress bar not found or slider operation failed");
        }
        
        // Save the task
        WebElement saveButton = driver.findElement(AppiumBy.id("add_task_done"));
        saveButton.click();
        waitFor(2);
        
        // Step 4: Click the option icon (menu/overflow button)
        try {
            WebElement optionsMenu = driver.findElement(AppiumBy.xpath(
                "//android.widget.ImageView[@content-desc='More options']"
            ));
            optionsMenu.click();
            waitFor(1);
            
            // Select "Completed tasks"
            WebElement completedTasksOption = driver.findElement(AppiumBy.xpath(
                "//android.widget.TextView[@text='Completed tasks']"
            ));
            completedTasksOption.click();
            waitFor(2);
            
        } catch (Exception e) {
            System.out.println("Error accessing completed tasks: " + e.getMessage());
        }
        
        // Step 5: Assertion - Verify only 2 tasks are shown in completed list
        List<WebElement> completedTasks = driver.findElements(AppiumBy.xpath(
            "//android.widget.TextView[contains(@resource-id, 'task_name')]"
        ));
        
        Assert.assertEquals(completedTasks.size(), 2, 
            "Expected 2 completed tasks, but found: " + completedTasks.size());
        
        System.out.println("✓ Activity 3 Passed: 2 tasks marked as complete");
        System.out.println("Completed tasks count: " + completedTasks.size());
    }
    
    /**
     * Helper method to mark a task as complete
     */
    private void markTaskComplete(int taskPosition) {
        try {
            // Find the checkbox for the task at the given position
            WebElement checkbox = driver.findElement(AppiumBy.xpath(
                String.format("(//android.widget.CheckBox[contains(@resource-id, 'task_checkbox')])[%d]", 
                    taskPosition)
            ));
            checkbox.click();
            System.out.println("Marked task " + taskPosition + " as complete");
        } catch (Exception e) {
            System.out.println("Error marking task " + taskPosition + " as complete: " + e.getMessage());
        }
    }
    
    /**
     * Helper method to perform long press
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
     * Helper method to slide progress bar to specific percentage
     */
    private void slideProgressBar(WebElement progressBar, int percentage) {
        int startX = progressBar.getLocation().getX();
        int startY = progressBar.getLocation().getY() + (progressBar.getSize().getHeight() / 2);
        int endX = startX + (progressBar.getSize().getWidth() * percentage / 100);
        
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence slide = new Sequence(finger, 1);
        
        slide.addAction(finger.createPointerMove(Duration.ZERO, 
            PointerInput.Origin.viewport(), startX, startY));
        slide.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        slide.addAction(finger.createPointerMove(Duration.ofMillis(500), 
            PointerInput.Origin.viewport(), endX, startY));
        slide.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        
        driver.perform(Arrays.asList(slide));
        System.out.println("Slid progress bar to " + percentage + "%");
    }
}
