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

# Check if the checkbox is selected
print("Checkbox selected:", checkbox.is_selected())

# Click the checkbox to select it
checkbox.click()

# Check if the checkbox is selected again
print("Checkbox selected after click:", checkbox.is_selected())

# Close the browser
driver.quit()
