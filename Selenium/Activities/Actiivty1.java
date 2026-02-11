import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity1 {
    public static void main(String[] args) {
        // Set up the driver (make sure chromedriver is in PATH)
        WebDriver driver = new ChromeDriver();

        // Open the training support site
        driver.get("https://training-support.net");

        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        // Click the "About Us" button
        WebElement aboutUsLink = driver.findElement(By.id("about-link"));
        aboutUsLink.click();

        // Print the title of the new page
        System.out.println("New page title: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
}
