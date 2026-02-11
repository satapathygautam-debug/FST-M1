import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity11 {
    public static void main(String[] args) {
        // Set up the driver
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the dynamic controls page
        driver.get("https://training-support.net/webelements/dynamic-controls");

        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Find the checkbox
        WebElement checkbox = driver.findElement(By.id("checkbox"));

        // Click the "Toggle Checkbox" button to remove the checkbox
        WebElement toggleButton = driver.findElement(By.id("toggleCheckbox"));
        toggleButton.click();

        // Wait for the checkbox to disappear
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
        System.out.println("Checkbox removed.");

        // Toggle the checkbox again
        toggleButton.click();

        // Wait for the checkbox to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkbox")));
        checkbox