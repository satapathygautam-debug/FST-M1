import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {
    public static void main(String[] args) {
        // Set up the driver
        WebDriver driver = new ChromeDriver();

        // Open the selects page
        driver.get("https://training-support.net/webelements/selects");

        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Find the Multi Select dropdown
        WebElement multiSelectElement = driver.findElement(By.id("multiSelect"));
        Select multiSelect = new Select(multiSelectElement);

        // Select the "HTML" option using visible text
        multiSelect.selectByVisibleText("HTML");

        // Select the 4th, 5th, and 6th options using index (index starts at 0)
        multiSelect.selectByIndex(3);
        multiSelect.selectByIndex(4);
        multiSelect.selectByIndex(5);

        // Select the "Node" option using value
        multiSelect.selectByValue("node");

        // Deselect the 5th option using index
        multiSelect.deselectByIndex(4);

        // Close the browser
        driver.quit();
    }
}
