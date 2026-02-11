@When("^the user enters \"(.*)\" and \"(.*)\"$")
public void enterCredentials(String username, String password) {
    driver.findElement(By.id("username")).sendKeys(username);
    driver.findElement(By.id("password")).sendKeys(password);
}
