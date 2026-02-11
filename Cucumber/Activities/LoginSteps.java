package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;

public class LoginSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://training-support.net/webelements/login-form");
    }

    @When("the user enters username and password")
    public void the_user_enters_username_and_password() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("admin");
        passwordField.sendKeys("password");
    }

    @When("clicks the submit button")
    public void clicks_the_submit_button() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }

    @Then("get the confirmation message and verify it")
    public void get_the_confirmation_message_and_verify_it() {
        WebElement message = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("confirmation"))
        );
        String loginMessage = message.getText();
        Assert.assertEquals("Welcome Back, admin", loginMessage);
        driver.quit();
    }
}
