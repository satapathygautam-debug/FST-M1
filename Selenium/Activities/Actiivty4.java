import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity4 {
    public static void main(String[] args) {
        // Set up the driver
        WebDriver driver = new ChromeDriver();

        // Open the target practice page
        driver.get("https://training-support.net/webelements/target-practice");

        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Using XPath: Find the 3rd header and print its text
        WebElement thirdHeader = driver.findElement(By.xpath("//h3"));
        System.out.println("3rd header text: " + thirdHeader.getText());

        // Using XPath: Find the 5th header and print its color
        WebElement fifthHeader = driver.findElement(By.xpath("//h5"));
        System.out.println("5th header color: " + fifthHeader.getCssValue("color"));

        // Using another locator: Find the purple button and print all its classes
        WebElement purpleButton = driver.findElement(By.className("purple"));
        System.out.println("Purple button classes: " + purpleButton.getAttribute("class"));

        // Using another locator: Find the slate button and print its text
        WebElement slateButton = driver.findElement(By.className("slate"));
        System.out