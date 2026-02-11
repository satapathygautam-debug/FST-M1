import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity7 {
    public static void main(String[] args) {
        // Set up the driver
        WebDriver driver = new ChromeDriver();

        // Open the dynamic controls page
        driver.get("https://training-support.net/webelements/dynamic-controls");

        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Find the text field
        WebElement textField = driver.findElement(By.id("textInput"));

        // Check if the text field is enabled
        System.out.println("Text field enabled: " + textField.isEnabled());

        // Click the "Enable Input" button
        WebElement enableButton = driver.findElement(By.id("toggleInput"));
        enableButton.click();

        // Check if the text field is enabled again
        textField = driver.findElement(By.id("textInput"));
        System.out.println("Text field enabled after click: " + textField.isEnabled());

        // Close the browser
        driver.quit();
    }
}
