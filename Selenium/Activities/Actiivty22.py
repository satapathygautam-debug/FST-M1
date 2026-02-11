from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# Set up the driver
driver = webdriver.Chrome()
wait = WebDriverWait(driver, 10)

# Open the popups page
driver.get("https://training-support.net/webelements/popups")

# Print the title of the page
print("Page title:", driver.title)

# Find the button and click it to launch the popup
popup_button = driver.find_element(By.ID, "popupButton")
popup_button.click()

# Wait for the popup to appear
username = wait.until(EC.visibility_of_element_located((By.ID, "username")))
password = driver.find_element(By.ID, "password")

# Enter credentials
username.send_keys("admin")
password.send_keys("password")

# Click submit
submit_button = driver.find_element(By.XPATH, "//button[@type='submit']")
submit_button.click()

# Print the message after logging in
message = wait.until(EC.visibility_of_element_located((By.ID, "action-confirmation")))
print("Login message:", message.text)

# Close the browser
driver.quit()
