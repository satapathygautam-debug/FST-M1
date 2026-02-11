import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity3 {
    public static void main(String[] args) {
        // Set up the driver
        WebDriver driver = new ChromeDriver();

        // Open the login form page
        driver.get("https://training-support.net/webelements/login-form/");

        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Find the username field using XPath and enter "admin"
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("admin");

        // Find the password field using XPath and enter "password"
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("password");

        // Find the "Log in" button using XPath and click it
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Close the browser
        driver.quit();
    }
}
