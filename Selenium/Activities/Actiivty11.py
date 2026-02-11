from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# Set up the driver
driver = webdriver.Chrome()
wait = WebDriverWait(driver, 10)

# Open the dynamic controls page
driver.get("https://training-support.net/webelements/dynamic-controls")

# Print the title of the page
print("Page title:", driver.title)

# Find the checkbox
checkbox = driver.find_element(By.ID, "checkbox")

# Click the "Toggle Checkbox" button to remove the checkbox
toggle_button = driver.find_element(By.ID, "toggleCheckbox")
toggle_button.click()

# Wait for the checkbox to disappear
wait.until(EC.invisibility_of_element(checkbox))
print("Checkbox removed.")

# Toggle the checkbox again
toggle_button.click()

# Wait for the checkbox to appear
checkbox = wait.until(EC.presence_of_element_located((By.ID, "checkbox")))

# Select the checkbox
checkbox.click()
print("Checkbox selected:", checkbox.is_selected())

# Close the browser
driver.quit()
