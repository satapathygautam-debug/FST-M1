import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        // ✅ Relative path to APK inside project folder
        options.setApp(System.getProperty("user.dir") + "/apps/Calculator_1.0.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
    }

    @Test
    public void testMultiplication() {
        // Click first number (e.g., 7)
        WebElement num7 = driver.findElement(By.id("com.android.calculator2:id/digit_7"));
        num7.click();

        // Click multiplication symbol (*)
        WebElement multiply = driver.findElement(By.id("com.android.calculator2:id/op_mul"));
        multiply.click();

        // Click second number (e.g., 5)
        WebElement num5 = driver.findElement(By.id("com.android.calculator2:id/digit_5"));
        num5.click();

        // Click equals (=)
        WebElement equals = driver.findElement(By.id("com.android.calculator2:id/eq"));
        equals.click();

        // Get result text
        WebElement result = driver.findElement(By.id("com.android.calculator2:id/result"));
        String actualResult = result.getText();

        // Assertion
        Assert.assertEquals(actualResult, "35", "Multiplication result is incorrect!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
