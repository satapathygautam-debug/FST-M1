import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity9 {
    public static void main(String[] args) {
        // Set up the driver
        WebDriver driver = new ChromeDriver();

        // Open the keyboard events page
        driver.get("https://training-support.net/webelements/keyboard-events");

        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Find the input field
        WebElement inputField = driver.findElement(By.id("keyboardInput"));

        // Type out a string
        String message = "Hello from Selenium Java!";
        inputField.sendKeys(message);

        // Print