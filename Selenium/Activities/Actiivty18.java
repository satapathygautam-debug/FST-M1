import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;

public class Activity18 {
    public static void main(String[] args) {
        // Set up the driver
        WebDriver driver = new ChromeDriver();

        // Open the alerts page
        driver.get("https://training-support.net/webelements/alerts");

        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Find the button to open a SIMPLE alert and click it
        WebElement simpleAlertButton = driver.findElement(By.id("simple"));
        simpleAlertButton.click();

        // Switch focus to the alert
        Alert simpleAlert = driver.switchTo().alert();

        // Get the text in the alert and print it
        System.out.println("Alert text: " + simpleAlert.getText());

        // Close the alert with OK
        simpleAlert.accept();

        // Close the browser
        driver.quit();
    }
}
