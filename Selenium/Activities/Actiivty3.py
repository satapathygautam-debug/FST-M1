from selenium import webdriver
from selenium.webdriver.common.by import By

# Set up the driver
driver = webdriver.Chrome()

# Open the login form page
driver.get("https://training-support.net/webelements/login-form/")

# Print the title of the page
print("Page title:", driver.title)

# Find the username field using XPath and enter "admin"
username = driver.find_element(By.XPATH, "//input[@id='username']")
username.send_keys("admin")

# Find the password field using XPath and enter "password"
password = driver.find_element(By.XPATH, "//input[@id='password']")
password.send_keys("password")

# Find the "Log in" button using XPath and click it
login_button = driver.find_element(By.XPATH, "//button[@type='submit']")
login_button.click()

# Close the browser
driver.quit()
