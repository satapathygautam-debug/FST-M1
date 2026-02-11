import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Activity14 {
    public static void main(String[] args) {
        // Set up the driver
        WebDriver driver = new ChromeDriver();

        // Open the tables page
        driver.get("https://training-support.net/webelements/tables");

        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Find number of rows
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        System.out.println("Number of rows: " + rows.size());

        // Find number of columns
        List<WebElement> cols = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
        System.out.println("Number of columns: " + cols.size());

        // Print the Book Name in the 5th row
        WebElement bookNameRow5 = driver.findElement(By.xpath("//table/tbody/tr[5]/td[1]"));
        System.out.println("Book Name in 5th row: " + bookNameRow5.getText());

        // Click the header of the Price column to sort ascending
        WebElement priceHeader = driver.findElement(By.xpath("//table/thead/tr/th[2]"));
        priceHeader.click();

        // Print the Book Name in the 5th row again after sorting
        WebElement bookNameRow5Sorted = driver.findElement(By.xpath("//table/tbody/tr[5]/td[1]"));
        System.out.println("Book Name in 5th row after sorting: " + bookNameRow5Sorted.getText());

        // Close the browser
        driver.quit();
    }
}
