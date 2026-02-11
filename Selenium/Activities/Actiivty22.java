import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity22 {
    public static void main(String[] args) {
        // Set up the driver
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the popups page
        driver.get("https://training-support.net/webelements/popups");

        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Find the button and click it to launch the popup
        WebElement popupButton = driver