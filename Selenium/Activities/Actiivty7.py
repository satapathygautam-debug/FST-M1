from selenium import webdriver
from selenium.webdriver.common.by import By

# Set up the driver
driver = webdriver.Chrome()

# Open the dynamic controls page
driver.get("https://training-support.net/webelements/dynamic-controls")

# Print the title of the page
print("Page title:", driver.title)

# Find the text field
text_field = driver.find_element(By.ID, "textInput")

# Check if the text field is enabled
print("Text field enabled:", text_field.is_enabled())

# Click the "Enable Input" button
enable_button = driver.find_element(By.ID, "toggleInput")
enable_button.click()

# Check if the text field is enabled again
text_field = driver.find_element(By.ID, "textInput")
print("Text field enabled after click:", text_field.is_enabled())

# Close the browser
driver.quit()
