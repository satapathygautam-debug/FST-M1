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
import java.util.List;

public class Activity7 {

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
    public void testLazyLoadingImages() {
        // Open the lazy loading page
        driver.get("https://training-support.net/webelements/lazy-loading");

        // Get number of images initially visible
        List<WebElement> imagesBeforeScroll = driver.findElements(AppiumBy.xpath("//android.widget.Image"));
        System.out.println("Number of images before scroll: " + imagesBeforeScroll.size());

        // Scroll to Helen's post
        WebElement helenPost = driver.findElement(AppiumBy.xpath("//android.view.View[@text='Helen']"));
        driver.executeScript("arguments[0].scrollIntoView(true);", helenPost);

        // Get number of images after scroll
        List<WebElement> imagesAfterScroll = driver.findElements(AppiumBy.xpath("//android.widget.Image"));
        System.out.println("Number of images after scroll: " + imagesAfterScroll.size());

        // Assertion: More images should be loaded after scrolling
        Assert.assertTrue(imagesAfterScroll.size() > imagesBeforeScroll.size(),
                "Lazy loading did not load more images after scrolling!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
