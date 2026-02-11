package com.appium.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Activity 1: Use the To-Do list app to create a list of tasks
 */
public class NativeApp_Activity1_AddTasksTest extends BaseTest {
    
    private static final String APP_PACKAGE = "com.google.android.apps.tasks";
    private static final String APP_ACTIVITY = ".ui.TaskListsActivity";
    
    @BeforeMethod
    @Override
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(PLATFORM_NAME);
        options.setDeviceName(DEVICE_NAME);
        options.setAutomationName(AUTOMATION_NAME);
        
        // Set app package and activity for To-Do List app
        // Note: Update these based on the actual app you're testing
        options.setAppPackage(APP_PACKAGE);
        options.setAppActivity(APP_ACTIVITY);
        
        // Alternatively, if you have the APK file:
        // options.setApp(System.getProperty("user.dir") + "/apps/TodoList.apk");
        
        driver = new io.appium.java_client.android.AndroidDriver(new URL(APPIUM_SERVER_URL), options);
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }
    
    @Test(priority = 1, description = "Activity 1: Add three tasks with different priorities")
    public void testAddTasksToList() {
        System.out.println("=== Starting Activity 1: Add Tasks Test ===");
        
        // Wait for app to load
        waitFor(2);
        
        // Task 1: Complete Activity 1 with priority high
        addTask("Complete Activity 1", "high");
        
        // Task 2: Complete Activity 2 with priority medium
        addTask("Complete Activity 2", "medium");
        
        // Task 3: Complete Activity 3 with priority low
        addTask("Complete Activity 3", "low");
        
        // Assertion: Verify all three tasks are added
        List<WebElement> taskList = driver.findElements(AppiumBy.id("task_item"));
        Assert.assertEquals(taskList.size(), 3, "Expected 3 tasks to be added!");
        
        System.out.println("✓ Activity 1 Passed: All 3 tasks added successfully");
        System.out.println("Total tasks in list: " + taskList.size());
    }
    
    /**
     * Helper method to add a task with priority
     */
    private void addTask(String taskName, String priority) {
        try {
            // Click the add task button (floating action button)
            // Update the locator based on actual app UI
            WebElement addButton = driver.findElement(AppiumBy.id("tasks_fab"));
            addButton.click();
            
            waitFor(1);
            
            // Enter task name
            WebElement taskNameField = driver.findElement(AppiumBy.id("add_task_title"));
            taskNameField.sendKeys(taskName);
            
            // Set priority if the app has this feature
            // Update locator based on actual app
            if (driver.findElements(AppiumBy.id("task_priority")).size() > 0) {
                WebElement priorityDropdown = driver.findElement(AppiumBy.id("task_priority"));
                priorityDropdown.click();
                
                // Select priority
                String priorityXPath = String.format("//android.widget.TextView[@text='%s']", 
                    priority.substring(0, 1).toUpperCase() + priority.substring(1));
                WebElement priorityOption = driver.findElement(AppiumBy.xpath(priorityXPath));
                priorityOption.click();
            }
            
            // Click Save button
            WebElement saveButton = driver.findElement(AppiumBy.id("add_task_done"));
            saveButton.click();
            
            waitFor(1);
            
            System.out.println("Added task: " + taskName + " with priority: " + priority);
            
        } catch (Exception e) {
            System.out.println("Error adding task: " + e.getMessage());
            // Take screenshot if needed
        }
    }
}
