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

public class Activity5 {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        // ✅ Launch default SMS app
        options.setAppPackage("com.google.android.apps.messaging");
        options.setAppActivity(".ui.ConversationListActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
    }

    @Test
    public void testSendSmsToSelf() {
        // Click "Start chat" or "Create new message"
        WebElement newMessageButton = driver.findElement(AppiumBy.accessibilityId("Start chat"));
        newMessageButton.click();

        // Enter your own phone number
        WebElement recipientField = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='To']"));
        recipientField.sendKeys("999148292"); // replace with your own number if needed

        // Enter the message text
        WebElement messageField = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Text message']"));
        messageField.sendKeys("Hello from Appium");

        // Click Send button
        WebElement sendButton = driver.findElement(AppiumBy.accessibilityId("Send SMS"));
        sendButton.click();

        // Assertion: Verify message is displayed in conversation
        WebElement sentMessage = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Hello from Appium']"));
        String actualMessage = sentMessage.getText();
        System.out.println("Message Sent: " + actualMessage);

        Assert.assertEquals(actualMessage, "Hello from Appium", "Message was not sent successfully!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
