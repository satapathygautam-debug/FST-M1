import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;

public class DataTableExampleSteps extends BaseClass {

    @Given("user is on the To-Do list page")
    public void openPage() {
        driver.get("https://training-support.net/webelements/todo-list");
        assertEquals(driver.getTitle(), "Selenium: To-Do List");
    }

    @When("user adds the following tasks")
    public void addTasks(DataTable tasks) {
        List<String> taskList = tasks.asList();
        for (String task : taskList) {
            driver.findElement(By.id("taskInput")).sendKeys(task);
            driver.findElement(By.id("addButton")).click();
        }
    }

    @Then("they can see the task added to the list")
    public void verifyTasks() {
        List<WebElement> items = driver.findElements(By.cssSelector("ul#tasks li"));
        for (WebElement item : items) {
            System.out.println("Task in list: " + item.getText());
        }
        // Example assertion: check that at least 3 tasks are present
        assertEquals(3, items.size());
    }
}
