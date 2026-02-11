import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;

public class Activity3Steps {
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    @Given("^User is on the page$")
    public void userOnPage() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://training-support.net/webelements/alerts");
    }

    @When("^User clicks the Simple Alert button$")
    public void clickSimpleAlert() {
        driver.findElement(By.id("simple")).click();
    }

    @When("^User clicks the Confirm Alert button$")
    public void clickConfirmAlert() {
        driver.findElement(By.id("confirm")).click();
    }

    @When("^User clicks the Prompt Alert button$")
    public void clickPromptAlert() {
        driver.findElement(By.id("prompt")).click();
    }

    @Then("^Alert opens$")
    public void alertOpens() {
        alert = driver.switchTo().alert();
    }

    @And("^Read the text from it and print it$")
    public void readAlertText() {
        System.out.println("Alert text: " + alert.getText());
    }

    @And("^Write a custom message in it$")
    public void writePromptMessage() {
        alert.sendKeys("Hello from Cucumber!");
    }

    @And("^Close the alert$")
    public void closeAlert() {
        alert.accept();
    }

    @And("^Close the alert with Cancel$")
    public void closeAlertWithCancel() {
        alert.dismiss();
    }

    @And("^Read the result text$")
    public void readResultText() {
        String result = driver.findElement(By.id("result")).getText();
        System.out.println("Result text: " + result);
    }
}
