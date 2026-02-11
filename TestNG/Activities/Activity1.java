package testngActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Create driver instance for Firefox
        driver = new FirefoxDriver();

        // Open the training-support page
        driver.get("https://training-support.net");
    }

    @Test
    public void testPageTitleAndNavigation() {
        // Get and print the title of the page
        String title = driver.getTitle();
        System.out.println("Home Page title is: " + title);

        // Assert the title of the page
        Assert.assertEquals(title, "Training Support");

        // Find the "About Us" button and click it
        driver.findElement(By.id("about")).click();

        // Get and print the title of the new page
        String newTitle = driver.getTitle();
        System.out.println("New Page title is: " + newTitle);

        // Assert the title of the new page
        Assert.assertEquals(newTitle, "About Training Support");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.close();
    }
}
