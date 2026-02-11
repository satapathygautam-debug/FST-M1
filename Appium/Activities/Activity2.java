import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        // ✅ Launch Chrome browser instead of APK
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
    }

    @Test
    public void testBrowserNavigation() {
        // Open the browser with the URL
        driver.get("https://training-support.net");

        // Locate heading on page and print it
        WebElement heading = driver.findElement(AppiumBy.xpath("//android.view.View[@text='Training Support']"));
        System.out.println("Heading: " + heading.getText());

        // Locate About Us button and click it
        WebElement aboutUsButton = driver.findElement(AppiumBy.xpath("//android.view.View[@text='About Us']"));
        aboutUsButton.click();

        // Print the heading on the About Us page
        WebElement aboutUsHeading = driver.findElement(AppiumBy.xpath("//android.view.View[@text='About Us']"));
        System.out