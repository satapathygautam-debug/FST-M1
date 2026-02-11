import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;

public class Activity19 {
    public static void main(String[] args) {
        // Set up the driver
        WebDriver driver = new ChromeDriver();

        // Open the alerts page
        driver.get("https://training-support.net/webelements/alerts");

        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Find the button to open a CONFIRM alert and click it
        WebElement confirmAlertButton = driver.findElement(By.id("confirm"));
        confirmAlertButton.click();

        // Switch focus to the alert
        Alert confirmAlert = driver.switchTo().alert();

        // Get the text in the alert and print it
        System.out.println("Alert text: " + confirmAlert.getText());

        // Close the alert with OK
        confirmAlert.accept();
        System.out.println("Alert closed with OK.");

        // Open the confirm alert again
        confirmAlertButton.click();
        confirmAlert = driver.switchTo().alert();

        // Print the text again
        System.out.println("Alert text: " + confirmAlert.getText());

        // Close the alert with Cancel
        confirmAlert.dismiss();
        System.out