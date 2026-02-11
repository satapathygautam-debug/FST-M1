import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity4 {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        // ✅ Launch Contacts app directly
        options.setAppPackage("com.google.android.contacts");
        options.setAppActivity("com.android.contacts.activities.PeopleActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
    }

    @Test
    public void testAddNewContact() {
        // Click on "Add Contact" button
        WebElement addContactButton = driver.findElement(AppiumBy.accessibilityId("Create new contact"));
        addContactButton.click();

        // Fill in First Name
        WebElement firstNameField = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']"));
        firstNameField.sendKeys("Aaditya");

        // Fill in Last Name
        WebElement lastNameField = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']"));
        lastNameField.sendKeys("Varma");

        // Fill in Phone Number
        WebElement phoneField = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']"));
        phoneField.sendKeys("999148292");

        // Click Save
        WebElement saveButton = driver.findElement(AppiumBy.id("com.android.contacts:id/editor_menu_save_button"));
        saveButton.click();

        // Assertion: Verify new contact is added
        WebElement contactName = driver.findElement(AppiumBy.id("com.android.contacts:id/large_title"));
        String actualName = contactName.getText();
        System.out.println("New Contact Added: " + actualName);

        Assert.assertEquals(actualName, "Aaditya Varma", "Contact was not added correctly!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
