import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity5 {
    public static void main(String[] args) {
        // Set up the driver
        WebDriver driver = new ChromeDriver();

        // Open the dynamic controls page
        driver.get("https://training-support.net/webelements/dynamic-controls");

        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Find the checkbox input element
        WebElement checkbox = driver.findElement(By.id("checkbox"));

        // Check if it is visible on the page
        System.out.println("Checkbox displayed: " + checkbox.isDisplayed());

        // Click the "Remove Checkbox" button
        WebElement removeButton = driver.findElement(By.id("toggleCheckbox"));
        removeButton.click();

        // Check if checkbox is visible again
        try {
            checkbox = driver.findElement(By.id("checkbox"));
            System.out.println("Checkbox displayed after removal: " + checkbox.isDisplayed());
        } catch (Exception e) {
            System.out.println("Checkbox is no longer displayed.");
        }

        // Close the browser
        driver.quit();
    }
}
