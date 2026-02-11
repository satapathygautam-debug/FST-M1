package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;

public class TSHomepageSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("user is on the TS homepage")
    public void user_is_on_the_TS_homepage() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://www.trainingsupport.com"); // Example URL
    }

    @When("the user clicks on the About Us link")
    public void the_user_clicks_on_the_about_us_link() {
        WebElement aboutLink = driver.findElement(By.linkText("About Us"));
        aboutLink.click();
    }

    @Then("they are redirected to another page")
    public void they_are_redirected_to_another_page() {
        wait.until(ExpectedConditions.titleContains("About Us"));
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("About Us"));
        driver.quit();
    }
}
