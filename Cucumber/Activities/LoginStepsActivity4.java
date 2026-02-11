import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;

public class LoginStepsActivity4 {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^the user is on the login page$")
    public void userOnLoginPage() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://training-support.net/webelements/login");
    }

    @When("^the user enters \"(.*)\" and \"(.*)\"$")
    public void enterCredentials(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("^clicks the submit button$")
    public void clickSubmit() {
        driver.findElement(By.id("loginButton")).click();
    }

    @Then("^get the confirmation text and verify message as \"(.*)\"$")
    public void verifyMessage(String expectedMessage) {
        String message = driver.findElement(By.id("confirmation")).getText();
        System.out.println("Confirmation message: " + message);
        if (!message.equals(expectedMessage)) {
            throw new AssertionError("Expected: " + expectedMessage + " but got: " + message);
        }
    }
}
