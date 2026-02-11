package testngActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Create driver instance for Firefox
        driver = new FirefoxDriver();

        // Open the target practice page
        driver.get("https://training-support.net/webelements/target-practice");
    }

    @Test(groups = {"HeaderTests"})
    public void testThirdHeaderText() {
        String thirdHeaderText = driver.findElement(By.tagName("h3")).getText();
        System.out.println("Third header text: " + thirdHeaderText);
        Assert.assertEquals(thirdHeaderText, "Third header");
    }

    @Test(groups = {"HeaderTests"})
    public void testFifthHeaderColor() {
        String fifthHeaderColor = driver.findElement(By.xpath("//h5")).getCssValue("color");
        System.out.println("Fifth header color: " + fifthHeaderColor);
        Assert.assertEquals(fifthHeaderColor, "rgba(33, 37, 41, 1)"); // Example expected value
    }

    @Test(groups = {"ButtonTests"})
    public void testEmeraldButtonText() {
        String emeraldButtonText = driver.findElement(By.className("emerald")).getText();
        System.out.println("Emerald button text: " + emeraldButtonText);
        Assert.assertEquals(emeraldButtonText, "Emerald");
    }

    @Test(groups = {"ButtonTests"})
    public void testThirdRowFirstButtonColor() {
        String buttonColor = driver.findElement(By.xpath("//div[@class='row'][3]/button[1]")).getCssValue("color");
        System.out.println("Third row first button color: " + buttonColor);
        Assert.assertEquals(buttonColor, "rgba(255, 255, 255, 1)"); // Example expected value
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.close();
    }
}
