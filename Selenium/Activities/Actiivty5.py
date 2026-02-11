from selenium import webdriver
from selenium.webdriver.common.by import By

# Set up the driver
driver = webdriver.Chrome()

# Open the dynamic controls page
driver.get("https://training-support.net/webelements/dynamic-controls")

# Print the title of the page
print("Page title:", driver.title)

# Find the checkbox input element
checkbox = driver.find_element(By.ID, "checkbox")

# Check if it is visible on the page
print("Checkbox displayed:", checkbox.is_displayed())

# Click the "Remove Checkbox" button
remove_button = driver.find_element(By.ID, "toggleCheckbox")
remove_button.click()

# Check if checkbox is visible again
try:
    checkbox = driver.find_element(By.ID, "checkbox")
    print("Checkbox displayed after removal:", checkbox.is_displayed())
except:
    print("Checkbox is no longer displayed.")

# Close the browser
driver.quit()
