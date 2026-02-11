import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity12 {
    public static void main(String[] args) {
        // Set up the driver
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the dynamic content page
        driver.get("https://training-support.net/webelements/dynamic-content");

        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Find and click the "Click me!" button
        WebElement clickMeButton = driver.findElement(By.id("clickMe"));
        clickMeButton