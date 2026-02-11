import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Activity13 {
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

        // Print all cell values in the third row
        List<WebElement> thirdRow = driver.findElements(By.xpath("//table/tbody/tr[3]/td"));
        System.out.println("Third row values:");
        for (WebElement cell : thirdRow) {
            System.out.println(cell.getText());
        }

        // Print the cell value at second row, second column
        WebElement cellValue = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        System.out.println("Second