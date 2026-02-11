from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# Set up the driver
driver = webdriver.Chrome()
wait = WebDriverWait(driver, 10)

# Open the dynamic attributes page
driver.get("https://training-support.net/webelements/dynamic-attributes")

# Print the title of the page
print("Page title:", driver.title)

# Find the input fields and type required data
username = driver.find_element(By.XPATH, "//input[contains(@placeholder, 'Username')]")
password = driver.find_element(By.XPATH, "//input[contains(@placeholder, 'Password')]")

username.send_keys("admin")
password.send_keys("password")

# Click the login button
login_button = driver.find_element(By.XPATH, "//button[contains(text(), 'Log in')]")
login_button.click()

# Wait for success message to appear
success_message = wait.until(EC.visibility_of_element_located((By.ID, "action-confirmation")))

# Print the success message
print("Success message:", success_message.text)

# Close the browser
driver.quit()
