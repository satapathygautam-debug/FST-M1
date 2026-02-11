import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Activity21 {
    public static void main(String[] args) {
        // Set up the driver
        WebDriver driver = new ChromeDriver();

        // Open the tabs page
        driver.get("https://training-support.net/webelements/tabs");

        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Find the button to open a new tab and click it
        WebElement newTabButton = driver.find