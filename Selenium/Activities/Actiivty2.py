from selenium import webdriver
from selenium.webdriver.common.by import By

# Set up the driver
driver = webdriver.Chrome()

# Open the login form page
driver.get("https://training-support.net/webelements/login-form/")

# Print the title of the page
print("Page title:", driver.title)

# Find the username field and enter "admin"
username = driver.find_element(By.ID, "username")
username.send_keys("admin")

# Find the password field and enter "password"
password = driver.find_element(By.ID, "password")
password.send_keys("password")

# Find the "Log in" button and click it
login_button = driver.find_element(By.CSS_SELECTOR, "button[type='submit']")
login_button.click()

# Close the browser
driver.quit()
