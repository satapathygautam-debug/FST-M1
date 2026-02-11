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

public class Activity3 {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        // ✅ Relative path to Calculator APK inside project folder
        options.setApp(System.getProperty("user.dir") + "/apps/Calculator_1.0.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
    }

    @Test
    public void testAddition() {
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/op_add")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_9")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();

        String result = driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
        System.out.println("Addition Result: " + result);
        Assert.assertEquals(result, "14");
    }

    @Test
    public void testSubtraction() {
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_1")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_0")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/op_sub")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();

        String result = driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
        System.out.println("Subtraction Result: " + result);
        Assert.assertEquals(result, "5");
    }

    @Test
    public void testMultiplication() {
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/op_mul")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_1")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_0")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_0")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();

        String result = driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
        System.out.println("Multiplication Result: " + result);
        Assert.assertEquals(result, "500");
    }

    @Test
    public void testDivision() {
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_0")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/op_div")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_2")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();

        String result = driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
        System.out.println("Division Result: " + result);
        Assert.assertEquals(result, "25");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
