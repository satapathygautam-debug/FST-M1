import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity8 {
    public static void main(String[] args) {
        // Set up the driver
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);

        // Open the mouse events page
        driver.get("https://training-support.net/webelements/mouse-events");

        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Left click on Cargo.lock, move to Cargo.toml and click
        WebElement cargoLock = driver.findElement(By.id("cargoLock"));
        WebElement cargoToml = driver.findElement(By.id("cargoToml"));
        actions.click(cargoLock).moveToElement(cargoToml).click().perform();

        // Print confirmation text
        WebElement confirm1 = driver.findElement(By.id("result"));
        System.out.println("Confirmation after Cargo sequence: " + confirm1.getText());

        // Double click on src button
        WebElement srcButton = driver.findElement(By.id("src"));
        actions.doubleClick(srcButton).perform();

