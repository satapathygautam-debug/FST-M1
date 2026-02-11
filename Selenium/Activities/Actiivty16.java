import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class Activity16 {
    public static void main(String[] args) {
        // Set up the driver
        WebDriver driver = new ChromeDriver();

        // Open the selects page
        driver.get("https://training-support.net/webelements/selects");

        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Find the Single Select dropdown
        WebElement dropdown = driver.findElement(By.id("singleSelect"));
        Select select = new Select(dropdown);

        // Select the second option using visible text
        select.selectByVisibleText("Option 2");

        // Select the third option using index (index starts at 0)
        select.selectByIndex(2);

        // Select the fourth option using value
        select.selectByValue("4");

        // Get all options and print them
        List<WebElement> options = select.getOptions();
        System.out.println("Dropdown options:");
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        // Close the browser
        driver.quit();
    }
}
