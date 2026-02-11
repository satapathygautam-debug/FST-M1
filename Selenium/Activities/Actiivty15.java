import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity15 {
    public static void main(String[] args) {
        // Set up the driver
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the dynamic attributes page
        driver.get("https://training-support.net/webelements/dynamic-attributes");

        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Find the input fields and type required data
        WebElement username = driver.findElement(By.xpath("//input[contains(@placeholder, 'Username')]"));
        WebElement password = driver.findElement(By.xpath("//input[contains(@placeholder, 'Password')]"));

        username.sendKeys("admin");
        password.sendKeys("password");

        // Click the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(), 'Log in')]"));
        loginButton.click();

        // Wait for success message to appear
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));

        // Print the success message
        System.out.println("Success message: " + successMessage.getText());

        // Close the browser
        driver.quit();
    }
}
