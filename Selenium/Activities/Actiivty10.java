import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10 {
    public static void main(String[] args) {
        // Set up the driver
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);

        // Open the drag and drop page
        driver.get("https://training-support.net/webelements/drag-drop");

        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Find the ball
        WebElement ball = driver.findElement(By.id("ball"));

        // Find Dropzone 1 and Dropzone 2
        WebElement dropzone1 = driver.findElement(By.id("dropzone1"));
        WebElement dropzone2 = driver.findElement(By.id