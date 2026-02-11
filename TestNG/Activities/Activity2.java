package testngActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Create driver instance for Firefox
        driver = new FirefoxDriver();

        // Open the target practice page
        driver.get("https://training-support.net/webelements/target-practice/");
    }

    @Test
    public void testPageTitle() {
        // Get and assert the title of the page
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertEquals(title, "Target Practice");
    }

    @Test
    public void testBlackButtonIncorrectAssertion() {
        // Find the black button
        String buttonText = driver.findElement(By.className("black")).getText();
        System.out.println("Black button text: " + buttonText);

        // Make an incorrect assertion (intentional failure)
        Assert.assertEquals(buttonText, "Green");
    }

    @Test(enabled = false)
    public void testSkippedByDisabled() {
        // This test will be skipped silently
        System.out.println("This test is disabled and will not run.");
    }

    @Test
    public void testSkippedByException() {
        // Skip this test explicitly
        System.out