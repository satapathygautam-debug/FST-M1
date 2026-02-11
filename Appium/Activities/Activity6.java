import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity6 {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        // ✅ Launch Chrome browser
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
    }

    @Test
    public void testSliderActions() {
        // Navigate to the slider page
        driver.get("https://training-support.net/webelements/sliders");

        // Locate the slider element
        WebElement slider = driver.findElement(AppiumBy.xpath("//input[@type='range']"));

        // Get slider location
        Point sliderLocation = slider.getLocation();
        int sliderWidth = slider.getSize().getWidth();

        // Move slider to 75%
        Point start = new Point(sliderLocation.getX(), sliderLocation.getY());
        Point end75 = new Point(sliderLocation.getX() + (int)(sliderWidth * 0.75), sliderLocation.getY());
        ActionsBase.doSwipe(driver, start, end75, 500);

        // Verify volume text at 75%
        WebElement volumeText75 = driver.findElement(AppiumBy.id("volume"));
        String text75 = volumeText75.getText();
        System.out.println("Volume at 75%: " + text75);
        Assert.assertTrue(text75.contains("75"), "Slider not set to 75%");

        // Move slider to 25%
        Point end25 = new Point(sliderLocation.getX() + (int)(sliderWidth * 0.25), sliderLocation.getY());
        ActionsBase.doSwipe(driver, start, end25, 500);

        // Verify volume text at 25%
        WebElement volumeText25 = driver.findElement(AppiumBy.id("volume"));
        String text25 = volumeText25.getText();
        System.out.println("Volume at 25%: " + text25);
        Assert.assertTrue(text25.contains("25"), "Slider not set to 25%");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
